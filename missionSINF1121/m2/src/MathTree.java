
public class MathTree<E> extends LinkedRBinaryTree<E> implements FormalExpressionTree {

	public MathTree(Position<E> parent, RBinaryTree<E> leftTree,
			RBinaryTree<E> rightTree, E element) {
		super(parent, leftTree, rightTree,element);
		// TODO Auto-generated constructor stub
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
