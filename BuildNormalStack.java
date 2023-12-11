import java.io.*;
import java.util.*;
class BuildNormalStack {
    public static void main(String[] args)throws Exception{
        BufferedReader brVal = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(brVal.readLine());
        CustomStack st = new CustomStack(n);
    }

    public static class CustomStack{
        int[] data;
        int tos;

        //Top Of Stack
        public CustomStack(int cap){
            data = new int[cap];
            tos = -1;
        }

        //Size of the stack
        int size(){
            return tos + 1;
        }

        void display(){
            for(int i = tos; i >= 0; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val){
            if(tos == data.length - 1){
                System.out.println("Stack Overflow");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int pop(){
            if(tos == -1){
                System.out.println("Stack nUnderflow");
                return -1;
            } else{
                 int val = data[tos];
                 tos--;
                 return val;
            }
        }
        int top(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            } else{
                return data[tos];
            }
        }

    }
}
