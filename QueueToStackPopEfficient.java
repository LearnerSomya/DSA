import java.io.*;
import java.util.*;
class QueueToStackPopEfficient {
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
        Stack<Integer> st = new Stack<>();
        Queue<Integer> MainQueue;
        Queue<Integer> HelpingQueue;

        public QueueToStack(){
            MainQueue = new ArrayDeque<>();
            HelpingQueue = new ArrayDeque<>();
        }

        int size(){
           return MainQueue.size();
        }

        void push(int val){
            while(MainQueue.size()> 0){
                HelpingQueue.add(MainQueue.remove());
            }
            MainQueue.add(val);

            while(HelpingQueue.size() > 0){
                MainQueue.add(HelpingQueue.remove());
            }
        }

        int pop(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else{
                return MainQueue.remove();
            }
        }

        int top(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else{
                return MainQueue.peek();
            }
        }
    }
}
