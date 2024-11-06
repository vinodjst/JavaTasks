package Assignment_Java.Banking_Demo;

public class CurrentAccount extends Account{
    private double overdraftLimit;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(
                ", overdraftLimit=" + overdraftLimit);
    }

    /*
    public void displayDetails() {
        System.out.println("CurrentAccount{" +
                "accountNumber=" + getAccountNumber() +
                ", accountHolderName='" + getAccountHolderName() + '\'' +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                '}');
    }
    */
}
