
public class MathTree<E> extends LinkedRBinaryTree<E> implements FormalExpressionTree {


	
	public MathTree(RBinaryTree<E> leftTree, RBinaryTree<E> rightTree, E element) {
		super(leftTree, rightTree, element);
		// TODO Auto-generated constructor stub
	}

	@Override
	public FormalExpressionTree derive() {
		
		// Pas de string dans un switch ! seulement int
		switch((String)this.element()) //Il faut creer une énum
		{
		case '+':
			return new MathTree<E>; //les casts ne passent pas
			break;
			
		case '-':
			return new MathTree((RBinaryTree<E>)((MathTree<E>)(this.leftTree)).derive(), (RBinaryTree<E>)((MathTree<E>)(this.rightTree)).derive(), "-"); //Les dérive ne passent pas
			break;
		
		
		case '*':
			break;
			
			
		}
		
		
		
		return null;
	}
	
	@Override
	public String toString(){
		return null;
	}
	
	// Besoin de methodes d'ajout ?

}


