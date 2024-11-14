package Assignment_Java.Banking_Demo;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputValidator {

    public String getValidInputString(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        String input;

        while(true){
            try {
                input = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid string value.");
                sc.next();
            }
        }

        //sc.close();

        return input;
    }

    public int getValidInputInt(Scanner sc){
        //Scanner scanner = new Scanner(System.in);
        int input=0;

        while(true){
            try {
                input = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                sc.next();
            }
        }

        //sc.close();

        return input;
    }

    public double getValidInputDouble(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        double input=0;

        while(true){
            try {
                input = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double value.");
                sc.next();
            }
        }

        //sc.close();

        return input;
    }

}
