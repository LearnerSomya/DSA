import java.io.*;
import java.util.*;
class MergeOverlapping {
    public static void main(String [] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter count of intervals you want to enter");
        int num = Integer.parseInt(brVal.readLine());
    }

    //Created a class here
    public static class Pair{
        int startTime;
        int endTime;
        Pair(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
