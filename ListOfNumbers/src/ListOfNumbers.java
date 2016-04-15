import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Modified for homework by adding a new method: readList().
 */
public class ListOfNumbers {
    private List<Integer> list;
    private Vector<Integer> vector;
    private static final int SIZE = 10;
    
    /**
     * Initializes an ArrayList and a vector.
     */
    public ListOfNumbers () {
        list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(i);
        
        vector = new Vector<>(SIZE);
    }
    
    /**
     * Writes numbers in a text file.
     */
    public void writeList() {
        PrintWriter out = null;
 
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
         
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    /**
     * Reads the text file OutFile.txt, prints the numbers inside it and adds
     * the numbers to a vector.
     */
    public void readList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("OutFile.txt"))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                int lastIndex = line.lastIndexOf(" ");
                int number = Integer.parseInt(line.substring(lastIndex).trim());
                
                System.out.println(number);
                
                vector.add(number);
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Could not parse all numbers.");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
        } catch (IOException ioException) {
            System.err.println("I/O Exception: " + ioException.getMessage());
        }
    }
}