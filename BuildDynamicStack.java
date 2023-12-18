//in Dynamic Stack we will increase the size of stack when extra value is being added
//basiclly will increase the size of stack 
import java.io.*;
import java.util.*;
class BuildDynamicStack{
    public static void main(String[] args)throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(brVal.readLine());
        DynamicStack st = new DynamicStack(n);
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
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if (str.startsWith("display")){
                st.display();
            } 
            str = brVal.readLine();
        }
    }
    public static class DynamicStack{
        //System.out.println("Eneter values in stack");
        int[] data;
        int tos;
        //Top Of Stack
        public DynamicStack(int cap){
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
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < data.length; i++){
                    ndata[i] = data[i];
                }
                data = ndata;
                tos++;
                data[tos] = val;
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