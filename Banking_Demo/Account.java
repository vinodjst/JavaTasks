package Assignment_Java.Banking_Demo;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        //System.out.println("Deposit Successful!");
    }

    public void withdraw(double amount){
        if(amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw Successful!");
            System.out.println("Current balance is ::: "+getBalance());

        }
        else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayDetails(){
        System.out.print(
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance
                );
    }

    /*
    public void displayDetails(){
        System.out.println("Account{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}');
    }*/

}
