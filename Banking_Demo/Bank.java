package Assignment_Java.Banking_Demo;

import java.util.Scanner;

public class Bank {

    Scanner sc = new Scanner(System.in);

    public void manageAccounts(){

        System.out.println("Welcome to Bank");

        System.out.println("Choose Account type:");
        System.out.println("1.Savings Account");
        System.out.println("2.Current Account");

        int choice = sc.nextInt();
        switch (choice){
            case 1:
                handleSavingsAccount();
                break;

            case 2:
                handleCurrentAccount();
                break;

            default:
                System.out.println("Invalid Choice!");
        }
    }


    private void handleSavingsAccount() {

        System.out.println("Enter Account Number:");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Account Holder Name:");
        String accountHolderName = sc.nextLine();

        System.out.println("Enter Initial Balance:");
        double balance = sc.nextDouble();

        System.out.println("Enter Interest Rate:");
        double interestRate = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount();

        sa.setAccountNumber(accountNumber);
        sa.setAccountHolderName(accountHolderName);
        sa.setBalance(balance);
        sa.setInterestRate(interestRate);

        System.out.println("Account created successfully!");
        boolean flag = true;
        while(flag) {
            System.out.println("Please choose your transaction: ");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Display details");
            System.out.println("4.Exit");


            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please Enter your deposit amount: ");
                    double deposit = sc.nextDouble();
                    sa.deposit(deposit);
                    break;

                case 2:
                    System.out.println("Please Enter your withdraw amount: ");
                    double withdraw = sc.nextDouble();
                    sa.withdraw(withdraw);
                    break;

                case 3:
                    System.out.println("Displaying details...");
                    sa.displayDetails();
                    break;

                case 4:
                    System.out.println("exiting....");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid input! \n Try Again");
                    break;

            }
        }
    }

    private void handleCurrentAccount() {

        System.out.println("Enter Account Number:");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Account Holder Name:");
        String accountHolderName = sc.nextLine();

        System.out.println("Enter Initial Balance:");
        double balance = sc.nextDouble();

        System.out.println("Enter Overdraft Limit:");
        double overdraftLimit = sc.nextDouble();

        CurrentAccount ca = new CurrentAccount();

        ca.setAccountNumber(accountNumber);
        ca.setAccountHolderName(accountHolderName);
        ca.setBalance(balance);
        ca.setOverdraftLimit (overdraftLimit);

        System.out.println("Account created successfully!");

        boolean flag = true;
        while(flag) {
            System.out.println("Please choose your transaction: ");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Display details");
            System.out.println("4.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please Enter your deposit amount: ");
                    double deposit = sc.nextDouble();
                    ca.deposit(deposit);
                    break;

                case 2:
                    System.out.println("Please Enter your withdraw amount: ");
                    double withdraw = sc.nextDouble();
                    ca.withdraw(withdraw);
                    break;

                case 3:
                    System.out.println("Displaying details...");
                    ca.displayDetails();
                    break;

                case 4:
                    System.out.println("exiting....");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid input! \n Try Again");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------Welcome Banking------------");
        Bank b = new Bank();
        b.manageAccounts();
    }
}
