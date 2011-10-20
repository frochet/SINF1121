public class LinkedRBinaryTree<E> implements RBinaryTree<E> {
	
	/**
	 *
	 * @author Florentin
	 */
	
	protected Position<E> root /*, parent*/;
	protected RBinaryTree<E> leftTree, rightTree;
	protected E element;
	
	public LinkedRBinaryTree(/*Position<E> parent,*/ RBinaryTree<E> leftTree, RBinaryTree<E> rightTree, E element){
		this.root = (Position<E>)this;
		/*this.parent = parent;*/
		this.leftTree = leftTree;
		this.rightTree = rightTree;
		this.element = element;
	}
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		if(isLeaf()) return 1;
		else return 1 + leftTree.size() + rightTree.size(); 
	}


	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public boolean isLeaf() {
		return (this.leftTree == null & this.rightTree == null);
	}

	@Override
	public RBinaryTree<E> leftTree() {
		return this.leftTree;
	}

	@Override
	public RBinaryTree<E> rightTree() {
		return this.rightTree;
	}
	/*public Position<E> parentTree(){
		return this.parent;
	}*/

	@Override
	public void setElement(E element) {
		this.element = element;
	}
	public E element(){
		return this.element;
	}
	@Override
	public void setLeft(RBinaryTree<E> tree) {
		this.leftTree=tree;
	}

	@Override
	public void setRight(RBinaryTree<E> tree) {
		this.rightTree= tree;
	}

}
