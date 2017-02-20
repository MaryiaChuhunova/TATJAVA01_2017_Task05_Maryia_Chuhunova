package parser.sax;

import bean.Food;
import parser.ParseException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 19.02.2017.
 */
public class SAXMenuParser {

    public static ArrayList<Food> parseWithSaxParser() throws ParseException {

        ArrayList<Food> menu;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource("food.xml"));

            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/string-interning", true);
            reader.setFeature("http://apache.org/xml/features/validation/schema", false);

            menu = handler.getFoodList();

        } catch (IOException ioex) {
            throw new ParseException("Troubles with reading data from source", ioex);
        } catch (SAXException saxex) {
            throw new ParseException("Troubles with parsing data", saxex);
        }

        return menu;
    }
}
