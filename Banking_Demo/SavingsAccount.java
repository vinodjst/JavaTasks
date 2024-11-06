package Assignment_Java.Banking_Demo;

public class SavingsAccount extends Account{
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(
                ", interestRate=" + interestRate);
    }

    /*
    public void displayDetails() {
        System.out.println("SavingsAccount{" +
                "accountNumber=" + getAccountNumber() +
                ", accountHolderName='" + getAccountHolderName() + '\'' +
                ", balance=" + getBalance() +
                ", interestRate=" + interestRate +
                '}');
    }
    */
}
