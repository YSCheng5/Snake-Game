/*
 * Created on 2024-04-08
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Random;

public abstract class Food {
    public abstract Position getPosition();

    public abstract String getIcon();

    public static Food randomFood(Position position) {
        int numFood = 3; // Represents the number of food items

        int randomNumber = new Random().nextInt(numFood);

        switch (randomNumber) {
            case 0:
                return new Cherry(position);
            case 1:
                return new Apple(position);
            case 2:
                return new Lemon(position);
            default:
                return null;
        }

    }
}
