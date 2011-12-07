/*
 * Auteur : Claude
 */
public class HuffmanComparator implements Comparator<HuffmanNode> {

	@Override
	public int compare(HuffmanNode arg0, HuffmanNode arg1) {
		if(arg0.getFrequence() > arg1.getFrequence())
			return 1;
		else if(arg0.getFrequence() < arg1.getFrequence())
			return -1;
		else
			return 0;
	}
}
