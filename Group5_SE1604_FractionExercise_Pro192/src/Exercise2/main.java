
package Exercise2;

/**
 *
 * @author Pham Nhat Quang CE170036 SE1604
 * Group 2
 * Pham Nhat Quang
 * Le Duy Khanh CE160277
 * Lam Nhut Tan CS160260
 * Giang Trung Nghia Nhan CE150722
 * 
 * Dear teacher,
 * Our group have tried to cover as many exception as possible
 * Unfortunately our group have not caught the overflow of calculation results.
 * Even though we have covered the overflow of input.
 * Example 2147483647/1 + 2147483647/1 = -2.
 * If possible please give us advice / hint on how we should solve this efficiently
 * Sincerely, Pham Nhat Quang.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Fraction fract1 = new Fraction();
        int numerator1 = 0, denominator1=0;
        
        Fraction fract2 = new Fraction();
        int numerator2 = 0, denominator2=0;
       
        int integer = 0;
        
        boolean check = false; //Check for correct input
        
        Scanner input = new Scanner (System.in); //Take input
        
        System.out.println("===========================================================");
        System.out.println("|    Program to get 2 fractions and 1 integer from user   |");
        System.out.println("|            then perform simple calculations.            |");
        System.out.println("|       All fractions are displayed in reduced form.      |");
        System.out.println("|    If a fraction has numerator 0 or denominator 1 it    |");
        System.out.println("|            will be displayed as an integer.             |");
        System.out.println("==========================================================");
        
        /**
         * Let user enter the numerator and denominator of the first fraction
         */
        System.out.println("Please enter the first fraction:");
        while(!check){
            try{
                System.out.print("Numerator: ");
                numerator1 = input.nextInt();
                check = true;
            } catch (InputMismatchException ime)  {
                input.nextLine();
                System.out.println("########################################################");
                System.out.println("#         Error: Numerator must be an integer          #");
                System.out.println("#         between -2147483648 and 2147483647           #");
                System.out.println("########################################################");
            }
        }
        check = false;
        while(!check){
            try{
                 System.out.print("Denominator: "); 
                 denominator1 = input.nextInt();
                 check = true;
            } catch (InputMismatchException ime)  {
                input.nextLine();
                System.out.println("########################################################");
                System.out.println("#        Error: Denominator must be an integer         #");
                System.out.println("#         between -2147483648 and 2147483647           #");
                System.out.println("########################################################");
            }
        }
       
        fract1.setNumerator(numerator1);
        fract1.setDenominator(denominator1);
        
        System.out.println("Fraction number 1 is: " + fract1.toString()); 
        
        System.out.println("--------------------------------");
        
        /**
         * Let user enter the numerator and denominator of the second fraction
         */
        System.out.println("Please enter the second fraction:");
        
        check = false;
        while(!check){
            try{
                System.out.print("Numerator: ");
                numerator2 = input.nextInt();
                
                check = true;
               } catch (InputMismatchException ime)  {
                input.nextLine();
                System.out.println("########################################################");
                System.out.println("#         Error: Numerator must be an integer          #");
                System.out.println("#         between -2147483648 and 2147483647           #");
                System.out.println("########################################################");
            }
        }
        check = false;
        while(!check){
            try{
                 System.out.print("Denominator: "); 
                 denominator2 = input.nextInt();
                 check = true;
            } catch (InputMismatchException ime)  {
                input.nextLine();
                System.out.println("########################################################");
                System.out.println("#       Error:  Denominator must be an integer         # ");
                System.out.println("#         between -2147483648 and 2147483647           #");
                System.out.println("########################################################");
            }
        }
        
        fract2.setNumerator(numerator2);
        fract2.setDenominator(denominator2);
        
        System.out.println("Fraction number 2 is: " + fract2.toString());
        
        System.out.println("--------------------------------");
        
        /**
         * Let user enter an integer to do calculations with fraction 1
         */   
        check = false;
        while(!check){
            try{
                 System.out.print("Please enter an integer: ");
                 integer = input.nextInt();
                 check = true;
            } catch (InputMismatchException ime)  {
                input.nextLine();
                System.out.println("########################################################");
                System.out.println("#          Error:  This must be an integer             # ");
                System.out.println("#         between -2147483648 and 2147483647           #");
                System.out.println("########################################################");
            }
        }
        System.out.println("--------------------------------");
        System.out.println("");
    
        /**
         * Display results of calculations between the two fractions
         */
        
        //Sum
        String sum1="";
        if (fract2.getNumerator() >= 0){
            sum1 = fract1.toString()+ " + " + fract2.toString();
        }
        else {
            sum1 = fract1.toString()+ " + " + "(" + fract2.toString() + ")";
        }
        System.out.println("The sum of the two fraction is: " + sum1 + " = " + fract1.Add(fract2));
        
        //Difference
        String difference1="";
        if (fract2.getNumerator() >= 0){
            difference1 = fract1.toString()+ " - " + fract2.toString();
        }
        else{
            difference1 = fract1.toString()+ " - " + "(" + fract2.toString() + ")";
        }
        System.out.println("The difference of the two fraction is: " + difference1 + " = " + fract1.Subtract(fract2));
        
        //Product
        String product1 ="";
        if (fract2.getNumerator()>=0)
            product1 = fract1.toString()+ " * " + fract2.toString();
        else
            product1 = fract1.toString()+ " * " +"("+ fract2.toString()+")";
        System.out.println("The product of the two fraction is: " + product1 + " = " + fract1.Multiply(fract2));
        
        
        //Quotient
        String quotient1="";
         if (fract2.getNumerator()>=0)
             quotient1 = fract1.toString()+ " : " + fract2.toString();
        else
             quotient1 = fract1.toString()+ " : " +"("+ fract2.toString()+")";
        System.out.println("The quotient of the two fraction is: " + quotient1 + " = " + fract1.Divide(fract2));
        
        System.out.println("--------------------------------");
        System.out.println("");
        
        /**
         * Display results of calculations between the fraction 1 and integer
         */
        
        //Sum
        String sum2 = "";
        if (integer >= 0){
            sum2 = fract1.toString()+ " + " + integer;
        }
        else {
            sum2 = fract1.toString()+ " + " + "(" + integer + ")";
        }
        System.out.println("The sum of the first fraction and the integer is: " + sum2 + " = " + fract1.Add(integer));
        
        //Difference
        String difference2 = "";
        if (integer >= 0){
            difference2 = fract1.toString() + " - " + integer;
        }
        else {
            difference2 = fract1.toString()+ " - " + "(" + integer + ")";
        }
        System.out.println("The difference of the first fraction and the integer is: " + difference2 + " = " + fract1.Subtract(integer));
        
        //Product
        String product2 = "";
        
        if (integer >= 0){
            product2 = fract1.toString()+ " * " + integer;
        }
        else {
            product2 = fract1.toString()+ " * " + "(" + integer + ")";
        }
        System.out.println("The product of the first fraction and the integer is: " + product2 + " = " + fract1.Multiply(integer));
        
        //Quotient
        String quotient2="";
        if (integer >= 0){
            quotient2 = fract1.toString()+ " : " + integer;
        }
        else {
            quotient2 = fract1.toString()+ " : " + "(" + integer + ")";
        }
        System.out.println("The quotient of the first fraction and the integer is: " + quotient2 + " = " + fract1.Divide(integer));
    }
}
