package HW4;
import java.util.Scanner;
public class Arrays {

    // CONVERT THE SUMS METHOD FROM HW3 TO ADD EACH VALUE TO AN ARRAY AND THEN OUTPUT THE 
    // ARRAY AND THE TOTAL.
    // SEE HW3 FOR SUMS METHOD
    // If you want to use an ArrayList for the inputs to be dynamic that is okay
    // Otherwise if you are using a regular array, assume the size is 10 total. 
    // EXAMPLE 
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 0
    // Total: 22
    // Array: {12,2,3,4,1,0}
    public static void Arraysums(){
        Scanner sc = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me...");
        System.out.print("Number: ");
        int num = sc.nextInt();
        int total = num;
        int [] sums = new int[10];
        sums[0] = num;
        int i = 0;
        while (num != 0) {
            System.out.println("The total so far is " + total + ".");
            System.out.print("Number: ");
            num = sc.nextInt();
            total = total + num;
            sums[i+1] = num;
            i = i+1;
            if (num == 0 || i == sums.length-1) {
                System.out.println("Total: " + total);
                System.out.print("{");
                for (int e = 0; e < sums.length; e++) {
                System.out.print(sums[e]);
                    if (e < sums.length - 1) {
                    System.out.print(", ");
                    }
                }
            break;
            }
        }
        System.out.println("}");
        sc.close();
    }
    // Create a method that will brute force a password EX.
    // bruteForce("ZZZZ")
    // The program should then guess each char of the string and compare it to see if it is equal
    // to the index of the alphabet char array below
    // Output Example:
    // Z
    // ZZ
    // ZZZ
    // ZZZZ

    // Hint 1: using a char array for the password is helpful here 
    // Hint 2: using the method .toCharArray is a way to convert the password parameter to a char array as well
    // From there creating for and while loops to compare the values is trivial

    public static String bruteForce(String password){
        String answer = "";
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')','<','>','/','?', ';'};
        char [] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            for (int e = 0; e < alphabet.length; e++) {
                if (passwordArray[i] == alphabet[e]) {
                    answer = answer + alphabet[e];
                    System.out.println(answer);
                }
            }
        }
        return answer; 
    }

    // Create a method that will sort an Array of integers from smallest to greatest.
    // NOTE: You CANNOT use the built in Arrays.sort method
    // Ex. 
    // sorter([9,10,2,5,3,4,7,8]) -> [2,3,4,5,7,8,9,10]

    // Hint 1: a temp Array is a helpful way to store variables for comparing 
    // Hint 2: 2 nested For loops should be all thats needed for the swapping logic
    public static int[] sorter(int[] nums){
        int [] sortedArray = new int[nums.length];
        int [] temp = new int [nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            for(int e = 0; e < nums.length; e++) {
                if (nums[e] > nums[i]) {
                    temp[e] = nums[i];
                    nums[i] = nums[e];
                    nums[e] = temp[e];
                    sortedArray[i] = nums[i];
                    sortedArray[e] = nums[e];
                }
                
            }
        }
        
        return sortedArray;     
        }   






    public static void main(String[] args) {
        // Tester main method for your methods
        System.out.println("Hello World!");
        Arraysums();
        System.out.println("==================================");
        bruteForce("gfdsnklgfdanjgvokp;f;gna;");
        System.out.println("==================================");
        int [] nums = {9,10,2,5,3,4,7,8};
        int [] sorted = sorter(nums);
        System.out.print("Sorted Array: {");
        for (int i = 0; i < sorted.length; i++) {
            if (i == sorted.length-1) {
                System.out.print(sorted[i]);
                break;
            }
            System.out.print(sorted[i] + ", ");
        }
        System.out.println("}");
    }

    
}