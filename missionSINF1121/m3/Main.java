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

    public static Revue revueParsing(String argument) {
        Revue tmp=null;
        String[] informations = argument.split(",");
        if (informations.length >= 2) {
            tmp = new Revue(informations[0], informations[1]);
            if (informations.length == 3) {
                tmp.setFor1(informations[2]);
            } else if (informations.length == 4) {
                tmp.setFor1(informations[2]);
                tmp.setFor1Name(informations[3]);
            } else if (informations.length == 5) {
                tmp.setFor1(informations[2]);
                tmp.setFor1Name(informations[3]);
                tmp.setFor2(informations[4]);
            } else if (informations.length == 6) {
                tmp.setFor1(informations[2]);
                tmp.setFor1Name(informations[3]);
                tmp.setFor2(informations[4]);
                tmp.setFor2Name(informations[5]);
            } else if (informations.length == 7) {
                tmp.setFor1(informations[2]);
                tmp.setFor1Name(informations[3]);
                tmp.setFor2(informations[4]);
                tmp.setFor2Name(informations[5]);
                tmp.setFor3(informations[6]);
            } else if (informations.length == 8) {
                 tmp.setFor1(informations[2]);
                tmp.setFor1Name(informations[3]);
                tmp.setFor2(informations[4]);
                tmp.setFor2Name(informations[5]);
                tmp.setFor3(informations[6]);
                tmp.setFor3Name(informations[7]);
            }
        }
       

        return tmp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner clavierIn = new Scanner(System.in);
            String cmd = "";
            String fileReader;
            InOut handler = new InOut();
            ArrayList<Revue> revueListe = new ArrayList<Revue>();
            HashMap<String,Revue> librairy=new HashMap<String,Revue>();
            handler.setReader("C:\\Users\\Abdel\\Downloads\\Journals\\Journals.csv");
            fileReader = handler.readLine();

            if (fileReader.equals("Rank,Title,FoR1,FoR1 Name,FoR2,FoR2 Name,FoR3,FoR3 Name")) {
                System.out.println("Wait for the application init....");
                while (!handler.isEndOfFile()) {
                    String lecture=handler.readLine();
                    if(lecture==null){
                        break;
                    }else{
                        Revue revueRead=revueParsing(lecture);
                        if(revueRead!=null){
                            revueListe.add(revueRead);
                        }
                    }
                    
                }
                for ( Revue e  : revueListe){
                    librairy.put(e.getTitle().toUpperCase(), e);
                }


                while (!cmd.equals("exit")) {
                    System.out.println("Welcome to the librairy application.");
                    System.out.println("Type a review name to access the informations or exit to leave.");
                    cmd = clavierIn.nextLine();
                    if(!cmd.equals("exit")){
                        Revue tmp=librairy.get(cmd.toUpperCase());
                        if(tmp==null){
                            System.out.println("la revue "+cmd+" n'existe pas dans la base de donnée");
                        }else{
                            System.out.println(tmp);
                        }
                    }
                }


            } else {
                System.out.println("Entete du fichier incorrecte! Veuillez verifier le fichier de donnée et recommencer.");
            }

            handler.closeReader();
        } catch (InOutException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
