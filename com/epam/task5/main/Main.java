package main;

import parser.DOM.DOMMenuParser;
import parser.ParseException;
import parser.SAX.SAXMenuParser;
import parser.StAX.StAXMenuParser;
import printer.Printer;

/**
 * Created by Maria on 19.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("With DOM parser:");
            System.out.println("---------------");
            Printer.printMenu(DOMMenuParser.parseWithDOMParser());

            System.out.println("\nWith SAX parser");
            System.out.println("---------------");
            SAXMenuParser.parseWithSaxParser();

            System.out.println("\nWith StAX parser");
            System.out.println("---------------");
            StAXMenuParser.parseMenuWithStAXParser();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
