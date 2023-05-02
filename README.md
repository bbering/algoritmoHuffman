# Algoritmo de Huffman
Algoritmo de Huffman implementado na linguagem Java, proposto pela disciplina Algoritmos e Estrutura de Dados (AED), cursada na Universidade Estadual do Sudoeste da Bahia (UESB).

## Sobre o algoritmo
![Explicação](https://github.com/bbering/algoritmoHuffman/blob/main/useful/huffmanTree.png)

O algoritmo funciona utilizando conceitos da árvore binária, uma estrutura de dados semelhante. No algoritmo de Huffman, são feitos 3 passos: A criação de um vetor de frequências, que armazenará a ocorrência de um dado símbolo i (letra, por exemplo) em uma palavra. 2- A ordenação das frequências e dos seus simbolos, utilizando uma fila de prioridade. 3- Codificar ou decodificar os textos.

Os nós possuem valores que são, na verdade, a soma das suas folhas (ou ramos). O nó raíz, por exemplo, possui 100 como valor pois é a soma de todos os outros nós em porcentagem (n1 + n2 + n3 + nx = 1 = 100%).

# Como executar o programa
## Pré-Requisito: Java Development Kit instalado

```
Clonar repositorio
git clone git@github.com:bbering/algoritmoHuffman.git

Executar na pasta raiz do programa (onde se encontra o .java HuffmanApp) o seguinte comando:

javac HuffmanApp.java (Compila o projeto)

java HuffmanApp (Executa o projeto)

E pronto! O projeto foi executado.

```
