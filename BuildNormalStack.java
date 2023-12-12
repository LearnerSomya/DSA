import java.io.*;
import java.util.*;
class BuildNormalStack {
    public static void main(String[] args)throws Exception{
        BufferedReader brVal = new BufferedReader (new InputStreamReader(System.in));
        //System.out.println("enter size of the stack");
        int n = Integer.parseInt(brVal.readLine());
        CustomStack st = new CustomStack(n);
        String str = brVal.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                } 
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if (str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("display")){
                st.display();
            } str = brVal.readLine();
        }
    }

    public static class CustomStack{
        //System.out.println("Eneter values in stack");
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
