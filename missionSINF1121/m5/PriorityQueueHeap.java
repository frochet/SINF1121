
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
	public BinaryNode<HuffmanNode> removeMin() throws PriorityQueueException{
		/*
		 * Si le noeud courant n'a pas d'enfant, aucun échange n'est à effectuer. S'il n'y a qu'un seul enfant, il est obligatoirement à gauche, on les échange si l'enfant est plus grand.
Si le noeud courant possède deux enfants, on va échanger la valeur courante avec celle du plus grand enfant. Ainsi, on est sûr que le nouveau noeud courant respectera la condition de tas. 
		 */
		BinaryNode<HuffmanNode> tmp = this.peek();
		nbrObject--;
		
		heap[0] = heap[nbrObject];
		int index = 0;
		int left = 1;
		int right = 2;
		
		
		while ((left <= nbrObject && heap[index].getElement().element().compareTo(heap[left].getElement().element()) < 0)
			|| (right <= nbrObject && heap[index].getElement().element().compareTo(heap[right].getElement().element()) < 0)){
			int k;
			
			// k sera l'indice du plus grand fils.
			if (right <= nbrObject &&
					heap[left].getElement().element().compareTo(heap[right].getElement().element()) < 0)
				k = right;
			else
				k = left;
			
			swap(k, index);
			index = k;
			left = getLeft(index);
			right = getRight(index);
		}
		return tmp;
	}
}
