package printer;

import bean.Food;

import java.util.ArrayList;

/**
 * Created by Maria on 20.02.2017.
 */
public class Printer {

    public static void printMenu(ArrayList<Food> foodList) {
        for (Food food : foodList) {
            System.out.println(food.getId() + " " + food.getPhoto() + " " + food.getTitle() + " "
                    + food.getDescription() + " " + food.getPortion() + " " + food.getPrice());
        }
    }
}
