import java.util.*;
import java.io.*;
class SumOfTwoArray {
    public static void main (String[] args) throws Exception{
        System.out.println("Enter First Array Size");
        Scanner scn = new Scanner(System.in);
        int FirstArraySize = scn.nextInt();
        int [] FirstArray = new int[FirstArraySize];
        System.out.println("Enter First Array Numbers");
        for(int i = 0; i < FirstArray.length; i++){
            FirstArray[i] = scn.nextInt();
        }

        System.out.println("Enter Second Array Size");
        int SecondArraySize = scn.nextInt();
        int [] SecondArray = new int[SecondArraySize];
        System.out.println("Enter Second Array Numbers");
        for(int j = 0; j < FirstArray.length; j++){
            FirstArray[j] = scn.nextInt();
        }

        int [] SumOfArray = new int[FirstArraySize > SecondArraySize ? FirstArraySize : SecondArraySize];
        int carry = 0;

        int FirstArrayPosition = FirstArray.length - 1;
        int SecondArrayPosition = SecondArray.length - 1;
        int SumOfArrayPosition = SumOfArray.length - 1;

        while(SumOfArrayPosition >= 0){
            int Digit = carry;

            if(FirstArrayPosition >= 0 ){
                Digit += FirstArray[FirstArrayPosition];
            } 
            if(SecondArrayPosition >= 0){
                Digit += SecondArray[SecondArrayPosition];
            }

            //Divide
            carry = Digit/10;

            //Reduce the number
            Digit = Digit % 10;

            SumOfArray[SumOfArrayPosition] = Digit;
            FirstArrayPosition--;
            SecondArrayPosition--;
            SumOfArrayPosition--;
        }

        System.out.println("Sum Of Two Array");
        if(carry != 0){
            System.out.println(carry);
        }
        for(int val:SumOfArray){
            System.out.println(val);
        }
    }    
}
