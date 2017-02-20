package parser;

/**
 * Created by Maria on 19.02.2017.
 */
public class ParseException extends Exception {
    public ParseException(String message, Exception e) {
        super(message, e);
    }
}
