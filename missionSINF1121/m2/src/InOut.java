import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InOut {

	public InOut(){

	}

	public void read(String filePathIn){

		FileReader fr = null;
		BufferedReader bf = null;
		String line = null;

		try {
			fr = new FileReader(filePathIn);
			bf = new BufferedReader(fr);

			try {
				while((line = bf.readLine()) != null){

					// Appel du Parser;

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

	}

	public void write(String filePathOut, String s) {

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
