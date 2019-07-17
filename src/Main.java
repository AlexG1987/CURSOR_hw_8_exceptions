import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Object obj1 = new Object();
        Object obj2 = null;
        try
                (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your word: ");
            String word = scanner.nextLine();
            DataServer.checkPalindrome(word);
            System.out.println("<================================================================================================>");
            System.out.println("Enter your number: ");
            int number = scanner.nextInt();
            DataServer.checkNumber(number);
            System.out.println("<================================================================================================>");
            scanner.nextLine();
            System.out.println("You have a two objects: obj1 and obj 2, which one you want to check if it's null (type 1 or 2)?");
            int choice = scanner.nextInt();
            if (choice == 1) {
                DataServer.checkObject(obj1);
            } else if (choice == 2) {
                DataServer.checkObject(obj2);
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
