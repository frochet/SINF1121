import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;

// WORKING IN PROGRESS
public class RevueParser {
	//Auteur : Florentin,Abdel,Claude
	private String filePathIn;
	private InOut handler;
	private HashMap<String,Revue> map; //Permet de rechercher une revue
	private HashMap<String,ConcurrentSkipListMap<String,Revue>> domainTitre; //Stocke tous les domaines et y associe des SkipList contenant les revues triés par ordre alphabétique
	private HashMap<String,ConcurrentSkipListMap<String,Revue>> domainRang; //Stocke tous les domaines et y associe des SkipList contenant les revues triés par rang
	private ConcurrentSkipListMap<String,Revue> map2; //Permet de lister toutes les revues triées par ordre alphabétique
	private ConcurrentSkipListMap<String,Revue> map3; //Permet de lister toutes les revues triées par rang


	/**
	*Create a new instance of a Revue Parser
	*@param filePathIn path of the file wich contains the informations of all the books
	*
	*/
	public RevueParser(String filePathIn){
		this.filePathIn = filePathIn;
		this.handler = new InOut(filePathIn,"");
		
		map = new HashMap<String,Revue>();
		domainTitre = new HashMap<String,ConcurrentSkipListMap<String,Revue>>();
		domainRang = new HashMap<String,ConcurrentSkipListMap<String,Revue>>();
		map2 = new ConcurrentSkipListMap<String,Revue>();
		map3 = new ConcurrentSkipListMap<String,Revue>();
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
	                    
	                    //Tri par domaine, ordre alphabétique
	                    if(domainTitre.get(revueRead.getFor1())==null){
	                    	domainTitre.put(revueRead.getFor1(), new ConcurrentSkipListMap<String,Revue>());
	                    	domainTitre.get(revueRead.getFor1()).put(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
	                    }
	                    else {
	                    	domainTitre.get(revueRead.getFor1()).put(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
	                    }
	                    
	                  //Tri par domaine, ordre numérique
	                    if(domainRang.get(revueRead.getFor1())==null){
	                    	domainRang.put(revueRead.getFor1(), new ConcurrentSkipListMap<String,Revue>());
	                    	domainRang.get(revueRead.getFor1()).put(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
	                    }
	                    else {
	                    	domainRang.get(revueRead.getFor1()).put(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
	                    }
	                    
	                    //Tri de toutes les revues, ordre alphabétique
	                    map2.put(revueRead.getTitle().toUpperCase(), map.get(revueRead.getTitle().toUpperCase()));
	                    
	                  //Tri de toutes les revues, ordre numérique
	                    map3.put(revueRead.getRank(), map.get(revueRead.getTitle().toUpperCase()));

	                    
	                    //L'enregistrement de la clÃ© sous forme majuscule prend son sens lors de la recherche.
                	}
                }
                handler.closeReader();
            } else {
                System.out.println("Entete du fichier incorrecte! Veuillez verifier le fichier de donnÃ©e et recommencer.");
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
         
         while (!cmd.equals("EXIT")) {
        	 System.out.println("");
        	 System.out.println("What do you want to do?");
        	 System.out.println("Type SEARCH to search a revue in the database");
        	 System.out.println("Type LIST to list revue in the database");
        	 System.out.println("Type EXIT to exit");
        	 cmd = clavierIn.nextLine();
        	 cmd = cmd.toUpperCase();
        			
        	 if(cmd.equals("SEARCH")){
        		 System.out.println("");
        		 System.out.println("Type the revue name you want to search in the database");
        		 String cmd2 = "";
        		 cmd2 = clavierIn.nextLine();
            	 cmd2 = cmd2.toUpperCase();
        		 Revue tmp=map.get(cmd2);
        	                 
	             /*
	             * Le fait de mettre le string entrÃ© en majuscule nous permet de rechercher la revue correspondante
	             * peu importe la maniÃ¨re dont l'utilisateur la entrÃ©e; qu'il y ait ou non des majuscules, minuscules, etc
	             */
        	                 
	             if(tmp==null){
	                 System.out.println("la revue "+cmd2+" n'existe pas dans la base de donnÃ©e");
	             }
	             else{
	                 System.out.println(tmp);
	             }
              }
        	 
        	 if(cmd.equals("LIST")){
        		 String cmd2 = "";
        		 while (!cmd2.equals("BACK")) {
        			 System.out.println("");
        			 System.out.println("What do you want to list?");
	        		 System.out.println("Type ALL to list revue in the complete database");
	        		 System.out.println("Type FIELD to list revue from a certain field of research");
	        		 System.out.println("Type BACK to go back to the main menu"); 
	        		 cmd2 = clavierIn.nextLine();
	            	 cmd2 = cmd2.toUpperCase();
	            	 
	            	 if (cmd2.equals("ALL")) {
	            		 String cmd3 = "";
	            		 while(!cmd3.equals("BACK")){
	            			 System.out.println("");
	            			 System.out.println("In which order do you want to list revues?");
		            		 System.out.println("Type ALPHA for revues sorted by alphabetical order");
		            		 System.out.println("Type RANK for revues sorted by rank");
		            		 System.out.println("Type BACK to go back to the previous menu");
		            		 cmd3 = clavierIn.nextLine();
		                	 cmd3 = cmd3.toUpperCase();
		            		 
		            		 if(cmd3.equals("ALPHA")){
		            			 System.out.println("This feature is not yet available");
		            		 }
		            		 
		            		 if(cmd3.equals("RANK")){
		            			 System.out.println("This feature is not yet available");
		            		 }
	            		 }
	            	 }
	            	 
	            	 if (cmd2.equals("FIELD")) {	            		 
	            		 String cmd3 = "";
	            		 while(!cmd3.equals("BACK")){
	            			 System.out.println("");
	            			 System.out.println("In which order do you want to list revues?");
		            		 System.out.println("Type ALPHA for revues sorted by alphabetical order");
		            		 System.out.println("Type RANK for revues sorted by rank");
		            		 System.out.println("Type BACK to go back to the previous menu");
		            		 cmd3 = clavierIn.nextLine();
		                	 cmd3 = cmd3.toUpperCase();
		            		 
		            		 if(cmd3.equals("ALPHA")){
		            			 System.out.println("Type the field of research from which you want to list revue");
			            		 String cmd4 = "";
			            		 cmd4 = clavierIn.nextLine();
			                	 cmd4 = cmd4.toUpperCase();
			                	 System.out.println("This feature is not yet available");
		            		 }
		            		 
		            		 if(cmd3.equals("RANK")){
		            			 System.out.println("Type the field of research from which you want to list revue");
			            		 String cmd4 = "";
			            		 cmd4 = clavierIn.nextLine();
			                	 cmd4 = cmd4.toUpperCase();
			                	 System.out.println("This feature is not yet available");
		            		 }
	            		 }
	            	 }   	 
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
