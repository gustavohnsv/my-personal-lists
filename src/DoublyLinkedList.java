/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

import org.jetbrains.annotations.NotNull;

public class DoublyLinkedList extends Node implements MyLists<DoublyLinkedList> {

    private Node root;

    public DoublyLinkedList() {
        root = null;
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
     * Metodo que cria um novo no com o valor passdado como chave
     *
     * @param key Valor da chave para a procura do no
     * @return Node
     */
    private @NotNull Node createNode(double key) {
        Node response = new Node();
        response.setKey(key);
        return response;
    }

    /**
     * Metodo que adiciona um no na lista em ordem crescente
     *
     * @param key Valor passado como chave
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
            while (aux.getNext() != null && aux.getNext().getKey() < key) {
                aux = aux.getNext();
            }
            if (aux == root) {
                if (aux.getKey() > key) {
                    aux.setPrevious(newNode);
                    newNode.setNext(aux);
                    root = newNode;
                    root.setKey(key);
                } else {
                    aux.setNext(newNode);
                    newNode.setPrevious(aux);
                }
                return true;
            } else if (!aux.hasNext()) {
                aux.setNext(newNode);
                newNode.setPrevious(aux);
                return true;
            } else {
                Node node = aux.getNext();
                newNode.setNext(node);
                newNode.setPrevious(aux);
                aux.setNext(newNode);
                node.setPrevious(newNode);
                return true;
            }
        }
    }

    /**
     * Metodo que remove um no da lista mantendo a ordem crescente
     *
     * @param key Double
     * @return boolean
     */
    @Override
    public boolean removeNode(double key) {
        Node aux = findNode(key);
        if (aux == root) {
            if (aux.hasNext()) {
                aux.getNext().setPrevious(null);
            }
            root = aux.getNext();
            aux.setNext(null);
            return true;
        } else if (!aux.hasNext()) {
            aux.getPrevious().setNext(null);
            aux.setPrevious(null);
            return true;
        } else {
            aux.getPrevious().setNext(aux.getNext());
            aux.getNext().setPrevious(aux.getPrevious());
            aux.setNext(null);
            aux.setPrevious(null);
            return true;
        }
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
        // Node aux = findNode(oldKey);
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
     * Metodo que exibe os nos da lista
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
     * Metodo que exibe as informacoes de um no da lista
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

    private void generateDoublyLinkedList(Node node, DoublyLinkedList response,
                                          double fromIndex, double toIndex) {
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
     * Metodo que retorna uma nova lista duplamente ligada para uma sublista
     * dentro de um intervalo especifico
     *
     * @param fromIndex Valor em que comeca a lista
     * @param toIndex   Valor em que a lista acaba (toIndex - 1)
     * @return DoublyLinkedList
     */
    @Override
    public DoublyLinkedList subList(double fromIndex, double toIndex) {
        DoublyLinkedList response = new DoublyLinkedList();
        generateDoublyLinkedList(root, response, fromIndex, toIndex);
        return response;
    }

    /**
     * Metodo que exibe a maior chave a partir de uma lista duplamente ligada
     *
     * @param doublyLinkedList Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMax(DoublyLinkedList doublyLinkedList) {
        if (doublyLinkedList.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            Node aux = doublyLinkedList;
            while (aux.hasNext()) {
                aux = aux.getNext();
            }
            return aux.getKey();
        }
    }

    /**
     * Metodo que exibe a menor chave a partir de uma lista duplamente ligada
     *
     * @param doublyLinkedList Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMin(DoublyLinkedList doublyLinkedList) {
        if (doublyLinkedList.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return root.getKey();
        }
    }
}
