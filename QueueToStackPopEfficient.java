import java.io.*;
import java.util.*;
class QueueToStackPopEfficient {
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in);
        Stack<Integer> st = new Stack<>();
        QueueToStack queueToStack = new QueueToStack();
        int num = scn.nextInt();
        while(num != -1){
            st.push(num);
            num = scn.nextInt();
        }

        while (queueToStack.size() > 0) {
            System.out.println(queueToStack.pop());
        }
    }

    public static class QueueToStack{
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
