/*
 * Auteur : Florentin, Claude
 */
public class Huffman {
	private BinaryTree<HuffmanNode> huffTree;
	private String[] huffCode;
	private String str; // Le String associŽ ˆ l'arbre
	private int[] freq;
	final static int NCHAR = 128; 
	
	//Constructeur
	public Huffman(String str) throws PriorityQueueException{
		this.str = str;
		this.freq = freqCount(this.str);
		huffTree = this.makeHuffTree();
		huffCode = new String[NCHAR];
		this.makeHuffCode();
	}
	
	public String[] getHuffCode(){
		return huffCode;
	}
	
	public BinaryTree<HuffmanNode> getHuffTree(){
		return huffTree;
	}
	
	/*Retourne un tableau de frŽquence dont la position de la frŽquence i correspond au caract�re i dans la table ASCII*/
	public int[] freqCount(String text) {
        int freq[] = new int[NCHAR];

        for(int i=0; i<text.length(); i++)
            freq[text.charAt(i)]++;

        return freq;
    }
		
	public BinaryTree<HuffmanNode> makeHuffTree() throws PriorityQueueException{
		//Initialisation de la PriorityQueue
		PriorityQueueHeap heap = new PriorityQueueHeap(NCHAR);
		//Remplissage de la PriorityQueue
		for (int i=0;i<freq.length;i++)
		{
			if (freq[i]>0){
				HuffmanNode HNode= new HuffmanNode(freq[i], (char)i);
				BinaryNode<HuffmanNode> BNode=new BinaryNode<HuffmanNode>(HNode,null,null,null);
				heap.add(BNode);
			}
		}
		//Fusions d'arbres
		while(heap.size()>1)
		{		
			BinaryNode<HuffmanNode> T1;
			BinaryNode<HuffmanNode> T2;
			BinaryNode<HuffmanNode> BNode;
			HuffmanNode HNode;
			
			T1=heap.peek();
			T2=heap.peek();
			HNode=new HuffmanNode(T1.element().getFrequence() + T2.element().getFrequence());
			BNode=new BinaryNode<HuffmanNode>(HNode,null,T1,T2);
			
			heap.add(BNode);
		}
		//Le dernier arbre restant est l'arbre de Huffman
		
		BinaryTree<HuffmanNode> res=new BinaryTree<HuffmanNode>();
		res.setRoot(heap.peek());
		
		return res;	
	}	
		
	//Fonction récursive donnant le code pour chaque lettre
	public void makeHuffCodeRec(BinaryNode<HuffmanNode> tree, String upCode){
		if (tree.isExternal()==true) {
			if (tree.getLeft()!=null) {
				makeHuffCodeRec(tree,upCode+"0");
			}
			if (tree.getRight()!=null) {
				makeHuffCodeRec(tree,upCode+"1");
			}
		}
		else {
			
			huffCode[(int)(tree.element().getLetter())]=upCode;
		}
		
	}
	//Fonction donnant le code de Huffman entier en appeler une fonction récursive sur l'arbre d'Huffman
	public void makeHuffCode()	{
		 makeHuffCodeRec(huffTree.getRoot(),"");
	}
	
	
	
}
