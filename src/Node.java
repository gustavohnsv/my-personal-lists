/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

public class Node {

    private double key;
    private Node next;
    private Node previous;

    /**
     * Metodo para definir um valor para a chave
     *
     * @param key Valor para ser definido como chave
     */
    public void setKey(double key) {
        this.key = key;
    }

    /**
     * Metodo para definir um no anterior ao atual
     *
     * @param previous No para ser definido como anterior do no atual
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    /**
     * Metodo para definir um no sucessor ao atual
     *
     * @param next No para ser definido como sucessor do no atual
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Metodo para obter o valor da chave do no
     *
     * @return double
     */
    public double getKey() {
        return key;
    }

    /**
     * Metodo para obter o no sucessor
     *
     * @return Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Metodo para obter o no anterior
     *
     * @return Node
     */
    public Node getPrevious() {
        return previous;
    }

    /**
     * Metodo que verifica se o no atual possui um no sucessor
     *
     * @return boolean
     */
    public boolean hasNext() {
        return getNext() != null;
    }

    /**
     * Metodo que verifica se o no atual possui um no anterior
     *
     * @return boolean
     */
    public boolean hasPrevious() {
        return getPrevious() != null;
    }

}
