import java.io.*;
import java.util.*;
class MergeOverlapping {
    public static void main(String [] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter count of intervals you want to enter");
        int num = Integer.parseInt(brVal.readLine());
        //num creates rows and 2 creats coloums
        int[][] arr = new int[num][2];

        for(int j = 0; j < num; j++){
            String line = brVal.readLine();
            //will have start time
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            //will have end time 
            arr[j][1] = Integer.parseInt(line.split(" ")[0]);
        }
        MergeOverlappingIntervals(arr);
    }

    public static void MergeOverlappingIntervals(int[][] arr){
        //This Pair[] here we made object "pairs" for class Pair
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++ ){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> startTime = new Stack<>();
        for(int i = 0; i < pairs.length; i++){
            if(i == 0){
                startTime.push(pairs[i]);
            } else{
                Pair top = startTime.peek();
                //Pair curr = pairs[i];

                if(pairs[i].startTime > top.endTime){
                    startTime.push(pairs[i]);
                } else{
                    top.endTime = Math.max(top.endTime, pairs[i].endTime);
                }
            }
        }

        Stack<Pair> resultStack = new Stack<>();
        while(startTime.size() > 0){
            resultStack.push(startTime.pop());
        }
        while(resultStack.size() > 0){
            Pair p = resultStack.pop();
            System.out.println(p.startTime + " " + p.endTime);
        }
        
    }

    //Created a class here, in java direct sort functions sorts integer array,
    // but to sort ibject array, we need to provide java to take which object greater and which object smaller

    public static class Pair implements Comparable<Pair>{
        int startTime;
        int endTime;
        Pair(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        //this > other reture +ve
        //this = other reture 0
        //this < other reture -ve

        public int compareTo(Pair other){
            if(this.startTime != other.startTime){
                return this.startTime - other.startTime;
            } else{
                return this.endTime - other.endTime;
            }
        }
    }
}
