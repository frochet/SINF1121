/*
 * Auteur : Florentin, Claude
 */
public class PriorityQueueHeap<E>{
	
	private Bucket<E>[] heap;
	private int nbrObject = 0;
	
	public PriorityQueueHeap(int defaultsize){
		this.heap = new Bucket[defaultsize];
	}
	
	public int size()	{
		return nbrObject;
	}
	
	public void add(E element){
		
		int index = nbrObject;
		this.heap[index] = new Bucket<E>(element);
		int parent = getParent(index);
		
		while (	parent >= 0 && element.compareTo(heap[parent].getElement()) > 0)
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
		E tmp = heap[a].getElement();
		heap[a].setElement(heap[b].getElement());
		heap[b].setElement(tmp);
	}
	
	public E peek() throws PriorityQueueException
	{
		if (nbrObject > 0)
		{
			nbrObject--;
			return heap[0].getElement();
		}
		else
			throw new PriorityQueueException("File vide.");
	}


}
