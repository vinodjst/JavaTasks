package Assignment_Java.Banking_Demo;

import java.io.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {

    Scanner sc = new Scanner(System.in);

    public void manageAccounts() {

        System.out.println("Welcome to Bank");

        System.out.println("Choose Account type:");
        System.out.println("1.Savings Account");
        System.out.println("2.Current Account");

        int choice = sc.nextInt();
        switch (choice) {
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


       int accountNumber = getvalidationAccunt();
      String accountHolderName = getvalidateHoldername();
      double balance = getValidateBalance();
       double interestrate = getValidateinterestrate();


        SavingsAccount sa = new SavingsAccount();

        sa.setAccountNumber(accountNumber);
        sa.setAccountHolderName(accountHolderName);
        sa.setBalance(balance);
        sa.setInterestRate(interestrate);

       // sa.getAccountNumber(),sa.getAccountHolderName(),sa.getBalance(),sa.getInterestRate()

        String logs = sa.toString();
        System.out.println("changed to String"+logs);
        Filess(logs);
        System.out.println("--------------------------------------------");

        System.out.println("Account created successfully!");
        boolean flag = true;
        while (flag) {
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

    private double getValidateinterestrate() {
        double interestrate;
        while (true) {
            try {
                System.out.println("ENTER THE INTERESTRate");
                interestrate = sc.nextDouble();
                sc.nextLine();
                if (BankChecking.validation4(interestrate)) {
                    System.out.println("Validated....");
                    return interestrate;
                }


            } catch (Exception e) {
                System.out.println("re-enter it....");
                sc.nextLine();

            }



        }
    }
    private double getValidateBalance() {
        double balances;
        while (true) {
            try {
                System.out.println("Enter the balancess");
                balances = sc.nextDouble();
                sc.nextLine();
                if (BankChecking.validation3(balances)) {
                    System.out.println("validated...");
                    return balances;
                }

            } catch (Exception e) {
                System.out.println("re-enter it");
                sc.nextLine();


            }

        }
    }

    private String  getvalidateHoldername() {
        String Holdername;
        while (true) {
            try {
                System.out.println("Enter new  Holder name.....");
                Holdername = sc.next();
                sc.nextLine();
                if (BankChecking.Validation2(Holdername)) {
                    System.out.println("Holdername is validated");
                    return Holdername;
                }



            } catch (Exception e) {
                System.out.println("re-enter it....");
                sc.nextLine();

            }

        }
    }


    private int getvalidationAccunt() {
        int accountNumber;
        while (true) {
            try {
                System.out.println("Enter Account Number...");
                accountNumber = sc.nextInt();
                sc.nextLine();


                if (BankChecking.Validation1(accountNumber)) {
                    System.out.println("Account number is validated.");
                    return accountNumber;
                }
            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a valid integer for the account number.");
                sc.nextLine();
            }
        }
    }

    private void handleCurrentAccount() {

        int accountNumber = getvalidationAccunt();

        String accountHolderName = getvalidateHoldername();

        double balance =getValidateBalance();

        System.out.println("Enter Overdraft Limit:");
        double overdraftLimit = sc.nextDouble();

        CurrentAccount ca = new CurrentAccount();

        ca.setAccountNumber(accountNumber);
        ca.setAccountHolderName(accountHolderName);
        ca.setBalance(balance);
        ca.setOverdraftLimit(overdraftLimit);
        String logs = ca.toString();
        System.out.println("changed to String"+logs);
        Filess(logs);

        System.out.println("Account created successfully!");

        boolean flag = true;
        while (flag) {
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

    void Filess(String logs) {
        File file = new File("BankingLogs");
        try {
            if (file.createNewFile()) {
                System.out.println("file is create successfully.."+file.getAbsoluteFile());
            } else {
                System.out.println("File is already existing..."+file.getAbsoluteFile());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//            try{
//                FileInputStream Input = new FileInputStream(logs);
//                FileOutputStream output = new FileOutputStream(file);
//                int i;
//                try {
//                    while ((i = Input.read()) != -1) {
//                        output.write(i);
//                        output.newline();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            try (BufferedWriter Bff = new BufferedWriter(new FileWriter(file, true))) {
                Bff.write(logs);
                Bff.newLine();
            }
            catch (Exception e) {
                e.printStackTrace();
            }




}

public static void main(String[] args) {
        System.out.println("---------------Welcome Banking------------");
        Bank b = new Bank();
        b.manageAccounts();

    }
}
