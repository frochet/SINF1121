/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Class InOut
 * @author Florentin,Abdel,Pierre-Yves
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    private boolean endOfFile;

	/**
	*Create a new instance of InOut
	*
	*/
    public InOut(String filePathIn, String filePathOut) {
        this.filePathIn = filePathIn;
        this.filePathOut = filePathOut;

    }

	/**
	*Create a new instance of InOut
	*
	*/
    public InOut() {

    }



    public void initReader() {
        try {
            this.fr = new FileReader(this.filePathIn);
            this.bf = new BufferedReader(fr);
            endOfFile=false;
        } catch (FileNotFoundException ex) {
            System.out.println("Impossible de trouver le fichier" + this.filePathIn);
        }

    }

    public void initWriter() {
        try {
            fw = new FileWriter(this.filePathOut);
            bw = new BufferedWriter(fw);
        } catch (IOException ex) {
             ex.printStackTrace();
        }
    }

    public String readLine() throws InOutException {

    	if(fr==null || bf==null)
    		throw  new InOutException("Reader is not initialized");
    	else{
    		String line = "";
    		try {
    			while ((line = bf.readLine()) != null) {
    				return line;
    			}
    			endOfFile=true;

    		} catch (IOException e) {
    			System.out.println("Impossible de lire : " + line);
    		}
    		return null;
    	}
    }

    public void write(String s) throws InOutException {
         if(fw==null || bw==null){
            throw  new InOutException("Writer is not initialized");
        }else {
        try {
            bw.write(s);

        } catch (IOException e) {

            System.out.println("Fichier de destination invalide");
        }
        }

    }

    public boolean isEndOfFile() {
    	return endOfFile;
    }


    public void closeReader() {
        try {
            this.bf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void closeWriter() {
        try {
            bw.close();
            this.bw=null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}