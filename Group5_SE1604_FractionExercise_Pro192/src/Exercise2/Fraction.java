/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise2;

/**
 *
 * @author Pham Nhat Quang CE170036 SE1604
 */
import java.util.Scanner;
public class Fraction {
    private int numerator;
    private int denominator;
    Scanner input = new Scanner (System.in);
    
    /**
     * Method to calculate Greatest Common Divisor
     * @param a
     * @param b
     * @return GCD of a and b
     */
    private int GCD(int a,int b){
        int temp=0;
        while (b!=0){
            temp=b;
            b=a % b;
            a=temp;
        }
        return a;
    }
    
    /**
     * Default constructor: the fraction is 0/1
     */
    public Fraction() {
        this.setNumerator(0);
        this.setDenominator(1);
    }

    /**
     * Constructor with 1 integer parameter 
     * @param numerator
     * Fraction is: numerator / 1
     */
    public Fraction(int numerator) {
        this.setNumerator(numerator);
        this.setDenominator(1);
    }
    
    /**
     * Constructor with 2 integer parameters, first will be numerator, second will be denominator
     * @param numerator
     * @param denominator 
     * Fraction is: numerator / denominator
     */
    public Fraction(int numerator, int denominator) {
        this.setNumerator(numerator);
        this.setDenominator(denominator);
        while (this.denominator==0)
        {
            input.nextLine();
            System.out.println("########################################################");
            System.out.println("#       Invalid denominator, it should not be 0!       #");
            System.out.println("########################################################");
            System.out.print("Please enter a different denominator:");
            denominator=input.nextInt();
            this.setDenominator(denominator);
            
        }
    }

    /**
     * Get numerator field
     * @return this object's numerator 
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Get denominator field
     * @return this object's denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Set numerator field with the parameter's value
     * @param numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Set denominator field with the parameter's value
     * @param denominator
     * If denominator parameter is 0 user has to enter another denominator until it's not 0
     */
    public void setDenominator(int denominator) {
        while (denominator==0)
        {
            System.out.println("########################################################");
            System.out.println("#      Invalid denominator, it should not be 0!        #");
            System.out.println("########################################################");
            System.out.print("Please enter a different denominator:");
            
            denominator=input.nextInt();
            input.nextLine();
        }
        this.denominator = denominator;
    }
   
    /**
     * Method to display the fraction object
     * A fraction will be reduced before display using GCD of numerator and denominator
     * A fraction will be displayed as an integer of denominator is 1 or numerator is 0
     * If the fraction is -a/-b it will become a/b
     * If the fraction is a/-b it will become -a/b
     * @return the representation of the fraction
     */
    @Override
    public String toString() {
        int GCD = GCD(this.numerator,this.denominator);
        this.numerator=this.numerator/GCD;
        this.denominator=this.denominator/GCD;
        
        if (this.numerator<0 && this.denominator<0 || this.numerator>0 && this.denominator<0)
        {
            this.setNumerator(this.numerator*-1);
            this.setDenominator(this.denominator*-1);
        }
        if (this.numerator==0 || this.denominator==1) {
            return ""+this.numerator;
        }
        return this.numerator + "/" + this.denominator;
    }
    
    /**
     * Perform addition between this object and another fraction f2
     * @param f2: fraction to do subtraction with
     * @return a Fraction object as result of addition
     */
    public Fraction Add(Fraction f2){
        return new Fraction(this.numerator*f2.denominator+f2.numerator*this.denominator,this.denominator*f2.denominator);
    }
    /**
     * Perform addition between this object and an integer
     * @param integer: integer to do addition with
     * @return a Fraction object as result of addition
     */
    public Fraction Add(int integer){
        Fraction f2 = new Fraction(integer,1);
        return new Fraction(this.numerator*f2.denominator+f2.numerator*this.denominator,this.denominator*f2.denominator);
    }
    
    /**
     * Perform subtraction between this object and another fraction
     * @param f2: fraction to do subtraction with fraction object
     * @return a Fraction object as result of subtraction
     */
    public Fraction Subtract(Fraction f2){
        return new Fraction(this.numerator*f2.denominator-f2.numerator*this.denominator,this.denominator*f2.denominator);
    }
    /**
     * Perform subtraction between this object and an integer
     * @param integer: integer to do subtraction with
     * @return a Fraction object as result of subtraction
     */
    public Fraction Subtract(int integer){
        Fraction f2 = new Fraction(integer,1);
        return new Fraction(this.numerator*f2.denominator-f2.numerator*this.denominator,this.denominator*f2.denominator);
    }
    
    /**
     * Perform multiplication between this object and another fraction
     * @param f2: fraction to do multiplication with
     * @return a Fraction object as result of multiplication
     */
    public Fraction Multiply(Fraction f2){
        return new Fraction(this.numerator*f2.numerator,this.denominator*f2.denominator);
    }
    /**
     * Perform multiplication between this object and an integer
     * @param integer: integer to do multiplication with
     * @return a Fraction object as result of multiplication
     */
    public Fraction Multiply(int integer){
        Fraction f2 = new Fraction(integer,1);
        return new Fraction(this.numerator*f2.numerator,this.denominator*f2.denominator);
    }
    /**
     * Perform division between this object and another fraction
     * @param f2: fraction to be the divisor
     * @return a Fraction object as result of division
     */
    public Fraction Divide(Fraction f2){
        if (f2.numerator==0) {
            System.out.println("########################################################");
            System.out.println("#        Invalid divisor, it should not be 0!          #");
            System.out.println("#             Your result will become -1               #");
            System.out.println("########################################################");
            return new Fraction(-1,1);
        }
        return new Fraction(this.numerator*f2.denominator,this.denominator*f2.numerator);
    }
    /**
     *  Perform division between this object and an integer
     * @param numerator: integer to be the divisor
     * @return a Fraction object as result of division
     */
    public Fraction Divide(int numerator){
        if (numerator==0)
        {
            System.out.println("########################################################");
            System.out.println("#           Invalid divisor, it should not be 0!       #");
            System.out.println("#                Your result will become -1            #");
            System.out.println("########################################################");
            return new Fraction(-1,1);
        }
        Fraction f2 = new Fraction(numerator,1);
        return new Fraction(this.numerator*f2.denominator,this.denominator*f2.numerator);
    }
}
