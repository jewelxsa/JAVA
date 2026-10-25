package controlflow1;

 // @author j.fernandez
 
public class ControlFlow1 {

    public static void main(String[] args) {

        System.out.println("========== BASIC ==========");
        // Test values to try: 79, 50
        int score = 75;

        if (score >= 60) {
            System.out.println("Score " + score + ": PASSED");
        } else {
            System.out.println("Score " + score + ": FAILED");
        }
        int score2 = 50;

        if (score2 >= 60) {
            System.out.println("Score " + score2 + ": PASSED");
        } else {
            System.out.println("Score " + score2 + ": FAILED");
        }

        System.out.println("\n========== INTERMEDIATE ==========");
        
        double purchaseAmount = 600.00;
        double discountPercent;
        String discountTier;

        // Ordered from highest to lowest so no tier is unreachable
        if (purchaseAmount >= 1000) {
            discountPercent = 15;
            discountTier = "Platinum";
        } else if (purchaseAmount >= 500) {
            discountPercent = 10;
            discountTier = "Gold";
        } else if (purchaseAmount >= 100) {
            discountPercent = 5;
            discountTier = "Silver";
        } else {
            discountPercent = 0;
            discountTier = "Standard";
        }

        double finalPrice = purchaseAmount - (purchaseAmount * discountPercent / 100);
        System.out.println("Purchase amount: $" + purchaseAmount);
        System.out.println("Discount tier: " + discountTier + " (" + discountPercent + "% off)");
        System.out.println("Final price: $" + finalPrice);

        System.out.println("\n========== ADVANCED ==========");
        // Correct login: "Jewel Fernandez" / "jewelandzei" / locked = false
        // Test failures by changing one value at a time:
        //   loginUser = "stranger"  -> fails stage 1
        //   loginPass = "wrong"     -> fails stage 2
        //   accountLocked = true    -> fails stage 3
        String loginUser = "Jewel Fernandez";
        String loginPass = "jewelandzei";
        boolean accountLocked = false;

        if (loginUser.equals("Jewel Fernandez")) {
            if (loginPass.equals("jewelandzei")) {
                if (!accountLocked) {
                    System.out.println("SUCCESS - Welcome, " + loginUser + "!");
                } else {
                    System.out.println("FAILED at stage 3 - Account is locked.");
                }
            } else {
                System.out.println("FAILED at stage 2 - Incorrect password.");
            }
        } else {
            System.out.println("FAILED at stage 1 - Username not found.");
        }

        System.out.println("\n========== EXPERT ==========");
        // Correct login: "student" / 1007
        // Try: wrong username, PIN 12 (not 4 digits), PIN 9999 (wrong),
        //      balance 800 with withdrawal 300 (over limit),
        //      balance 800 with withdrawal 199 (can't cover fee)
        String username = "student";
        int pin = 1007;
        double balance = 6000.00;
        double withdrawal = 800.00;

        boolean approved = false;
        String denialReason = "";
        String accountTier = "N/A";
        double feePercent = 0;
        double dailyLimit = 0;
        double fee = 0;
        double totalCost = 0;

        // 1) Authentication: nested if (username AND 4-digit PIN)
        if (username.equals("student")) {
            if (pin >= 1000 && pin <= 9999) {
                if (pin == 1007) {

                    // 2) Tier from balance: else-if ladder
                    if (balance >= 20000) {
                        accountTier = "Platinum";
                    } else if (balance >= 5000) {
                        accountTier = "Gold";
                    } else if (balance >= 1000) {
                        accountTier = "Silver";
                    } else {
                        accountTier = "Bronze";
                    }

                    // 3) Fee percentage and daily limit: switch on tier
                    switch (accountTier) {
                        case "Platinum":
                            feePercent = 0.5;
                            dailyLimit = 5000;
                            break;
                        case "Gold":
                            feePercent = 1.0;
                            dailyLimit = 1000;
                            break;
                        case "Silver":
                            feePercent = 1.5;
                            dailyLimit = 500;
                            break;
                        default: // Bronze
                            feePercent = 2.0;
                            dailyLimit = 200;
                            break;
                    }

                    fee = withdrawal * feePercent / 100;
                    totalCost = withdrawal + fee;

                    // 4) Withdrawal, nested if (amount valid, balance, daily limit)
                    if (withdrawal > 0) {
                        if (totalCost <= balance) {
                            if (withdrawal <= dailyLimit) {
                                approved = true;
                            } else {
                                denialReason = "Withdrawal $" + withdrawal
                                        + " exceeds the " + accountTier
                                        + " daily limit of $" + dailyLimit + ".";
                            }
                        } else {
                            denialReason = "Insufficient balance: need $" + totalCost
                                    + " (including fee) but only $" + balance + " available.";
                        }
                    } else {
                        denialReason = "Withdrawal amount must be greater than zero.";
                    }

                } else {
                    denialReason = "Incorrect PIN.";
                }
            } else {
                denialReason = "PIN must be exactly 4 digits.";
            }
        } else {
            denialReason = "Username not recognized.";
        }

        // Final decision
        System.out.println("User: " + username);
        System.out.println("Tier: " + accountTier);
        System.out.println("Fee: " + feePercent + "%");
        System.out.println("Daily limit: $" + dailyLimit);
        if (approved) {
            System.out.println("Status: APPROVED");
            System.out.println("Withdrawn: $" + withdrawal);
            System.out.println("Fee charged: $" + fee);
            System.out.println("New balance: $" + (balance - totalCost));
        } else {
            System.out.println("Status: DENIED");
            System.out.println("Reason: " + denialReason);
        }
    }
}