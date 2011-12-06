
public class Huffman {
	private BinaryTree<HuffmanNode> huffTree;
	private String str; // Le String associ� � l'arbre
	private int[] freq;
	final static int NCHAR = 128; 
	public Huffman(String str){
		this.str = str;
		huffTree = new BinaryTree<HuffmanNode>();
		this.freq = freqCount(this.str);
	}
	
	public void construcTree(){
		//... Appliquer l'algo du livre
		initQueue();
		
	}
	public void initQueue(){
		
	}
	/*Retourne un tableau de fr�quence dont la position de la fr�quence i correspond au caract�re i dans la table ASCII*/
	public int[] freqCount(String text) {
        int freq[] = new int[NCHAR];

        for(int i=0; i<text.length(); i++)
            freq[text.charAt(i)]++;

        return freq;
    }
}
