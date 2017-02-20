package parser.stax;

/**
 * Created by Maria on 19.02.2017.
 */
public enum MenuTagName {
    PHOTO, TITLE, DESCRIPTION, PORTION, PRICE, FOOD, MENU, COLD, WARM, BREAKFAST;

    public static  MenuTagName getElementTagName(String element) {
        switch(element) {
            case "food":
                return FOOD;
            case "price":
                return PRICE;
            case "photo":
                return PHOTO;
            case "title":
                return TITLE;
            case "description":
                return DESCRIPTION;
            case "portion":
                return PORTION;
            case "menu":
                return MENU;
            case "cold":
                return COLD;
            case "warm":
                return WARM;
            case "breakfast":
                return BREAKFAST;
                default:
                    throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }
}
