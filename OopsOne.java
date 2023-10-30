import java.io.*;
import java.util.*;
class OopsOne {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.saysHi();
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
