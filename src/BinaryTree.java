/**
 * @author Gustavo Henriques Vieira
 * @version 1.0
 */
import org.jetbrains.annotations.NotNull;
public class BinaryTree extends Node implements MyLists<BinaryTree> {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    /** Metodo que retorna o no com maior chave da subarvore a partir de um no fornecido
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

    /** Metodo que retorna o no com menor chave da subarvore a partir de um no fornecido
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

    /** Metodo que retorna o valor da altura da subarvore a partir de um no fornecido
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

    /** Classe para guardar um no e sua direcao segundo aplicacoes
     *
     */
    private static class ParentDirection {
        Node parent;
        boolean isLeftChild;
        ParentDirection(Node parent, boolean isLeftChild) {
            this.parent = parent;
            this.isLeftChild = isLeftChild;
        }
    }

    /** Metodo que procura pelo pai e qual direcao ele pertence a partir de uma chave
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
                child =  child.getNext();
                isLeftChild = false;
            } else {
                child = child.getPrevious();
                isLeftChild = true;
            }
        }
        return null;
    }

    /** Metodo que verifica se a arvore binaria de busca esta vazia, se estiver, retorna true, se nao estiver, retorna false
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /** Metodo que cria um novo no com o valor passado como chave
     *
     * @param key Valor passado como chave
     * @return Node
     */
    private @NotNull Node createNode(double key) {
        Node response = new Node();
        response.setKey(key);
        return response;
    }

    /** Metodo que cria um novo no e acrescenta ele a arvore, mantendo as propriedades de uma arvore binaria de busca
     *
     * @param key Chave da insercao
     */
    @Override
    public void addNode(double key) {
        if (this.isEmpty()) {
            this.setKey(key);
            root = this;
        } else {
            Node aux = this;
            while (true) {
                if (key < aux.getKey()) {
                    if (aux.getPrevious() == null) {
                        Node newNode = new Node();
                        newNode.setKey(key);
                        aux.setPrevious(newNode);
                        break;
                    } else {
                        aux = aux.getPrevious();
                    }
                } else {
                    if (aux.getNext() == null) {
                        Node newNode = createNode(key);
                        aux.setNext(newNode);
                        break;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
        }
    }

    /** Metodo que remove um no da arvore, mantendo as propriedades de uma arvore binaria de busca
     *
     * @param key Chave para a exclusao
     */
    @Override
    public void removeNode(double key) {
        if (this.isEmpty()) {
            return;
        }

        Node nodeToRemove = findNode(key);
        if (nodeToRemove == null) {
            return;
        }

        ParentDirection aux = findFatherAndDirection(key);
        Node father = aux != null ? aux.parent : null;
        boolean isLeftChild = aux != null && aux.isLeftChild;

        // Case 1: leaf node
        if (!nodeToRemove.hasPrevious() && !nodeToRemove.hasNext()) {
            if (nodeToRemove == root) {
                root = null;
            } else if (isLeftChild) {
                father.setPrevious(null);
            } else {
                assert father != null;
                father.setNext(null);
            }
        }

        // Case 2: only one child
        else if (nodeToRemove.hasPrevious() && !nodeToRemove.hasNext()) {
            if (nodeToRemove == root) {
                root = nodeToRemove.getNext();
            } else if (isLeftChild) {
                father.setPrevious(nodeToRemove.getNext());
            } else {
                assert father != null;
                father.setNext(nodeToRemove.getNext());
            }
        } else if (!nodeToRemove.hasPrevious() && nodeToRemove.hasNext()) {
            if (nodeToRemove == root) {
                root = nodeToRemove.getPrevious();
            } else if (isLeftChild) {
                father.setPrevious(nodeToRemove.getPrevious());
            } else {
                assert father != null;
                father.setNext(nodeToRemove.getNext());
            }
        }

        // Case 3: have both children
        else {
            Node child = minNode(nodeToRemove.getNext());
            double childKey = child.getKey();
            removeNode(childKey);
            nodeToRemove.setKey(childKey);
        }
    }

    /** Metodo que modifica um no existente da arvore, dada a chave passdada como parametro e
     * muda seu valor para uma nova chave
     *
     * @param oldKey double
     * @param newKey double
     */
    @Override
    public void modifyNode(double oldKey, double newKey) {
        //   Node aux = findNode(oldKey); Caso queira aproveitar algo como registro, etc
        removeNode(oldKey);
        addNode(newKey);
    }

    /** Metodo que procura por um no na arvore, dada a chave passada como parametro
     *
     * @param key Chave para a busca
     * @return Node
     */
    @Override
    public Node findNode(double key) {
        Node aux = root ;
        while (aux != null) {
            if (aux.getKey() == key) {
                return aux;
            }
            if (aux.getKey() < key) {
                aux =  aux.getNext();
            } else {
                aux = aux.getPrevious();
            }
        }
        return null;
    }

    /** Metodo que exibe a arvore de busca binaria
     *
     */
    @Override
    public void printNodes() {
        printNodes(root);
    }

    /** Metodo que exibe a arvore de busca binaria, a partir de um no fornecido
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

    /** Metodo que exibe as informacoes de um no especifico, dada uma chave fornecida como parametro
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
        System.out.printf("Chave: %.2f / Possui proximo? %b%n", aux.getKey(), aux.hasNext());
    }

    @Override
    public boolean containsNode(double key) {
        Node aux = findNode(key);
        return aux != null;
    }

}
