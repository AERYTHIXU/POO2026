package Talleres.Taller01.Ejercicio04;

public class TestVehicle {
    private static String evaluateChange(boolean accepted, String type, Object value, Object actual ) { 
        return String.format("Assignment of %s to %s = %s. Actual value = %s.", value, type, accepted ? "Accepted" : "Declined", actual);
    }

    private static String evaluateLicensePlates(Vehicle vehicle, String testLicensePlate) {
        ValidationResult state = vehicle.setLicensePlate(testLicensePlate);
        
        String evaluationMesagge = switch(state) {
            case ACCEPTED_WITHOUT_CHANGES -> "Accepted without modifications.";
            case ACCEPTED_WITH_NORMALIZATION -> "Accepted with modifications.";
            case REJECTED -> "Rejected (The previus one is retained).";
        };
        return evaluationMesagge;
    }
    private static void testAction(Vehicle vehicle, String action) {
    int previousSpeed = vehicle.getCurrentSpeed();
    
    if (action.equalsIgnoreCase("accelerate")) {
        vehicle.accelerate();
    } else if (action.equalsIgnoreCase("brake")) {
        vehicle.brake();
    }
    
    System.out.printf("%nAction: %s = Went from %d to %d km/h", 
    action.toUpperCase(), previousSpeed, vehicle.getCurrentSpeed());
    }

    // Loop to check string values.
    private static void runTest(Vehicle vehicle, String title, String[] values, String stringType) {
        System.out.println("\n|| " + title + " ||\n");
        for (String brand : values) {
            boolean accepted = vehicle.setBrand(brand);
            String assesment = evaluateChange(accepted, stringType, brand, vehicle.getBrand());
            System.out.println(assesment);
        }
    }
    
    // Loop to check speed values.
    private static void runTest(Vehicle vehicle, String title, int[] values, String speedType) {
        System.out.println("\n|| " + title + " +||\n");
        for (int value : values) {
            boolean accepted;
            Object actual;
            
            if (speedType.equalsIgnoreCase("Current")) {
                accepted = vehicle.setCurrentSpeed(value);
                actual = vehicle.getCurrentSpeed();
            } else {
                accepted = vehicle.setMaximumSpeed(value);
                actual = vehicle.getMaximumSpeed();
            }
            
            String assessment = evaluateChange(accepted, speedType + " Speed", value, actual);
            System.out.println(assessment);
        }
    }

    public static void main(String[] args) {
        int maximumSpeed = 190;
        System.out.println("\n||| VEHICLE TEST |||\n");
        Vehicle myVehicle = new Vehicle("Mercedes", "AEI-958",  maximumSpeed);

        String[] brands = {"", "  ", "Ferrari", "BMW", "Toyota"};
        runTest(myVehicle, "BRANDS TEST", brands, "Brand");

        int[] currentSpeeds = {-50, 45, 39, 125, 5000, 61312};
        runTest(myVehicle, "CURRENT SPEEDS TEST", currentSpeeds, "Current");

        int[] maximumSpeeds = {-20, 0, 80, 120, -1, 1};
        runTest(myVehicle, "MAXIMUM SPEED TEST", maximumSpeeds, "Maximum");

        String[] plates = {"abc123", "XYZ789", "invalid", "DEF456", "ASDFAS123"};
        System.out.println("\n||| LICENSE PLATES TEST |||\n");
        for (String plate : plates) {
            String resultMessage = evaluateLicensePlates(myVehicle, plate);
            System.out.printf("Trying plate %s = %s Actual plate = %s%n", plate, resultMessage, myVehicle.getLicensePlate());
        }

        myVehicle.setCurrentSpeed(0);
        myVehicle.setMaximumSpeed(maximumSpeed);
        String[] actions = {"accelerate", "accelerate", "accelerate", "brake", "brake", "brake"};
        System.out.println("\n||| ACTIONS TEST |||\n");
        for (String action : actions) {
            testAction(myVehicle, action);
        }
    }
}
