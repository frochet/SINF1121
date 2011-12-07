
import java.util.HashMap;

/*
 * Auteur : Florentin, Claude,Abdel
 */
public class Huffman {

    private BinaryTree<HuffmanNode> huffTree;
    private String[] huffCode;
    private String str; // Le String associŽ ˆ l'arbre
    private int[] freq;
    final static int NCHAR = 128;
    private HashMap<Character, Integer> frequenceLettre;
    private  HashMap<Character,String> codeCharacter;
    private String texteEncodé;
    //Constructeur

    public Huffman(String str) throws PriorityQueueException {
        frequenceLettre = new HashMap<Character, Integer>();
        codeCharacter=new HashMap<Character, String>();

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
        this.freq = freqCount(this.str);
        huffCode = new String[NCHAR];
        huffTree = this.makeHuffTree();
       // Utils.display(huffTree.getRoot());

        this.makeHuffCode();
        this.EncodeTexte(str);
    }

    private void EncodeTexte(String txtDepart){
        this.texteEncodé="";
        for(char e:txtDepart.toCharArray()){
            texteEncodé+=codeCharacter.get(e);
        }
        System.out.println("texte encodé = "+texteEncodé);

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
    public int[] freqCount(String text) {
        int freq[] = new int[NCHAR];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        return freq;
    }

    public BinaryTree<HuffmanNode> makeHuffTree() throws PriorityQueueException {
        //Initialisation de la PriorityQueue
        PriorityQueueHeap heap = new PriorityQueueHeap(frequenceLettre.size());
        Comparator comparatorhuff= new HuffmanComparator();
       // PriorityQueue<BinaryNode<HuffmanNode>> tmp=new PriorityQueue<BinaryNode<HuffmanNode>>(frequenceLettre.size(),comparatorhuff);

        //Remplissage de la PriorityQueue

        for (Character e : frequenceLettre.keySet()) {

            HuffmanNode HNode = new HuffmanNode(frequenceLettre.get(e), e);
            HNode.setPoids(1);
            BinaryNode<HuffmanNode> BNode = new BinaryNode<HuffmanNode>(HNode, null, null, null);
            System.out.println(BNode.element());
            heap.add(BNode);
        }

        //Fusions d'arbres
        while (heap.size() > 1) {
            System.out.println("Nombre elemn dans Heap="+heap.size());
            BinaryNode<HuffmanNode> T1;
            BinaryNode<HuffmanNode> T2;
            BinaryNode<HuffmanNode> BNode;
            HuffmanNode HNode;

            T1 = heap.removeMin();
            T2 = heap.removeMin();
            System.out.println("T1 = "+T1);
            System.out.println("T2 = "+T2);
            HNode = new HuffmanNode(T1.element().getFrequence() + T2.element().getFrequence());
            BNode = new BinaryNode<HuffmanNode>(HNode, null, T1, T2);

            heap.add(BNode);
            System.out.println("Etat du heap = "+heap.size());
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
