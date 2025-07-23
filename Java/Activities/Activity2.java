package activities;
import java.util.*;

public class Activity2 {
    public static void main(String[] args) {
    	
	int[] numbers = {10, 77, 10, 54, -11, 10};
	int search = 10;
    int result = 30;
    int numcounter=0;
    int sum;

    System.out.println("Array: " + Arrays.toString(numbers));
    for(int i=0;i<=5;i++)
    	if(numbers[i]==search) {
    		numcounter++;
    	}
    		System.out.println("The number 10 appears " + numcounter + " times in the array");
    	
   
    sum = search *numcounter;
    // normal if loop
    /*if (sum== result)
    {
    System.out.println("The sum of all 10s is 30.");
    }*/
    
    //try boolean expression in if loop
boolean isSumThirty = (sum == result);

if (isSumThirty) {
    System.out.println("The sum of all 10s is 30.");
} else {
    System.out.println("Then number of times 10 appears " + sum);
}
}
}
