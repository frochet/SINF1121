
/**
 *
 * Class AvlNode
 * 
 */
class AvlNode<E> {
    // Constructeur

    AvlNode(Comparable key, E obj) {
        this(key, obj, null, null);
    }

    AvlNode(Comparable key, E obj, AvlNode leftN, AvlNode rightN) {
        element = key;
        left = leftN;
        right = rightN;
        height = 0;
        object = obj;
    }

    public Comparable getElement() {
        return element;
    }

    public int getHeight() {
        return height;
    }

    public AvlNode getLeft() {
        return left;
    }

    public E getObject() {
        return object;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setElement(Comparable element) {
        this.element = element;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }
    //attributs
    private Comparable element;      // clé pour tri
    private AvlNode left;         // enfant gauche
    private AvlNode right;        // enfant droit
    private int height;       // hauteur
    private E object; // reference vers object
}
