/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdel
 */
public class Main {

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	RevueParser parser = new RevueParser("journals.csv"); // En chemin relatif les gars :-)
    	parser.start();
    	parser.commandLine();
    }
}
