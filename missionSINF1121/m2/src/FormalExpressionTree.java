/**
 * Un "FormalExpressionTree" est un arbre permettant de m�moriser
 * et de manipuler une expression analytique.
 *
 * Une classe impl�mentant cette interface doit disposer d'un CONSTRUCTEUR
 * prenant comme argument une cha�ne de caract�res (String) et construisant
 * l'arbre associ�. 
 * Cette cha�ne est suppos�e correspondre � une expression analytique 
 * syntaxiquement correcte et compl�tement parenth�s�e. 
 * Une gestion d'exceptions doit �tre pr�vue lorsque cette pr�condition n'est pas v�rifi�e. 
 *   
 * Un CONSTRUCTEUR sans argument permet de construire un arbre �l�mentaire
 * correspondant � l'expression vide "".
 *
 */ 
public interface FormalExpressionTree {
  /**
   * Cette m�thode renvoie une cha�ne de caract�res correspondant �
   * l'expression analytique repr�sent�e dans l'arbre.
   *  
   * @pre  this repr�sente une expression analytique syntaxiquement correcte
   * @post une cha�ne de caract�res, correspondant � l'expression analytique 
   *       compl�tement parenth�s�e repr�sent�e par this, est renvoy�e.
   */  
  public String toString();

  /**
   * Cette m�thode calcule le nouvel arbre correspondant � la d�riv�e formelle
   * de l'arbre courant. L'arbre courant (this) n'est pas modifi�.
   * 
   * @pre   this repr�sente une expression analytique syntaxiquement correcte.
   * @post  Une r�f�rence � un nouvel arbre repr�sentant la d�riv�e formelle 
   *        de this est renvoy�e. 
   */
  public FormalExpressionTree derive();
} 
