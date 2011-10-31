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

    public InOut(String filePathIn, String filePathOut) {
        this.filePathIn = filePathIn;
        this.filePathOut = filePathOut;

    }

    public InOut() {
        fr=null;
        bf=null;
        fw=null;
        bw=null;

    }

    /*
    public void init() {

        try {
            this.fr = new FileReader(this.filePathIn);
            this.bf = new BufferedReader(fr);
            fw = new FileWriter(this.filePathOut);
            bw = new BufferedWriter(fw);

        } catch (FileNotFoundException e) {
            System.out.println("Impossible de trouver le fichier" + this.filePathIn);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     *
     */

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

        if(fr==null || bf==null){
            throw  new InOutException("Reader is not initialized");
        }else {
             String line = "";
        try {
            while ((line = bf.readLine()) != null) {
                // Comment a appel du parser ?? Jamais !
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

    public void setReader(String filePathIn){
        if(bf!=null){
            closeReader();
        }
        this.filePathIn=filePathIn;
        this.initReader();

    }

    public void setWriter(String filePathOut){
        if(bw!=null){
            this.closeWriter();
        }
        this.filePathOut=filePathOut;
        this.initWriter();
    }

    public boolean isEndOfFile() {
        if(bf==null){
            return true;
        }else{

        return endOfFile;
        }
    }


    public void closeReader() {
        try {
            this.bf.close();
            this.bf=null;
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