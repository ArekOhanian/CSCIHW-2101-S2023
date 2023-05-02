package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.print.attribute.standard.NumberUpSupported;

public class ArrayListPlayground {
    public static void main(String[] args) {
    // Question 1
    // Write Java statements that do the following:
    // a) Declare an arrayList nums of 15 elements of type int.
    // b) Output the value of the tenth element of the array nums.
    // c) Set the value of the 5th element of the array nums to 99.
    // d) set the value of the 13th element to 15
    // d) set the value of the 2nd element to 6
    // d) Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums.
    
    //a)
    ArrayList<Integer> nums = new ArrayList<Integer>(15);
    for (int i = 0; i < 15; i++){
        nums.add(0);
    }
    nums.add(1);
    //b)
    System.out.println(nums.get(9));
    //c)
    nums.set(4, 99);
    //d)
    nums.set(12, 15);
    //e)
    nums.set(1, 6);
    //f)
    nums.set(8, nums.get(12) + nums.get(1));


         
    // Question 2
    // a) create an arrayList of Strings that contain each day of the week.(starting on monday)
    // b) output each of the days of the week
    // c) output the days of the week that we have class 
    // d) change the arrayList to start on Sunday
        ArrayList<String> Week = new ArrayList<String>();
        Week.add("Monday");
        Week.add("Tuesday");
        Week.add("Wednesday");
        Week.add("Thursday");
        Week.add("Friday");
        Week.add("Saturday");
        Week.add("Sunday");
        System.out.println(Week.get(1));
        System.out.println(Week.get(3));
        Week.set(0, "Sunday");
        Week.set(1, "Monday");
        Week.set(2, "Tuesday");
        Week.set(3, "Wednesday");
        Week.set(4, "Thursday");
        Week.set(5, "Friday");
        Week.set(6, "Saturday");

    // Question 3 
    // a) create an ArrayList and prompt the user for numbers to add to it until the number 0 is selected
    // b) return the largest and smallest number
    // c) return the ArrayList sorted smallest to largest
    // d) take that ArrayList see if its size is divisable by 3 and then output the ArrayList in a matrix format
    // NOTE: make the matrix n X 3 so it can be n rows by 3 columns 
    // EX. ArrayList [1,2,3,4,5,6,7,8,9]
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers and add them until it is
    // ArrayList Size: 7
    // Please enter 2 more numbers to create the matrix...
    // 
    // Hint 1: use collections sort to sort the numbers 
    // Hint 2: you can see if the size of the array list is divisible by 3 by running:
    //  numbers.size()%3==0
    // Hint 3: You can use this logic to print the array list in a 3x3 pattern once its created:
    // for(int i=0;i<numbers.size();i++)
    //     {
    //         System.out.print(numbers.get(i)+" ");
    //         if((i+1)%3==0)
    //         {
    //             System.out.println();
    //         }
    //     }
        System.out.println("Please enter numbers to add to the ArrayList if you enter 0 it will stop.");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(num);
        int i = 0;
        int p = 0;
        int largest = 0;
        int smallest = num;
        while(num != 0){
            num = input.nextInt();
            if (numbers.size()%3 != 0 && i > 0 && num == 0){
                while (numbers.size()%3 != 0){
                System.out.println("Please enter " + (2 - (i)%3) + " more numbers to create the matrix...");
                num = input.nextInt();
                if (num == 0){
                    while (num == 0){
                    System.out.println("That is not a valid number please enter a number that is not 0.");
                    num = input.nextInt();
                    }
                }
                if (num != 0){
                numbers.add(num);
                }
                if (numbers.size()%3 == 0){
                    break;
                }
                p++;
                i++;
                }
            }
            if (num == 0 && i%3 == 0){
                break;
            }
            if (p == 1){
                break;
            }
            if (num != 0){
            numbers.add(num);
            }
            i++;
            
        }
        for (int j = 0; j < numbers.size(); j++){
            if (numbers.get(j) > largest){
                largest = numbers.get(j);
            }
            if (numbers.get(j) < smallest && numbers.get(j) != 0){
                smallest = numbers.get(j);
            }
        }
        Collections.sort(numbers);
        System.out.print("Array List: {");
        for (int b = 0; b < numbers.size(); b++) {
            if (b == numbers.size()-1) {
                System.out.print(numbers.get(b));
                break;
            }
            System.out.print(numbers.get(b) + ", ");
        }
        System.out.println("}");
        for (int j = 0; j < numbers.size(); j++){
            if (numbers.get(j) != 0){
                System.out.print(numbers.get(j) + " ");
            }
            if ((j+1)%3 == 0){
                System.out.println();
            }
        }
        input.close();
    }
}





   

