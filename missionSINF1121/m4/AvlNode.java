
/**
 * Class AvlNode
 * @param <K>
 */
class AvlNode<E, K> implements Comparable<K>{
    // Constructeur
	 //attributs
    private K element;      // clé pour tri
    private AvlNode<E,K> left;         // enfant gauche
    private AvlNode<E, K> right;        // enfant droit
    private int height;       // hauteur
    private E object; // reference vers object
    
    AvlNode(K key, E obj) {
    	this.element = key;
    	this.object = obj;
    }

    AvlNode(K key, E obj, AvlNode<E, K> leftN, AvlNode<E, K> rightN) {
        element = key;
        left = leftN;
        right = rightN;
        height = 0;
        object = obj;
    }

    public K getElement() {
        return element;
    }

    public int getHeight() {
        return height;
    }

    public AvlNode<E, K> getLeft() {
        return left;
    }

    public E getObject() {
        return object;
    }

    public AvlNode<E, K> getRight() {
        return right;
    }

    public void setElement(K element) {
        this.element = element;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(AvlNode<E, K> left) {
        this.left = left;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public void setRight(AvlNode<E, K> right) {
        this.right = right;
    }
 
	@Override
	public int compareTo(K o) {
		// TODO Auto-generated method stub
		if(o instanceof String)
			return ((String) o).compareTo((String)this.element);
		return 0;
	}
}
