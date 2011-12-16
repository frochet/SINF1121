
import java.io.Serializable;
import java.util.HashMap;

/*
 * Auteur : Florentin, Claude,Abdel
 */
public class Huffman implements Serializable {

    private BinaryTree<HuffmanNode> huffTree;
    private String[] huffCode;
    private String str; // Le String associŽ ˆ l'arbre
    private int[] freq;
    final static int NCHAR = 128;
    private HashMap<Character, Integer> frequenceLettre;
    private HashMap<Character, String> codeCharacter;
    private HashMap<String, Character> codeLettre;
    private String texteEncode;

    //Constructeur

    public Huffman(String str) throws PriorityQueueException {
        frequenceLettre = new HashMap<Character, Integer>();
        codeCharacter = new HashMap<Character, String>();
        codeLettre = new HashMap<String, Character>();

        for (char e : str.toCharArray()) {
            if (frequenceLettre.containsKey(e)) {
                Integer val = frequenceLettre.get(e);
                val++;
                frequenceLettre.put(e, val);
            } else {
                frequenceLettre.put(e, 1);
            }
        }

        this.str = str;
     
        huffCode = new String[NCHAR];
        huffTree = this.makeHuffTree();
        // Utils.display(huffTree.getRoot());

        this.makeHuffCode();
        this.EncodeTexte(str);

        for (Character f : codeCharacter.keySet()) {
            this.codeLettre.put(codeCharacter.get(f), f);
        }

    }

    public Huffman(BinaryTree<HuffmanNode> arbre, String codeBinaire) {
        frequenceLettre = new HashMap<Character, Integer>();
        codeCharacter = new HashMap<Character, String>();
        codeLettre = new HashMap<String, Character>();
        this.huffTree = arbre;
        this.texteEncode = codeBinaire;
        this.makeHuffCode();
          for (Character f : codeCharacter.keySet()) {
            this.codeLettre.put(codeCharacter.get(f), f);
        }
        this.Decodebit(texteEncode);

    }

    private void EncodeTexte(String txtDepart) {
        this.texteEncode = "";
        for (char e : txtDepart.toCharArray()) {
            texteEncode += codeCharacter.get(e);
        }


    }

    public String getTexteEncode() {
        return texteEncode;
    }

    public String Decodebit(String txtToDecode) {
       
        String tmp = "";
        int begin, end;
        begin = 0;
        end = 0;
        for (int i = 0; i < txtToDecode.length(); i++) {

            if (codeLettre.containsKey(txtToDecode.substring(begin, end))) {

                tmp += codeLettre.get(txtToDecode.substring(begin, end));
                begin = i;
                end = begin + 1;
            } else {
                if ((i + 1) < txtToDecode.length()) {

                    end = i + 1;
                }
            }

        }
     
        return tmp;

    }

    public String[] getHuffCode() {
        return huffCode;
    }

    public BinaryTree<HuffmanNode> getHuffTree() {
        return huffTree;
    }

    public HashMap<Character, String> getCodeCharacter() {
        return codeCharacter;
    }


    /*Retourne un tableau de frŽquence dont la position de la frŽquence i correspond au caract�re i dans la table ASCII*/
  

    public BinaryTree<HuffmanNode> makeHuffTree() throws PriorityQueueException {
        //Initialisation de la PriorityQueue
        PriorityQueueHeap heap = new PriorityQueueHeap(frequenceLettre.size());
        Comparator comparatorhuff = new HuffmanComparator();
        // PriorityQueue<BinaryNode<HuffmanNode>> tmp=new PriorityQueue<BinaryNode<HuffmanNode>>(frequenceLettre.size(),comparatorhuff);

        //Remplissage de la PriorityQueue

        for (Character e : frequenceLettre.keySet()) {

            HuffmanNode HNode = new HuffmanNode(frequenceLettre.get(e), e);
            HNode.setPoids(1);
            BinaryNode<HuffmanNode> BNode = new BinaryNode<HuffmanNode>(HNode, null, null, null);

            heap.add(BNode);
        }

        //Fusions d'arbres
        while (heap.size() > 1) {

            BinaryNode<HuffmanNode> T1;
            BinaryNode<HuffmanNode> T2;
            BinaryNode<HuffmanNode> BNode;
            HuffmanNode HNode;

            T1 = heap.removeMin();
            T2 = heap.removeMin();

            HNode = new HuffmanNode(T1.element().getFrequence() + T2.element().getFrequence());
            BNode = new BinaryNode<HuffmanNode>(HNode, null, T1, T2);

            heap.add(BNode);

        }
        //Le dernier arbre restant est l'arbre de Huffman

        BinaryTree<HuffmanNode> res = new BinaryTree<HuffmanNode>();
        res.setRoot(heap.peek());

        return res;
    }

    //Fonction récursive donnant le code pour chaque lettre
    public void makeHuffCodeRec(BinaryNode<HuffmanNode> tree, String upCode) {
        if (!tree.element().isChar()) {
            if (tree.getLeft() != null) {
                makeHuffCodeRec(tree.getLeft(), upCode + "0");
            }
            if (tree.getRight() != null) {
                makeHuffCodeRec(tree.getRight(), upCode + "1");
            }
        } else {

            codeCharacter.put(tree.element().getLetter(), upCode);
        }

    }

    //Fonction donnant le code de Huffman entier en appeler une fonction récursive sur l'arbre d'Huffman
    public void makeHuffCode() {
        makeHuffCodeRec(huffTree.getRoot(), "");
    }
}
