

public class main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Compress compres = new Compress("test", "output");
        compres.compressFile();
        Decompress decompress=new Decompress("output","decompression");

        decompress.decompress();
        System.out.println("Fini");
    }
}
