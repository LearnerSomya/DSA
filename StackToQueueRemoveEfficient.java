import java.io.*;
import java.util.*;
class StackToQueueRemoveEfficient {
    public static void main(String[] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        StackToQueue stackToQueue = new StackToQueue();
        String str = brVal.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                stackToQueue.add(val);
            } else if(str.startsWith("remove")){
                int val = stackToQueue.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = stackToQueue.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(stackToQueue.size());
            } 
            str = brVal.readLine();
        }
    }

    public static class StackToQueue{
        Stack<Integer> MainStack;
        Stack<Integer> HelperStack;

        public StackToQueue(){
            MainStack = new Stack<>();
            HelperStack = new Stack<>();
        }
        void add(int val){
            while(MainStack.size() > 0){
                HelperStack.push(MainStack.pop());
            }
            MainStack.push(val);
            while (HelperStack.size() > 0) {
                MainStack.push(HelperStack.pop());
            }
        }

        int remove() {
            if(size() == 0){
                System.out.println("Queue is Empty");
                return -1;
            } else{
                return MainStack.pop();
            }

        }

        int peek(){
            if(size() == 0){
                System.out.println("Queue is Empty");
                return -1;
            } else{
                return MainStack.peek();
            }
        }

        int size(){
            return MainStack.size();
        }
    }
}
