public class HuffmanLeaf extends HuffmanTree{
    public final char symbol;

    /* Folhas da árvore (fins dos nós) */
    public HuffmanLeaf (char symbol, int frequency){
        super(frequency);
        this.symbol = symbol;
    }
}