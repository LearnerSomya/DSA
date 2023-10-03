import java.io.*;
import java.util.*;

import org.w3c.dom.ls.LSException;
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
        for(int i = 0; i <= HistogramArray.length; i++){
            while(BoundaryStack.size() > 0 && HistogramArray[i] < HistogramArray[BoundaryStack.peek()]){
                BoundaryStack.pop();
            }

            if(BoundaryStack.size() == 0){
                LeftBoundary[i] = -1;
            } else {
                LeftBoundary[i] = BoundaryStack.peek();
            }
            BoundaryStack.push(i);
        }

        //Area
        int MaxHistogramArea = 0;
        for(int i = 0; i < HistogramArray.length; i++){
            int width = RightBoundary[i] - LeftBoundary[i] - 1;
            int area = HistogramArray[i] - width;
            if(area > MaxHistogramArea){
                MaxHistogramArea = area;
            }
        }

        System.out.println(MaxHistogramArea);
        
    }
}
