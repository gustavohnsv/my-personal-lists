/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

import org.jetbrains.annotations.NotNull;

public class Queue extends Node implements MyLists<Queue> {

    private Node root;


    public Queue() {
        this.root = null;
    }

    /**
     * Metodo que verifica se a fila esta vazia
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
     * @param key Valor da chave para a procura do no
     * @return Node
     */
    private @NotNull Node createNode(double key) {
        Node response = new Node();
        response.setKey(key);
        return response;
    }

    /**
     * Metodo que adiciona um no ao inicio da fila
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
        } else {
            newNode.setNext(root);
            root = newNode;
        }
        return true;
    }

    /**
     * Metodo que remove um no da fila
     *
     * @param key Valor passado como chave
     * @return boolean
     */
    @Override
    public boolean removeNode(double key) {
        if (isEmpty()) {
            return false;
        }
        Node aux = findNode(key);
        Node previous = root;
        while (previous != null && previous.getNext() != aux) {
            previous = previous.getNext();
        }
        if (aux == null) {
            return false;
        }
        if (aux == root) {
            if (!aux.hasNext()) {
                root = null;
            } else {
                root = aux.getNext();
            }
        } else {
            if (!aux.hasNext()) {
                previous.setNext(null);
            } else {
                previous.setNext(aux.getNext());
            }
        }
        return true;
    }

    /**
     * Metodo que modifica um no existente da fila, dada a chave passdada como parametro e
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
     * Metodo que procura por um no na fila, dada a chave passada como parametro
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
     * Metodo que exibe os nos da fila
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
     * Metodo que exibe as informacoes de um no da fila
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
     * Metodo que verifica se um no com uma chave presente na fila existe
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
     * @param toIndex   Chave em que a sublista acabara (inclui ate toIndex-1)
     */
    private void generateQueue(Node node, Queue response, double fromIndex, double toIndex) {
        while (node != null) {
            if (node.getKey() >= fromIndex && node.getKey() < toIndex) {
                response.addNode(node.getKey());
            }
            node = node.getNext();
        }
    }

    /**
     * Metodo que retorna uma nova fila a partir de uma sublista dentro de um intervalo especifico
     *
     * @param fromIndex Valor em que comeca a lista
     * @param toIndex   Valor em que a lista acaba (toIndex - 1)
     * @return Queue
     */
    @Override
    public Queue subList(double fromIndex, double toIndex) {
        Queue response = new Queue();
        generateQueue(root, response, fromIndex, toIndex);
        return response;
    }

    /**
     * Metodo que exibe a maior chave a partir de uma fila
     *
     * @param queue Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMax(Queue queue) {
        if (queue.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            Node aux = queue;
            double response = Integer.MIN_VALUE;
            while (aux != null) {
                if (aux.getKey() > response) {
                    response = aux.getKey();
                }
                aux = aux.getNext();
            }
            return response;
        }
    }

    /**
     * Metodo que exibe a menor chave a partir de uma fila
     *
     * @param queue Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMin(Queue queue) {
        if (queue.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            Node aux = queue;
            double response = Integer.MIN_VALUE;
            while (aux != null) {
                if (aux.getKey() < response) {
                    response = aux.getKey();
                }
                aux = aux.getNext();
            }
            return response;
        }
    }
}
