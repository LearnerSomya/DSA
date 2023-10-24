import java.io.*;
import java.util.*;
class SmallestNumberFollowingPattern {
    public static void main(String [] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        String Exp = brVal.readLine();

        Stack<Integer> NumberSt = new Stack<>();
        int num = 1;

        for (int i = 0; i < Exp.length(); i++){
            char ch = Exp.charAt(i);
            if(ch == 'd'){
                NumberSt.push(num);
                num++;
            } else {
                NumberSt.push(num);
                num++;
                while(NumberSt.size() > 0){
                    System.out.println(NumberSt.pop());
                }
            }
        }
        
        NumberSt.push(num);
        while(NumberSt.size() > 0){
                    System.out.println(NumberSt.pop());
                }
    }
}
