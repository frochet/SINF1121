import java.io.File;

/**
*
* @author Pierre-Yves
*/

public class Fichier extends File {

	private String tag;
	
	public Fichier(String pathname, String tag) {
		super(pathname);
		this.tag = tag;
	}

}
