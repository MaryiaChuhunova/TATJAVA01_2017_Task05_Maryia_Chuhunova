package parser.dom;

import bean.Food;
import parser.ParseException;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Maria on 19.02.2017.
 */
public class DOMMenuParser {

    public static ArrayList<Food> parseWithDOMParser() throws ParseException {

        ArrayList<Food> menu;
        try {
            DOMParser parser = new DOMParser();
            parser.parse("food.xml");
            Document document = parser.getDocument();

            Element root = document.getDocumentElement();

            menu = new ArrayList<Food>();

            NodeList foodNodes = root.getElementsByTagName("food");

            Food food = null;
            for (int i = 0; i < foodNodes.getLength(); i++) {
                food = new Food();
                Element foodElement = (Element) foodNodes.item(i);

                food.setId(Integer.parseInt(foodElement.getAttribute("id")));
                food.setPhoto(getSingleChild(foodElement, "photo").getTextContent());
                food.setTitle(getSingleChild(foodElement, "title").getTextContent());
                food.setDescription(getSingleChild(foodElement, "description").getTextContent());
                food.setPortion(getSingleChild(foodElement, "portion").getTextContent());
                food.setPrice(getSingleChild(foodElement, "price").getTextContent());
                menu.add(food);
            }

        } catch (IOException ioex) {
            throw new ParseException("Troubles with reading data from source", ioex);
        } catch (SAXException saxex) {
            throw new ParseException("Troubles with parsing data", saxex);
        }
        return menu;
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }


}

