package com.pluralsight.model;

import com.pluralsight.model.enums.SandwichSize;

public abstract class Topping implements Priceable {
    public enum ToppingType {
        MEAT("Meat Premium Topping", 1.00, .50),
        CHEESE("Cheese Premium Topping", .75, .30),
        REGULAR("Regular Topping", 0.00, 0.00);

        private final String description;
        private final double basePrice;
        private final double extraPrice;

        ToppingType(String description, double basePrice, double extraPrice) {
            this.description = description;
            this.basePrice = basePrice;
            this.extraPrice = extraPrice;
        }

        public String getDescription() {
            return description;
        }
    }

    private SandwichSize sandwichSize;
    private ToppingType toppingType;
    private boolean hasExtra;

    public Topping(SandwichSize sandwichSize, ToppingType toppingType, boolean hasExtra) {
        this.sandwichSize = sandwichSize;
        this.toppingType = toppingType;
        this.hasExtra = hasExtra;
    }

    @Override
    public double getPrice() {
        // price of small sandwich with meat and cheese no extra for either
        // 7.25 = 5.50 + (1 * 1.00 + 1 * .75) + 0 * (1.00 + .60)
        // 5.50 + 1 * (1.00 + .75)
        // small = 1;
        // total price = base price of Small sandwich + (small meat + small cheese)
        // Medium = 2;
        // 14 = 7.00 + 2 * (2.00 + 1.50)

        double price = 0.0;
        int sizeMultiplier = 1;

        switch (sandwichSize) {
            case MEDIUM -> sizeMultiplier = 2;
            case LARGE -> sizeMultiplier = 3;
        }

        switch (toppingType) {
            case MEAT -> {
                price += ToppingType.MEAT.basePrice;
                if (hasExtra) {
                    price += ToppingType.MEAT.extraPrice;
                }
            }
            case CHEESE -> {
                price += ToppingType.CHEESE.basePrice;
                if (hasExtra) {
                    price += ToppingType.CHEESE.extraPrice;
                }
            }
        }

        return price * sizeMultiplier;
    }

    public boolean withExtra() {
        return hasExtra;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }
}