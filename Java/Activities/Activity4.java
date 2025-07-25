package activities;

public class Activity4 {
	 public static void main(String[] args) {

	        int[] arrys = {10, 5, 9, 2, 5, 3, 4};

	        System.out.println("Original array:");
	        printArray(arrys);

	        int comparenum;

	        for (int i = 1; i < arrys.length; i++) {
	            comparenum = arrys[i];
	            int j;

	            for (j = i - 1; j >= 0 && arrys[j] > comparenum; j--) {
	                arrys[j + 1] = arrys[j];
	            }

	            // put back the number
	            arrys[j + 1] = comparenum;

	         // for each iteration
	         //   System.out.print("After inserting " + comparenum + ": ");
	        //    printArray(arrys);
	        }

	        System.out.println("Sorted array:");
	        printArray(arrys);
	    }

	    public static void printArray(int[] arrys) {
	        for (int num : arrys) {
	            System.out.print(num + " ");
	        }
	       // }
	            System.out.println();
	            //for each iteration
	        //System.out.println(num + ""); 
	    }
	}