
import java.io.Serializable;

/*
 * Auteur : Florentin, Claude
 */
/*Chaque noeud de l'arbre contiendra soit :
 * - Seulement un poid
 * - Seulement fr�quence et lettre correspondante.*/

public class HuffmanNode implements Comparable,Serializable {

    private int poids;
    private int frequence;
    private char letter;
    private boolean isChar;

    @Override
    public String toString() {
        StringBuffer tmp=new StringBuffer();
        tmp.append("Poid du noeux = "+this.poids+" frequence du charactere "+this.letter+" "+this.frequence);
        return tmp.toString();
    }

    HuffmanNode(int poids) { /* Correspond � un noeud de l'arbre */
        this.poids = poids;
        this.isChar=false;
    }

    HuffmanNode(int frequence, char letter) { /* Correspond � une feuille de l'arbre */
        this.frequence = frequence;
        this.letter = letter;
        this.isChar=true;
    }

    public boolean isChar() {
        return isChar;
    }


    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getFrequence() {
        return this.frequence;
    }

    public char  getLetter() {
        return this.letter;
    }

    public int compareTo(Object o) {

        if (o instanceof HuffmanNode) {
            if (((HuffmanNode) o).getFrequence() > (this.getFrequence())) {
                return 1;
            } else if (((HuffmanNode) o).getFrequence() < this.getFrequence()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
	