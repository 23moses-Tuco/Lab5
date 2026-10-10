import java.util.Scanner;
/**
 * This program will contain two methods, the first is main and the second
 * is getDistance. Utilizing an int paramater called seconds, getDistance()
 * will calculate the distance fallen while main displays it in a readable
 * format.
 *
 * @author Moses Mendez
 * @version v1.0
 * @since 10/4/2026
 */
public class FallingDistance
{
    // instance variables - replace the example below with your own
    public static int sec;
    public double tsquared, result;
    public static final double ACCELERATION = 9.8;
    public static final String promptSec = "Please enter how many seconds to compute: ";
    public static final String headerLabels = "Time(secs) Distance(m)";
    public static final String headerUnder =  "========= ===========";
    static Scanner keyboardIn = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print(promptSec);
        sec = keyboardIn.nextInt();
        System.out.println(headerLabels);
        System.out.println(headerUnder);
        
        FallingDistance calc = new FallingDistance();
        for(int i=1;i<=sec;i++){
         System.out.printf("%-10d %-10.1f%n", i, calc.getDistance(i));    
        }
    }

    /**
     * This method will utilize an int called secIn and will return a double
     * which displays, in meters, how far an object has fallen based on the 
     * physics equation.
     *
     * @param  sec; seconds to be calculated; int
     * @return result; distance fallen; double
     */
    public double getDistance(int secIn)
    {
         tsquared = Math.pow(secIn,2);
         result = ACCELERATION*0.5*tsquared;
         return result;
    }
}