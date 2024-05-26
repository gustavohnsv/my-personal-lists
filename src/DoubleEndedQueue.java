/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

import org.jetbrains.annotations.NotNull;

public class DoubleEndedQueue extends Node implements MyLists<DoubleEndedQueue> {

    private Node firstRoot;
    private Node secondRoot;

    /**
     * Metodo que verifica se o deque esta vazio
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return firstRoot == null;
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
     * Metodo que cria um novo no e acrescenta ele a fila, mantendo as propriedades de um deque
     *
     * @param key Chave da insercao
     * @return boolean
     */
    public boolean addNode(double key) {
        Node newNode = createNode(key);
        if (isEmpty()) {
            this.setKey(key);
            firstRoot = newNode;
            secondRoot = newNode;
        } else {
            this.setNext(newNode);
            newNode.setNext(firstRoot);
            firstRoot.setPrevious(newNode);
            firstRoot = newNode;
            Node aux = firstRoot;
            while (aux.hasNext()) {
                aux = aux.getNext();
            }
            secondRoot = aux;
        }
        return true;
    }

    /**
     * Metodo que remove um no da fila, mantendo as propriedades de um deque
     *
     * @param key Chave para a exclusao
     * @return boolean
     */
    public boolean removeNode(double key) {
        Node aux = findNode(key);
        if (aux == null) {
            return false;
        }
        if (aux == firstRoot) {
            if (aux.getNext() == null) {
                firstRoot = null;
                secondRoot = null;
            } else {
                firstRoot = aux.getNext();
                firstRoot.setPrevious(null);
            }
        } else if (aux == secondRoot) {
            secondRoot = aux.getPrevious();
            secondRoot.setNext(null);
        } else {
            aux.getPrevious().setNext(aux.getNext());
            aux.getNext().setPrevious(aux.getPrevious());
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
        // Node aux = findNode(oldKey);
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
        Node firstAux = firstRoot;
        Node secondAux = secondRoot;
        do {
            if (firstAux != null && firstAux.getKey() == key) {
                return firstAux;
            } else if (secondAux != null && secondAux.getKey() == key) {
                return secondAux;
            }
            if (firstAux != null) {
                firstAux = firstAux.getNext();
            }
            if (secondAux != null) {
                secondAux = secondAux.getPrevious();
            }
        }
        while (firstAux != null && secondAux != null);
        return null;
    }

    /**
     * Metodo que exibe o deque
     */
    @Override
    public void printNodes() {
        Node aux = firstRoot;
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
        System.out.printf("Chave: %.2f / Possui proximo? %b / Possui anterior? %b%n", aux.getKey(), aux.hasNext(), aux.hasPrevious());
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
     * @param toIndex   Chave em que a sublista acabara (inclui ate toIndex - 1)
     */
    private void generateDEQueue(Node node, DoubleEndedQueue response,
                                 double fromIndex, double toIndex) {
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
     * @return DoubleEndedQueue
     */
    @Override
    public DoubleEndedQueue subList(double fromIndex, double toIndex) {
        DoubleEndedQueue response = new DoubleEndedQueue();
        generateDEQueue(firstRoot, response, fromIndex, toIndex);
        return response;
    }

    /**
     * Metodo que exibe a maior chave a partir de uma fila
     *
     * @param doubleEndedQueue Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMax(DoubleEndedQueue doubleEndedQueue) {
        if (doubleEndedQueue.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            Node aux = doubleEndedQueue;
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
     * @param doubleEndedQueue Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMin(DoubleEndedQueue doubleEndedQueue) {
        if (doubleEndedQueue.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            Node aux = doubleEndedQueue;
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
