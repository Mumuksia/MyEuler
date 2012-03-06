package com.euler;


import java.util.*;
public class BinaryCode {
    public String[] decode(String message) {
        String[] res = new String[2];
        char[] msgs = message.toCharArray();
        int[] resc = new int[msgs.length +2];
        int[] input = new int[msgs.length +2];
        //1block resc1 = 0;
        
        for (int i=0;i<msgs.length; i++){
        	input[i] = Integer.valueOf(String.valueOf(msgs[i]));
        }
        
        resc[0] = 0;
        resc[1] = input[0];
        
        
        res[0] = String.valueOf(resc[0]) + String.valueOf(resc[1]);
        
        for (int i=1;i<msgs.length; i++){
        	resc[i+1] = input[i] - resc[i] - resc[i-1]; 
        	if (resc[i+1] > 1 || resc[i+1] < 0) 
        		{
        		res[0] = "NONE";
        		break;
        		}
        	else {
        		if (i < msgs.length-1){
        		res[0] += resc[i+1];
        		}
        	}
        }
        
        if (resc[1] > 1){
        	res[0] ="NONE";
        }
        
       
        //2
        resc[0] = 1;
        resc[1] = input[0] - 1;
        
        
        res[1] = String.valueOf(resc[0]) + String.valueOf(resc[1]);
        
        for (int i=1;i<msgs.length; i++){
        	resc[i+1] = input[i] - resc[i] - resc[i-1]; 
        	if (resc[i+1] > 1 || resc[i+1] < 0) 
        		{
        		res[1] = "NONE";
        		break;
        		}
        	else {
        		if (i < msgs.length-1){
        		res[1] += resc[i+1];
        		}
        	}
        }
        
        if (resc[1] > 1){
        	res[1] ="NONE";
        }
        
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new BinaryCode()).decode("123210122"),new String[] { "011100011",  "NONE" });
            eq(1,(new BinaryCode()).decode("11"),new String[] { "01",  "10" });
            eq(2,(new BinaryCode()).decode("22111"),new String[] { "NONE",  "11001" });
            eq(3,(new BinaryCode()).decode("123210120"),new String[] { "NONE",  "NONE" });
            eq(4,(new BinaryCode()).decode("3"),new String[] { "NONE",  "NONE" });
            eq(5,(new BinaryCode()).decode("12221112222221112221111111112221111"),new String[] { "01101001101101001101001001001101001",  "10110010110110010110010010010110010" });
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
