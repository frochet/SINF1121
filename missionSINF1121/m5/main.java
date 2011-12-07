
import java.util.logging.Level;
import java.util.logging.Logger;




public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
            Huffman texteaEncodé = new Huffman("Saluuuutttt monsieur beauuuu");
            System.out.println("texte encodé est "+texteaEncodé.getTexteEncodé());
            Huffman texteDecodé=new Huffman(texteaEncodé.getHuffTree(), texteaEncodé.getTexteEncodé());
            System.out.println("Texte decodé = "+texteDecodé.Decodebit(texteaEncodé.getTexteEncodé()));

        } catch (PriorityQueueException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
