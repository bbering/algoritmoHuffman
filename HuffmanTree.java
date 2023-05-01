abstract class HuffmanTree implements Comparable<HuffmanTree> {

  public final int frequency;

  /*
   * Construtor da classe abstrata de arvore, todas as subclasses precisarão
   * implementar as suas frequencias pois herdam de HuffmanTree
   */
  public HuffmanTree(int freq) {
    frequency = freq;
  }

  /* Metodo obrigatório de ser sobrescrito */
  public int compareTo(HuffmanTree tree) {
    return frequency - tree.frequency;
  }
}
