package HW2;

import java.util.Scanner;
//I imported the scanner because why not

public class MathGames {
    // 1. Create a method that will calculate the Pythagorean Theorem (https://en.wikipedia.org/wiki/Pythagorean_theorem)
    // c = sqrt(a^2+b^2)
    // NOTE: You can assume you will only need to calculate the Hypotenuse
    // Hint 1: Method should take in 2 sides(a and b) of the triangle and return the missing side.
    //      Remember the Triangle has a base, Perpendicular, and Hypotenuse
    // Hint 2: Math.pow and Math.sqrt are your friend here
    // Bonus points: Try to make it accept any 2 sides and return the 3rd. So it can take in
    // Hypotenuse and Perpendicular and return the base.
    // Example 1: pythagorean(3,4) would return 5

    public static double findhype(double Perpendicular, double Base){
        return Math.sqrt(Math.pow(Perpendicular , 2) + Math.pow(Base , 2));
    }
    public static double findbase(double Perpendicular, double hypotenuse){
        return Math.sqrt(Math.pow(hypotenuse , 2) - Math.pow(Perpendicular , 2));
    }
    public static double findperp(double Base, double hypotenuse){
        return Math.sqrt(Math.pow(hypotenuse , 2) - Math.pow(Base , 2));
    }


    
    // 2. Create a method that will calcuate my grade in the class. You can use the grade range as follows
        // A: 100 - 90
        // B:  89 - 80
        // C:  79 - 70
        // D:  69 - 60
        // F:  60 -  0 
        // method should accept the grade as a double and return the letter grade of what I got
        // NOTE: Im a really nice guy and always round up on my grading so a 69.3 will round up to a 70.0
        // Hint 1: if statements required here you will probably need at the least 5 if / ifelse / else statments
        // Hint 2: You will probably need to cast the double to an int
        // Hint 3: You will probably need to use the Math.ceil() method
        // Example: grade(69.3) would return a D
    public static String Letter(double grade){
        if(grade >= 90){
            return "You have an A";
        }else if(grade >= 80){
            return "You have a B";
        }else if(grade >= 70){
            return "You have a C";
        }else if(grade >= 60){
            return "You have a D";
        }else{
            return "You have a F";
        }
    }





    // 3. Create a method that will calculate the tip on a bill per person
    //      Method parameters: total bill, amount of people splitting the bill, percentage to tip.
    //      Note: I would like the total always rounded up to a whole number
    //      Hint 1: percentage can be made easier to work with if you divide by 100 so 18% is 18/100 = 0.18
    //      Hint 2: Using doubles will be helpful for when you need to calculate decimals
    //      Hint 3: It is possible you might need to Cast a double to an int or vice versa
    //      Hint 4: You will probably need to use the Math.ceil() method
    //      Example: tip(100, 4, 18) would return 5.0
    public static double tip(double bill, double people, double tip){
        return Math.ceil((bill * (tip / 100)) / people);
    }
    
 


    // You can either create a tester class or put your code here
     public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("=================== Pythagorean Program ==============");
        System.out.println("Please enter the name of your first side (pick between Perpendicular, Hypotenuse, or Base(only use a side once): ");
        String side1 = input.nextLine();
        System.out.println("Please enter the name of the other side: ");
        String side2 = input.nextLine();
        if (side1.equalsIgnoreCase("Perpendicular") && side2.equalsIgnoreCase("Hypotenuse")|| side1.equalsIgnoreCase("Hypotenuse") && side2.equalsIgnoreCase("Perpendicular")){
            System.out.print("Please enter the perpendicular side: ");
            double Perpendicular = input.nextDouble();
            System.out.print("Please enter the hypotenuse: ");
            double hypotenuse = input.nextDouble();
            System.out.println("Your base side is " + findbase(Perpendicular, hypotenuse));
        }
        else if (side1.equalsIgnoreCase("Base") && side2.equalsIgnoreCase("Hypotenuse") || side1.equalsIgnoreCase("Hypotenuse") && side2.equalsIgnoreCase("Base")){
            System.out.print("Please enter the base: ");
            double Base = input.nextDouble();
            System.out.print("Please enter the hypotenuse: ");
            double hypotenuse = input.nextDouble();
            System.out.println("Your perpendicular side is " + findperp(Base, hypotenuse));
        }
        else if (side1.equalsIgnoreCase("Perpendicular") && side2.equalsIgnoreCase("Base") || side1.equalsIgnoreCase("Hypotenuse") && side2.equalsIgnoreCase("Base")){
            System.out.print("Please enter the base: ");
            double Base = input.nextDouble();
            System.out.print("Please enter the perpendicular side: ");
            double Perpendicular = input.nextDouble();
            System.out.println("Your hypotenuse is " + findhype(Perpendicular, Base));
        }
        else{
            System.out.println("Thats not a side, you spelt it wrong, or you said the same side twice. Please run the program again. Dickhead.");
        }
        System.out.println("=================== Grade Program ==============");
        System.out.print("Please enter your grade: ");
        double grade = input.nextDouble();
        if (grade <= 100 && grade >=0){
        System.out.println(Letter(Math.ceil(grade)));
        }
        else {
            System.out.println("Thats not a possible grade I can't belive you would lie to me");
        }
        System.out.println("==================== Tipping Program ====================");
        System.out.print("Please enter the total bill as a number: ");
        double bill = input.nextDouble();
        System.out.print("PLease enter the amount of people splitting the bill again as a number: ");
        double people = input.nextDouble();
        System.out.print("Please enter the percentage to tip one more time as a number or the program will break please: ");
        double tip = input.nextDouble();
        int tipammount = ((int) Math.ceil(tip(bill, people, tip)));
        System.out.println("Each person will tip " + tipammount + "$");
        System.out.println("Thank you for playing/not crashing my program");
        input.close();
    }
  
}
