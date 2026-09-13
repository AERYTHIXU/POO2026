package Talleres.Taller01.Ejercicio08;

public class TestElectronicWallet {
    private static String evaluatePayment(ElectronicWallet electronicWallet, int amount) {
        PaymentStatus status = electronicWallet.payment(amount);
        String evaluationMessage = switch(status) {
            case ACCEPTED -> String.format("Payment of %d accepted. Actual balance = %d", amount, electronicWallet.getBalance());
            case INSUFFICIENT_FOUNDS -> String.format("Payment of %d rejected. (Insuficient founds.)", amount);
            case AMOUNT_TOO_LARGE -> String.format("Payment %d rejected. (amount exceeding 500000)", amount);
            case INVALID_AMOUNT -> String.format("Payment of %d rejected. (Amount less than or equal to 0)", amount);
        };
        return evaluationMessage;
    }

    private static String evaluateChange(boolean accepted, String type, Object value, Object actual ) { 
        return String.format("Assignment of %s to %s = %s. Actual value = %s.", value, type, accepted ? "Accepted" : "Declined", actual);
    }
    // Loop to check String values.
    private static void runTest(ElectronicWallet electronicWallet, String title, String[] values, String stringType) {
        System.out.println("\n" + title + "\n");
        for (String value : values) {
            boolean accepted = true;
            String actual = "";

            if (stringType.matches("Owner")) {
                accepted = electronicWallet.setOwner(value);
                actual = electronicWallet.getOwner();
            }
            
            String assessment = evaluateChange(accepted, stringType, value, actual);
            System.out.println(assessment);
        }
    }

    public static void main(String[] args) {
        ElectronicWallet myElectronicWallet = new ElectronicWallet("Cristian");
        
        String[] owner = {"", " ", "Juan", "Pedro", "Camilo"};
        runTest(myElectronicWallet, "OWNERS TEST", owner, "Owner");

        String[] actions = {"Payment", "Top-up", "Top-up", "Top-up", "Payment", "Payment", "Payment", "Payment"};
        int[] amounts = {-20000, -127500, 25000, 756550, 650000, 500000, 300000, -1500000};
        System.out.println("\n|| ACTIONS TEST ||\n");
        for (int i = 0; i < amounts.length; i++) {
            if (actions[i].matches("Payment")) {
                String resultMessage = evaluatePayment(myElectronicWallet, amounts[i]);
                System.out.println(resultMessage);
            } else {
                boolean accepted = myElectronicWallet.topUp(amounts[i]);
                String resultMessage = evaluateChange(accepted, "Balance", amounts[i], myElectronicWallet.getBalance());
                System.out.println(resultMessage);
            }
        }
    }
}
