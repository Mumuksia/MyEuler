// END CUT HERE

public class DropCoins {
    public int getMinimum(String[] board, int K) {
        int res = -1;
        int operations = 200;
        int tries = 0;
        boolean flag = false;
        int way = 1;//1 up 2 down 3 left 4 right

        char[][] linesBase = new char[30][30];

        for (int i = 0; i < board.length; i++) {
            linesBase[i] = board[i].toCharArray();
        }
        
       
/*        	for (int i=0;i<30;i++){  
                char[][] lines= linesBase;
        		 tries = 0;
        		 way++;
        		 way = way%5;
        		for (int j=0;j<30;j++){
        			lines = moveLines(lines, way);
           		 way++;
        		 way = way%5;
        		 tries++;
        			for (int m=0;m<30;m++){               		 
            		 lines = moveLines(lines, way);
            		 tries++;
            		 way++;
            		 way = way%5;
        				for (int l=0;l<30;l++){
        					lines = moveLines(lines, way);
        					tries++;
        					if (getCoins(lines) == K && tries < operations){
        						operations = tries;
        						flag = true;
        					}
        					
        					
        				}        					
        			}
        		}
        		
        	}*/


        if (flag) return operations;


        return res;
    }

    public int getCoins(char[][] lines) {
        int count = 0;
        for (char[] cs : lines) {
            for (char c : cs) {
                if (c == 'o') count++;
            }
        }
        return count;
    }
    
/*    public char[][] moveRec(char[][] line, int way, List<Integer> pastWay, int K){
    	List<Integer> oper = new ArrayList<Integer>();
    	if (getCoins(line) < K || getCoins(line) ==0){
    		return moveRec(line, pastWay.get(0), pastWay, K);
    	}
    	if (pastWay.isEmpty()){
    		way++;
    		way = way%5;
    		
    		moveRec(line)
    	}
    	
    }*/

    public char[][] moveLines(char[][] line, int way) {
        char[][] res = new char[30][30];
        if (way == 1) {
            for (int i = 1; i < line.length; i++) {
                res[i - 1] = line[i];
            }
        } else if (way == 2) {
            for (int i = 0; i < line.length - 1; i++) {
                res[i + 1] = line[i];
            }
        } else if (way == 3) {
            for (int i = 0; i < line.length; i++) {
                for (int j = 1; j < line[i].length; j++) {
                    res[i][j - 1] = line[i][j];
                }
            }
        } else if (way == 4) {
            for (int i = 0; i < line.length; i++) {
                for (int j = 0; j < line[i].length - 1; j++) {
                    res[i][j + 1] = line[i][j];
                }
            }
        }
        return res;
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new DropCoins()).getMinimum(new String[]{".o.."
                    , "oooo"
                    , "..o."}
                    , 3), 2);
            eq(1, (new DropCoins()).getMinimum(new String[]{".....o"
                    , "......"
                    , "oooooo"
                    , "oooooo"
                    , "......"
                    , "o....."}
                    , 12), 3);
            eq(2, (new DropCoins()).getMinimum(new String[]{"...."
                    , ".oo."
                    , ".oo."
                    , "...."}
                    , 3), -1);
            eq(3, (new DropCoins()).getMinimum(new String[]{"......."
                    , "..ooo.."
                    , "ooooooo"
                    , ".oo.oo."
                    , "oo...oo"}
                    , 12), 4);
            eq(4, (new DropCoins()).getMinimum(new String[]{"................."
                    , ".ooooooo...oooo.."
                    , ".ooooooo..oooooo."
                    , ".oo.......oo..oo."
                    , ".oo.......oo..oo."
                    , ".ooooo.....oooo.."
                    , ".ooooooo...oooo.."
                    , ".....ooo..oo..oo."
                    , "......oo..oo..oo."
                    , ".ooooooo..oooooo."
                    , ".oooooo....oooo.."
                    , "................."}
                    , 58), 6);
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, char a, char b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
    }

    private static void eq(int n, long a, long b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b)
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b))
            System.err.println("Case " + n + " passed.");
        else
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(int a) {
        System.err.print(a + " ");
    }

    private static void print(long a) {
        System.err.print(a + "L ");
    }

    private static void print(String s) {
        System.err.print("\"" + s + "\" ");
    }

    private static void print(int[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if (rs == null) return;
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if (i != rs.length - 1)
                System.err.print(", ");
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
