import java.io.*;
import java.util.*;
class InfixEvaluation {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String Expression = scn.next();
        Stack <Integer> operands = new Stack<>();
        Stack <Integer> operators = new Stack<>();
        for(int i = 0; i < Expression.length(); i++){
            char ch = Expression.charAt(i);
            if(ch == '('){
                operators.push(ch);
            } else if(Character.isDigit(ch)){
                operands.push(ch - '0');
            } else if( ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size){}
            }
        }
    }
}
