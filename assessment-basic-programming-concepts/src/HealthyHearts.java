import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args){

        int age, max;
        double targetMin, targetMax;

        Scanner sc = new Scanner(System.in);
        System.out.print("What is your age? ");
        age = sc.nextInt();

        max = 220 - age;

        System.out.println("Your maximum heart rate should be " +max+ " beats per minute");

        targetMin = 0.5 * max;
        targetMax = 0.85 * max;

        System.out.println("Your target HR Zone is " +targetMin+ " - " +targetMax + " beats per minute " );
    }
}