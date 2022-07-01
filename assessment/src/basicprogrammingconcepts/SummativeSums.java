package basicprogrammingconcepts;

public class SummativeSums {

  // method to add elements in array and return the sum of elements of array
    static int addArray(int[] array){

        int sum=0;
        for (int i=0; i<array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    public static void main(String[] args) {

        int[] arr1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] arr2 = { 999, -60, -77, 14, 160, 301 };
        int[] arr3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };

        // print all array sum
        System.out.println("#1 Array Sum: " +addArray(arr1));
        System.out.println("#2 Array Sum: " +addArray(arr2));
        System.out.println("#3 Array Sum: " +addArray(arr3));

    }

}
