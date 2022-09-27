/*
*
* This is a standard boardFoot program
* that calculates the length required.
*
* @author  Jackson Naufal
* @version 1.0
* @since   2020-09-26
*
* This is a boardFoot length program
*/

import java.util.Scanner;
/**
 * This is a boardFoot program.
 */

final class BoardFoot {

    /**
     * Board length constant number.
     */
    public static final double BOARD = 144.0;
    /**
     * The minimun number.
     */
    public static final double MIN = 0;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */

    private BoardFoot() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Calculates the length.
     *
     * @param width width of board
     * @param height height of board
     * @return returns length of board
     */

    public static double boardFoot(
                final double width, final double height) {
        final double userLength = Math.round(BOARD / (width * height));
        return userLength;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */

    public static void main(final String[] args) {

        // identifying the changing variables.
        // randomNumber, counter
        final Scanner firstInput = new Scanner(System.in);
        final Scanner secondInput = new Scanner(System.in);

        // try and catch for invalid or valid inputs.
        try {
            // This is where the user makes their inputs.
            System.out.print("Enter your width: ");
            final double userWidth = firstInput.nextDouble();
            System.out.print("Enter your height: ");
            final double userHeight = secondInput.nextDouble();

            // goes through ifs to see if the input equals any
            // of these scenario, if not the proccess of the program
            // will get the information from the return in the function
            // boardFoot, and tell the user what the length is.
            if (userWidth <= MIN || userHeight < MIN) {
                System.out.println("Invalid Number!");
            } else {
                final double userLength = boardFoot(userWidth, userHeight);
                System.out.println("\n Your length is " + userLength
                    + " inch(es) long.");
            }
            // This catches invalid inputs.
        } catch (java.util.InputMismatchException ex) {
            System.out.println("Invalid Input!");
        }
        System.out.println("\nDone!");
    }
}

