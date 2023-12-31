import java.util.*;
import java.io.*;
class MinimumStackOne {
    public static void main (String[] args)throws Exception{
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
    public static class MinimumStack{
        //Here we used two stack one for keeping all entred values o
        //ther for valuse wich are lesser than the earler entred value
        Stack<Integer> AllData;
        Stack<Integer> MinData;
        public MinimumStack(){
            AllData = new Stack<>();
            MinData = new Stack<>();
        }
        void push(int val){
            AllData.push(val);
            //here in push function we are filling both stacks, AllData will have all values
            //MinData stack will have values which are less then previously entred value
            //at first in MinData 1st entred value is pushed 
            if(MinData.size() == 0 || val <= MinData.peek()){
                MinData.push(val);
            }
        }
        int pop(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = AllData.pop();

                if(val == MinData.peek()){
                    MinData.pop();
                }
                return val;
            }
        } 
        int top(){
            if(size() == 0){
                System.out.println("Stack Undereflow");
                return -1;
            } else {
                return AllData.peek();
            }
        }
        int size(){
            return AllData.size();
        }
        int min(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else{
                return MinData.peek();
            }
        }
    }
}
