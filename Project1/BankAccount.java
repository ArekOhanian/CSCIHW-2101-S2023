package Project1;

import java.util.Scanner;
/*
 * Appas Bank
 * Bank Account Parameters:
 * public Name -> String ✓
 * private Balance -> double ✓ 
 * private Date of Birth -> String ✓
 * private SSN -> int (Maybe String) ✓
 * private Account Number -> int ✓
 * 
 * Bank Account Methods:
 * Constructor 
 * Getters and Setters
 * Deposit
 * Withdraw
 * Transfer (HomeWork)
 * Balance
 * Menu
 * Compound Interest
 * Simple Interest (HomeWork)
 * Authentication Basic
 * Authentication Advanced (HomeWork?)
 * 
 * Bank Account Constructor
 * Name, Balance, SSN, Account Number, Date of Birth
 * Name, SSN
 */

public class BankAccount {

    // Bank Account Parameters
    public String name;
    private double balance;
    private String dob;
    private int ssn;
    private int accountNumber;
    public double interestRate = 0.01;
    public int period = 4; // quarterly

    // Bank Account Constructor
    public BankAccount(String name, int ssn, double balance, int accountNumber, String dob) {
        this.name = name;
        this.ssn = ssn;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dob = dob;
    }

    // Bank Account Constructor
    public BankAccount(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    // Bank Account Methods

    // Note you do need to create a getter for public variables however it is best
    // practice to create a getter for all variables

    /*
     * Getters and Setters
     */

    public String getName() {
        return this.name;
    }

    public double getbalance() {
        return this.balance;
    }

    public String getdob() {
        return this.dob;
    }

    public int getssn() {
        return this.ssn;
    }

    public int getaccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Should only be used by during the creation of the account never after instead
     * see deposit and withdraw
     */
    public void setbalance(double balance) {
        this.balance = balance;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public void setssn(int ssn) {
        this.ssn = ssn;
    }

    public void setaccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
    public void overDraft(double amount, BankAccount bank){
            this.balance -= (amount + 35);   

    }
    public void transfer(double amount, BankAccount account_user, BankAccount account_reciver) {
        account_user.withdraw(amount);
        account_reciver.deposit(amount);
    }
    public void simpleinterest(double Principal, int time, double rate) {
        double simpleInterest = (Principal * time * rate)/100;
        double roundedamount = Math.round(simpleInterest * 100.0) / 100.0;
        System.out.println("The current rate is " + rate + "%");
        System.out.println("The selected time is " + time + " years");
        System.out.println("The simple interest after " + time + " years is: $" + simpleInterest);
        System.out.println("The total amount after " + time + " years is: $" + roundedamount);

    }
    // Create a mthod that will subtract a mothly fee from the balance
    // this method will take a double as a parameter
    // this method will subtract the fee from the balance
    // Netflix subscription is $12.99
    public void monthlyFee(double fee) {
        withdraw(fee);
    }

    // Create a method that will print a menu to the user
    // This is called a helper method / function
    public static int menu() {
        int choice;
        Scanner input = new java.util.Scanner(System.in);
        System.out.println("Welcome to Appas Bank");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer"); // HomeWork
        System.out.println("4. Balance");
        System.out.println("5. Compound Interest");
        System.out.println("6. Simple Interest"); // HomeWork
        System.out.println("7. Savings Account");
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
        choice = input.nextInt();
        return choice;
    }
    
    public void printBalance() {
        System.out.println("Your balance is: $" + this.balance);
    }

    // Create a method that will interact with the user based on their choice from
    // the menu method
    // This method will take a Bank Account as a parameter
    public static void interact(BankAccount account, BankAccount account2) {
        // get the choice from the menu method
        int choice = menu();
        // create a scanner object
        Scanner input = new java.util.Scanner(System.in);
        // use that choice and run the method associated with that choice

        if (choice == 1) {
            System.out.println("Please enter the amount you would like to deposit: ");
            double amount = input.nextDouble();
            account.deposit(amount);
            account.printBalance();
        } else if (choice == 2) {
            System.out.println("How much would you like to withdraw?");
            double amount = input.nextDouble();
            if (account.balance <= 0 || account.balance < amount){
                System.out.println("Your account balance is going to be less than or equal to $0 you are going to be charged an overdraft fee of $35. Would you still like to withdraw? (please input 1 for yes and 2 for no). ");
                int yn = input.nextInt();
                if (yn == 1){
                    account.overDraft(amount, account);
                    account.printBalance();
                    System.out.println("Thank you for banking with Appas Bank you better pay us or we will break your kneecaps.");
                }
                else if (yn == 2){
                    System.out.println("Thank you for banking with Appas Bank");
                }
            }
            else if (amount == 0){
                System.out.println("you can't withdraw $0");
                System.out.println("Thank you for banking with Appas Bank");
            }
            else if (amount < 0){
                System.out.println("you can't withdraw a negative amount");
                System.out.println("Thank you for banking with Appas Bank");
            }
            else {
            account.withdraw(amount);
            account.printBalance();
            }

        } // place holder for choice 3\
        else if (choice == 3) {
            System.out.println("How much would you like to transfer?");
            double amount = input.nextDouble();
            System.out.println("Who would you like to transfer to?");
            String name = input.next();
            if (name.equalsIgnoreCase("MOMO")){
                account.transfer(amount, account, account2);
                account.printBalance();
            }
            else if (name.equalsIgnoreCase("Katara")){
                account.transfer(amount, account2, account);
                account2.printBalance();
            }
            else {
                System.out.println("Invalid name");
            }
        }
        else if (choice == 4) {
            account.printBalance();
        } 
        else if (choice == 5) {
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.compoundInterest(account.getbalance(), years, account.interestRate, account.period);
            account.printBalance();
        }
        else if (choice == 6) {
            System.out.println("How many years? (Whole numbers only)");
            int time = input.nextInt();
            account.simpleinterest(account.getbalance(), time, account.interestRate);
            account.printBalance();
        }
        else if (choice == 7){
            System.out.println("Would you like to open a savings account? (please input 1 for yes and 2 for no). ");
            int yesorno = input.nextInt();
            if (account.balance > 10000 & yesorno == 1){
                System.out.println("How much would you like to deposit into your savings account?");
                double amount = input.nextDouble();
                System.out.println("Would you like compound or flat interest? (please input 1 for compound and 2 for flat). ");
                int interest = input.nextInt();
                if (interest == 1){
                    System.out.println("How many years would you like to compound your interest for? (Whole numbers only)");
                    int years = input.nextInt();
                    account.compoundInterest(amount, years, .0001, 4);
                    account.printBalance();
                }
                else if (interest == 2){
                    System.out.println("How many years would you like to compound your interest for? (Whole numbers only)");
                    int years = input.nextInt();
                    account.simpleinterest(amount, years, .001);
                    account.printBalance();
                }
                else {
                    System.out.println("Invalid choice");
                }
            }
            else if (account.balance < 10000 & yesorno == 1){
                System.out.println("You need at least $10,000 to open a savings account");
            }
            else if (yesorno == 2){
                System.out.println("Thank you for banking with Appas Bank");
            }
            else {
                System.out.println("Invalid choice");
            }
        }

        else if (choice == 0) {
            System.out.println("Thank you for banking with Appas Bank");
        } 
        else { // this would catch any invalid choices like
            System.out.println("Invalid choice");
        }
        input.close();
    }

    // Create a method that will calculate the interest on the balance using
    // compound interest
    // P(1 + R/n)^(nt) - P
    // A = P(1 + R/n)^(nt)
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter

    public void compoundInterest(double principal, int time, double rate, int annum) {
        double amount = principal * Math.pow(1 + (rate / annum), annum * time);
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal; // A-P
        compinterest = Math.round(compinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Compound Interest after " + time + " years is: $" + compinterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    }
}
