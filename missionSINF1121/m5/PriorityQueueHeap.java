
/*
 * Auteur : Florentin, Claude
 */
public class PriorityQueueHeap{
	
	private Bucket<BinaryNode<HuffmanNode>>[] heap;
	private int nbrObject = 0;
	
	public PriorityQueueHeap(int defaultsize){
		this.heap = new Bucket[defaultsize];
	}
	
	public int size()	{
		return nbrObject;
	}
	
	public void add(BinaryNode<HuffmanNode> element){
		
		int index = nbrObject;
		this.heap[index] = new Bucket<BinaryNode<HuffmanNode>>(element);
		int parent = getParent(index);
		
		while (	(parent >= 0) && (element.element().compareTo(heap[parent].getElement().element()) > 0)){
			// Echange des deux éléments.
			swap(parent, index);
			
			// Déplacement vers le niveau supérieur.
			index = parent;
			parent = getParent(index);
		}
		nbrObject++;

	}
	
	// Pour un index, calcule son parent dans le tas.
	private int getParent(int index){
		return (int) Math.floor((index - 1) / 2);
	}

	// Pour un index, calcule son fils à gauche dans le tas.
	private int getLeft(int index){
		return index * 2 + 1;
	}

	// Pour un index, calcule son fils à droite dans le tas.
	private int getRight(int index){
		return getLeft(index) + 1;
	}
	private void swap(int a, int b){
		BinaryNode<HuffmanNode> tmp = heap[a].getElement();
		heap[a].setElement(heap[b].getElement());
		heap[b].setElement(tmp);
	}
	
	public BinaryNode<HuffmanNode> peek() throws PriorityQueueException{
		if (nbrObject > 0){
			nbrObject--;
			return heap[0].getElement();
		}
		else
			throw new PriorityQueueException("File vide.");
	}
}
