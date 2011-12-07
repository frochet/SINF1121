
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Auteur : Florentin,Abdel
 */
public class Compress implements Serializable {

    private String filein, fileout;
    private InOut writerReader;
    private Huffman huffman;

    public Compress(String filein, String fileout) {
        this.filein = filein;
        this.fileout = fileout;
        writerReader = new InOut(filein, fileout);

    }

    public Huffman getHuffmanInformation() {
        return this.huffman;
    }
    // Compresse par la methode de Huffman le fichier filein

    public void compressFile() {
        StringBuffer buffer = new StringBuffer();
        writerReader.initReader();
        try {
            buffer.append(writerReader.readLine());
            while (!writerReader.isEndOfFile()) {

                
                buffer.append("\n");
                buffer.append(writerReader.readLine());

            }
            writerReader.closeReader();
            huffman = new Huffman(buffer.toString());
            OutputBitStream out = new OutputBitStream(fileout);
            int oct = 0;
            boolean temp;


            StringBuffer tmpReader2 = new StringBuffer();
            for (int i = 0; i < huffman.getTexteEncodé().length(); i++) {
                StringBuffer tmpReader = new StringBuffer();
                tmpReader.append(huffman.getTexteEncodé().charAt(i));
                tmpReader2.append(huffman.getTexteEncodé().charAt(i));
                boolean val;
                if (tmpReader.toString().equals("0")) {
                    val = false;
                } else {
                    val = true;
                }
                out.write(val);


            }
            FileOutputStream fos = new FileOutputStream(fileout + ".arbre");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(huffman);
            oos.close();


            out.close();
            System.out.println("Compression terminée.");


        } catch (IOException ex) {
            Logger.getLogger(Compress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PriorityQueueException ex) {
            Logger.getLogger(Compress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InOutException ex) {
            System.out.println("erreur de lecture du fichier d'entré");
        }


    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        if (args == null || args.length != 2) {
            System.out.println("Usage :");
            System.out.println("Compress [file1] [file2]");
            System.exit(0);
        }
        Compress compression = new Compress(args[0], args[1]);
        compression.compressFile();
        System.exit(0);

    }
}
