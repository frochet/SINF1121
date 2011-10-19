import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InOut {
	// Correction : Flo
	// Pour que la classe soit plus complète, il manque la vérification dans les méthodes readLine et write si les fichiers existent bien
	// Sinon, dans le cas de write, faut le créer et dans le cas de read, faut lever une exception.
	
	private String filePathIn;
	private String filePathOut;

	public InOut(String filePathIn, String filePathOut){
		this.filePathIn = filePathIn;
		this.filePathOut = filePathOut;
	}

	public String readLine(){

		FileReader fr = null;
		BufferedReader bf = null;
		String line = null;

		try {
			fr = new FileReader(filePathIn);
			bf = new BufferedReader(fr);

			try {
				while((line = bf.readLine()) != null){
					// Comment ça appel du parser ?? Jamais !
					return line;
				}
			}		
			catch (IOException e) {
				System.out.println("Impossible de lire : " + line);
			}
			finally{
				bf.close();
			}			
		}		
		catch (FileNotFoundException e) {
			System.out.println("Impossible de trouver le fichier" + filePathIn);			
		} 		
		catch (IOException e) {
			System.out.println("Erreur de lecture");
		}	
		return null;
	}

	public void write(String s) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(filePathOut);
			bw = new BufferedWriter(fw);

			bw.write(s);

			bw.close();

		} catch (IOException e) {

			System.out.println("Fichier de destination invalide");
		}

	}
}
