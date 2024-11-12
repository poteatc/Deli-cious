//package com.pluralsight.model;
//
//import com.pluralsight.model.enums.BreadType;
//import com.pluralsight.model.enums.Size;
//
//public class Bread implements Priceable {
//    private BreadType breadType;  // BreadType enum to determine type of bread
//
//    // Constructor
//    public Bread(BreadType breadType, Size size) {
//        this.breadType = breadType;
//    }
//
//    // Getter for BreadType
//    public BreadType getBreadType() {
//        return breadType;
//    }
//
//    // Setter for BreadType
//    public void setBreadType(BreadType breadType) {
//        this.breadType = breadType;
//    }
//
//    // Getter for Size
//    public Size getSize() {
//        return size;
//    }
//
//    // Setter for Size
//    public void setSize(Size size) {
//        this.size = size;
//    }
//
//    // Priceable interface method to get price based on bread size
//    @Override
//    public double getPrice() {
//        // Different bread sizes have different prices (small, medium, large)
//        switch (size) {
//            case SMALL:
//                return 2.00; // Example price for SMALL bread
//            case MEDIUM:
//                return 3.00; // Example price for MEDIUM bread
//            case LARGE:
//                return 4.00; // Example price for LARGE bread
//            default:
//                return 0.0;  // Default if size is not defined
//        }
//    }
//}
