import java.util.*;
import java.io.*;
class GoogleInterviewQuestionOne{
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Matrix Size ");
        int matrixSize = scn.nextInt();
        int[][] InputMatrix = new int[matrixSize][matrixSize];
        System.out.println("Enter values");
        for(int a = 0; a < InputMatrix.length; a++){
            for(int b = 0; b < InputMatrix[0].length; b++){
                InputMatrix[a][b] = scn.nextInt();
            }
        }

        //Display 
        System.out.println("Matrix you entered");
        for(int x = 0; x < InputMatrix.length; x++){
            for(int y = 0; y < InputMatrix[0].length; y++){
                System.out.print(InputMatrix[x][y] + " ");
            }
            System.out.println();
        }

        int minRow = 0;
        int minCol = 0;
        int maxRow = InputMatrix.length - 1;
        int maxCol = InputMatrix[0].length - 1;
        //Outer Square
        System.out.println("Outer Circle");
        //Outer box top side
        for(int i = minRow , j = minCol; j <= maxCol; j++){
            if(InputMatrix[i][j] == 1 ){
                System.out.println("Location " + i + " " + j);
            }
        }
        //outer box right side 
        for(int i = minRow, j = maxCol; i <= maxRow; i++){
            if(InputMatrix[i][j] == 1){
                System.out.println("Location " + i + " " + j);
            }
        }
        //outer box bottom side
        for(int i = maxRow, j = maxCol; j >= minCol; j--){
            if(InputMatrix[i][j] == 1){
                System.out.println("Location " + i + " " + j);
            }
        }
        //outer box left side
        for(int i = maxRow, j = 0; i >= minRow; i--){
            if(InputMatrix[i][j] == 1){
                System.out.println("Location " + i + " " + j);
            }
        }

        //Modified Matrix
        int[][] ModifiedMatrix = new int[matrixSize][matrixSize];

        //Inner 1st Square
        int changeRowCount = 1;
        int changeColCount = 1;
        //Inner 1st square top side
        System.out.println("1st Inner Circle");
        for(int i = minRow + changeRowCount, j = minCol + changeColCount; j <= maxCol - changeColCount; j++){
            if(InputMatrix[i][j] == 1){
                //checking adjucent 1 in previous column in the same row
                if(InputMatrix[i][j - 1] == 1){
                    System.out.println("1 is present in outer square");
                    System.out.println("Location " + i + " " + j);
                    ModifiedMatrix[i][j] = InputMatrix[i][j];
                } else {
                    System.out.println("1 is not present in outer square");
                    System.out.println("Location " + i + " " + j);
                    ModifiedMatrix[i][j] = 0;
                }
            }
        }
        //Matrix afrer replacement is done
        //Display 
        System.out.println("Matrix you You get");
        for(int x = 0; x < ModifiedMatrix.length; x++){
            for(int y = 0; y < ModifiedMatrix[0].length; y++){
                System.out.print(ModifiedMatrix[x][y] + " ");
            }
            System.out.println();
        }
    }
}