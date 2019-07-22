package main.java;

import main.java.exceptions.OwnMoreThanHundredException;
import main.java.exceptions.OwnOddException;
import main.java.exceptions.OwnPalindromeException;

class Main {

    public static void main(String[] args) {
        try {
            DataServer.checkPalindrome();
        } catch (OwnPalindromeException e) {
            e.printStackTrace();
        }
        try {
            DataServer.checkNumber();
        } catch (OwnMoreThanHundredException | OwnOddException e) {
            e.printStackTrace();
        }
        DataServer.chooseObjectCheck();
        DataServer.dontDoThat();
    }
}
