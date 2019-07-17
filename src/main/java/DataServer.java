package main.java;

import main.java.exceptions.OwnMoreThanHundredException;
import main.java.exceptions.OwnNullObjectException;
import main.java.exceptions.OwnOddException;
import main.java.exceptions.OwnPalindromeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

class DataServer {

    static void checkPalindrome(String s) throws OwnPalindromeException {
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            System.out.println("Word" + s + " is a palindrome");
        } else {
            throw new OwnPalindromeException("Entered word " + s + " isn't a palindrome!");
        }
    }

    static void checkNumber(Integer n) throws OwnMoreThanHundredException, OwnOddException {
        if (n > 100) {
            throw new OwnMoreThanHundredException("Entered number is greater than 100!");
        } else if (n % 2 == 0) {
            System.out.println("Entered number is even!");
        } else {
            throw new OwnOddException("Entered number is odd");
        }
    }

    static void checkObject(Object object) throws OwnNullObjectException {
        if (Optional.ofNullable(object).isEmpty()) {
            throw new OwnNullObjectException("Entered object is null");
        } else {
            System.out.println("Entered object is not null. Object type is: " + object.getClass());
        }
    }

    static void stackOverflowError(int i) {
        System.out.println("Number: " + i);
        if (i == 0)
            System.out.println("Good choice! No stackOverflowError!");
        else
            stackOverflowError(++i);
    }

    static void outOfMemoryError(String shure) {
        if (shure.equals("Yes")) {
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            while (true)
                list.add(random.nextInt());
        } else if (shure.equals("No")) System.out.println("Good choice! No outOfMemoryError");
        else {
            System.out.println("Enter your answer again ('Yes' or 'No')");
        }
    }

}
