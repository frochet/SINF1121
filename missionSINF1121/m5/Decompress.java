
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author : G�rard Val�ry
 */

public class Decompress {

    private String fileInput, fileDecompressed;
    private Huffman huffman;
    private InOut rederWriter;

    public Decompress(String fileInput, String fileDecompressed,Huffman huff) {
        this.fileInput = fileInput;
        this.fileDecompressed = fileDecompressed;
        this.huffman=huff;
        rederWriter=new InOut(fileInput, fileDecompressed);

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
                        String tmp= temp ? "1" : "0";
                        
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
            rederWriter.write(huffman.Decodebit(codeLu.toString()));
            System.out.println("Code lu est = " + codeLu.toString());
            rederWriter.closeWriter();
            
        } catch (InOutException ex) {
            Logger.getLogger(Decompress.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
