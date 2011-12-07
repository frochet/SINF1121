/*
 * Auteur : Florentin, Claude
 */
public class Huffman {
	private BinaryTree<HuffmanNode> huffTree;
	private String[] huffCode;
	private String str; // Le String associŽ ˆ l'arbre
	private int[] freq;
	final static int NCHAR = 128; 
	public Huffman(String str){
		this.str = str;
		huffTree = new BinaryTree<HuffmanNode>();
		this.freq = freqCount(this.str);
	}
	
	public void constructCode(){
		String huffCode[] = new String[NCHAR];
		for (int i=0;i<freq.length;i++)
		{
			
		}
	}
	
	public void construcTree() throws PriorityQueueException{
		//Initialisation de la PriorityQueue
		PriorityQueueHeap<BinaryTree<HuffmanNode>> heap = new PriorityQueueHeap<BinaryTree<HuffmanNode>>(NCHAR);
		//Remplissage de la PriorityQueue
		for (int i=0;i<freq.length;i++)
		{
			BinaryTree<HuffmanNode> currentTree = new BinaryTree<HuffmanNode>();
			HuffmanNode currentNode= new HuffmanNode(freq[i], (char)i);
			currentTree.setRoot(new BinaryNode<HuffmanNode>(currentNode,null,null,null));
			heap.add(currentTree); // ATTENTION, méthode incorrecte, on devrait avoir plutot heap.insert((char)i,freq(i))
		}
		//Fusions d'arbres
		while(heap.size()>1)
		{
			
			BinaryTree<HuffmanNode> T1;
			BinaryTree<HuffmanNode> T2;
			BinaryTree<HuffmanNode> T3;
			
			T1=heap.peek();
			T2=heap.peek();
			T3=new BinaryTree<HuffmanNode>();
			HuffmanNode T3Node= new HuffmanNode(
					T1.getRoot().element().getFrequence() +
					T2.getRoot().element().getFrequence());
			T3.setRoot(new BinaryNode<HuffmanNode>(T3Node,null,T1.getRoot(),T2.getRoot()));
			if (T1.getRoot().isExternal()==true) {
				huffCode[(char)T1.getRoot().element().getLetter()]=huffCode[(char)T1.getRoot().element().getLetter()]+"0";
				huffCode[(char)T2.getRoot().element().getLetter()]=huffCode[(char)T2.getRoot().element().getLetter()]+"1";
			}
			else {
				
			}
			
			heap.add(T3); // ATTENTION, méthode incorrecte, on devrait avoir plutot heap.insert(i,freq(i))
		}
		//Le dernier arbre restant est l'arbre de Huffman
		huffTree=heap.peek();	
	}	
		

	public void makeHuffCode(BinaryTree<BinaryNode<HuffmanNode>> tree, String upCode){
		if (tree.getRoot().isExternal()==false) {
			//TO-DO
		}
		else {
			//TO-DO
		} 
	}
	
	
	/*Retourne un tableau de frŽquence dont la position de la frŽquence i correspond au caract�re i dans la table ASCII*/
	public int[] freqCount(String text) {
        int freq[] = new int[NCHAR];

        for(int i=0; i<text.length(); i++)
            freq[text.charAt(i)]++;

        return freq;
    }
}
