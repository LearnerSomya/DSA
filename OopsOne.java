import java.io.*;
import java.util.*;
class OopsOne {
    public static void main(String[] args){

    }

    //Here we created class Person
    public static class Person{
        //int age and String name are two datamembers
        int age;
        String name;

        //saysHi is function name
        void saysHi(){
            System.out.println(name + "(" + age + ") says hi");
        }
    }
}
