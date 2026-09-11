package Talleres.Taller01.Ejercicio04;

public class TestVehicle {
    private static String validateLicensePlates(Vehicle vehicle, String testLicensePlate) {
        ValidationResult state = vehicle.setLicensePlate(testLicensePlate);
        
        String statusMesagge = switch(state) {
            case ACCEPTED_WITHOUT_CHANGES -> "Accepted without modifications.";
            case ACCEPTED_WITH_NORMALIZATION -> "Accepted with modifications.";
            case REJECTED -> "Rejected (The previus one is retained).";
        };

        return statusMesagge;
    }

    private static String evaluateChange(boolean accepted, String type, Object value, Object actual ) { 
        return String.format("Assignment of %s to %s = %s. Actual value = %s.", value, type, accepted ? "Accepted" : "Declined", actual);
    }

    private static void testAction(Vehicle vehicle, String action) {
    int previousSpeed = vehicle.getCurrentSpeed();
    
    if (action.equalsIgnoreCase("accelerate")) {
        vehicle.accelerate();
    } else if (action.equalsIgnoreCase("brake")) {
        vehicle.brake();
    }
    
    System.out.println(String.format("Action: %s = Went from %d to %d km/h", 
    action.toUpperCase(), previousSpeed, vehicle.getCurrentSpeed()));
}

    public static void main(String[] args) {
        System.out.println("\n||| VEHICLE TEST |||\n");
        Vehicle myVehicle = new Vehicle("Mercedes", "AEI-958",  190);

        //Loop to check brands.
        String[] brands = {"", "  ", "Ferrari", "BMW", "Toyota"};
        System.out.println("\n|| BRAND TESTS ||\n");
        for (String brand : brands) {
            boolean accepted = myVehicle.setBrand(brand);
            String assesment = evaluateChange(accepted, "Brand", brand, myVehicle.getBrand());
            System.out.println(assesment);
        }

        //Loop to check current speeds.
        System.out.println("\n|| CURRENT SPEED TESTS ||\n");
        int[] currentSpeeds = {-10, 20, 150, 210, 34, 22};
        for (int speed : currentSpeeds) {
            boolean accepted = myVehicle.setCurrentSpeed(speed, myVehicle.getMaximumSpeed());
            String assesment = evaluateChange(accepted, "Current Speed", speed, myVehicle.getCurrentSpeed());
            System.out.println(assesment);
        }

        //Loop to check maximum speeds.
        System.out.println("\n|| MAXIMUM SPEED TESTS ||\n");       

        int[] maximumSpeeds = {-20, 0, 80, 120, -1, 1};
        for (int maximumSpeed : maximumSpeeds) {
            boolean accepted = myVehicle.setMaximumSpeed(maximumSpeed);
            String assesment = evaluateChange(accepted, "Maximum Speed", maximumSpeed, myVehicle.getMaximumSpeed());
            System.out.println(assesment);
        }

        System.out.println("\n|| LICENSE PLATE TESTS ||\n");
        String[] plates = {"abc123", "XYZ789", "invalid", "DEF456", "ASDFAS123"};

        for (String plate : plates) {
            String resultMessage = validateLicensePlates(myVehicle, plate);
            System.out.println(String.format("Trying plate '%s' = %s Current plate: %s", 
            plate, resultMessage, myVehicle.getLicensePlate()));
        }

        myVehicle.setCurrentSpeed(0, myVehicle.getMaximumSpeed());
        System.out.println("\n|| ACTION TESTS ||\n");
        String[] actions = {"accelerate", "accelerate", "accelerate", "brake", "brake", "brake"};

        for (String action : actions) {
            testAction(myVehicle, action);
        }
    }
}
