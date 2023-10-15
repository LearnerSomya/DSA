import java.io.*;
import java.util.*;
class InfixConversion {
    public static void main(String[] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        String Expression = brVal.readLine();
        Stack <String> Prefix = new Stack<>();
        Stack <Character> Operators = new Stack<>();
        Stack <String> Postfix = new Stack<>();
        for (int i = 0; i < Expression.length(); i++){
            char ch = Expression.charAt(i);
            if(ch == '('){
                Operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z' )){
                Postfix.push(ch + "");
                Prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*'){
                while(!Operators.isEmpty() && Operators.peek() != '(' && Operators.size() > 0 && Precedence(ch) <= Precedence(Operators.peek())){ 
                    Process(Operators, Postfix, Prefix);
                    // char op = Operators.pop();
                    // String PostVal2 = Postfix.pop();
                    // String PostVal1 = Postfix.pop();
                    // String PostVal = PostVal1 + PostVal2 + op;
                    // Postfix.push(PostVal);

                    // String PreVal2 = Prefix.pop();
                    // String PreVal1 = Prefix.pop();
                    // String PreVal = op + PreVal1 + PreVal2;
                    // Prefix.push(PreVal);
                }
                Operators.push(ch);
            } else if(ch == ')'){
                while(Operators.peek() != '('){
                    Process(Operators, Postfix, Prefix);
                    // char op = Operators.pop();
                    // String PostVal2 = Postfix.pop();
                    // String PostVal1 = Postfix.pop();
                    // String PostVal = PostVal1 + PostVal2 + op;
                    // Postfix.push(PostVal);

                    // String PreVal2 = Prefix.pop();
                    // String PreVal1 = Prefix.pop();
                    // String PreVal = op + PreVal1 + PreVal2;
                    // Prefix.push(PreVal);
                }
                Operators.pop();
            }
        }
        while(Operators.size() > 0){
            Process(Operators, Postfix, Prefix);
        //     char op = Operators.pop();
        //     String PostVal2 = Postfix.pop();
        //     String PostVal1 = Postfix.pop();
        //    String PostVal = PostVal1 + PostVal2 + op;
        //     Postfix.push(PostVal);
        //     String PreVal2 = Prefix.pop();
        //     String PreVal1 = Prefix.pop();
        //     String PreVal = op + PreVal1 + PreVal2;
        //     Prefix.push(PreVal);
        }
        System.out.println("Postfix " + Postfix.pop());
        System.out.println("Prefix " + Prefix.pop());
    }

    public static void Process(Stack<Character> Operators, Stack<String> Postfix, Stack<String> Prefix){
        char op = Operators.pop();
            String PostVal2 = Postfix.pop();
            String PostVal1 = Postfix.pop();
           String PostVal = PostVal1 + PostVal2 + op;
            Postfix.push(PostVal);
            String PreVal2 = Prefix.pop();
            String PreVal1 = Prefix.pop();
            String PreVal = op + PreVal1 + PreVal2;
            Prefix.push(PreVal);
    }

    public static int Precedence(char op){
        if(op == '+' || op == '-'){
            return 1;
        } else if (op == '*' || op == '/'){
            return 2;
        } else {
            return 0;
        }
    }
}
