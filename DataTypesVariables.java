
package datatypes.variables;

// @author User
 
public class DataTypesVariables {


     public static void main(String args[]) {
    System.out.println("========== BASIC ==========");
      // reference-type variable
    String fname = "Alexa Jewel Fernandez";
    
    // primitive-type variables
    int age = 19;
    double height = 5.4;
    char midinitial = 'C';
    boolean isEnrolled = true;

    // printing all values
    System.out.println("Full Name : " + fname);
    System.out.println("Age       : " + age);
    System.out.println("Height    : " + height);
    System.out.println("Initial   : " + midinitial);
    System.out.println("Enrolled  : " + isEnrolled + "\n"); // student status

    System.out.println("========== INTERMEDIATE ==========");
    // initialization and declaration
    String storeName = "Jewel & Zei's Fragrance";
    double unitPrice = 579.50;
    int quantity = 7;
    
    // totalCost should NOT be declared as an int because multiplying an integer quantity by a double unit price will result in a decimal value.
    double totalCost = unitPrice * quantity; 
    
    // print
    System.out.println("Store Name : " + storeName);
    System.out.println("Unit Price : " + unitPrice);
    System.out.println("Quantity   : " + quantity);
    System.out.println("Total Cost : " + totalCost + "\n");
    
    System.out.println("========== ADVAMCED ==========");
    // Declare a double value representing centimeters
    double totalCentimeters = 162.56;

    // Compute whole meters and remaining centimeters
    // Explicitly cast the division result to an int to get whole meters
    int wholeMeters = (int) (totalCentimeters / 100); 
    double remaining = totalCentimeters % 100;
        
    System.out.println("--- Centimeter Conversion ---");
    System.out.println("Centimeters          : " + totalCentimeters + " cm");
    System.out.println("Whole Meters         : " + wholeMeters + " meter ");
    System.out.println("Remaining Centimeters: " + remaining + " cm"); 
        
    // Implicit widening example (int to double)
    int intMeters = 5;
    /* No cast is needed because a double has a larger capacity than an int, 
    allowing the compiler to convert the value without losing data. */
    double doubleMeters = intMeters; 
    System.out.println("--- Implicit Widening ---");
    System.out.println("Int Value   : " + intMeters);
    System.out.println("Double Value: " + doubleMeters);
        
    // Explicit narrowing example (double to int)
    double exactValue = 172.78;
    /* An explicit cast is required because converting a double to an int 
    forces a larger data type into a smaller one, which the compiler won't do automatically.*/
    int truncatedValue = (int) exactValue; 
    System.out.println("--- Explicit Narrowing ---");
    System.out.println("Double Value: " + exactValue);
    System.out.println("Int Value   : " + truncatedValue + "\n");
    // The decimal part (.78) is truncated and completely lost.
    
    System.out.println("========== EXPERT ==========");
    // Byte Overflow Demonstration
    System.out.println("--- Byte Overflow ---");
    byte maxByte = 127; // Maximum value for 8-bit byte
    System.out.println("Max Byte: " + maxByte);

    maxByte++; // Incrementing past max value causes an overflow/wrap-around
    System.out.println("Overflow: " + maxByte);
    System.out.println();

    // String Comparison Demonstration
    System.out.println("--- String Comparisons ---");
    String str1 = new String("ziggy");
    String str2 = new String("ziggy");
    String str3 = "ziggy";

    // Comparing str1 and str2
    System.out.println("String 1 == String 2      : " + (str1 == str2));
    System.out.println("String 1.equals(String 2) : " + str1.equals(str2));
    // Comparing str1 and str3
    System.out.println("String 1 == String 3      : " + (str1 == str3));
    System.out.println("String 1.equals(String 3) : " + str1.equals(str3));
    // Comparing str2 and str3
    System.out.println("String 2 == String 3      : " + (str2 == str3));
    System.out.println("String 2.equals(String 3) : " + str2.equals(str3));
    System.out.println();

    // Shared Array Reference Demonstration
    System.out.println("--- Shared Array Reference ---");
    int[] array1 = {100, 200, 300};
    int[] array2 = array1; // Both variables refer to the same array.

    System.out.println("Before Modification : ");
    System.out.println("Array 1 [0] : " + array1[0]);
    System.out.println("Array 2 [0] : " + array2[0]);

    // Modify the first element using array2
    array2[0] = 79;

    System.out.println("\nAfter Modification : ");
    System.out.println("Array 1 [0] : " + array1[0]);
    System.out.println("Array 2 [0] : " + array2[0]);
    // Both show 79 because they refer to the same array.
    }
    
}

