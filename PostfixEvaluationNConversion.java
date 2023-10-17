import java.io.*;
import java.util.*;
class PostfixEvaluationNConversion{
    public static void main(String [] args) throws Exception {
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        String Exp = brVal.readLine();

        Stack<Integer> ValueSt = new Stack<>();
        Stack<String> InfixSt = new Stack<>();
        Stack<String> PrefixSt = new Stack<>();

        for(int i = 0; i < Exp.length(); i++){
            char ch = Exp.charAt(i);
            if(Character.isDigit(ch)){
                //Converting character into integer as it takes value in ascii value, ascii vallue of "0" is 48
                ValueSt.push(ch - '0');
                System.out.println("Value Stack" + ValueSt);
                //Converting character value into integer as we have to print values in this stack
                InfixSt.push(ch + "");
                System.out.println("Infix Stack" + InfixSt);
                //changing charater value into integer as we have to print values in this stack
                PrefixSt.push(ch + "");
                System.out.println("Prefox Stack" + PrefixSt);
            } else if(ch =='+' || ch == '-' || ch == '*' || ch == '/'){
                int Val2 = ValueSt.pop();
                int Val1 = ValueSt.pop();
                int ValueOperation = Operation(Val1, Val2, ch);
                ValueSt.push(ValueOperation);

                String InVal2 = InfixSt.pop();
                String InVal1 = InfixSt.pop();
                String InfixValue = "(" + InVal1 + ch + InVal2 + ")";
                InfixSt.push(InfixValue);

                String PreVal2 = PrefixSt.pop();
                String PreVal1 = PrefixSt.pop();
                String PrefixValue = ch + PreVal1 + PreVal2;
                PrefixSt.push(PrefixValue);
            }
        }
        System.out.println(ValueSt.pop());
        System.out.println(InfixSt.pop());
        System.out.println(PrefixSt.pop());
    }


    public static int Operation(int Val1, int Val2, char Operator){
        if(Operator == '+'){
            return Val1 + Val2;
        } else if (Operator == '-'){
            return Val1 - Val2;
        } else if (Operator == '*'){
            return Val1 * Val2;
        } else if (Operator == '/'){
            return Val1 / Val2;
        } else {
            return 0;
        }
    }
}