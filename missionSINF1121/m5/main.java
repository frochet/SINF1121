
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Compress compres = new Compress("C:\\Users\\Abdel\\Desktop\\test", "C:\\Users\\Abdel\\Desktop\\output");
        compres.compressFile();
        Decompress decompress=new Decompress("C:\\Users\\Abdel\\Desktop\\output","C:\\Users\\Abdel\\Desktop\\decompression", compres.getHuffmanInformation());

        decompress.decompress();
        System.out.println("Fini");
    }
}
