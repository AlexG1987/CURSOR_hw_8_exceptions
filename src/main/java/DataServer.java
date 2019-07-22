package main.java;

import main.java.exceptions.OwnMoreThanHundredException;
import main.java.exceptions.OwnNullObjectException;
import main.java.exceptions.OwnOddException;
import main.java.exceptions.OwnPalindromeException;

import java.util.*;
import java.util.regex.Pattern;

class DataServer {

    static void checkPalindrome() throws OwnPalindromeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String s = scanner.next(Pattern.compile("^[a-zA-Z]+$"));
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            System.out.println("Word " + s + " is a palindrome");
        } else {
            throw new OwnPalindromeException("Entered word " + s + " isn't a palindrome!");
        }
    }

    static void checkNumber() throws OwnMoreThanHundredException, OwnOddException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int n = 1;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (n > 100) {
            throw new OwnMoreThanHundredException("Entered number is greater than 100!");
        } else if (n % 2 == 0) {
            System.out.println("Entered number is even!");
        } else {
            throw new OwnOddException("Entered number is odd");
        }
    }

    static void chooseObjectCheck() {
        Object obj1 = new Object();
        Object obj2 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of object to check (1/2): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            try {
                DataServer.checkObject(obj1);
            } catch (OwnNullObjectException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            try {
                DataServer.checkObject(obj2);
            } catch (OwnNullObjectException e) {
                e.printStackTrace();
            }
        }
    }

    static void checkObject(Object object) throws OwnNullObjectException {
        if (Optional.ofNullable(object).isEmpty()) {
            throw new OwnNullObjectException("Entered object is null");
        } else {
            System.out.println("Entered object is not null. Object type is: " + object.getClass());
        }
    }

    static void dontDoThat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to call OutOfMemoryError ('Yes' or 'No')?");
        String answer = scanner.nextLine();
        answer.toLowerCase();
        DataServer.outOfMemoryError(answer);
        System.out.println("Do you want to call StackOverflowError ('1' or '0')?");
        int oops = scanner.nextInt();
        DataServer.stackOverflowError(oops);
    }


    static void stackOverflowError(int i) {
        if (i == 0) {
            System.out.println("Good choice! No stackOverflowError!");
        } else if (i == 1) {
            stackOverflowError(++i);
        } else {
            System.out.println("You entered incorrect data!");
        }
    }

    static void outOfMemoryError(String shure) {
        if (shure.equals("yes")) {
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            while (true)
                list.add(random.nextInt());
        } else if (shure.equals("no")) {
            System.out.println("Good choice! No outOfMemoryError");
        }
    }

}
