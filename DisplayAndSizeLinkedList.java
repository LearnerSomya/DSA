import java.io.*;
import java.util.*;
class DisplayAndSizeLinkedList {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("addLast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if(str.startsWith("size")){
                System.out.println(list.size());
            } else if(str.startsWith("display")){
                list.display();
            }
            str = br.readLine();
        }
        testList(list);
    }
    public static void testList(LinkedList list){
        for(Node temp = list.head; temp != null; temp = temp.next){
            System.out.println(temp.data);
        }
        System.out.println(list.size);

        if(list.size > 0){
            System.out.println(list.tail.data);
        }
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        //adding value in linkedList at end
        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            } else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        //display entred value
        public int size(){
            return size;
        }

        public void display(){
            Node tempValue = head;
            while(tempValue != null){
                System.out.println(tempValue.data + " ");
                tempValue = tempValue.next;
            }
            System.out.println();
        }
    }
    public static class Node{
        int data;
        Node next;
    }
}
