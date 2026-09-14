package Talleres.Taller01.Ejercicio04;

public class Vehicle {
    private String brand;
    private String licensePlate;
    private int currentSpeed;
    private int maximumSpeed;
    
    
    public Vehicle(String brand, String licensePlate, int maximumSpeed) {
        if (!setBrand(brand)) { this.brand = "Unknown"; }
        if (setLicensePlate(licensePlate) == ValidationResult.REJECTED) {this.licensePlate = "AAA000"; }
        if (!setMaximumSpeed(maximumSpeed)) { this.maximumSpeed = 0; }
        this.currentSpeed = 0;
    }

    public boolean setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand.trim();
            return true;
        }
        return false;
    }
    
    public ValidationResult setLicensePlate(String licensePlate) {
        if (licensePlate == null || !licensePlate.trim().matches("(?i)^[a-zA-Z]{3}[0-9]{3}$")) {
            return ValidationResult.REJECTED;
        }

        String normalized = licensePlate.toUpperCase();

        if (licensePlate.equals(normalized)) {
            this.licensePlate = licensePlate;
            return ValidationResult.ACCEPTED_WITHOUT_CHANGES;
        } else {
            this.licensePlate = normalized;
            return  ValidationResult.ACCEPTED_WITH_NORMALIZATION;
        }
    }
    
    public boolean setCurrentSpeed(int currentSpeed) {
        if (currentSpeed >= 0 && currentSpeed <= this.maximumSpeed) {
            this.currentSpeed = currentSpeed;
            return true;
        }
        return false;
    }

    public boolean setMaximumSpeed(int maximumSpeed) {
        if (maximumSpeed > 0 && maximumSpeed >= this.currentSpeed) {
            this.maximumSpeed = maximumSpeed;
            return true;
        }
        return false;
    }

    public void accelerate() {
        if (this.currentSpeed + 10 <= this.maximumSpeed) {
            this.currentSpeed += 10;
        } else {
            this.currentSpeed = maximumSpeed;
        }
    }

    public void brake() {
        if (this.currentSpeed - 10 >= 0) {
            this.currentSpeed -= 10;
        } else {
            this.currentSpeed = 0;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }
}
