package Talleres.Taller01.Ejercicio08;

public class ElectronicWallet {
    private String owner;
    private int balance;

    public ElectronicWallet(String owner) {
        if (!setOwner(owner)) { this.owner = "Unkwown"; }
        this.balance = 0;
    }

    public boolean setOwner(String owner) {
        if (owner != null && !owner.trim().isEmpty()) {
            this.owner = owner.trim();
            return true;
        }
        return false;
    }
    
    public boolean topUp(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public PaymentStatus payment(int amount) {
        if (amount <= 0) { return PaymentStatus.INVALID_AMOUNT; }
        else if (amount > 500000) { return PaymentStatus.AMOUNT_TOO_LARGE; }
        else if (amount > this.balance) { return PaymentStatus.INSUFFICIENT_FUNDS; }
        else {
            this.balance -= amount;
        }
        return PaymentStatus.ACCEPTED;

    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }
}
