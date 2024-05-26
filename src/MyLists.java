/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

public interface MyLists<T extends Node> {

    /**
     * Metodo que verifica se uma lista esta vazia
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Metodo que adiciona um novo no para a lista
     *
     * @param key Chave do no que sera inserido
     */
    boolean addNode(double key);

    /**
     * Metodo que remove um no existente da lista
     *
     * @param key Chave do no que sera deletado
     */
    boolean removeNode(double key);

    /**
     * Metodo que edita um no existente da lista
     *
     * @param oldKey Antiga chave do no
     * @param newKey Nova chave do no
     */
    boolean modifyNode(double oldKey, double newKey);

    /**
     * Metodo que procura por um no na lista, dada a chave passada como parametro
     *
     * @param key Chave do no que sera procurado
     * @return Node
     */
    Node findNode(double key);

    /**
     * Metodo que exibe todos os nos da lista
     */
    void printNodes();

    /**
     * Metodo que exibe as informacoes de um no da lista
     *
     * @param key Chave do no que sera exibido
     */
    void printNode(double key);

    /**
     * Metodo que verifica se existe um no com uma chave passada como parametro
     *
     * @param key Chave do no que sera procurado
     * @return boolean
     */
    boolean containsNode(double key);

    /**
     * Metodo que cria uma sub-lsita a partir de dois indices com intervalos [a, b)
     *
     * @param fromIndex Indice que a sublista
     * @param toIndex   Valor em que a lista acaba (toIndex - 1)
     * @return T
     */
    T subList(double fromIndex, double toIndex);

    /**
     * Metodo que retorna o valor da maior chave da lista
     *
     * @param t Tipo da lista utilizada
     * @return double
     */
    double findMax(T t);

    /**
     * Metodo que retorna o valor da menor chave da lista
     *
     * @param t Tipo da lista utilizada
     * @return double
     */
    double findMin(T t);
}
