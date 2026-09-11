package Talleres.Taller01.Ejercicio02;

public class TestProduct {

    // helper class to generate the string (Object is used because all data types inherit from this class).
    private static String evaluateChange(boolean accepted, String type, Object value, Object actual ) { 
        return String.format("Assignment of %s to %s = %s. Actual value = %s.", value, type, accepted ? "Accepted" : "Declined", actual);
    }
    public static void main(String[] args) {
        System.out.println("\n||| PRODUCT TEST |||\n");
        Product myProduct = new Product("", 2000000, 14);

        String[] testNames = {"", "Fridge", "Laptop", "Smartphone", "    ", "Microwave"};
        // Loop to check names.
        System.out.println("\n|| NAME TESTS ||\n");
        for (String name : testNames) {
            boolean accepted = myProduct.setName(name);
            String assessment = evaluateChange(accepted, "Name", name, myProduct.getName());
            System.out.println(assessment);
        }

        double[] testPrices = {-20000, 3799999.99, 5359599.89, -1, 1234, 458465};
        // Loop to check prices.
        System.out.println("\n|| PRICE TESTS ||\n");

        for (double price : testPrices) {
            boolean accepted = myProduct.setPrice(price);
            String assessment = evaluateChange(accepted, "Price", price, myProduct.getPrice());
            System.out.println(assessment);
        }

        int[] testStocks = {-50, 1000, 123456, 325896, -1111111, 65656565};
        // Loop to check stocks
        System.out.println("\n|| STOCK TESTS ||\n");

        for (int stock : testStocks) {
            boolean accepted = myProduct.setStock(stock);
            String assesment = evaluateChange(accepted, "Stock", stock, myProduct.getStock());
            System.out.println(assesment);
        }
    }
}
