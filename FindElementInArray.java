import java.io.*;
import java.util.*;
class FindElementInArray{
    public static void main(String[] args) throws Exception{
        System.out.println("Enter Count of Numbers");
        Scanner scn = new Scanner(System.in);
        int ArraySize = scn.nextInt();
        int [] Array = new int[ArraySize];
        //Taking user input of numbers in array
        System.out.println("Enter Numbers");
        for (int i = 0; i < Array.length; i++){
            Array[i] = scn.nextInt();
        }

        System.out.println("Number you want to find");
        //We gave index as value -1 because when user enters numbers the value index starts counting from 0 
        int index = -1; 
        int NumToFind = scn.nextShort();
        for(int a = 0; a < Array.length; a++){
            if(Array[a] == NumToFind){
                index = a;
            }
        }
        System.out.println("Number is at index " + index);
    }
}