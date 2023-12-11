import java.io.*;
import java.util.*;
class BuildNormalStack {
    public static void main(String[] args) {

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
    }
}
