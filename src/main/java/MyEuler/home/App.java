package MyEuler.home;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       String input = "inni";
       char[] c = input.toCharArray();
       for (int i=0; i<c.length;i++){
    	   if (c[i] != c[c.length - i -1]) {System.out.println("false"); break;}
       }       
    }
}
