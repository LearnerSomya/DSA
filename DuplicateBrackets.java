import java.io.*;
import java.util.*;
class DuplicateBrackets {
    public static void main (String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')') {
                if(st.peek() == '('){
                    //this true means duplicacy exist
                    System.out.println(true);
                    return;
                } else {
                    while(st.peek() != '('){
                        st.pop();
                    }
                }
            }  else {
                    st.push(ch);
            }
        }
        System.out.println(false);
    }    
}
