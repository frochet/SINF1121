
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Auteur : Florentin,Abdel
 */
public class Compress {

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
            while (!writerReader.isEndOfFile()) {

                buffer.append(writerReader.readLine());
                buffer.append("\n");

            }
            writerReader.closeReader();
            huffman = new Huffman(buffer.toString());
            OutputBitStream out = new OutputBitStream(fileout);
            int oct = 0;
            boolean temp;
            System.out.println("texte encodé = " + huffman.getTexteEncodé());

            StringBuffer tmpReader2 = new StringBuffer();
            for (int i = 0; i < huffman.getTexteEncodé().length(); i ++) {
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
            System.out.println("Fin = " + tmpReader2.toString());

            out.close();


        } catch (IOException ex) {
            Logger.getLogger(Compress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PriorityQueueException ex) {
            Logger.getLogger(Compress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InOutException ex) {
            System.out.println("erreur de lecture du fichier d'entré");
        }


    }
}
