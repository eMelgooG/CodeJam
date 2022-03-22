import java.util.Scanner ;
public class Main {
    public static void main ( String args[] ) {
        long n ;
        Scanner in = new Scanner ( System.in ) ;
        while ( ( n = in.nextLong() ) != 0 ){
            long sq = ( int ) Math.sqrt( n ) ;
            System.out.print( ( sq * sq == n ) ? "yes\n" : "no\n" );
        }
    }
}