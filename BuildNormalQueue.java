import java.util.*;
import java.io.*;
class BuildNormalQueue {
    public static void main(String [] args) throws Exception {
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of queue");
        int num = Integer.parseInt(brVal.readLine());
        CustomQueue qu = new CustomQueue(num);

        String str = brVal.readLine();
        while (str.equals("quit") == false ) {
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(qu.size());
            } else if (str.startsWith("display")){
                qu.display();
            }
            str = brVal.readLine();
        }
    }

    public static class CustomQueue{
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap){
            data = new int[cap];
            front = 0;
            size = 0;
        }
        void add(int val){
            if(size == data.length){
                System.out.println("Queue Overflow");
            } else {
                //here modules method is used as, when a value is added in a queue after removing some values,
                //then we add those new values in the place where old values were placed
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove(){
            if(size == 0){
                System.out.println(("Empty Queue"));
                return -1;
            } else {
                int val = data[front];
                //here we are using modules logic so that front comes back to the start of queue when values are removed from queue
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek(){
            if(size == 0){
                System.out.println("Empty Queue");
                return -1;
            } else{
                return data[front];
            }
        }

        int size(){
            return size;
        }

        void display(){
            for(int i = 0; i < size; i++){
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }
    }
}
