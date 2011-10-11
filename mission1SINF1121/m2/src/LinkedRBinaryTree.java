
public class LinkedRBinaryTree<E> implements RBinaryTree<E> {
	
	private Position<E> root, parent, leftTree, rightTree;
	private E element;
	//private int size;
	
	public LinkedRBinaryTree(Position<E> root,Position<E> parent, Position<E> leftTree, Position<E> rightTree){
		this.root = root;
		this.parent = parent;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return countNode((RBinaryTree<E>)this.root);
	}
	private int countNode(RBinaryTree<E> tree){
		if(tree == null)
			return 1;
		return 1 + countNode(tree.leftTree()) + countNode(tree.rightTree()); 
	}

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return (this == null);
	}

	@Override
	public RBinaryTree<E> leftTree() {
		// TODO Auto-generated method stub
		return (RBinaryTree<E>)this.leftTree;
	}

	@Override
	public RBinaryTree<E> rightTree() {
		// TODO Auto-generated method stub
		return (RBinaryTree<E>)this.rightTree;
	}

	@Override
	public void setElement(E element) {
		// TODO Auto-generated method stub
		this.element = element;
	}

	@Override
	public void setLeft(RBinaryTree<E> tree) {
		// TODO Auto-generated method stub
		this.leftTree = (Position<E>)tree;
	}

	@Override
	public void setRight(RBinaryTree<E> tree) {
		// TODO Auto-generated method stub
		this.rightTree = (Position<E>)tree;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
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
