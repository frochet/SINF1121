
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

            }
            writerReader.closeReader();
            huffman = new Huffman(buffer.toString());
            OutputBitStream out = new OutputBitStream(fileout);
            for (int i = 0; i < huffman.getTexteEncodé().length(); i = i + 8) {
                if (i + 8 < this.huffman.getTexteEncodé().length()) {
                    out.write((Integer.parseInt(huffman.getTexteEncodé().substring(i, i + 8))));
                }else{
                     out.write((Integer.parseInt(huffman.getTexteEncodé().substring(i, i + (huffman.getTexteEncodé().length()-i-1)))));
                }
            }


        } catch (IOException ex) {
            Logger.getLogger(Compress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PriorityQueueException ex) {
            Logger.getLogger(Compress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InOutException ex) {
            System.out.println("erreur de lecture du fichier d'entré");
        }


    }
}
