
public class Revue {

	//Les diff�rents champs de chaque revue
	String rank;
	String title;
	String for1;
	String for1Name;
	String for2;
	String for2Name;
	String for3;	
	String for3Name;
	
	//Le constructeur de l'objet revue � partir d'une ligne
	// Preconditions : Inputs : Une entr�e de la BDD comportant 6 champs s�par� par le charact�re "," et mise sous la forme d'une chaine de caract�re
	// Postconditions : Output : Un objet revue dont les champs correspondent � ceux de la base de donn�e
	public Revue(String chaine)	{
		String[] tab=chaine.split(",");
		if (tab.length!=8) {
			System.out.println("Erreur, Nombre de champs � cette ligne incorrect");
			rank="Z"; title="Inconnu"; for1="ZZZZ"; for1Name="Inconnu"; for2="ZZZZ"; for2Name="Inconnu"; for3="ZZZZ"; for3Name="Inconnu"; }
		else {
			rank=tab[0]; title=tab[1]; for1=tab[2]; for1Name=tab[3]; for2=tab[4]; for2Name=tab[5]; for3=tab[6]; for3Name=tab[7]; }
		}				
	
	//M�thode permettant de visualiser une entr�e
	public String toString() 	{
		return "Rang : "+rank+", Titre : "+title+", FoR1 : "+for1+"-"+for1Name+", FoR2 : "+for2+"-"+for2Name+", For3 : "+for3+"-"+for3Name;	
	}
	
	//Diff�rents tests
	public static void main(String[] args) {
		Revue test1=new Revue("1,2,3,4,5,6,7,8");
		Revue test2=new Revue("1,2,3,4,5,6,7");
		Revue test3=new Revue("1,2,3,4,,,,8");
		Revue test4=new Revue("1,2,3,4,5,6,,");
		Revue test5=new Revue("");
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test3.toString());
		System.out.println(test4.toString());
		System.out.println(test5.toString());
	}
}
