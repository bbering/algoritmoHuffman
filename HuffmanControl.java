import java.util.PriorityQueue;

public class HuffmanControl {
  public HuffmanTree buildHuffmanTree(int[] freqCounter) {
    /*
     * Antes de tudo, é necessária uma fila de prioridade que ordenará as
     * frequencias de cada simbolo
     */
    PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();

    /* Criando as folhas da árvore de Huffman para cada simbolo */
    for (int i = 0; i < freqCounter.length; i++) {
      if (freqCounter[i] != 0) {
        /*
         * Para cada ciclo do for é adicionado uma folha a fila que possuirá o valor em
         * caractere do simbolo (na linha (char)i) e a sua frequencia numerica
         */
        trees.offer(new HuffmanLeaf((char) i, freqCounter[i]));
      }
    }
    while (trees.size() > 1) {
      /*
       * Serão criadas as arvores da esquerda e direita, na esquerda a de maior
       * frequencia pois o poll retira o primeiro elemento da fila de prioridade
       * e na direita a de menor frequencia, e assim segue enquanto houver elementos
       * na fila
       */
      HuffmanTree higherFreq = trees.poll();
      HuffmanTree lowerFreq = trees.poll();
      trees.offer(new HuffmanNode(higherFreq, lowerFreq));
    }
    /*
     * Quando não houverem mais elementos na fila, retornará a raiz principal que
     * representa todas as frequencias somadas
     */
    return trees.poll();
  }

  /* Metodo que converte uma string de texto para codigo binario */
  public String textToBinary(HuffmanTree tree, String text) {
    // Caso a arvore recebida como parâmetro exista
    if (tree != null) {
      String binaryText = "";
      for (char c : text.toCharArray()) {
        binaryText = binaryText + (getBinary(tree, new StringBuffer(), c));
      }
      return binaryText;
    }
    return null;
  }

  public static String getBinary(HuffmanTree tree, StringBuffer previous, char c) {
    if (tree != null) {
      /* Verifica se a arvore passada como argumento é uma instância de uma folha */
      if (tree instanceof HuffmanLeaf) {
        HuffmanLeaf leaf = (HuffmanLeaf) tree;

        /*
         * Caso o simbolo encontrado na folha for igual ao caractere c recebido como
         * parametro, retornará o proprio prefixo (StringBuffer)
         */
        if (leaf.symbol == c) {
          return previous.toString();
        }

        /*
         * Caso a arvore seja a instância de um nó ao invés de um laço, o algoritmo terá
         * de percorrer a árvore
         */
      } else if (tree instanceof HuffmanNode) {
        HuffmanNode node = (HuffmanNode) tree;

        /*
         * Percorre a arvore a esquerda, em direção à maior frequencia atribuindo 0 como
         * valor prefixo
         */
        previous.append('0');
        String leftValue = getBinary(node.left, previous, c);
        previous.deleteCharAt(previous.length() - 1);

        /*
         * Percorre a arvore a direita, em direção a menor frequencia atribuindo 1 como
         * valor prefixo
         */
        previous.append('1');
        String rightValue = getBinary(node.right, previous, c);
        previous.deleteCharAt(previous.length() - 1);

        if (leftValue == null) {
          return rightValue;
        } else {
          return leftValue;
        }
      }
    }
    return null;
  }

  public static void printBinary(HuffmanTree tree, StringBuffer previous) {
    if (tree != null)
      if (tree instanceof HuffmanLeaf) {
        HuffmanLeaf leaf = (HuffmanLeaf) tree;
        System.out.println(
            "Caractere: " + "[" + leaf.symbol + "]" + " Frequencia: " + "[" + leaf.frequency + "]" + " Binario: " + "["
                + previous + "]");
      } else if (tree instanceof HuffmanNode) {
        HuffmanNode node = (HuffmanNode) tree;
        // Esquerda
        previous.append('0');
        printBinary(node.left, previous);
        previous.deleteCharAt(previous.length() - 1);

        // Direita
        previous.append('1');
        printBinary(node.right, previous);
        previous.deleteCharAt(previous.length() - 1);
      }
  }

  public String binaryToText(HuffmanTree tree, String text) {
    // Caso a arvore recebida como parâmetro exista
    if (tree != null) {
      String charText = "";
      HuffmanNode node = (HuffmanNode) tree;
      for (char c : text.toCharArray()) {
        // Caso seja igual a 0, é no lado esquerdo
        if (c == '0') {
          if (node.left instanceof HuffmanLeaf) {
            charText = charText + ((HuffmanLeaf) node.left).symbol; // A string de texto recebe o simbolo da folha da esquerda
            node = (HuffmanNode) tree;
            // O nó agora volta a ser a raíz, o nó que equivale a soma de todos os outros nós
          } else {
            /*
             * Caso o nó não seja uma instância de uma folha, continuará percorrendo o lado
             * esquerdo
             */
            node = (HuffmanNode) node.left;
          }
        } else if (c == '1') {
          if (node.right instanceof HuffmanLeaf) {
            charText = charText + ((HuffmanLeaf) node.right).symbol; // A string de texto recebe o simbolo da folha da direita
            node = (HuffmanNode) tree;
            // O nó agora volta a ser a raíz, o nó que equivale a soma de todos os outros nós
          } else{
            /*
             * Caso o nó não seja uma instância de uma folha, continuará percorrendo o lado
             * direito
             */
            node = (HuffmanNode) node.right;
          }
        }
      }
      return charText;
    }
    return null;
  }

}
