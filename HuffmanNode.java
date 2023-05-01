public class HuffmanNode extends HuffmanTree {
  /* Sub arvores que funcionarão como nós */
  public HuffmanTree left;
  public HuffmanTree right;

  /* Construtor de nós para a arvore */
  public HuffmanNode(HuffmanTree left, HuffmanTree right) {
    super(left.frequency + right.frequency);
    this.left = left;
    this.right = right;
  }
}
