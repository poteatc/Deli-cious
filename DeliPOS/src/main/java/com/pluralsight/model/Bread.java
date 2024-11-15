package com.pluralsight.model;

import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.SandwichSize;

/**
 * Represents a bread component in a sandwich, implementing the Priceable interface.
 * Includes the type and size of the bread, along with price calculation logic.
 */
public class Bread implements Priceable {
    private BreadType breadType;  // The type of bread (e.g., White, Wheat, Rye)
    private SandwichSize sandwichSize; // The size of the sandwich (Small, Medium, Large)

    /**
     * Constructor to create a Bread object with specified bread type and size.
     *
     * @param breadType the type of bread
     * @param sandwichSize the size of the sandwich
     */
    public Bread(BreadType breadType, SandwichSize sandwichSize) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
    }

    /**
     * Default constructor to initialize bread to White and size to Small.
     */
    public Bread() {
        this.breadType = BreadType.WHITE;
        this.sandwichSize = SandwichSize.SMALL;
    }

    /**
     * Setter for the bread type.
     *
     * @param breadType the type of bread to set
     */
    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    /**
     * Getter for the sandwich size.
     *
     * @return the size of the sandwich
     */
    public SandwichSize getSize() {
        return sandwichSize;
    }

    /**
     * Setter for the sandwich size.
     *
     * @param size the size to set for the sandwich
     */
    public void setSize(SandwichSize size) {
        this.sandwichSize = size;
    }

    /**
     * Calculates the price of the bread based on its size.
     *
     * @return the price of the bread
     */
    @Override
    public double getPrice() {
        double price = 0.0;
        // Set price based on sandwich size
        switch (sandwichSize) {
            case SMALL -> price = 5.50;   // Price for SMALL bread
            case MEDIUM -> price = 7.00; // Price for MEDIUM bread
            case LARGE -> price = 8.50;  // Price for LARGE bread
        }
        return price;
    }

    /**
     * Provides a formatted description of the bread, including size, type, and price.
     *
     * @return a string description of the bread
     */
    public String getDescription() {
        return String.format("\t+ %s %s: $%.2f",
                sandwichSize.getDescription(),
                breadType.getDescription(),
                getPrice());
    }
}
