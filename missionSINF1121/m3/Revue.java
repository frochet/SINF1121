
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
     *
     * @param rank
     * @param title
     */
    public Revue(String rank, String title) {
        this.rank = rank;
        this.title = title;
    }

    public Revue() {
		// TODO Auto-generated constructor stub
	}

    public String getTitle() {
        return title;
    }
    
    public void setRank(String rank) {
		this.rank = rank;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    /**
     *
     * @param for1
     */
    public void setFor1(String for1) {
        this.for1 = for1;
    }

    /**
     *
     * @param for1Name
     */
    public void setFor1Name(String for1Name) {
        this.for1Name = for1Name;
    }

    /**
     *
     * @param for2
     */
    public void setFor2(String for2) {
        this.for2 = for2;
    }

    /**
     *
     * @param for2Name
     */
    public void setFor2Name(String for2Name) {
        this.for2Name = for2Name;
    }

    /**
     *
     * @param for3
     */
    public void setFor3(String for3) {
        this.for3 = for3;
    }

    /**
     *
     * @param for3Name
     */
    public void setFor3Name(String for3Name) {
        this.for3Name = for3Name;
    }
    
    public void setValue(String value, int code){
    	switch (code){
    	case 0 : setRank(value);
    	case 1 : setTitle(value);
    	case 2 : setFor1(value);
    	case 3 : setFor1Name(value);
    	case 4 : setFor2(value);
    	case 5 : setFor2Name(value);
    	case 6 : setFor3(value);
    	case 7 : setFor3Name(value);
    	}
    }
    @Override
    public String toString() {

        return "Rang : " + rank + ", Titre : " + title + ", FoR1 : " + for1 + "-" + for1Name + ", FoR2 : " + for2 + "-" + for2Name + ", For3 : " + for3 + "-" + for3Name;

    }
}
