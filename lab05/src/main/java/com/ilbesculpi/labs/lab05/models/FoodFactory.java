package com.ilbesculpi.labs.lab05.models;

import java.util.ArrayList;
import java.util.List;

public class FoodFactory {

    private static Food[] db = new Food[] {
            new Food(1, "Hamburguesa con papas fritas", "hamburguesa", FoodType.ALMUERZO, 3500.0f, true),
            new Food(2, "Pizza 4 quesos", "pizza", FoodType.ALMUERZO, 4100.0f, false),
            new Food(3, "Arepa mixta", "arepa", FoodType.DESAYUNO, 1200.0f, false),
            new Food(4, "Sandwich jamón y queso", "sandwich", FoodType.DESAYUNO, 4100.0f, false),
            new Food(5, "Pasta 4 quesos", "pasta", FoodType.ALMUERZO, 3000.0f, false),
            new Food(6, "Ensalada Cesar", "ensalada", FoodType.ENTRADA, 2600.0f, false),
            new Food(7, "Helado 2 sabores", "helado", FoodType.POSTRE, 1000.0f, false),
            new Food(8, "Arroz con pollo", "pollo", FoodType.ALMUERZO, 3000.0f, false),
            new Food(9, "Pasta carbonara", "pasta", FoodType.ALMUERZO, 3000.0f, false),
            new Food(10, "Pasticho", "pasticho", FoodType.ALMUERZO, 3000, true),
    };

    public static List<Food> getJokes() {
        List<Food> foods = new ArrayList<>();
        for( Food j : db ) {
            foods.add(j);
        }
        return foods;
    }

}
