
// Aluno : Breno Bering Silva
import java.util.Scanner;

public class HuffmanApp {
  public static void main(String[] args) {
    // Instanciando o controlador do algoritmo de Huffman
    HuffmanControl control = new HuffmanControl();
    Scanner scan = new Scanner(System.in);
    String text;
    System.out.println("Forneça uma palavra para ser comprimida");
    text = scan.next();
    int arraySize = 300;

    /* Momento de criar a árvore de Huffman */
    HuffmanTree tree = control.buildHuffmanTree(control.fillFreq(arraySize, text));
    control.buildHuffmanTree(control.fillFreq(arraySize, text));

    /* Metodo que codificará a palavra */
    System.out.println("Texto codificado: ");
    System.out.println(control.textToBinary(tree, text));
    System.out.println("Numero de caracteres: " + control.getCharCounter());

    /*
     * Printando as refêrencias usadas para codificar o texto usando o código de
     * Huffman
     */
    System.out.println("Tabela de referencia: ");
    control.printBinary(tree, new StringBuffer());

    /* Decodificando a palavra */
    System.out.println("Palavra decodificada: ");
    System.out.println(control.binaryToText(tree, control.textToBinary(tree, text)));
  }
}
