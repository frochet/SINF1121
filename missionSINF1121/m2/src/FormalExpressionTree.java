/**
 * Un "FormalExpressionTree" est un arbre permettant de mémoriser
 * et de manipuler une expression analytique.
 *
 * Une classe implémentant cette interface doit disposer d'un CONSTRUCTEUR
 * prenant comme argument une chaîne de caractères (String) et construisant
 * l'arbre associé. 
 * Cette chaîne est supposée correspondre à une expression analytique 
 * syntaxiquement correcte et complètement parenthésée. 
 * Une gestion d'exceptions doit être prévue lorsque cette précondition n'est pas vérifiée. 
 *   
 * Un CONSTRUCTEUR sans argument permet de construire un arbre élémentaire
 * correspondant à l'expression vide "".
 *
 */ 
public interface FormalExpressionTree {
  /**
   * Cette méthode renvoie une chaîne de caractères correspondant à
   * l'expression analytique représentée dans l'arbre.
   *  
   * @pre  this représente une expression analytique syntaxiquement correcte
   * @post une chaîne de caractères, correspondant à l'expression analytique 
   *       complètement parenthésée représentée par this, est renvoyée.
   */  
  public String toString();

  /**
   * Cette méthode calcule le nouvel arbre correspondant à la dérivée formelle
   * de l'arbre courant. L'arbre courant (this) n'est pas modifié.
   * 
   * @pre   this représente une expression analytique syntaxiquement correcte.
   * @post  Une référence à un nouvel arbre représentant la dérivée formelle 
   *        de this est renvoyée. 
   */
  public FormalExpressionTree derive();
} 
