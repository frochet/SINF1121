
public class Revue {
    //Les différents champs de chaque revue
	// Florentin,Abdel,Claude
    private String rank="";
	private String title="";
    private String for1="";
    private String for1Name="";
    private String for2="";
    private String for2Name="";
    private String for3="";
    private String for3Name="";

    /**
     *Create a new instance of Revue
     * @param rank rank of the revue
     * @param title title of the revue
     */
    public Revue(String rank, String title) {
        this.rank = rank;
        this.title = title;
    }

	/**
	*Create a new instance of Revue
	*
	*/
    public Revue() {
		// TODO Auto-generated constructor stub
	}

	/**
	*Return the title of the Revue
	*@return Name of the revue
	*
	*/
    public String getTitle() {
        return title;
    }
    /**
	*Return the Rank of the Revue
	*@return Rank of the revue
	*
	*/
    public String getRank() {
        return rank;
    }
    /**
	*Return the field for1 of the Revue
	*@return field for1 of the revue
	*
	*/
    public String getFor1() {
        return for1;
    }
    /**
	*Set the Rank of the Revue
	*@param rank of the revue
	*/
    public void setRank(String rank) {
		this.rank = rank;
	}
    /**
	*set the Title of the Revue
	*@param title of the revue
	*/
	public void setTitle(String title) {
		this.title = title;
	}

    /**
     *Set for1 field of the revue
     * @param for1 new for1 name of the revue
     */
    public void setFor1(String for1) {
        this.for1 = for1;
    }

    /**
     *set the for1Name field of the revue
     * @param for1Name new for1Name name of the revue
     */
    public void setFor1Name(String for1Name) {
        this.for1Name = for1Name;
    }

    /**
     *set for2 field of the revue
     * @param for2 new for2 Name of the revue
     */
    public void setFor2(String for2) {
        this.for2 = for2;
    }

    /**
     *set the for2name of the revue
     * @param for2Name new for2Name name of the revue
     */
    public void setFor2Name(String for2Name) {
        this.for2Name = for2Name;
    }

    /**
     *set the for3 field of the revue
     * @param for3 new for3 name fo the revue
     */
    public void setFor3(String for3) {
        this.for3 = for3;
    }

    /**
     *set the for3Name field ot the revue
     * @param for3Name new for3Name of the revue
     */
    public void setFor3Name(String for3Name) {
        this.for3Name = for3Name;
    }
    
	/**
	*Set a revue's field value 
	*@param value Information value 
	*@param code code of a specific field of the revue
	*/
    public void setValue(String value, int code){
    	switch (code){
    	case 0 : setRank(value); break;
    	case 1 : setTitle(value); break;
    	case 2 : setFor1(value); break;
    	case 3 : setFor1Name(value); break;
    	case 4 : setFor2(value); break;
    	case 5 : setFor2Name(value); break;
    	case 6 : setFor3(value); break;
    	case 7 : setFor3Name(value); break;
    	}
    }
	
	
    @Override
    public String toString() {

        return "Rang : " + rank + ", Titre : " + title + ", FoR1 : " + for1 + "-" + for1Name + ", FoR2 : " + for2 + "-" + for2Name + ", For3 : " + for3 + "-" + for3Name;

    }
}
