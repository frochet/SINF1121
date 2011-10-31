/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mission3;

/**
 *Classe InOutException
 * @author Abdel
 */
public class InOutException extends Exception {

    /**
     * Creates a new instance of <code>InOutException</code> without detail message.
     */
    public InOutException() {
    }


    /**
     * Constructs an instance of <code>InOutException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InOutException(String msg) {
        super(msg);
    }
}
