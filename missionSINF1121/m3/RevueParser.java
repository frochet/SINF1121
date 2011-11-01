import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// WORKING IN PROGRESS
public class RevueParser<E> {
	
	private String filePathIn;
	private E map;

	public RevueParser(String filePathIn, E map){
		this.filePathIn = filePathIn;
		this.map = map;
	}
	
	public void start(){
		try {
            // TODO code application logic here
            Scanner clavierIn = new Scanner(System.in);
            String cmd = "";
            String line;
            InOut handler = new InOut();
            ArrayList<Revue> revueListe = new ArrayList<Revue>();
            HashMap<String,Revue> librairy=new HashMap<String,Revue>();
            handler.setReader(this.filePathIn);
            line = handler.readLine();

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
	
	public void putInMap(E map, String key, Revue o){
		
	}
}
