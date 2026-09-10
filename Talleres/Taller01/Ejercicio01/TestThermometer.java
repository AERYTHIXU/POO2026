package Talleres.Taller01.Ejercicio01;

public class TestThermometer {
    public static void main(String[] args) {
        System.out.print("\n|||THERMOMETER TEST|||\n");

        Thermometer myThermometer = new Thermometer(28.5);
        System.out.printf("\nInitial temperature registered: %.2f°C.%n", myThermometer.getTemperature());
        System.out.println();
        double[] testValues = {20, -50, 72.35, 100, -51, 105.5, 0};

        for (double value : testValues) {
            boolean validTemperature = myThermometer.setTemperature(value);
            if (validTemperature) {
                System.out.printf("[SUCCES!] The value %.2f°C was accepted, the current temperature is: %.2f°C.%n", value, myThermometer.getTemperature());
            } else {
                System.out.printf("[ERROR!] The value %.2f°C was not accepted, the current temperature is: %.2f°C.%n", value, myThermometer.getTemperature());
            }
        }
    }
}
