public class HuffmanLeaf extends HuffmanTree{
    public final char symbol;

    public HuffmanLeaf (char symbol, int frequency){
        super(frequency);
        this.symbol = symbol;
    }
}
