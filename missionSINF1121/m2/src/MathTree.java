public class MathTree extends LinkedRBinaryTree<String> implements FormalExpressionTree {

	/**
	 *
	 * @author Gérard Valéry & Carpentier Claude
	 */

	
	public MathTree(RBinaryTree<String> leftTree, RBinaryTree<String> rightTree, String element) {
		super(leftTree, rightTree, element);
	}
	
	
	public MathTree(String element) {
		super (null, null, element);
	}
	
	@Override
	public String toString(){	
		if (leftTree==null & rightTree==null)
			return element;
	
		else if (leftTree==null)
		{
			return element+" ("+rightTree.toString()+")";
		}
		else if (rightTree==null)
		{
			return leftTree.toString();
		}
		
		else
		{
			return "("+leftTree.toString()+") "+element+" ("+rightTree.toString()+")";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public FormalExpressionTree derive() {
	
		if (isLeaf())
		{
			if (element()=="x")
			{
				return new MathTree("1");
			}
			
			else return null;
		}
		else
		{
			if(element()=="+")
			{			
				if (((MathTree)leftTree).derive()==null)
				{
					return ((MathTree)(rightTree)).derive();
				}
				else if (((MathTree)rightTree).derive()==null)
				{
					return ((MathTree)(leftTree)).derive();
				}
				else
				{
					return new MathTree(
							(RBinaryTree<String>)((MathTree)leftTree).derive(),
							(RBinaryTree<String>)((MathTree)rightTree).derive(),
							"+");
				}
			}
		
			else if (element()=="-")
			{
				if (((MathTree)rightTree).derive()==null)
				{
					return ((MathTree)(leftTree)).derive();
				}
				else
				{
					return new MathTree(
							(RBinaryTree<String>)((MathTree)leftTree).derive(),
							(RBinaryTree<String>)((MathTree)rightTree).derive(),
							"-");
				}
			}
			
			else if (this.element()=="*")
			{	
                if (((MathTree)rightTree).derive()==null & ((MathTree)leftTree).derive()==null)
				{
					return null;
				}				


                else if (((MathTree)leftTree).derive()==null)
				{
					return new MathTree(
							leftTree,
							(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
							"*");
				}
				else if (((MathTree)rightTree).derive()==null)
				{
					new MathTree(
							(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
							rightTree,
							"*");
				}
				
				else
				{
					return new MathTree(
							new MathTree(
									leftTree,
									(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
									"*"),
							new MathTree(
									(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
									rightTree,
									"*"),
							"+");
				}
			}
			
			else if (this.element()=="/")
			{
                if (((MathTree)(leftTree)).derive()==null)
                {
                	return new MathTree(
							new MathTree(
									null,
									new MathTree(
											(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
											leftTree,
											"*"),
									"-"),
							new MathTree(
											rightTree,
											new MathTree("2"),
											"^"),
							"/");
                }
                
                else if (((MathTree)(rightTree)).derive()==null)
                {
                	return new MathTree(
							new MathTree(
											rightTree,
											(RBinaryTree<String>)((MathTree)(leftTree)).derive(),
											"*"),
							new MathTree(
											rightTree,
											new MathTree("2"),
											"^"),
							"/");
                }
                else
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
											"^"),
							"/");
                }
			}
			
			
			else if (this.element()=="sin")
			{
				if (((MathTree)(rightTree)).derive()==null)
				{
					return new MathTree(
							null,
							rightTree,
							"cos");
				}
				else
				{
					return new MathTree(
							(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
							new MathTree(
									null,
									rightTree,
									"cos"),
							"*");
				}								
			}
			
			else if (this.element()=="cos")
			{
				if (((MathTree)(rightTree)).derive()==null)
				{
					return new MathTree(
							null,
							rightTree,
							"sin");
				}
				else
				{
				return new MathTree(
						null,
						new MathTree(				
								(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
								new MathTree(
										null,
										rightTree,
										"sin"),
								"*"),
						"-");
				}
			}
			
			else if (this.element()=="^") //A modifier
			{
				return new MathTree(
						rightTree,
						new MathTree(
								new MathTree(
										leftTree,
										new MathTree(""+(Double.parseDouble(rightTree.element())-1)),
										"^"),
								(RBinaryTree<String>)((MathTree)(rightTree)).derive(),
								"*"),
						"*");								
			}
		}
		return null;
		

		
	}
	
}


