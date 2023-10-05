import java.io.*;
import java.util.*;
class SlidingWindowMax {
    public static void main(String[] args) throws Exception {
        BufferedReader brVar = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Array Size");
        int num = Integer.parseInt(brVar.readLine());
        int[] SlidingWindowInputArray = new int[num];
        System.out.println("Enter Element ");
        for(int i = 0; i < SlidingWindowInputArray.length; i++){
            SlidingWindowInputArray[i] = Integer.parseInt(brVar.readLine());
        }
        System.out.println("Window Size");
        int WindowSize = Integer.parseInt(brVar.readLine());

        Stack<Integer> SlidingWindowElementStack = new Stack<>();
        //this NextGreaterElemt we made to check next greater element so that we have if greater element 
        //is out of window then window will have last element of window as greater element of window
        int[] NextGreaterElement =  new int[SlidingWindowInputArray.length];

        //In stck we pushed the index values of elements
        SlidingWindowElementStack.push(SlidingWindowInputArray.length - 1);
        NextGreaterElement[SlidingWindowInputArray.length - 1] = SlidingWindowInputArray.length;

        for(int i = SlidingWindowInputArray.length - 2; i >= 0; i-- ){
            while(SlidingWindowElementStack.size() > 0 && SlidingWindowInputArray[i] >= SlidingWindowInputArray[SlidingWindowElementStack.peek()]){
                SlidingWindowElementStack.pop();
            }

            if(SlidingWindowElementStack.size() == 0){
                NextGreaterElement[i] = SlidingWindowInputArray.length;
            } else {
                NextGreaterElement[i] = SlidingWindowElementStack.peek();
            }

            SlidingWindowElementStack.push(i);
        }

        int k = 0;
        System.out.println("Max of Window of" + WindowSize);
        for(int j = 0; j <= SlidingWindowInputArray.length - WindowSize; j++){
            if(k < j){
                k = j;
            }

            while(NextGreaterElement[k] < j + WindowSize){
                k = NextGreaterElement[k];
            }

            System.out.println(SlidingWindowInputArray[k]);
        }
    }
}
