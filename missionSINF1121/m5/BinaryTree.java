/*
 * Auteur : Florentin, Claude
 */
public class BinaryTree<K> {
	
	private BinaryNode<K> root;
	
	public BinaryTree(){
		
	}
	public void setRoot(BinaryNode<K> root){
		this.root = root;
	}
	public BinaryNode<K> getRoot(){
		return root;
	}
}
