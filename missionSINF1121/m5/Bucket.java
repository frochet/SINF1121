
import java.io.Serializable;

/*
 * Auteur : Florentin
 */
public class Bucket<E> implements Serializable{
	
	private E element;

	public Bucket(){
		this(null);
	}
	
	public Bucket(E element){
		this.element = element;
	}

	public E getElement(){
		return this.element;
	}

	public void setElement(E element){
		this.element = element;
	}
	
	public E swapElement(E element){
        E tmp = this.element;
        this.element = element;
        return tmp;
    }
	
}
