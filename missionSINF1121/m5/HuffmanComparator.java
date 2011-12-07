/*
 * Auteur : Claude
 */
public class HuffmanComparator implements Comparator<BinaryNode<HuffmanNode>> {

	


    public int compare(BinaryNode<HuffmanNode> arg0, BinaryNode<HuffmanNode> arg1) {
       if(arg0.element().getFrequence() > arg1.element().getFrequence())
			return 1;
		else if(arg0.element().getFrequence() < arg1.element().getFrequence())
			return -1;
		else
			return 0;
    }
}
