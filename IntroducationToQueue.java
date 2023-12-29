import java.util.*;
class IntroducationToQueue {
    public static void main (String[] args){
        //Queue and Dqueue are interfaces where Queue Interface is implementd by Dqueue Interface and ArrayDque in a class,
        //and then Dqueue Interface is implemented by ArrayDque class 
        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);
        

        System.out.println(que.remove());
        System.out.println(que);

        System.out.println(que.peek());
        System.out.println(que);
    }
}
