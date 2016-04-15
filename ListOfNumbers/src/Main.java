/**
 * Contains the main() method.
 */
public class Main {
    /**
     * Starts program execution.
     * @param args command-line parameters
     */
    public static void main(String[] args) {
        ListOfNumbers numbersList = new ListOfNumbers();
        
        numbersList.writeList();
        
        numbersList.readList();
    }
}