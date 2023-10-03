import java.io.*;
import java.util.*;
class LargestAreaHistogram {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //This code is to take inpur from user
        int num = Integer.parseInt(br.readLine());
        int[] HistogramArray = new int[num];
        for(int i = 0; i < num; i++){
            HistogramArray[i] = Integer.parseInt(br.readLine());
        }

        int[] RightBoundary = new int[HistogramArray.length];
        Stack<Integer> BoundaryStack = new Stack<>();
        BoundaryStack.push(HistogramArray.length - 1);
        RightBoundary[HistogramArray.length - 1] = HistogramArray.length;
        for(int i = HistogramArray.length - 2; i >= 0; i--){
            while(BoundaryStack.size() > 0 && HistogramArray[i] < HistogramArray[BoundaryStack.peek()]){
                BoundaryStack.pop();
            }
           
        }

        int[] LeftBoundary = new int[HistogramArray.length];
        BoundaryStack = new Stack<>();
        BoundaryStack.push(0);
        LeftBoundary[0] = -1;
        for(int j = 0; j < HistogramArray.length; j++){
            while(BoundaryStack.size() > 0 && HistogramArray[j] < HistogramArray[BoundaryStack.peek()]){
                BoundaryStack.pop();
            }

            if(BoundaryStack.size() == 0){
                LeftBoundary[j] = -1;
            } else {
                LeftBoundary[j] = BoundaryStack.peek();
            }
            BoundaryStack.push(j);
            
        }
        

        //Area
        int MaxHistogramArea = 0;
        for(int i = 0; i < HistogramArray.length; i++){
            System.out.println("RB "+RightBoundary[i]);
            System.out.println("LB "+LeftBoundary[i]);
            int width = RightBoundary[i] - LeftBoundary[i];
            System.out.println("width "+width);
            int area = HistogramArray[i] * width;
            System.out.println("area" + area);
            if(area > MaxHistogramArea){
                MaxHistogramArea = area;
            }
        }

        System.out.println("Max Area" + MaxHistogramArea);
        
    }
}
