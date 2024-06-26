/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

import org.jetbrains.annotations.NotNull;

public class LinkedList extends Node implements MyLists<LinkedList> {

    private Node root;

    public LinkedList() {
        this.root = null;
    }

    /**
     * Metodo que verifica se a lista esta vazia
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
    private @NotNull Node createNode(double key) {
        Node response = new Node();
        response.setKey(key);
        return response;
    }

    /**
     * Metodo que cria um novo no na lista, mantendo a ordem crescente das chaves
     *
     * @param key Chave da insercao
     * @return boolean
     */
    @Override
    public boolean addNode(double key) {
        Node newNode = createNode(key);
        if (this.isEmpty()) {
            this.setKey(key);
            root = this;
            return true;
        } else {
            Node aux = root;
            Node previous = null;
            while (aux != null && aux.getKey() < key) {
                previous = aux;
                aux = aux.getNext();
            }
            if (previous == null) {
                newNode.setNext(root);
                root = newNode;
                return true;
            } else if (aux == null) {
                previous.setNext(newNode);
                return true;
            } else {
                previous.setNext(newNode);
                newNode.setNext(aux);
                return true;
            }
        }
    }

    /**
     * Metodo que remove um no da lista, mantendo a ordem crescente das chaves
     *
     * @param key Chave para a exclusao
     * @return boolean
     */
    @Override
    public boolean removeNode(double key) {
        Node aux = root;
        Node previous = aux;
        while (aux != null && aux.getKey() < key) {
            previous = aux;
            aux = aux.getNext();
        }
        if (aux == null) {
            return false;
        } else if (aux == root) {
            root = aux.getNext();
            aux.setNext(null);
        } else {
            previous.setNext(aux.getNext());
            aux.setNext(null);
        }
        return true;
    }

    /**
     * Metodo que modifica um no existente da lista, dada a chave passdada como parametro e
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
     * Metodo que procura por um no na lista, dada a chave passada como parametro
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
            aux = aux.getNext();
        }
        return null;
    }

    /**
     * Metodo que exibe a lista
     */
    @Override
    public void printNodes() {
        Node aux = root;
        while (aux != null) {
            System.out.print(aux.getKey() + " ");
            aux = aux.getNext();
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
        System.out.printf("Chave: %.2f / Possui proximo? %b%n", aux.getKey(), aux.hasNext());
    }

    /**
     * Metodo que verifica se um no com uma chave presente na lista existe
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
    private void generateLinkedList(Node node, LinkedList response, double fromIndex, double toIndex) {
        while (node != null) {
            if (node.getKey() >= fromIndex && node.getKey() < toIndex) {
                response.addNode(node.getKey());
            } else {
                return;
            }
            node = node.getNext();
        }
    }

    /**
     * Metodo que retorna uma nova lista a partir de uma sublista dentro de um intervalo especifico
     *
     * @param fromIndex Valor em que comeca a lista
     * @param toIndex   Valor em que a lista acaba (toIndex - 1)
     * @return BinaryTree
     */
    @Override
    public LinkedList subList(double fromIndex, double toIndex) {
        LinkedList response = new LinkedList();
        generateLinkedList(root, response, fromIndex, toIndex);
        return response;
    }

    /**
     * Metodo que exibe a maior chave a partir de uma lista
     *
     * @param linkedList Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMax(LinkedList linkedList) {
        Node aux = linkedList;
        while (aux.hasNext()) {
            aux = aux.getNext();
        }
        return aux.getKey();
    }

    /**
     * Metodo que exibe a menor chave a partir de uma lista
     *
     * @param linkedList Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMin(LinkedList linkedList) {
        return linkedList.root.getKey();
    }

}
