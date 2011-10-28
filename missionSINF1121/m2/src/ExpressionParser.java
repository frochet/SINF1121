/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Abdelali Ajrhourh & Cappart Quentin
 */

public class ExpressionParser {

    private MathTree expressionTree;
    private int index;
    private String expression;
    private InOut in;

    public ExpressionParser() {
    	
    	in = new InOut("expressions.txt", "test2.txt");
    	in.init();
        while((expression = in.readLine())!=null){
    	this.expression = expression;
        this.index = 1;
        RBinaryTree<String> root= buildChildExpression(expression);
        ExpressionParser.affiche(root);
        expressionTree=new MathTree(root.leftTree(), root.rightTree(), root.element());
        }
        in.closeReader();

    }

    public MathTree getExpressionTree() {
        return expressionTree;
    }


    private RBinaryTree<String> buildChildExpression(String expression) {


        ArrayList<Integer> openingParenthese;
        Stack<Integer> closingParenthese;
        ArrayList<Integer> operateur;
        ArrayList<Integer> function;

        boolean operatorFound = false;
        function = new ArrayList<Integer>();

        openingParenthese = new ArrayList<Integer>();
        closingParenthese = new Stack<Integer>();
        operateur = new ArrayList<Integer>();

        RBinaryTree<String> root = null;
        int expressionIndex = 1;
        while (expressionIndex < expression.length() - 1) {
            String tmp = expression.substring(expressionIndex, expressionIndex + 1);
//            System.out.println("entreee");
            // System.out.println(expression);
            if (ParserToken.isParentheseOuvranteToken(tmp)) {
                openingParenthese.add(expressionIndex);
                expression = expression.substring(1);
                //System.out.println("ajout parenthese");

            } else if (ParserToken.isOperateurToken(tmp)) {
                operateur.add(expressionIndex);

                if ((openingParenthese.size() >= closingParenthese.size())) {

                    operatorFound = true;
                    root = new LinkedRBinaryTree<String>( null, null, tmp);
                    //System.out.println("reation d'un noeu avec la valeur  " + tmp);
                    if (expression.length() > 1) {
                        root.setLeft(buildChildExpression(expression.substring(0, expressionIndex)));
                        root.setRight(buildChildExpression(expression.substring(expressionIndex, expression.length())));
                    }else{
                        System.out.println("Fils non init");
                    }
                }


            } else if (ParserToken.isParentheseFermanteToken(tmp)) {
                closingParenthese.add(expressionIndex);

            } else if (expressionIndex + 3 < expression.length()) {
                String funString = expression.substring(expressionIndex, expressionIndex + 3);
                if (ParserToken.isFonctionToken(funString)) {

                    function.add(expressionIndex);
                    root = new LinkedRBinaryTree<String>(null, null, funString);

                  //  System.out.println("reation d'un noeu avec la funString  " + funString);


                    operatorFound = true;
                    root.setLeft(buildChildExpression(expression.substring(expressionIndex + 3, expression.length() )));
                    expressionIndex+=3;

                }
            } else if (ParserToken.isExposantToken(tmp)) {
                root = new LinkedRBinaryTree<String>( null, null, tmp);

                //System.out.println("reation d'un noeu avec la valeur  " + tmp);

                operatorFound = true;
                if (expression.length() - 1 > 1) {


                    root.setLeft(buildChildExpression(expression.substring(0, expressionIndex)));
                    root.setRight(buildChildExpression(expression.substring(expressionIndex, expression.length())));
                }else{
                  // System.out.println("Fils non init");
                }


            }



            expressionIndex++;
        }


        if (!operatorFound) {
            boolean charFind = false;
            String tmp = expression.substring(1, expression.length());
            tmp = tmp.replace('(', ' ');
            tmp = tmp.replace(')', ' ');
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) != ' ') {
                    charFind = true;
                }



            }
            if (charFind) {
                root = new LinkedRBinaryTree<String>( null, null, tmp);
                // System.out.println("reation d'un noeu avec la valeur  " + tmp);

            }

           
        }


        //System.out.println("retourne un noeud avec la valeure : "+ root.element());
        return root;

    }

     public static void affiche(RBinaryTree<String> noeu){
         if(noeu!=null){
             affiche(noeu.leftTree());
             System.out.println(noeu.element());
             affiche(noeu.rightTree());

         }
     }
}






