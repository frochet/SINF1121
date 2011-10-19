/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mission2;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Abdel
 */
public class ExpressionParser {

    private ArrayList<Integer> openingParenthese;
    private Stack<Integer> closingParenthese;
    private ArrayList<Integer> operateur;
    private MathTree<String> expressionTree;
    private ArrayList<Integer> function;
    private int index;
    private String expression;

    public ExpressionParser(String expression) {
        this.expression = expression;
        this.index = 0;
        this.openingParenthese = new ArrayList<Integer>();
        this.closingParenthese = new Stack<Integer>();
        this.operateur = new ArrayList<Integer>();
        function = new ArrayList<Integer>();
        init();



    }

    private void init() {
        while (index < expression.length()) {
            String tmp = expression.substring(index, index + 1);
            if (index + 3 < expression.length()) {

            }
            if (ParserToken.isParentheseOuvranteToken(tmp)) {
                openingParenthese.add(index);

            } else if (ParserToken.isOperateurToken(tmp)) {
                operateur.add(index);


            } else if (ParserToken.isParentheseFermanteToken(tmp)) {
                closingParenthese.add(index);

            } else if (index + 3 < expression.length()) {
                String funString = expression.substring(index, index + 3);
                if (ParserToken.isFonctionToken(funString)) {

                    function.add(index);
                }
            }

            index++;

        }


    }

    @Override
    public String toString() {
        System.out.println("Ouvrante se trouve en pos : " + openingParenthese);
        System.out.println("Fermante en pos : " + closingParenthese);
        System.out.println("Operateur en pos : " + operateur);
        System.out.println("function en pos : " + function);
        return " finiii";
    }

    private RBinaryTree<String> buildChildExpression(String expression, int index) {






        return null;
    }
}
