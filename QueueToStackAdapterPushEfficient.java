import java.io.*;
import java.util.*;
class QueueToStackAdapterPushEfficient {
    public static void main(String[] args) throws Exception {
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        QueueToStack queueToStack = new QueueToStack();
        String str = brVal.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                queueToStack.push(val);
            } else if(str.startsWith("pop")){
                int val = queueToStack.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = queueToStack.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(queueToStack.size());
            } 
            str = brVal.readLine();
        }
    }
    public static class QueueToStack{
        Queue<Integer> MainQueue;
        Queue<Integer> HelperQueue;
        

        public QueueToStack(){
            MainQueue = new ArrayDeque<>();
            HelperQueue = new ArrayDeque<>();
        }

        void push(int val){
            MainQueue.add(val);
        }
        
        int top(){
            if(MainQueue.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else{
                while (MainQueue.size() > 1) {
                    HelperQueue.add(MainQueue.remove());
                }
                int val =MainQueue.remove();
                HelperQueue.add(val);
                
                while(HelperQueue.size() > 0){
                    MainQueue.add(HelperQueue.remove());
                }
                return val;
            }
        }

        int pop(){
            if(MainQueue.size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                while (MainQueue.size() > 1) {
                    HelperQueue.add(MainQueue.remove());
                }
                int val =MainQueue.remove(); //this line will be executed when MainQueue.size() == 0 
                while(HelperQueue.size() > 0){
                    MainQueue.add(HelperQueue.remove());
                }
                return val;
            }
        }
        
        int size(){
            return MainQueue.size();
        }
    }
}
