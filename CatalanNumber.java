import java.io.*;
import java.util.Scanner;
class CatalanNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int[] dpArray = new int[num + 1];
        dpArray[0] = 1; // has only one output that us blank but blank is also a output
        dpArray[1] = 1; // has one output refer Generate Parantheses in coaching folder
        for(int i = 2; i < dpArray.length; i++){ // this is refering to n-1 of first C0*C(n-1) means refering to right side C0*C(n-1) + C1*C(n-2) + C2*C(n-3) ...... C(n-1)*C0
            for(int j = 0; j < i; j++){ //this is refering to 0 of first C0*C(n-1) means refering to right side C0*C(n-1) + C1*C(n-2) + C2*C(n-3) ...... C(n-1)*C0
                dpArray[i] += dpArray[j] * dpArray[i - j - 1];
            }
        }
        System.out.println(dpArray[num]);
    }
}
