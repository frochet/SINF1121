/*
 * Auteur : Florentin
 */
public class BinaryNode<K> {
	private K elem;
	private BinaryNode<K> parent, rigth,left;
	public BinaryNode(K elem, BinaryNode<K> parent, BinaryNode<K> left, BinaryNode<K> right){
		this.elem = elem;
		this.parent = parent;
		this.left = left;
		this.rigth = right;
	}
	public void setRight(BinaryNode<K> right)	{
		this.rigth = right;
	}
	
	public void setLeft(BinaryNode<K> left)	{
		this.left = left;
	}
	
	public BinaryNode<K> getRight()	{
		return rigth;
	}
	
	public BinaryNode<K> getLeft()	{
		return left;
	}
	
	public boolean isExternal(){
		if (rigth==null|left==null)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}		
	
	public K element()	{
		return elem;
	}
	
}
