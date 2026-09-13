package Talleres.Taller01.Ejercicio08;

public class TestElectronicWallet {
    //Creation of the record (I found out about this class while I was doing the workshop).
    private record WalletFuntionsTest(String action, int amount) {};
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

            if (stringType.equalsIgnoreCase("Owner")) {
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

        WalletFuntionsTest[] tests = {
            new WalletFuntionsTest("Payment", -20000),
            new WalletFuntionsTest("Top-up", -127500),
            new WalletFuntionsTest("Top-up", 25000),
            new WalletFuntionsTest("Top-up", 756550),
            new WalletFuntionsTest("Payment", 650000),
            new WalletFuntionsTest("Payment", 500000),
            new WalletFuntionsTest("Payment", 300000),
            new WalletFuntionsTest("Payment", -1500000)
        };
        System.out.println("\n|| ACTIONS TEST ||\n");
        for (WalletFuntionsTest test : tests) {
            if (test.action.equalsIgnoreCase("Payment")) {
                String resultMessage = evaluatePayment(myElectronicWallet, test.amount);
                System.out.println(resultMessage);
            } else {
                boolean accepted = myElectronicWallet.topUp(test.amount);
                String resultMessage = evaluateChange(accepted, "Balance", test.amount, myElectronicWallet.getBalance());
                System.out.println(resultMessage);
            }
        }
    }
}
