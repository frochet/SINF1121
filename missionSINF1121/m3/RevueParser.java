import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// WORKING IN PROGRESS
public class RevueParser {
	//Auteur : Florentin,Abdel
	private String filePathIn;
	private InOut handler;
	private HashMap<String,Revue> map;

	/**
	*Create a new instance of a Revue Parser
	*@param filePathIn path of the file wich contains the informations of all the books
	*
	*/
	public RevueParser(String filePathIn){
		this.filePathIn = filePathIn;
		this.handler = new InOut(filePathIn,"");
		map = new HashMap<String,Revue>();
	}
	
	/**
	*fulfil the books informations
	*
	*/
	public void start(){
		try {
            // TODO code application logic here
            handler.initReader();
            String line = handler.readLine();

            if (line.equals("Rank,Title,FoR1,FoR1 Name,FoR2,FoR2 Name,FoR3,FoR3 Name")) {
            	System.out.println("Welcome to the librairy application.");
                System.out.println("Wait for the application init....");
                while (!handler.isEndOfFile()) {
                	line = handler.readLine();
                	if(line == null) break;
                	else{
	                    Revue revueRead=constructRevue(line);
	                    map.put(revueRead.getTitle().toUpperCase(), revueRead);
	                    //L'enregistrement de la clé sous forme majuscule prend son sens lors de la recherche.
                	}
                }
                handler.closeReader();
            } else {
                System.out.println("Entete du fichier incorrecte! Veuillez verifier le fichier de donnée et recommencer.");
            }

            handler.closeReader();
        } catch (InOutException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
	}
	
	/**
	*Principal method to retrieve the book's informations
	*
	*/
	public void commandLine(){
		 Scanner clavierIn = new Scanner(System.in);
         String cmd = "";
         while (!cmd.equals("exit")) {
             System.out.println("Type a review name to access the informations or exit to leave.");
             cmd = clavierIn.nextLine();
             if(!cmd.equals("exit")){
                 Revue tmp=map.get(cmd.toUpperCase());
                 
                 /*
                 * Le fait de mettre le string entré en majuscule nous permet de rechercher la revue correspondante
                 * peu importe la manière dont l'utilisateur la entrée; qu'il y ait ou non des majuscules, minuscules, etc
                 */
                 
                 if(tmp==null){
                     System.out.println("la revue "+cmd+" n'existe pas dans la base de donnée");
                 }else{
                     System.out.println(tmp);
                 }
             }
         }

	}
	private Revue constructRevue(String line){
		String[] tab = line.split(",");
		Revue revue = new Revue();
		int i;
		for(i = 0; i<tab.length; i++){
			revue.setValue(tab[i],i);
		}
		
		if(i<7){
			do{
				revue.setValue("", i);
				i++;
			}while(i<7);
		}
		return revue;
	}
}
