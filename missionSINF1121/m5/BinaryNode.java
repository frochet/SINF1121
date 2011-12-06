/*
 * Auteur : Florentin
 */
public class BinaryNode<K> {
	private K elem;
	private BinaryNode<K> parent, rigth,left;
	public BinaryNode(K elem, BinaryNode<K> parent, BinaryNode<K> left, BinaryNode<K> righ){
		this.elem = elem;
		this.parent = parent;
		this.left = left;
		this.rigth = rigth;
	}
}
