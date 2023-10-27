import java.beans.Expression;
import java.io.*;
import java.util.*;
class CheckPassword {
    public static void main(String [] args) throws Exception{
        BufferedReader brVal = new BufferedReader(new InputStreamReader(System.in));
        String Expression = brVal.readLine();
        System.out.println(checkPassword(Expression, Expression.length()));
    }

    public static int checkPassword (String str, int n){
        if(n < 4){
            //As the length of passsword must be more than 4
            return 0;
        }

        if(Character.isDigit(str.charAt(0))){
            return 0;
        }
        int numDigit = 0;
        int capitalLetter = 0;
        for(int i = 0;  i < str.length(); i++){
            if(str.charAt(i) == ' ' || str.charAt(i) == '/'){
                return 0;
            }
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                numDigit++;
            }
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                capitalLetter++;
            }
        }
        if(capitalLetter > 0 && numDigit > 0){
            return 1;
        } else{
            return 0;
        }
    }
}
