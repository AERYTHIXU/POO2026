package Talleres.Taller01.Ejercicio02;


public class Product {
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        if (!setName(name)) {
            this.name = "Unknown"; // Valid default name.
        }

        if (!setPrice(price)) {
            this.price = 0; // Valid default price.
        }

        if (!setStock(stock)) {
            this.stock = 0; // Valid default stock.
        }
    }

    public boolean setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public boolean setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public boolean setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
