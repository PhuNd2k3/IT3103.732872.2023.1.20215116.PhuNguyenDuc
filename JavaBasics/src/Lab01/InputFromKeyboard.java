package Lab01;

// Exercise 6.2
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("PhuNd 215116 ask you: What's your name?");
        String strName = keyboard.nextLine();

        System.out.println("PhuNd 215116 ask you: How old are you?");

        int iAge = keyboard.nextInt();
        System.out.println("PhuNd 215116 ask you: How tall are you (m)?");

        double dHeight = keyboard.nextDouble();

        // similar to other data types
        // nextByte(), nextShort(), nextLong()
        // nextFloat(), nextBoolean()

        System.out.println("PhuNd 215116 return to you: Mrs/Ms. " + strName + ", " + iAge + " year old. "
                + "Your height is " + dHeight + ".");
        keyboard.close();
    }
}
