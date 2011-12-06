/*
 * Auteur : Florentin
 */
public class PriorityQueueHeap {
	
	private Bucket<HuffmanNode>[] heap;
	private int defaultsize;
	private int nbrObject = 0;
	
	public PriorityQueueHeap(int defaultsize){
		this.defaultsize = defaultsize;
		this.heap = new Bucket[defaultsize];
	}
	
	public void add(HuffmanNode element){
		
		int index = nbrObject;
		this.heap[index] = new Bucket<HuffmanNode>(element);
		int parent = getParent(index);
		
		while (	parent >= 0 && heap[parent].getElement().compareTo(element) > 0)
		{
			// Echange des deux ŽlŽments.
			swap(parent, index);
			
			// DŽplacement vers le niveau supŽrieur.
			index = parent;
			parent = getParent(index);
		}
		nbrObject++;

	}
	
	// Pour un index, calcule son parent dans le tas.
	private int getParent(int index)
	{
		return (int) Math.floor((index - 1) / 2);
	}

	// Pour un index, calcule son fils ˆ gauche dans le tas.
	private int getLeft(int index)
	{
		return index * 2 + 1;
	}

	// Pour un index, calcule son fils ˆ droite dans le tas.
	private int getRight(int index)
	{
		return getLeft(index) + 1;
	}
	private void swap(int a, int b)
	{
		HuffmanNode tmp = heap[a].getElement();
		heap[a].setElement(heap[b].getElement());
		heap[b].setElement(tmp);
	}
	
	public HuffmanNode peek() throws PriorityQueueException
	{
		if (nbrObject > 0)
			return heap[0].getElement();
		else
			throw new PriorityQueueException("File vide.");
	}


}
