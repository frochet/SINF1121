import java.util.HashMap;
import java.util.concurrent.ConcurrentSkipListMap;

//Auteur : Claude

public class BDDRevue {

	private HashMap<String,Revue> map; //Permet de rechercher une revue
	private HashMap<String,ConcurrentSkipListMap<String,Revue>> domainTitre; //Stocke tous les domaines et y associe des SkipList contenant les revues tri�s par ordre alphab�tique
	private HashMap<String,ConcurrentSkipListMap<String,Revue>> domainRang; //Stocke tous les domaines et y associe des SkipList contenant les revues tri�s par rang
	private ConcurrentSkipListMap<String,Revue> map2; //Permet de lister toutes les revues tri�es par ordre alphab�tique
	private ConcurrentSkipListMap<String,Revue> map3; //Permet de lister toutes les revues tri�es par rang
	
	public BDDRevue(){
		map = new HashMap<String,Revue>();
		domainTitre = new HashMap<String,ConcurrentSkipListMap<String,Revue>>();
		domainRang = new HashMap<String,ConcurrentSkipListMap<String,Revue>>();
		map2 = new ConcurrentSkipListMap<String,Revue>();
		map3 = new ConcurrentSkipListMap<String,Revue>();
	}
	
	//Chercher une revue dans la BDD
	public Revue getRevue(String key){
		return map.get(key);
	}
	
	
	
	public void put(Revue revueRead){
        
		map.put(revueRead.getTitle().toUpperCase(), revueRead);
		
        //Tri par domaine, ordre alphab�tique
        if(domainTitre.get(revueRead.getFor1())==null){
        	domainTitre.put(revueRead.getFor1(), new ConcurrentSkipListMap<String,Revue>());
        	domainTitre.get(revueRead.getFor1()).put(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
        }
        else {
        	domainTitre.get(revueRead.getFor1()).put(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
        }
        
      //Tri par domaine, ordre num�rique
        if(domainRang.get(revueRead.getFor1())==null){
        	domainRang.put(revueRead.getFor1(), new ConcurrentSkipListMap<String,Revue>());
        	domainRang.get(revueRead.getFor1()).put(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
        }
        else {
        	domainRang.get(revueRead.getFor1()).put(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
        }
        
        //Tri de toutes les revues, ordre alphab�tique
        map2.put(revueRead.getTitle().toUpperCase(), map.get(revueRead.getTitle().toUpperCase()));
        
      //Tri de toutes les revues, ordre num�rique
        map3.put(revueRead.getRank(), map.get(revueRead.getTitle().toUpperCase()));
	}
	
}
