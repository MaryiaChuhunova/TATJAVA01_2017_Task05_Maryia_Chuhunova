package parser.stax;

import bean.Food;
import parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 19.02.2017.
 */
public class StAXMenuParser {

    public static ArrayList<Food> parseMenuWithStAXParser() throws ParseException {

        ArrayList<Food> menu;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
                InputStream input = new FileInputStream("food.xml");
                XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
                menu = process(reader);

        } catch (FileNotFoundException fnfex) {
            throw new ParseException("Couldn't find data source", fnfex);
        } catch (XMLStreamException e) {
            throw new ParseException("Couldn't read xml file", e);
        }
        return menu;
    }

    private static ArrayList<Food> process(XMLStreamReader reader) throws XMLStreamException {
        ArrayList<Food> menu = new ArrayList<>();
        Food food = null;
        MenuTagName elementName = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            food = new Food();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            food.setId(id);
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();

                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case PHOTO:
                            food.setPhoto(text.toString());
                            break;
                        case TITLE:
                            food.setTitle(text.toString());
                            break;
                        case DESCRIPTION:
                            food.setDescription(text.toString());
                            break;
                        case PORTION:
                            food.setPortion(text.toString());
                            break;
                        case PRICE:
                            food.setPrice(text.toString());
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.getElementTagName((reader.getLocalName()));
                    switch (elementName) {

                        case FOOD:
                            menu.add(food);
                    }
            }
        }
        return menu;
    }
}

