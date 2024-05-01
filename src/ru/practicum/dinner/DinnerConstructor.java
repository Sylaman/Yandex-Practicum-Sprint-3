package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> businessLunches = new HashMap<>();
    Random random = new Random();

    void addNewDish(String type, String name) {
        String addMessage = "Блюдо ".concat(name).concat(" успешно добавлено в тип ".concat(type));
        if (checkDish(name)) {
            System.out.println("Данное блюдо уже добавлено в меню ресторана!");
        } else if (checkType(type)) {
            businessLunches.get(type).add(name);
            System.out.println(addMessage);
        } else {
            ArrayList<String> dishForNewType = new ArrayList<>();
            dishForNewType.add(name);
            businessLunches.put(type, dishForNewType);
            System.out.println(addMessage);
        }
    }

    void generateDishCombo(int number, ArrayList<String> types) {
        for (int i = 0; i < number; i++) {
            System.out.println("Комбо ".concat(String.valueOf(i + 1)).concat(":"));
            ArrayList<String> newCombo = new ArrayList<>();
            for (String type : types) {
                int dishNumber = random.nextInt(businessLunches.get(type).size());
                String dish = businessLunches.get(type).get(dishNumber);
                newCombo.add(dish);
            }
            System.out.println(String.join(", ", newCombo).concat("\n"));
        }
    }

    boolean checkType(String type) {
        return businessLunches.containsKey(type);
    }

    boolean checkDish(String name) {
        for (ArrayList<String> dishes : businessLunches.values()) {
            if (dishes.contains(name)) {
                return true;
            }
        }
        return false;
    }
}