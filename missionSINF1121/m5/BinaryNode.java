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
	public void setRight(BinaryNode<K> right)
	{
		this.rigth = right;
	}
	
	public void setLeft(BinaryNode<K> left)
	{
		this.left = left;
	}
	public K element()
	{
		return elem;
	}
	
}
