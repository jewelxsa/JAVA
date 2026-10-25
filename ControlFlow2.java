package controlflow2;
import java.util.Scanner;

//@author j.fernandez
 
public class ControlFlow2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========== BASIC ==========");
        // Change limit to 20 to confirm the output updates
        int limit = 10;

        for (int i = 1; i <= limit; i++) {
            System.out.println("Number: " + i + " | Square: " + (i * i));
        }
        
        System.out.println("\n========== INTERMEDIATE ==========");
        int total = 0;

        System.out.print("Enter an integer (-1 to stop): ");
        int number = input.nextInt();

        while (number != -1) {          // stops the instant -1 is entered
            total += number;            // -1 is never added
            System.out.print("Enter an integer (-1 to stop): ");
            number = input.nextInt();
        }
        System.out.println("Final total: " + total);

        System.out.println("\n========== ADVANCED ==========");
        int size = 5;          // size of the right triangle
        int skipRow = 3;       // row to skip entirely
        int stopColumn = 4;    // inner loop stops after this column

        for (int row = 1; row <= size; row++) {

            if (row == skipRow) {
                continue;               // CONTINUE: skips printing row 3 entirely
            }

            for (int col = 1; col <= row; col++) {

                if (col > stopColumn) {
                    break;              // BREAK: stops the INNER loop early past column 4
                }

                System.out.print(col + " ");
            }
            System.out.println();
        }


        System.out.println("\n========== EXPERT ==========");
        // Warehouse: rows = aisles, columns = shelves. -1 = damaged shelf.
        int[][] warehouse = {
            {20, 15, -1, 30},
            { 8,  3, 25, 12},
            {40, -1,  2, 18}
        };
        int criticalLevel = 5;   // a shelf below this count is "critically low"
        int choice;

        do {
            System.out.println("\n--- WAREHOUSE MENU ---");
            System.out.println("1. View warehouse");
            System.out.println("2. Total inventory");
            System.out.println("3. Find first critically low shelf");
            System.out.println("4. Restock a shelf");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    for (int r = 0; r < warehouse.length; r++) {
                        System.out.print("Aisle " + (r + 1) + ": ");
                        for (int c = 0; c < warehouse[r].length; c++) {
                            if (warehouse[r][c] == -1) {
                                System.out.print("[DAMAGED] ");
                            } else {
                                System.out.print("[" + warehouse[r][c] + "] ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    int inventoryTotal = 0;
                    for (int r = 0; r < warehouse.length; r++) {
                        for (int c = 0; c < warehouse[r].length; c++) {
                            if (warehouse[r][c] == -1) {
                                continue;       // CONTINUE: skip damaged shelves
                            }
                            inventoryTotal += warehouse[r][c];
                        }
                    }
                    System.out.println("Total inventory (damaged shelves skipped): " + inventoryTotal);
                    break;

                case 3:
                    boolean found = false;
                    for (int r = 0; r < warehouse.length; r++) {
                        for (int c = 0; c < warehouse[r].length; c++) {
                            if (warehouse[r][c] != -1 && warehouse[r][c] < criticalLevel) {
                                System.out.println("First critically low shelf: Aisle " + (r + 1)
                                        + ", Shelf " + (c + 1) + " (" + warehouse[r][c] + " items)");
                                found = true;
                                break;          // BREAK: leave inner loop
                            }
                        }
                        if (found) {
                            break;              // BREAK: leave outer loop
                        }
                    }
                    if (!found) {
                        System.out.println("No critically low shelves.");
                    }
                    break;

                case 4:
                    restock(input, warehouse);
                    break;

                case 5:
                    System.out.println("Exiting inventory system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
                    break;
            }

        } while (choice != 5);

        input.close();
    }

    // Restocking: while loop with input validation, and return to leave the method.
    // (return needs a method, so this is the only place a separate method is used.)
    static void restock(Scanner input, int[][] warehouse) {
        while (true) {
            System.out.print("Aisle number (1-" + warehouse.length + ", 0 to cancel): ");
            int aisle = input.nextInt();
            if (aisle == 0) {
                System.out.println("Restock cancelled.");
                return;                         // RETURN: cancel and leave the method
            }

            System.out.print("Shelf number (1-" + warehouse[0].length + "): ");
            int shelf = input.nextInt();

            if (aisle < 1 || aisle > warehouse.length || shelf < 1 || shelf > warehouse[0].length) {
                System.out.println("Invalid aisle or shelf. Try again.");
                continue;
            }
            if (warehouse[aisle - 1][shelf - 1] == -1) {
                System.out.println("That shelf is damaged and cannot be restocked. Try again.");
                continue;
            }

            System.out.print("Quantity to add: ");
            int amount = input.nextInt();
            if (amount <= 0) {
                System.out.println("Quantity must be greater than zero. Try again.");
                continue;
            }

            warehouse[aisle - 1][shelf - 1] += amount;
            System.out.println("Restocked Aisle " + aisle + ", Shelf " + shelf
                    + ". New count: " + warehouse[aisle - 1][shelf - 1]);
            return;                             // RETURN: restock done, leave the method
        }
    }
}