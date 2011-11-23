import java.util.HashMap;
import java.util.concurrent.ConcurrentSkipListMap;

//Auteur : Claude

public class BDDRevue {

	private HashMap<String,Revue> map; //Permet de rechercher une revue
	private HashMap<String,ConcurrentSkipListMap<String,Revue>> domainTitre; //Stocke tous les domaines et y associe des SkipList contenant les revues triés par ordre alphabétique
	private HashMap<String,ConcurrentSkipListMap<String,Revue>> domainRang; //Stocke tous les domaines et y associe des SkipList contenant les revues triés par rang
	private ConcurrentSkipListMap<String,Revue> map2; //Permet de lister toutes les revues triées par ordre alphabétique
	private ConcurrentSkipListMap<String,Revue> map3; //Permet de lister toutes les revues triées par rang
	
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
	
	//Lister toutes les revues par ordre alphabétiques
	public String getAllAlpha(){
		return "To do";
	}
	
	//Lister toutes les revues par ordre numérique
	public String getAllNum(){
		return "To do";
	}
		
	//Lister les revues d'un domaine par ordre alphabétique
	public String getFieldAlpha(String field){
		return "To do";	
	}
	
	//Lister les revues d'un domaine par ordre numérique
	public String getFieldNum(String field){
		return "To do";	
	}
	
	
	
	public void put(Revue revueRead){
        
		map.put(revueRead.getTitle().toUpperCase(), revueRead);
		
        //Tri par domaine, ordre alphabétique
        if(domainTitre.get(revueRead.getFor1().toUpperCase())==null){
        	domainTitre.put(revueRead.getFor1().toUpperCase(), new ConcurrentSkipListMap<String,Revue>());
        	domainTitre.get(revueRead.getFor1().toUpperCase()).put(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
        }
        else {
        	domainTitre.get(revueRead.getFor1().toUpperCase()).put(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
        }
        
      //Tri par domaine, ordre numérique
        if(domainRang.get(revueRead.getFor1().toUpperCase())==null){
        	domainRang.put(revueRead.getFor1().toUpperCase(), new ConcurrentSkipListMap<String,Revue>());
        	domainRang.get(revueRead.getFor1().toUpperCase()).put(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
        }
        else {
        	domainRang.get(revueRead.getFor1().toUpperCase()).put(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
        }
        
        //Tri de toutes les revues, ordre alphabétique
        map2.put(revueRead.getTitle().toUpperCase(), map.get(revueRead.getTitle().toUpperCase()));
        
      //Tri de toutes les revues, ordre numérique
        map3.put(revueRead.getRank(), map.get(revueRead.getTitle().toUpperCase()));
	}
	
}
