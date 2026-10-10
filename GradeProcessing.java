import java.util.Scanner; 
import java.io.*;
/**
 * This program aims to analyze a set of grades and determine the number of A's, B's
 * C's, D's, and F's that are present. The program will also return the highest score,
 * lowest score, and average score across all grades of that set.
 *
 * @author Moses Mendez
 * @version v1.0
 * @since 10/4/2026
 */
public class GradeProcessing
{
    // instance variables - replace the example below with your own
    static Scanner keyboard = new Scanner(System.in);
    public static final String promptIn = "Enter the name of the input file (ie input.txt): ";
    public static final String promptOut = "Enter the name of the output file (ie output.txt): ";
    
    public static void main(String[] args) throws IOException
    {
        //variables
        String inFile;
        String outFile;
        
        inFile = getInFile();
        
        outFile = getOutFile();
        keyboard.close();
        
        System.out.printf(processFile(inFile, outFile), outFile);
        
        //prompt for file name
        }
        
    /**
     * Prompts the user to provide a file name from which data will be extracted.
     * should the file not be found, the method will prompt the user for a new path.
     *
     * @return   directIn; details the path for the input file.; String
     */
    public static String getInFile() throws IOException
    {       
        //
        File fileIn;
        String directIn;
        
        do{
        System.out.print(promptIn);
        directIn = keyboard.nextLine().trim();
        
        //simply used to check is exists.
        fileIn = new File(directIn);
        }while(!fileIn.exists());
        
        return directIn;
        }
        
    /**
     * Returns a path detailing the location of the output file. Uses scanner to name
     * the output file prior to creating it.
     *
     * @return   fileOut; details the path for the output file.; String
     */
    public static String getOutFile()
    {
        //
        String directOut;
        
        System.out.print(promptOut);
        directOut = keyboard.nextLine().trim();
        
        return directOut;
        }
        
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  inFile1; file detailing raw data, looks for sentinel value -1; String
     * @param  outFile1; once each line of inFile1 is processed, write to output file; String
     * @return    completion; a formatted string to include where the output file can be found.; String
     */
    public static String processFile(String inFile1, String outFile1) throws IOException
    {
        //variables
        File input = new File(inFile1);
        String noGrades = "No grades to average%n%n";
        String setHeader = "Set %d of grades calculated%n";
        String numberOf = "Number of %cs: %d%n";
        String hiScore = "The high score was: %.2f %n";
        String lowScore = "The low score was: %.2f %n";
        String avgScore = "The avg score was: %.2f %n%n";
        String completion = "Grade processing completed %nYou can retrieve the output file at, %s";
        int setAccumulator = 1;
        int gradeAccumulator = 0;
        double gradesTotalSum = 0;
        double sentinel = -1;
        double min=100, max=0;
        int aS = 0, bS = 0, cS = 0, dS = 0, fS = 0;
        
        Scanner in = new Scanner(input);
        PrintWriter output = new PrintWriter(outFile1);
        
        //set # of grades calculated
            while(in.hasNextInt())//if int is NOT -1, analyze
            {
                gradeAccumulator=0;//reset grades accumulator
                aS=0;
                bS=0;
                cS=0;
                dS=0;
                fS=0;
                gradesTotalSum=0;
                min=100;
                max=0;
                
                double grade = in.nextInt();
                while(grade!=sentinel)
                {
                    gradeAccumulator++;
                    gradesTotalSum+=grade;
                    if(grade>max)
                        max = grade;
                    
                    if(grade<min)
                        min = grade;
                    
                    if(grade>=90) aS++;
                    else if(grade>=80) bS++;
                    else if(grade>=70) cS++;
                    else if(grade>=60) dS++;
                    else fS++;
                    
                    grade=in.nextInt();
                }
                //else we skip; set acc continues 
            
            output.printf(setHeader, setAccumulator);
            if(gradeAccumulator==0){
                output.printf(noGrades);
            }else{
                //number of As
                output.printf(numberOf, 'A', aS);
                output.printf(numberOf, 'B', bS);
                output.printf(numberOf, 'C', cS);
                output.printf(numberOf, 'D', dS);
                output.printf(numberOf, 'F', fS);
                
                output.printf(hiScore, max);
                output.printf(lowScore, min);
                output.printf(avgScore, (gradesTotalSum/gradeAccumulator));
            }
            setAccumulator++;
        }
        output.close();
        in.close();
        return completion;
    }
}