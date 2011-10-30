
public class Revue {

	//Les différents champs de chaque revue
	String rank;
	String title;	
	String for2;
	String for2Name;
	String for3;	
	String for3Name;
	
	//Le constructeur de l'objet revue à partir d'une ligne
	// Preconditions : Inputs : Une entrée de la BDD comportant 6 champs séparé par le charactère "," et mise sous la forme d'une chaine de caractère
	// Postconditions : Output : Un objet revue dont les champs correspondent à ceux de la base de donnée
	public Revue(String chaine)	{
		String[] tab=chaine.split(",");
		if (tab.length!=6) {
			System.out.println("Erreur, Nombre de champs à cette ligne incorrect");
			rank="Z"; title="Inconnu"; for2="ZZZZ"; for2Name="Inconnu"; for3="ZZZZ"; for3Name="Inconnu"; }
		else {
			rank=tab[0]; title=tab[1]; for2=tab[2]; for2Name=tab[3]; for3=tab[4]; for3Name=tab[5]; }
		}				
	
	//Méthode permettant de visualiser une entrée
	public String toString() 	{
		return "Rang : "+rank+", Titre : "+title+", FoR2 : "+for2+"-"+for2Name+", For3 : "+for3+"-"+for3Name;	
	}

	public static void main(String[] args) {
		Revue test1=new Revue("1,2,3,4,5,6");
		Revue test2=new Revue("1,2,3,4,5,6,7");
		Revue test3=new Revue("1,2,3,,,6");
		Revue test4=new Revue("1,2,3,,,");
		Revue test5=new Revue("");
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test3.toString());
		System.out.println(test4.toString());
		System.out.println(test5.toString());
	}
}
