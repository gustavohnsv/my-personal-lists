/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

import org.jetbrains.annotations.NotNull;

public class BinaryTree extends Node implements MyLists<BinaryTree> {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Metodo que retorna o no com maior chave da subarvore a partir de um no fornecido
     *
     * @param node Raiz da subarvore
     * @return Node
     */
    private Node maxNode(@NotNull Node node) {
        while (node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Metodo que retorna o no com menor chave da subarvore a partir de um no fornecido
     *
     * @param node Raiz da subarvore
     * @return Node
     */
    private Node minNode(@NotNull Node node) {
        while (node.hasPrevious()) {
            node = node.getPrevious();
        }
        return node;
    }

    /**
     * Metodo que retorna o valor da altura da subarvore a partir de um no fornecido
     *
     * @param node Raiz da subarvore
     * @return int
     */
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getPrevious()), height(node.getNext()));
    }

    /**
     * Classe para guardar um no e sua direcao segundo aplicacoes
     */
    private record ParentDirection(Node parent, boolean isLeftChild) {
    }

    /**
     * Metodo que procura pelo pai e qual direcao ele pertence a partir de uma chave
     *
     * @param key Valor da chave para a procura do no
     * @return ParentDirection
     */
    private ParentDirection findFatherAndDirection(double key) {
        Node father = null;
        Node child = root;
        boolean isLeftChild = false;
        while (child != null) {
            if (child.getKey() == key) {
                return new ParentDirection(father, isLeftChild);
            }
            father = child;
            if (child.getKey() < key) {
                child = child.getNext();
                isLeftChild = false;
            } else {
                child = child.getPrevious();
                isLeftChild = true;
            }
        }
        return null;
    }

    /**
     * Metodo que verifica se a arvore binaria de busca esta vazia
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Metodo que cria um novo no com o valor passado como chave
     *
     * @param key Valor passado como chave
     * @return Node
     */
    private @NotNull BinaryTree createNode(double key) {
        BinaryTree response = new BinaryTree();
        response.setKey(key);
        return response;
    }

    /**
     * Metodo que cria um novo no e acrescenta ele a arvore, mantendo as propriedades de uma arvore binaria de busca
     *
     * @param key Chave da insercao
     * @return boolean
     */
    @Override
    public boolean addNode(double key) {
        if (this.isEmpty()) {
            this.setKey(key);
            root = this;
            return true;
        } else {
            Node aux = this;
            Node newNode = createNode(key);
            while (true) {
                if (key < aux.getKey()) {
                    if (aux.getPrevious() == null) {
                        newNode.setKey(key);
                        aux.setPrevious(newNode);
                        return true;
                    } else {
                        aux = aux.getPrevious();
                    }
                } else {
                    if (aux.getNext() == null) {
                        aux.setNext(newNode);
                        return true;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
        }
    }

    /**
     * Metodo que remove um no da arvore, mantendo as propriedades de uma arvore binaria de busca
     *
     * @param key Chave para a exclusao
     * @return boolean
     */
    @Override
    public boolean removeNode(double key) {
        if (this.isEmpty()) {
            return false;
        }

        Node aux = findNode(key);
        if (aux == null) {
            return false;
        }

        ParentDirection parentDirection = findFatherAndDirection(key);
        Node father = parentDirection != null ? parentDirection.parent() : null;
        boolean isLeftChild = parentDirection != null && parentDirection.isLeftChild();

        // Case 1: leaf node
        if (!aux.hasPrevious() && !aux.hasNext()) {
            if (aux == root) {
                root = null;
                return true;
            } else if (isLeftChild) {
                father.setPrevious(null);
                return true;
            } else {
                assert father != null;
                father.setNext(null);
                return true;
            }
        }

        // Case 2: only one child
        else if (aux.hasPrevious() && !aux.hasNext()) {
            if (aux == root) {
                root = aux.getNext();
                return true;
            } else if (isLeftChild) {
                father.setPrevious(aux.getNext());
                return true;
            } else {
                assert father != null;
                father.setNext(aux.getNext());
                return true;
            }
        } else if (!aux.hasPrevious() && aux.hasNext()) {
            if (aux == root) {
                root = aux.getPrevious();
                return true;
            } else if (isLeftChild) {
                father.setPrevious(aux.getPrevious());
                return true;
            } else {
                assert father != null;
                father.setNext(aux.getNext());
                return true;
            }
        }

        // Case 3: have both children
        else {
            Node child = minNode(aux.getNext());
            double childKey = child.getKey();
            removeNode(childKey);
            aux.setKey(childKey);
            return true;
        }
    }

    /**
     * Metodo que modifica um no existente da arvore, dada a chave passdada como parametro e
     * muda seu valor para uma nova chave
     *
     * @param oldKey Valor da chave antiga
     * @param newKey Valor da chave nova
     * @return boolean
     */
    @Override
    public boolean modifyNode(double oldKey, double newKey) {
        //   Node aux = findNode(oldKey); Caso queira aproveitar algo como registro, etc
        return removeNode(oldKey) && addNode(newKey);
    }

    /**
     * Metodo que procura por um no na arvore, dada a chave passada como parametro
     *
     * @param key Chave para a busca
     * @return Node
     */
    @Override
    public Node findNode(double key) {
        Node aux = root;
        while (aux != null) {
            if (aux.getKey() == key) {
                return aux;
            }
            if (aux.getKey() < key) {
                aux = aux.getNext();
            } else {
                aux = aux.getPrevious();
            }
        }
        return null;
    }

    /**
     * Metodo que exibe a arvore de busca binaria
     */
    @Override
    public void printNodes() {
        printNodes(root);
    }

    /**
     * Metodo que exibe a arvore de busca binaria, a partir de um no fornecido
     *
     * @param node Raiz da subarvore
     */
    public void printNodes(Node node) {
        if (node != null) {
            printNodes(node.getPrevious());
            System.out.print(node.getKey() + " ");
            printNodes(node.getNext());
        }
    }

    /**
     * Metodo que exibe as informacoes de um no especifico, dada uma chave fornecida como parametro
     *
     * @param key Chave do no que sera exibido
     */
    @Override
    public void printNode(double key) {
        Node aux = findNode(key);
        if (aux == null) {
            System.out.println("No nao existe!");
            return;
        }
        System.out.printf("Chave: %.2f / Possui filho esquerdo? %b / Possui filho direito? %b%n", aux.getKey(), aux.hasPrevious(), aux.hasNext());
    }

    /**
     * Metodo que verifica se um no com uma chave presente na arvore existe
     *
     * @param key Chave do no que sera procurado
     * @return boolean
     */
    @Override
    public boolean containsNode(double key) {
        Node aux = findNode(key);
        return aux != null;
    }

    /**
     * Metodo que anexa novos nos para a sublista dentro de um intervalo especifico
     *
     * @param node      No iterador de cada funcao
     * @param response  No raiz que sera retornado
     * @param fromIndex Chave em que a sublista comecara
     * @param toIndex   Chave em que a sublista acabara (inclui ate toIndex - 1)
     */
    private void generateBinaryTree(Node node, BinaryTree response, double fromIndex, double toIndex) {
        if (node.hasPrevious()) {
            generateBinaryTree(node.getPrevious(), response, fromIndex, toIndex);
        }
        if (node.getKey() >= fromIndex && node.getKey() < toIndex) {
            response.addNode(node.getKey());
        } else {
            return;
        }
        if (node.hasNext()) {
            generateBinaryTree(node.getNext(), response, fromIndex, toIndex);
        }
    }

    /**
     * Metodo que retorna uma nova arvore de busca binaria a partir de uma sublista dentro de um intervalo especifico
     *
     * @param fromIndex Valor em que comeca a lista
     * @param toIndex   Valor em que a lista acaba (toIndex - 1)
     * @return BinaryTree
     */
    public BinaryTree subList(double fromIndex, double toIndex) {
        BinaryTree response = new BinaryTree();
        generateBinaryTree(root, response, fromIndex, toIndex);
        return response;
    }

    /**
     * Metodo que exibe a maior chave a partir de uma arvore binaria de busca
     *
     * @param binaryTree Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMax(BinaryTree binaryTree) {
        if (binaryTree.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            Node aux = binaryTree;
            while (aux.hasNext()) {
                aux = aux.getNext();
            }
            return aux.getKey();
        }
    }

    /**
     * Metodo que exibe a menor chave a partir de uma arvore binaria de busca
     *
     * @param binaryTree Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMin(BinaryTree binaryTree) {
        if (binaryTree.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            Node aux = binaryTree;
            while (aux.hasPrevious()) {
                aux = aux.getPrevious();
            }
            return aux.getKey();
        }
    }

}
