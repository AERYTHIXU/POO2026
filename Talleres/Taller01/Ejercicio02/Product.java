package Talleres.Taller01.Ejercicio02;


public class Product {
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            this.name = "Unknown"; // Valid default name.
        }

        if (price > 0) {
            this.price = price;
        } else {
            this.price = 0; // Valid default price.
        }

        if (stock > 0) {
            this.stock = stock;
        } else {
            this.stock = 0; // Valid default .
        }
    }

    public String getName() {
        return name;
    }
    public boolean setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public double getPrice() {
        return price;
    }
    public boolean setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public int getStock() {
        return stock;
    }
    public boolean setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            return true;
        }
        return false;
    }
}
