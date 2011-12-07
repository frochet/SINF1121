


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
            Huffman tmp = new Huffman("sssssssssssssssssssssssssalut toi mon petit enfant");
            System.out.println(tmp.getCodeCharacter());
        } catch (PriorityQueueException ex) {
            System.out.println(ex);;
        }
	}

}
