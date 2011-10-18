
public class MathTree<E> extends LinkedRBinaryTree<E> implements FormalExpressionTree {


	public MathTree(FormalExpressionTree leftTree, MathTree<E> rightTree, E element) { //On teste deux possibilit� de type d'input
		super(leftTree, rightTree,element); //Probl�me d'interface avec le constructeur de la classe m�re
	}

	@Override
	public FormalExpressionTree derive() {
		switch((String)this.element()) //Il faut creer une �num
		{
		case '+':
			return new MathTree<E>(((MathTree<E>) this.leftTree).derive(), ((MathTree<E>) this.rightTree).derive(), '+'); //les casts ne passent pas
			break;
			
		case '-':
			return new MathTree<E>((this.leftTree).derive(), (this.rightTree).derive(), '-'); //Les d�rive ne passent pas
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


