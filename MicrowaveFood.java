import java.util.Scanner;
/**
 * This program calculates the time needed to heat food.
 *
 * @author  Marlon Poddalgoda
 * @version 1.0
 * @since 2021-04-26
 */

public final class MicrowaveFood {
    private MicrowaveFood() {

        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }
    /**
    * This method calculates the time needed to heat food.
    * @param args
    */
    public static void main(final String[] args) {

        // Create new Scanner-type variable
        Scanner foodInput = new Scanner(System.in);
        Scanner numInput = new Scanner(System.in);

        // Constants
        final float zeroPercentIncrease = 1f;
        final float fiftyPercentIncrease = 1.5f;
        final float hundredPercentIncrease = 2f;
        final float subTime = 1f;
        final float pizzaTime = 0.75f;
        final float soupTime = 1.75f;
        final float sixtySeconds = 60f;
        // style checker wanted these as constants
        final int one = 1;
        final int two = 2;
        final int three = 3;

        // Variables
        float cookTime = 0f;
        float cookSeconds = 0f;
        int numOfItems = 0;

        System.out.println("This microwave program calculates the total time"
            + " needed to heat up certain foods.");
        System.out.println();

        // Asks user to enter one of several choices
        System.out.print("Are you heating a sub, pizza or soup: ");

        while (true) {
            // food item input
            String foodItem = foodInput.nextLine();

            if (foodItem.equals("sub")) {
                // Assigning cooktime for sub
                cookTime = subTime;
            } else if (foodItem.equals("pizza")) {
                // Assigning cooktime for pizza
                cookTime = pizzaTime;
            } else if (foodItem.equals("soup")) {
                // Assigning cooktime for soup
                cookTime = soupTime;
            } else {
                // error catch
                System.out.println("That's not an option! Try again.");
                System.out.print("Are you heating a sub, pizza or soup: ");
                continue;
            }

            // number of items input
            while (true) {

                System.out.print("Enter how many " + foodItem
                                + "(s) you are heating (max. 3): ");

                // check if input is an integer
                while (!numInput.hasNextInt()) {
                    System.out.println("That's not a valid number!");
                    System.out.print("Enter how many " + foodItem
                                    + "(s) you are heating (max. 3): ");
                    numInput.next(); // moves scanner until correct value
                }
                numOfItems = numInput.nextInt();

                // process
                if (numOfItems == one) {
                    // assigning cooktime for 1 item
                    cookTime = cookTime * zeroPercentIncrease;
                } else if (numOfItems == two) {
                    // assigning cooktime for 2 items
                    cookTime = cookTime * fiftyPercentIncrease;
                } else if (numOfItems == three) {
                    // assigning cooktime for 3 items
                    cookTime = cookTime * hundredPercentIncrease;
                } else {
                    System.out.println("That's not an option! Try again.");
                    continue;
                }
                // calculate how many seconds
                cookSeconds = cookTime * sixtySeconds;
                break;
            }
            // output
            System.out.println("");
            System.out.println("The total cook time to is " + cookTime
                                + " minutes (" + cookSeconds + " seconds).");
            System.out.println("");
            System.out.println("Done.");
            break;
        }
    }
}
