import java.util.Scanner;
/**
 * This program will tell the use if the number they have input is a prime number or not.
 *
 * @author Moses Mendez
 * @version v1.0
 * @since 10/4/2026
 */
public class PrimeNumbers
{
    // instance variables - replace the example below with your own
    public static int assessed;
    public static String again;
    public static boolean result = true;
    public static final String yesPrime = " is prime";
    public static final String noPrime = " is not prime";
    public static final String promptIn = "Enter a whole number>2 (ie 19) to test if prime: ";
    public static final String promptAgain = "Enter yes to test another number, no to quit. ";
    public static void main(String[] args)
    {
        PrimeNumbers game = new PrimeNumbers();
        Scanner keyboard = new Scanner(System.in);
        do{
            //input int
            System.out.print(promptIn);
            while(!(keyboard.hasNextInt())){
                System.out.print(promptIn);
                keyboard.next();
            }
            assessed = keyboard.nextInt();

            //test int then ask again.
            if(game.testForPrime(assessed)){
                System.out.printf("%d"+yesPrime+"%n", assessed);
            }else{
                System.out.printf("%d"+noPrime+"%n", assessed);
            }
            
            //clear for next input, then read whether we should continue.
            keyboard.nextLine();
            
            //
            System.out.print(promptAgain);
            again = keyboard.nextLine().trim().toUpperCase();
        }while(!again.equals("NO"));
    }
    
    /**
     * testForPrime does as the name implies, which is to test whether a number is prime or not.
     *
     * @param  assessed2; number to be assessed; int
     * @return  result; is or is not prime; boolean
     */
    public boolean testForPrime(int assessed2)
    {
            //test if prime
            int sqrtN = (int)Math.sqrt(assessed2)+1;
            if(assessed2==1){
            result = false;
            }else if(assessed2==2){
                result = true;
            }else if(assessed2%2==0&&assessed2!=2){
                result = false;
            }else{
            for(int i = 3;i<=sqrtN;i+=2){
                if(assessed2%i==0){
                    result = false;
                }else{
                    result = true;
                    break;
                }
            }
            }
            return result;
    }
}