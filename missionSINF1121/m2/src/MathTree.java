public class MathTree extends LinkedRBinaryTree<String> implements FormalExpressionTree {


	
	public MathTree(RBinaryTree<String> leftTree, RBinaryTree<String> rightTree, String element) {
		super(leftTree, rightTree, element);
	}
	
	
	public MathTree(String element) {
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
			return new MathTree(
						(RBinaryTree<String>)((MathTree)leftTree).derive(),
						(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
						element);
		}
	
		if (element()=="-")
		{
			return new MathTree(
						(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
						(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
						element);
		}
		
		if (this.element()=="*")
		{	
			return new MathTree(
						new MathTree(
								leftTree,
								(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
								element),
						new MathTree(
								(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
								rightTree,
								element),
						"+");
		}
		
		if (this.element()=="/")
		{
			return new MathTree(
						new MathTree(
								new MathTree(
										rightTree,
										(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
										"*"),
								new MathTree(
										(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
										leftTree,
										"*"),
								"-"),
						new MathTree(
										rightTree,
										new MathTree("2"),
										"exp"),
						"/");
		}
		
		
		if (this.element()=="sin")
		{
			return new MathTree(
					(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
					new MathTree(
							leftTree,
							null,
							"cos"),
					"*");								
		}
		
		if (this.element()=="cos")
		{
			return new MathTree(
					null,
					new MathTree(				
							(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
							new MathTree(
									leftTree,
									null,
									"cos"),
							"*"),
					"-");								
		}
		
		if (this.element()=="^")
		{
			return new MathTree();								
		}
	}
	
	@Override
	public String toString(){
		return null;
	}
	
	// Besoin de methodes d'ajout ?

}


