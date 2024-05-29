/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

public interface MyMatrices<T extends NodeXY> {
    /**
     * Metodo que verifica se uma matriz esta vazia
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Metodo que adiciona um novo no na matriz
     *
     * @param key Chave do no que sera inserido
     * @param x   Coordenada X do no que sera inserido
     * @param y   Coordenada Y do no que sera inserido
     * @return boolean
     */
    boolean setCoordinatedNode(double key, int x, int y);

    /**
     * Metodo que remove um no existente da matriz
     *
     * @param key Chave do no que sera deletado
     */
    boolean removeNode(double key);

    /**
     * Metodo que edita um no existente da matriz
     *
     * @param oldKey Antiga chave do no
     * @param newKey Nova chave do no
     */
    boolean modifyNode(double oldKey, double newKey);

    /**
     * Metodo que procura por um no na matriz, dada a chave passada como parametro
     *
     * @param key Chave do no que sera procurado
     * @return T
     */
    NodeXY findNode(double key);

    /**
     * Metodo que exibe todos os nos da matriz
     */
    void printNodes();

    /**
     * Metodo que exibe as informacoes de um no da matriz
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
     * Metodo que cria uma sub-lista a partir de quatro indices com intervalos [(x, y), (x, y))
     *
     * @param fromX Valor em que comeca a lista
     * @param toX   Valor em que a lista acaba (toIndex - 1)
     * @param fromY Valor em que comeca a lista
     * @param toY   Valor em que a lista acaba (toIndex - 1)
     * @return NodeXY
     */
    NodeXY subList(int fromX, int toX, int fromY, int toY);

    /**
     * Metodo que retorna o valor da maior chave da matriz
     *
     * @param t Tipo da lista utilizada
     * @return double
     */
    double findMax(T t);

    /**
     * Metodo que retorna o valor da menor chave da matriz
     *
     * @param t Tipo da lista utilizada
     * @return double
     */
    double findMin(T t);
}
