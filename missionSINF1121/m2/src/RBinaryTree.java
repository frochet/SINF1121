/**
 * Interface for a Binary Tree defined recursively.
 *
 * This interface uses the Position interface described in DSAJ-4.  
 */
public interface RBinaryTree<E> {
  /**
   * @pre -
   * @post return true if this is empty, false otherwise.
   */
  public boolean isEmpty();

  /**
   * @pre -
   * @post return the number of nodes of this. 
   *       Note: the number of nodes of an empty tree is 0.
   */
  public int size();

  /**
   * @pre this is not empty.
   * @post return a reference to the tree root.
   */
  public Position<E> root();

  /**
   * @pre this is not empty
   * @post return true if this is reduced to a leaf (External Node), 
   *       false otherwise
   */
  public boolean isLeaf();

  /**
   * @pre this is not empty.
   * @post return a reference to the left subtree.
   */
  public RBinaryTree<E> leftTree();

  /**
   * @pre this is not empty.
   * @post return a reference to the right subtree.
   */
  public RBinaryTree<E> rightTree();

  /**
   * @pre this is not empty.
   * @post o is the element stored at the root of this.
   */
  public void setElement (E o);

  /**
   * @pre this is not empty.
   * @post tree is the left subtree of this.
   */
  public void setLeft (RBinaryTree<E> tree);

  /**
   * @pre this is not empty.
   * @post tree is the right subtree of this.
   */
  public void setRight (RBinaryTree<E> tree);

  /**
   * @pre -
   * @post an iterable collection of the positions of this, 
   *       following an inorder traversal, is returned. 
   */   
  public Iterable<Position<E>> positions();
}
