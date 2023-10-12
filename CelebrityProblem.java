import java.io.*;
import java.util.*;
class CelebrityProblem {
    public static void main(String[] args) throws Exception {
        //Scanner scn = new Scanner(System.in);
        //int n = scn.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int j = 0; j < n; j++){
            String line = br.readLine();
            for(int k = 0; k < n; k++){
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }
    public static void findCelebrity(int arr[][]) {
        Stack <Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            st.push(i);
        }
        while(st.size() >= 2){
            int a = st.pop();
            int b = st.pop();
            if(arr[a][b] == 1){
                //if a knows b than a is snot celebrity
                st.push(b);
            } else{
                //if a doesnt know b than b is not celebrity
                st.push(a);
            }
        }
        int potCeleb = st.pop();
        for(int i = 0; i < arr.length; i++){
            if(i != potCeleb){
                // here we are checking row nd coloum of the value potCeleb that is whay,here row or coloumn are of same value
                if(arr[i][potCeleb] == 0 || arr[potCeleb][i] == 1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potCeleb);
        
 }
}
