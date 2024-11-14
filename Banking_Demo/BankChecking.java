package Assignment_Java.Banking_Demo;



public   class BankChecking {


    public static boolean Validation1(int accountNumber) {
        if(accountNumber != 0) {
            if (accountNumber == 123456789) {
                System.out.println("Account is correctly matched...");
                return  true;
            }
            else {
                alerts("Account number should be re-enetered in proper Format ,pleaseTry again");
            }
        }
        else{
            System.out.println("Input values Not be Zero");
        }
        return false;
    }

    static boolean Validation2(String Holdername) {

        if (Holdername.matches("[a-zA-Z]+") && !Holdername.isEmpty() && Holdername != null){
                Holdername.toUpperCase();
                System.out.println("regesterd Holdername " + Holdername);
               return  true;
            } else {
                alerts("Holder name Should be re-enter in proper Format, please Try again");
            }

        return false;

    }

    static boolean validation3(double balancesss) {
        char i =9;

            if (balancesss>0) {
                if (balancesss>= 100) {
                    System.out.println("Account Credited With Amount");
                    return true;
                } else {
                    alerts("Balance should be re-enter  in proper Format, please try again ");
                }

            } else {
                System.out.println("Balancess Should be in betweeen  123456789");
            }
        return false;
        }



    static boolean validation4 (double interestRate) {
        if (interestRate > 0 && interestRate <= 12) {
            System.out.println("interest rate is added successfully");
            return  true;
        } else {
            alerts("interest rate should be given properly");
        }
        return false;
    }
 private static void alerts(String message){
     System.out.println(message);


 }





    }


