public class Karatsuba {
    
    public static int max(int x, int y) {
        return (x>y)? x:y;
    }
    
    public static String[] strCopy(long index, String string) {
        String  first = "",
                last = "";
        long actualIndex = string.length() - index;
        for (int i = 0; i<actualIndex; i++) {
            first+=string.charAt(i);
        }
        for (int i = (int)actualIndex; i<string.length(); i++) {
            last+=string.charAt(i);
        }
        return new String[] {first, last};
    }
    
    // An exponent function. Works the same way as Math.pow, but with 64bit integers instead of double precision floats.
    public static long power(long x, long y) {
        if (y == 0)
            return 1;
        else {
            long answer = 1;
            for (int i = 1; i<=y; i++) {
                answer *= x;
            }
            return answer;
        }
    }
    
    
    public static long karatsuba(long x, long y) {
        // Base case: single digit multiplication
        if (x<10 || y<10) {
            return x * y;
        }
        else {
            
            String xString = Integer.toString((int)x);
            String yString = Integer.toString((int)y);
            // Local variables
            long    m = max(xString.length(), yString.length()), // the maximum # of digits
                    m2 = m/2, // the middle; if the number is odd, it will floor the fraction
                    high1 = Integer.parseInt(strCopy(m2, xString)[0]), // the most significant digits. this is the scalar multiplier for b^m2
                    low1 = Integer.parseInt(strCopy(m2, xString)[1]), // the least significant digits. this is what is added on to high1*b^m2
                    high2 = Integer.parseInt(strCopy(m2, yString)[0]), // same for y
                    low2 = Integer.parseInt(strCopy(m2, yString)[1]), // same for y
                    // Three recursive calls
                    z0 = karatsuba(low1, low2), // z0 = x0y0
                    z2 = karatsuba(high1, high2), // z2 = x1y1
                    z1 = karatsuba((low1 + high1), (low2 + high2)) - z2 - z0; // z1 = (x0 + y1)*(x1 + y0) - z2 - z0, courtesy of Karatsuba

            return (z2 * power(10, 2*m2) + (z1 * power(10, m2)) + z0);
        }
    }
    
    

    public static void main(String[] args) {
        
        System.out.println(karatsuba(200, 200));
        System.out.println(karatsuba(12345, 6789));
        System.out.println(karatsuba(2358925, 1259174));
    }

}
