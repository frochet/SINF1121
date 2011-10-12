
public class LinkedRBinaryTree<E> implements RBinaryTree<E> {
	
	private Position<E> root, parent;
	private LinkedRBinaryTree<E> leftTree, rightTree;
	private E element;
	private int size;
	
	public LinkedRBinaryTree(Position<E> root,Position<E> parent, LinkedRBinaryTree<E> leftTree, LinkedRBinaryTree<E> rightTree){
		this.root = root;
		this.parent = parent;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return countNode((RBinaryTree<E>)this.root);
	}
	private int countNode(){
		if(isLeaf()) return 1;
		else return 1 + leftTree.countNode() + rightTree.countNode(); 
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

	@Override
	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public void setLeft(RBinaryTree<E> tree) {
		this.leftTree=tree;
	}

	@Override
	public void setRight(RBinaryTree<E> tree) {
		this.rightTree= tree;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// Classe NodePositionList fournie dans DSAJ-5 section 6.2.4
		PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
		if(size() ==0)
			preorderPositions(root(),positions);
		return positions;
		}
		private void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException{
		pos.addLast(v);
		if(((LinkedRBinaryTree<E>) this.leftTree).isLeaf())
			preorderPositions((Position<E>)leftTree(),pos);
		if(((LinkedRBinaryTree<E>) this.rightTree).isLeaf())
			preorderPositions((Position<E>)rightTree(),pos);
	}

}
