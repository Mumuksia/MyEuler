



// END CUT HERE
import java.util.*;
public class RainyRoad {
    public String isReachable(String[] road) {
        String res = "YES";
        
        
        char[] line1 = road[0].toCharArray();
        char[] line2 = road[1].toCharArray();
        for (int i=0;i<line1.length;i++){
        	if (line1[i] == 'W' && line2[i] == 'W') return "NO";
        }
        return "YES";/*
        int count = 0;
        int line = 1;
        
        int flag = 0;

        while (count != road[0].length() -1){
        	if (line ==1){
        		if (line1[count+1] == '.'){
        			count++;
        			flag = 0;
        		}
        		else if(line2[count+1] == '.'){
        			count ++;
        			line = 2;
        			flag = 0;
        		} else if (line2[count] == '.'){
        			line = 2;
        			flag++;
        		} else return "NO";
        	}
        	
        	if (line ==2){
        		if (line2[count+1] == '.'){
        			count++;
        			flag = 0;
        		}
        		else if(line1[count+1] == '.'){
        			count ++;
        			line = 1;
        			flag = 0;
        		} else if (line1[count] == '.'){
        			line = 1;
        			flag++;
        		} else return "NO";
        	}
        	if (count == road[0].length() -2) break;
        	if (flag >=2) return "NO";
        }
        
        
        return res;*/
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new RainyRoad()).isReachable(new String[] {".W.."
               ,"...."}),"YES");
            eq(1,(new RainyRoad()).isReachable(new String[] {".W.."
               ,"..W."}),"YES");
            eq(2,(new RainyRoad()).isReachable(new String[] {".W..W.."
               ,"...WWW."}),"NO");
            eq(3,(new RainyRoad()).isReachable(new String[] {".."
               ,"WW"}),"YES");
            eq(4,(new RainyRoad()).isReachable(new String[] {".WWWW."
               ,"WWWWWW"}),"NO");
            eq(5,(new RainyRoad()).isReachable(new String[] {".W.W.W."
               ,"W.W.W.W"}),"YES");
            eq(6,(new RainyRoad()).isReachable(new String[] {".............................................W."
               ,".............................................W."}),"NO");
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
