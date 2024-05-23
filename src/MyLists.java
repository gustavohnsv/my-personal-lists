public interface MyLists<T extends Node> {

    /** Metodo que verifica se uma lista esta vazia
     *
     * @return boolean
     */
    boolean isEmpty();

    /** Metodo que adiciona um novo no para a lista
     *
     * @param key Double
     */
    void addNode(double key);

    /** Metodo que remove um no existente da lista
     *
     * @param key Double
     */
    void removeNode(double key);

    /** Metodo que edita um no existente da lista
     *
     * @param oldKey Double
     * @param newKey Double
     */
    void modifyNode(double oldKey, double newKey);

    /** Metodo que procura por um no na lista, dada a chave passada como parametro
     *
     * @param key Double
     * @return Node
     */
    Node findNode(double key);

    /** Metodo que exibe todos os nos da lista
     *
     */
    void printNodes();

    /** Metodo que exibe as informacoes de um no da lista
     *
     * @param key Chave do no que sera exibido
     */
    void printNode(double key);

    /** Metodo que verifica se existe um no com uma chave passada como parametro
     *
     * @param key Chave do no que sera procurado
     * @return boolean
     */
    boolean containsNode(double key);
}
