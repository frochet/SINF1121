
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author : G�rard Val�ry,Abdel
 */
public class Decompress implements Serializable {

    private String fileInput, fileDecompressed;
    private Huffman huffman;
    private InOut rederWriter;

    public Decompress(String fileInput, String fileDecompressed) {
        FileInputStream fos = null;
        {
            ObjectInputStream oos = null;
            try {
                this.fileInput = fileInput;
                this.fileDecompressed = fileDecompressed;
                fos = new FileInputStream(fileInput + ".arbre");
                oos = new ObjectInputStream(fos);
                this.huffman = (Huffman) oos.readObject();
                rederWriter = new InOut(fileInput, fileDecompressed);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Decompress.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    // Decompress 'fileInput' file to 'fileDecompressed'

    public void decompress() {
        try {
            StringBuffer codeLu = new StringBuffer();

            int oct = 0;
            boolean[] octet = new boolean[8];
            try {
                InputBitStream in = new InputBitStream(fileInput);
                try {
                    while (true) {
                        boolean temp = in.readBoolean();
                        String tmp = temp ? "1" : "0";

                        codeLu.append(tmp);


                    }
                } catch (IOException ex) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            huffman.Decodebit(codeLu.toString());
            rederWriter.initWriter();
            

            rederWriter.write(huffman.Decodebit(codeLu.toString()).substring(0,huffman.Decodebit(codeLu.toString()).indexOf("null")));

            rederWriter.closeWriter();
            System.out.println("Decompression terminée");

        } catch (InOutException ex) {
            Logger.getLogger(Decompress.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            System.out.println("Usage :");
            System.out.println("Decompress [file1] [file2]");
            System.exit(0);
        }

        Decompress decompression=new Decompress(args[0], args[1]);
        decompression.decompress();
    }
}
