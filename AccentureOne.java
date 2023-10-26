import java.io.*;
import java.util.*;
class AccentureOne {
    public static void main(String [] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enetr the size of 1D Matrix");
        //enter the size of matrix
        int num = Integer.parseInt(brVal.readLine());
        int[] OneDMatrix = new int[num];
        System.out.println("Enetr element of matrix");
        for(int i = 0; i < OneDMatrix.length; i++){
            OneDMatrix[i] = Integer.parseInt(brVal.readLine());
        }

        //Dividing Matrix elements into two diferent submatrix
        int MatrixLength = OneDMatrix.length;

        //Determining the size of subMatrix
        int OddMatrixSize = (MatrixLength + 1) / 2;
        // System.out.println(OddMatrixSize);
        int EvenMatrixSize = MatrixLength / 2;
        // System.out.println(EvenMatrixSize);
        //Created two matrix
        int[] OddSubMatrix = new int[OddMatrixSize];
        int[] EvenSubMatrix = new int[EvenMatrixSize];
        //Here j = 0 as indexing starts from 0
        for(int j = 0; j < MatrixLength; j++){
            if(j % 2 == 0){
                EvenSubMatrix[j / 2] = OneDMatrix[j];
                //System.out.println("Even index Submatrix" + EvenSubMatrix );
            } else {
                OddSubMatrix[j / 2] = OneDMatrix[j];
                //System.out.println("Odd Index Submatrix" + OddSubMatrix);
            }
        }
        System.out.println("Even index Submatrix" + Arrays.toString(EvenSubMatrix));
        System.out.println("Odd Index Submatrix" + Arrays.toString(OddSubMatrix));

        //Arrays.sort sorts array in ascending order
        Arrays.sort(EvenSubMatrix);
        System.out.println("Even index Submatrix" + Arrays.toString(EvenSubMatrix) );
        Arrays.sort(OddSubMatrix);
        System.out.println("Odd Index Submatrix" + Arrays.toString(OddSubMatrix));

        int EvenSecondLargestDigit = EvenSubMatrix[EvenSubMatrix.length - 2];
        int OddSecondLargestDigit = OddSubMatrix[OddSubMatrix.length - 2];
        int SumOfSecondLargestDigits = EvenSecondLargestDigit + OddSecondLargestDigit;
        System.out.println(SumOfSecondLargestDigits);
    }
}

