
// Aluno : Breno Bering Silva
import java.util.Scanner;

public class HuffmanApp {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String text;
    System.out.println("Forneça uma palavra para ser comprimida");
    text = scan.next();

    /*
     * Criado um array de elementos, com o tamanho maximo fixado em 300, ou seja,
     * a palavra pode possuir até 300 caracteres diferentes
     */
    int[] freqCounter = new int[300];

    /*
     * Percorre um dado texto e atribui a um vetor de frequencias a ocorrencia de
     * cada simbolo
     * Ex: a palavra "teste" possui 2 ocorrências do simbolo "t", que representa um
     * total de 2/5 da palavra
     */
    for (char c : text.toCharArray()) {
      freqCounter[c]++;
    }

    /* Momento de criar a árvore de Huffman */
  }
}
