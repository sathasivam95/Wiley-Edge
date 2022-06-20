import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

    public static void main(String[] args){

        String name;
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your dog's name? ");
        name = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on " +name+
                "'s prestigious background right here.");

        Random rand = new Random();

        int[] array = new int[5];
        int total = 100;
        for(int i=0;i<array.length-1;i++){
            array[i] = rand.nextInt(total);
            total -= array[i];
        }

        System.out.println( "\n" +name + " is : \n");
        array[4] = total;

        System.out.println(array[0]+"% St. Bernard");
        System.out.println(array[1]+"% Chihuahua");
        System.out.println(array[2]+"% Dramatic RedNosed Asian Pug");
        System.out.println(array[3]+"% Common Cur");
        System.out.println(array[4]+"% King Doberman");
        System.out.println("\nWow, that's QUITE the dog!");

    }
}
