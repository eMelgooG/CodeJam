import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {

    private static String one() throws Exception {
        rl();
       StringBuilder sb = new StringBuilder(st.nextToken());

        int sum = 0;
        for(int i = 0;i<sb.length();i++) {
            sum += sb.charAt(i)-'0';
        }
        int nrToBeAdded = sum%9;
        if(nrToBeAdded==0) {
            if(sb.length()==1) {
                sb.append("0");
            } else {
                sb.insert(1,"0");
            }
            return sb.toString();

        }


            nrToBeAdded = 9 - nrToBeAdded;
        int i = 0;

        for(;i<sb.length();i++) {
            int curr = sb.charAt(i) - '0';
            if(curr > nrToBeAdded) break;
        }
        if(i == sb.length()) {
            sb.append(Integer.toString(nrToBeAdded));
        } else {
            sb.insert(i,Integer.toString(nrToBeAdded));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        /* Read line*/
        rl();
        int T = nin();

        for(int i = 1;i<=T;i++){
            bw.write(String.format("Case #%d: %s%n",i,one()));
        }
        bw.flush();
    }



    //helper methods and classes
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static void rl() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
    static long nlo(){
        return Long.parseLong(st.nextToken());
    }
    static int nin(){
        return Integer.parseInt(st.nextToken());
    }
    /*private static void te(){
      }*/
    static double ndo(){
        return Double.parseDouble(st.nextToken());
    }
    static char[] nca(){
        return st.nextToken().toCharArray();
    }



}



