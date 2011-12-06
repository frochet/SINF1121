/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdel
 */
public class Main {

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	RevueParser parser = new RevueParser("journals.csv"); 
    	parser.start();
    	parser.commandLine();
    }
}
