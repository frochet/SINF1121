/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdel
 */
public enum ParserToken {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    OPEN_PARENTHESE("("),
    CLOSE_PARENTHESE(")"),
    EXPOSANT("^"),
    SINUS("sin"),
    COSINUS("cos");
    private final String symbole;

    private ParserToken(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }

    public static boolean isOperateurToken(String token) {

        if (token.equalsIgnoreCase(ADDITION.symbole) || token.equalsIgnoreCase(SUBTRACTION.symbole) || token.equalsIgnoreCase(MULTIPLICATION.symbole) || token.equalsIgnoreCase(DIVISION.symbole)) {
            return true;

        }else{
            return false;
        }

    }

    public static boolean isParentheseOuvranteToken(String token){
        if(token.equalsIgnoreCase(OPEN_PARENTHESE.symbole)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isExposantToken(String token){
        return token.equalsIgnoreCase(EXPOSANT.symbole);

    }

    public static boolean isParentheseFermanteToken(String token){
        if(token.equalsIgnoreCase(CLOSE_PARENTHESE.symbole)){
            return true;

        }else{
            return false;
        }
    }
    
     public static boolean isFonctionToken(String token){
        if(token.equalsIgnoreCase(SINUS.symbole) || token.equalsIgnoreCase(COSINUS.symbole)){
            return true;

        }else{
            return false;
        }
    }

     public static boolean isNumberToken(String token){
         return true;
     }


}
