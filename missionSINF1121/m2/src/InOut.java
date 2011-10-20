import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InOut {

	
	private String filePathIn;
	private String filePathOut;
	private FileReader fr;
	private BufferedReader bf;
	private FileWriter fw;
	private BufferedWriter bw;
	
	public InOut(String filePathIn, String filePathOut){
		this.filePathIn = filePathIn;
		this.filePathOut = filePathOut;

	}
	public void init(){

		try {
			this.fr = new FileReader(this.filePathIn);
			this.bf = new BufferedReader(fr);
			fw = new FileWriter(this.filePathOut);
			bw = new BufferedWriter(fw);

		}
		catch (FileNotFoundException e) {
			System.out.println("Impossible de trouver le fichier" + this.filePathIn);			
		} 	
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readLine(){

		String line = "";
		try {
			while((line = bf.readLine()) != null){
				// Comment ça appel du parser ?? Jamais !
				return line;
			}
		}		
		catch (IOException e) {
			System.out.println("Impossible de lire : " + line);
		}				
		return null;
	}

	public void write(String s) {
		try {
			bw.write(s);

		} catch (IOException e) {

			System.out.println("Fichier de destination invalide");
		}

	}
	public void closeReader(){
		try {
			this.bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeWriter(){
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
