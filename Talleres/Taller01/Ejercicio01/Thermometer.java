package Talleres.Taller01.Ejercicio01;

public class Thermometer {
    private double temperature;

    public Thermometer(double initialTemperature) {
        if(!setTemperature(initialTemperature)) {
            this.temperature = 0; // Valid default temperature.
        }
    }

    public boolean setTemperature(double newTemperature) {
        if (newTemperature >= -50 && newTemperature <= 100) {
            this.temperature = newTemperature;
            return true;
        }
        return false;
    }

    public double getTemperature() {
        return this.temperature;
    }
}
