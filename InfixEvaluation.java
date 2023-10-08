import java.io.*;
import java.util.*;
class InfixEvaluation {
    public static void main(String[] args)throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        String Expression = brVal.readLine();
        //Scanner scn = new Scanner(System.in);
        //String Expression = scn.next();
        Stack <Integer> operands = new Stack<>();
        Stack <Character> operators = new Stack<>();
        for(int i = 0; i < Expression.length(); i++){
            char ch = Expression.charAt(i);
            if(ch == '('){
                operators.push(ch);
            } else if(Character.isDigit(ch)){
                operands.push(ch - '0');//convert char into integer
            } else if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    char opr = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();

                    int oprval = operations(val1, val2, opr);
                    operands.push(oprval);
                }
                operators.push(ch);
            } else if(ch == ')'){
                while(operators.size() > 0 && operators.peek() != '('){
                    char opr = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();

                    int oprval = operations(val1, val2, opr);
                    operands.push(oprval);
                }
                if(operators.size() > 0){
                    operators.pop();
                }
            }
        }

        while(operators.size() > 0){
            char opr = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            int oprval = operations(val1, val2, opr);
            operands.push(oprval);
        }
        int val = operands.pop();
        System.out.println(val);
    }

    public static int precedence(char op){
        if(op == '+'){
            return 1;
        } else if(op == '-'){
            return 1;
        } else if(op == '*'){
            return 2;
        } else {
            return 2;
        }
    }

    public static int operations(int val1, int val2, char operator){
        if(operator == '+'){
            return val1 + val2;
        } else if(operator == '-'){
            return val1 - val2;
        } else if(operator == '*'){
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }
}
