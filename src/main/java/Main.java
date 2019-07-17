package main.java;

import main.java.exceptions.OwnMoreThanHundredException;
import main.java.exceptions.OwnNullObjectException;
import main.java.exceptions.OwnOddException;
import main.java.exceptions.OwnPalindromeException;

import java.util.Scanner;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = null;
        try
                (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your word: ");
            String word = scanner.next(Pattern.compile("^[a-zA-Z]+$"));
            try {
                DataServer.checkPalindrome(word);
            } catch (OwnPalindromeException e) {
                e.printStackTrace();
            }
            System.out.println("<================================================================================================>");
            scanner.nextLine();
            System.out.println("Enter your number: ");
            int number = scanner.nextInt();
            try {
                DataServer.checkNumber(number);
            } catch (OwnMoreThanHundredException | OwnOddException e) {
                e.printStackTrace();
            }
            System.out.println("<================================================================================================>");
            scanner.nextLine();
            System.out.println("You have a two objects: obj1 and obj 2, which one you want to check if it's a null (type 1 or 2)?");
            int choice = scanner.nextInt();
            try {
                if (choice == 1) {
                    DataServer.checkObject(obj1);
                } else if (choice == 2) {
                    DataServer.checkObject(obj2);
                }
            }catch (OwnNullObjectException e){
                e.printStackTrace();
            }
            System.out.println("<================================================================================================>");
            scanner.nextLine();
            System.out.println("Do you want to call OutOfMemoryError ('Yes' or 'No')?");
            String answer = scanner.nextLine();
            DataServer.outOfMemoryError(answer);
            System.out.println("<================================================================================================>");
            System.out.println("Do you want to call OutOfMemoryError (if 'Yes' enter any number, if 'No' enter 0)");
            int oops = scanner.nextInt();
            DataServer.stackOverflowError(oops);
        }
    }
}
