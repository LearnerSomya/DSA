import java.io.*;
import java.util.*;
class MinimumStackTwo {
    public static void main(String[] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        MinimumStack MinSt = new MinimumStack();
        String str = brVal.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                MinSt.push(val);
            } else if(str.startsWith("pop")){
                int val = MinSt.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = MinSt.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(MinSt.size());
            } else if(str.startsWith("Min")){
                int val = MinSt.min();
                if(val != -1){
                    System.out.println(val);
                }
            }
            str = brVal.readLine();
        }
    }
    public static class MinimumStack {
        Stack<Integer> AllData;
        int min;
        public MinimumStack(){
            AllData = new Stack<>();
        }
    
        void push(int val){
            //means if stack in empty
            if(AllData.size() == 0){
                AllData.push(val);
                min = val;
            } else if(val >= min){
                AllData.push(val);
            } else { // pushed value is less than min value
                AllData.push(val + val - min);// DETECTION, storing fake samller value 
                min = val;
            }
        }
        int top(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else{
                if(AllData.peek() >= min){
                    return AllData.peek();
                } else{
                    return min;
                }
            }
        } 
        int pop(){
             if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
             } else{
                if(AllData.peek() >= min ){
                    return AllData.pop();
                } else{
                    int originslVal = min;
                    min = 2 * min - AllData.pop();
                    return originslVal;
                }
             }
        }
        int size(){
            return AllData.size();
        }
        int min(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return min;
            }
        }
    }
}
