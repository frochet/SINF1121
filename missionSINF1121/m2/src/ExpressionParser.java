/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 // Attention a la definition des package, non valide chez les autres.
// => travaillé dans le default package.
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Abdel Quentin
 */
public class ExpressionParser {

    private ArrayList<Integer> openingParenthese;
    private Stack<Integer> closingParenthese;
    private ArrayList<Integer> operateur;
    private MathTree expressionTree;
    private ArrayList<Integer> function;
    private int index;
    private String expression;

    public ExpressionParser(String expression) {
        this.expression = expression;
        this.index = 1;
        init();
        RBinaryTree<String> root = buildChildExpression(expression);




    }

    private void init() {
        /**
        while (index < expression.length() - 1) {
        String tmp = expression.substring(index, index + 1);

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
         * */
    }

    @Override
    public String toString() {
        return " finiii";
    }

    private RBinaryTree<String> buildChildExpression(String expression) {
        

        ArrayList<Integer> openingParenthese;
        Stack<Integer> closingParenthese;
        ArrayList<Integer> operateur;
        ArrayList<Integer> function;

        function = new ArrayList<Integer>();

        openingParenthese = new ArrayList<Integer>();
        closingParenthese = new Stack<Integer>();
        operateur = new ArrayList<Integer>();

        RBinaryTree<String> root;
        boolean thereIsAnOperator = false;
        int expressionIndex = 1;
        while (expressionIndex < expression.length() - 1) {
            String tmp = expression.substring(expressionIndex, expressionIndex + 1);
//            System.out.println("entreee");
            System.out.println(expression);
            if (ParserToken.isParentheseOuvranteToken(tmp)) {
                openingParenthese.add(expressionIndex);
                expression=expression.substring(1);
                System.out.println("ajout parenthese");

            } else if (ParserToken.isOperateurToken(tmp)) {
            	 thereIsAnOperator = true;
                operateur.add(expressionIndex);

                if ((openingParenthese.size() >= closingParenthese.size())) {

                    root = new LinkedRBinaryTree<String>(null, null, null, tmp);
                    System.out.println("Operateur racine = " + tmp);
                    if (expression.length()  > 1) {
                        root.setLeft(buildChildExpression(expression.substring(0, expressionIndex)));
                        root.setRight(buildChildExpression(expression.substring(expressionIndex, expression.length())));
                    }
                }


            } else if (ParserToken.isParentheseFermanteToken(tmp)) {
                closingParenthese.add(expressionIndex);

            } else if (expressionIndex + 3 < expression.length()) {
                String funString = expression.substring(expressionIndex, expressionIndex + 3);
                if (ParserToken.isFonctionToken(funString)) {
                	thereIsAnOperator = true;
                    function.add(expressionIndex);
                    root = new LinkedRBinaryTree<String>(null, null, null, funString);
                    System.out.println("Operateur racine = " + funString);

                    root.setLeft(buildChildExpression(expression.substring(expressionIndex +3,expression.length()-1)));

                }
            }else if (ParserToken.isExposantToken(tmp)) {
            	 	thereIsAnOperator = true;
                    root = new LinkedRBinaryTree<String>(null, null, null, tmp);
                    System.out.println("Operateur racine = " + tmp);
                    if (expression.length() - 1 > 1) {
                        root.setLeft(buildChildExpression(expression.substring(0, expressionIndex )));
                        root.setRight(buildChildExpression(expression.substring(expressionIndex, expression.length())));
                    }


            }
            
            if (!thereIsAnOperator) {
            	root = new LinkedRBinaryTree<String>(null, null, null, expression);
            }
            expressionIndex++;
            
        }








        return null;
    }
}
