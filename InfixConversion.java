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
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <. 'z') || (ch >= 'A' && ch <= 'Z' )){

            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*'){

            } else if(ch == ')'){

            }
        }
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
