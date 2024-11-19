package Assignment_Java.Banking_Demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {

    InputValidator inp = new InputValidator();

    Scanner sc = new Scanner(System.in);

    public void manageAccounts(){

        System.out.println("Welcome to Bank");

        System.out.println("Choose Account type:");
        System.out.println("1.Savings Account");
        System.out.println("2.Current Account");

        int choice = inp.getValidInputInt(sc);
        //System.out.println(choice);
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

    private boolean validateAccount(int accountNumber){
        Map<Integer, Integer> acc = new HashMap<>(){{
            put(12345678, 1234);
            put(12345679, 6738);
            put(12344678, 9321);
        }};

        int attempt = 0;
        if(acc.containsKey(accountNumber)){
            System.out.println("Account Found!");
            System.out.println("Please enter your password:");
            attempt = 1;
            while(attempt<=3) {
                int pass_acc = sc.nextInt();
                if (pass_acc == acc.get(accountNumber)) {
                    break;
                } else {
                    System.out.println("Invalid attempt!");
                    System.out.println("Only "+ (3-attempt)+ " attempts left.");
                    attempt++;
                    if(attempt>3){
                        System.err.println("Your account has been locked!");
                        System.exit(0);
                    }
                }
            }
        }
        if(attempt>=1 && attempt <= 3) {
            return true;
        }
        else{
            return false;
        }
    }

    private void handleSavingsAccount() {

        //InputValidator inp = new InputValidator();

        System.out.println("Enter Account Number:");
        int accountNumber = inp.getValidInputInt(sc);
        //sc.nextLine();

        if(validateAccount(accountNumber)){
            System.out.println("Login Successful!");
        }
        else {
            System.err.println("Account not found!");
            System.out.println("Please fill out the details to create an account");
            System.out.println("Enter Account Holder Name:");
            String accountHolderName = inp.getValidInputString(sc);

            System.out.println("Enter Initial Balance:");
            double balance = inp.getValidInputDouble(sc);

            System.out.println("Enter Interest Rate:");
            double interestRate = inp.getValidInputDouble(sc);

            SavingsAccount sa = new SavingsAccount();

            sa.setAccountNumber(accountNumber);
            sa.setAccountHolderName(accountHolderName);
            sa.setBalance(balance);
            sa.setInterestRate(interestRate);

            appendToFile(sa.toString());

            System.out.println("Account created successfully!");
            boolean flag = true;
            while (flag) {
                System.out.println("Please choose your transaction: ");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Display details");
                System.out.println("4.Exit");


                int choice = inp.getValidInputInt(sc);

                switch (choice) {
                    case 1:
                        System.out.println("Please Enter your deposit amount: ");
                        double deposit = inp.getValidInputDouble(sc);
                        sa.deposit(deposit);
                        break;

                    case 2:
                        System.out.println("Please Enter your withdraw amount: ");
                        double withdraw = inp.getValidInputDouble(sc);
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
    }

    private void handleCurrentAccount() {

        //InputValidator inp = new InputValidator();

        System.out.println("Enter Account Number:");
        int accountNumber = inp.getValidInputInt(sc);
        sc.nextLine();

        if(validateAccount(accountNumber)){
            System.out.println("Login Successful!");
        }
        else {
            System.err.println("Account not found!");
            System.out.println("Please fill out the details to create an account");
            System.out.println("Enter Account Holder Name:");
            String accountHolderName = inp.getValidInputString(sc);

            System.out.println("Enter Initial Balance:");
            double balance = inp.getValidInputDouble(sc);

            System.out.println("Enter Overdraft Limit:");
            double overdraftLimit = inp.getValidInputDouble(sc);

            CurrentAccount ca = new CurrentAccount();

            ca.setAccountNumber(accountNumber);
            ca.setAccountHolderName(accountHolderName);
            ca.setBalance(balance);
            ca.setOverdraftLimit(overdraftLimit);

            appendToFile(ca.toString());

            //appendToFile("Account Number : "+ accountNumber+ " Account Holder Name : "+accountHolderName+ " Balance : "+balance+" Overdraft Limit : "+overdraftLimit);

            System.out.println("Account created successfully!");

            boolean flag = true;
            while (flag) {
                System.out.println("Please choose your transaction: ");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Display details");
                System.out.println("4.Exit");

                int choice = inp.getValidInputInt(sc);

                switch (choice) {
                    case 1:
                        System.out.println("Please Enter your deposit amount: ");
                        double deposit = inp.getValidInputDouble(sc);
                        ca.deposit(deposit);
                        break;

                    case 2:
                        System.out.println("Please Enter your withdraw amount: ");
                        double withdraw = inp.getValidInputDouble(sc);
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
    }

    private static void appendToFile(String text){
        try {
            FileWriter fw = new FileWriter("UserInputs_Test.txt", true);
            fw.write(text+System.lineSeparator());
            fw.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------Welcome Banking------------");
        Bank b = new Bank();
        b.manageAccounts();
    }
}
