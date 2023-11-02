//Taylor Series Program//
//Synopsis: Given the taylor series take from the user an x value in the form of a double and a number of iterations for the taylor 
// series in the variable n. From that use the formula to calculate the estimated value of e^ x variable, then get the actual value
// e^x and find the margin of error between the two//
//Lila Hilizah//
//References: Jalen Smith//

import java.util.Scanner;
import java.util.ArrayList;

public class TaylorSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        Double x = sc.nextDouble();
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();
        //Continues asking the user until it gives me an appropriate number of iterations.//
        while(!(n >= 1 && n <= 10000)){
            System.out.print("Enter number of iterations: ");
            n = sc.nextInt();
        }
        double z = 0.0;
        double taylornum = taylor_step(z, x, n);
        double enumber = Math.exp(x);
        double difference = Math.abs(100*(1-(taylornum/enumber)));
        // Getting the margin of error to the nearest whole number no rounding//
        System.out.printf("TAYLOR: %.3f, EXP: %.3f, ERROR: %.0f%%",taylornum,enumber,difference);
        sc.close();
        }
    public static double taylor_step(double z,double x, int n){
        for(int i = 2; i <= n; i++ ){
            double numerator = Math.pow(x,i);
            // Finding the value of the denominator at the current step//
            double denominator = taylor(i);
            //At the current step finding the value of the taylor series//
            double result = numerator/denominator;
            //Continuously adding current step to the previous step//
            z+= result;
        }
        //Since the value of the first step is 1 and the value of the 2nd step would be the value of the x variable//
        z += (x+1);
        return z;
    }
    public static double taylor(int i){
        //Creating a list of all the positive numbers up to the current step//
        ArrayList<Integer> nums = new ArrayList(); 
        for(int j = 1; j <= i; j++){
            nums.add(j);
        }
        //Getting the factorial value of current step of n!//
            int zoro = 1;
            for(int k =0; k <nums.size();k++){
            zoro *= nums.get(k);
        }
        return zoro; 
    }
}
