public class MathTree<E> extends LinkedRBinaryTree<E> implements FormalExpressionTree {


	
	public MathTree(RBinaryTree<E> leftTree, RBinaryTree<E> rightTree, E element) {
		super(leftTree, rightTree, element);
		// TODO Auto-generated constructor stub
	}
	public MathTree(E element) {
		super (null, null, element);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FormalExpressionTree derive() {
		
		
		/*	public static void main(String[] args)
	{
		Integer i = 17;
		String str = "19";
		System.out.println( i.getClass() );
		System.out.println( str.getClass() );

	
	}
	
	Résultat : 
	
	class java.lang.Integer
	class java.lang.String

Ca me semblait audacieux, je vais corriger ça ^^
*/
		if(this.element().getClass()==java.lang.Number)
		{
			return null;
		}
			
		if(element()=="+")
		{			
			return new MathTree<E>(
									(RBinaryTree<E>)((MathTree<E>)(leftTree)).derive(),
									(RBinaryTree<E>)((MathTree<E>)(rightTree)).derive(),
									element);
		}
	
		if (element()=="-")
		{
			return new MathTree<E>(
									(RBinaryTree<E>)((MathTree<E>)(leftTree)).derive(),
									(RBinaryTree<E>)((MathTree<E>)(rightTree)).derive(),
									element);
		}
		
		if (this.element()=="*")
		{	
			return new MathTree<E>(
									new MathTree<E>(
													leftTree,
													(RBinaryTree<E>)((MathTree<E>)(rightTree)).derive(),
													element),
									new MathTree<E>(
													(RBinaryTree<E>)((MathTree<E>)(leftTree)).derive(),
													rightTree,
													element),
									/*"+"*/);
		}
		
		if (this.element()=="/")
		{
			return new MathTree<E>(
									new MathTree<E>(
													new MathTree<E>(
																	rightTree,
																	(RBinaryTree<E>)((MathTree<E>)(leftTree)).derive(),
																	/*"*"*/),
													new MathTree<E>(
																	(RBinaryTree<E>)((MathTree<E>)(rightTree)).derive(),
																	leftTree,
																	/*"*"*/),
													/*"'-'"*/),
									new MathTree<E>(
													rightTree,
													MathTree<E>(/*"2"*/),
													/*"exp"*/)),
									/*"/'"*/);
		}
		
		
		if (this.element()=="sin")
		{
			return new MathTree<E>(
									(RBinaryTree<E>)((MathTree<E>)(leftTree)).derive(),
									new MathTree<E>(
												leftTree,
												null,
												/*"cos"*/),
									/*"*"*/);								
		}
		
		if (this.element()=="cos")
		{
			return new MathTree<E>(
									null,
									new MathTree<E>(				
													(RBinaryTree<E>)((MathTree<E>)(leftTree)).derive(),
													new MathTree<E>(
																leftTree,
																null,
																/*"cos"*/),
													/*"*"*/),
									/*"-"*/);								
		}
		
		if (this.element()=="exp")
		{
			return new MathTree<E>();								
		}
	}
	
	@Override
	public String toString(){
		return null;
	}
	
	// Besoin de methodes d'ajout ?

}


