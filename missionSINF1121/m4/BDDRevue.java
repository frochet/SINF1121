import java.util.HashMap;

//Auteur : Claude

public class BDDRevue {

	private HashMap<String,Revue> map; //Permet de rechercher une revue
	private HashMap<String,AvlTree<Revue,String>> domainTitre; //Stocke tous les domaines et y associe des SkipList contenant les revues tri�s par ordre alphab�tique
	private HashMap<String,AvlTree<Revue,String>> domainRang; //Stocke tous les domaines et y associe des SkipList contenant les revues tri�s par rang
	private AvlTree<Revue,String> map2; //Permet de lister toutes les revues tri�es par ordre alphab�tique
	private AvlTree<Revue,String> map3; //Permet de lister toutes les revues tri�es par rang
	
	public BDDRevue(){
		map = new HashMap<String,Revue>();
		domainTitre = new HashMap<String,AvlTree<Revue,String>>();
		domainRang = new HashMap<String,AvlTree<Revue,String>>();
		map2 = new AvlTree<Revue,String>();
		map3 = new AvlTree<Revue,String>();
	}
	
	//Chercher une revue dans la BDD
	public Revue getRevue(String key){
		return map.get(key);
	}
	
	//Lister toutes les revues par ordre alphab�tiques
	public String getAllAlpha(){
		return "To do";
	}
	
	//Lister toutes les revues par ordre num�rique
	public String getAllNum(){
		return "To do";
	}
		
	//Lister les revues d'un domaine par ordre alphab�tique
	public String getFieldAlpha(String field){
		return "To do";	
	}
	
	//Lister les revues d'un domaine par ordre num�rique
	public String getFieldNum(String field){
		return "To do";	
	}
	
	
	
	public void put(Revue revueRead){
        
		map.put(revueRead.getTitle().toUpperCase(), revueRead);
		
        //Tri par domaine, ordre alphab�tique
        if(domainTitre.get(revueRead.getFor1().toUpperCase())==null){
        	domainTitre.put(revueRead.getFor1().toUpperCase(), new AvlTree<Revue,String>());
        	domainTitre.get(revueRead.getFor1().toUpperCase()).insert(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
        }
        else {
        	domainTitre.get(revueRead.getFor1().toUpperCase()).insert(revueRead.getTitle().toUpperCase(),map.get(revueRead.getTitle().toUpperCase()));
        }
        
      //Tri par domaine, ordre num�rique
        if(domainRang.get(revueRead.getFor1().toUpperCase())==null){
        	domainRang.put(revueRead.getFor1().toUpperCase(), new AvlTree<Revue,String>());
        	domainRang.get(revueRead.getFor1().toUpperCase()).insert(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
        }
        else {
        	domainRang.get(revueRead.getFor1().toUpperCase()).insert(revueRead.getRank(),map.get(revueRead.getTitle().toUpperCase()));
        }
        
        //Tri de toutes les revues, ordre alphab�tique
        map2.insert(revueRead.getTitle().toUpperCase(), map.get(revueRead.getTitle().toUpperCase()));
        
      //Tri de toutes les revues, ordre num�rique
        map3.insert(revueRead.getRank(), map.get(revueRead.getTitle().toUpperCase()));
	}
	
}
