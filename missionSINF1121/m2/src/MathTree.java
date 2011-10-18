
public class MathTree<E> extends LinkedRBinaryTree implements FormalExpressionTree {

	public MathTree(Position<E> root, Position<E> parent, RBinaryTree<E> leftTree,
			RBinaryTree<E> rightTree, E element) {
		super(root, parent, leftTree, rightTree);
		// TODO Auto-generated constructor stub
		setElement(element);
	}

	@Override
	public FormalExpressionTree derive() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		return null;
	}
	
	// Besoin de methodes d'ajout ?

}
