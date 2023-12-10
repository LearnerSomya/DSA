import java.io.*;
import java.util.*;
class BuildNormalStack {
    public static void main(String[] args) {

    }

    public static class CustomStack{
        int[] data;
        int tos;

        public CustomStack(int cap){
            data = new int[cap];
            tos = -1;
        }
    }
}
