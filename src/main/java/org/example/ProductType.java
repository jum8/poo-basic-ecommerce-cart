package org.example;

public enum ProductType {
    ELECTRONIC("Electronic"),
    LIBRARY("Library"),
    OTHERS("Others");

    public final String label;

    private ProductType(String label) {
        this.label = label;
    }
}
