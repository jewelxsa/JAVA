package javaoperators;
// @author j.fernandez

public class JavaOperators {
    public static void main(String[] args) {
    System.out.println("========== BASIC ==========");
    
    int num1 = -39, num2 = 19;
    
    // arithmetic operations
    System.out.println("Number 1: "+ num1);
    System.out.println("Number 2: "+ num2);
    System.out.println("Addition Result      : " + (num1 + num2));
    System.out.println("Subtraction Result   : " + (num1 - num2));
    System.out.println("Multiplication Result: " + (num1 * num2));
    System.out.println("Division Result      : " + (num1 / num2));
    System.out.println("Modulo Result        : " + (num1 % num2)+ "\n"); 
    /* division and modulo are the operations that behave differently with negative
       operands. In Java, integer division truncates toward zero, and the
       sign of % follows the dividend (left operand).*/
    
    System.out.println("========== INTERMEDIATE ==========");
    
    //variables for a student's average grade and number of absences
    double average = 82.5;
    int absences = 2;
 
    // Passes if (average >= 75 AND absences <= 3) OR (average >= 90 regardless of absences)
    boolean isEligible = (average >= 75 && absences <= 3) || (average >= 90);

    // Print student details
    System.out.println("--- Student Evaluation ---");
    System.out.println("Average Grade : " + average);
    System.out.println("Absences      : " + absences);

    // Print a PASS/FAIL message and reasoning
    if (isEligible) {
        System.out.println("Result: PASSED" +"\n");
    } else {
        System.out.println("Result: FAILED" + "\n");   
    }
        
    System.out.println("========== ADVANCED ==========");  
    
    // Track balance growth over time
    double balance = 4000.00;

    System.out.println("Initial Balance          : " + balance);
    balance += 300.00;
    System.out.println("Balance after adding 300 : " + balance);
    balance *= 2.15;
    System.out.println("Balance after 20% growth : " + balance);
    balance += 700.00;
    System.out.println("Balance after adding 700 : " + balance + "\n");

    // Demonstrate postfix increment
    int count = 19;

    System.out.println("Postfix count++     : " + count++);
    System.out.println("Count after postfix : " + count);

    // Demonstrate prefix increment
    System.out.println("Prefix ++count      : " + (++count));
    System.out.println("Count after prefix  : " + count + "\n");
    // count++ prints the old value before incrementing.
    // ++count increments first, so it prints the new value.
    
    System.out.println("========== EXPERT ==========");  
    
    	int frst = 19, sec = 7, trd = 9;

        // PREDICTED: 33
        System.out.println("Expression 1: " +
                (frst++ * sec + --trd));

        int score = 5;
        int limit = 6;

        // PREDICTED: true
        System.out.println("Expression 2: " +
                (++score >= limit && score % 2 == 0));

        int number = 5;
        int value = 5;

        // PREDICTED: 14
	System.out.println("Expression 3: " + (number++ * 2 + --value) + "\n");
    
    }
    
}
