import java.io.*;
import java.util.*;
class PostfixEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Exp = br.readLine();

        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();
        for(int i = 0; i < Exp.length(); i++){
            char ch = Exp.charAt(i);
            if(ch == '-' || ch == '+' || ch == '*' || ch == '/'){
                int v2 = valueStack.pop();
                int v1 = valueStack.pop();
                int val = operations(v1, v2, ch);
                System.out.println(val);
                valueStack.push(val);

                String inv2 = infixStack.pop();
                String inv1 = infixStack.pop();
                String inval = "(" + inv1 + ch + inv2 + ")";
                System.out.println(inval);
                infixStack.push(inval);
                
                String prev2 = prefixStack.pop();
                String prev1 = prefixStack.pop();
                String preval = "(" + ch + prev1 + prev2 +")";
                System.out.println(preval);
                prefixStack.push(preval);
            } else {
                valueStack.push(ch - '0');
                System.out.println(valueStack);
                infixStack.push(ch + "");
                System.out.println(infixStack);
                prefixStack.push(ch + "");
                System.out.println(prefixStack);
            }
        }
        System.out.println(valueStack.pop());
        System.out.println(infixStack.pop());
        System.out.println(prefixStack.pop());
        
    }
    public static int operations(int v1, int v2, char op) {
        if(op == '+'){
            return v1 + v2;
        } else if(op == '-'){
            return v1 - v2;
        } else if( op == '*'){
            return v1 * v2;
        } else if (op == '/'){
            return v1 / v2;
        } else {
            return 0;
        }
    }
}
