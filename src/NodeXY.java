/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

public class NodeXY {

    private double key;
    private int coordinateX;
    private int coordinateY;
    private NodeXY next;
    private NodeXY previous;

    /**
     * Metodo para definir um valor para a chave
     *
     * @param key Valor para ser definido como chave
     */
    public void setKey(double key) {
        this.key = key;
    }

    /**
     * Metodo para definir a posicao do no com base na coordenada X
     *
     * @param coordinateX Valor para ser definido como posicao X
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * Metodo para definir a posicao do no com base na coordenada Y
     *
     * @param coordinateY Valor para ser definido como posicao Y
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * Metodo para definir um no sucessor ao atual
     *
     * @param next No para ser definido como sucessor do no atual
     */
    public void setNext(NodeXY next) {
        this.next = next;
    }

    /**
     * Metodo para definir um no anterior ao atual
     *
     * @param previous No para ser definido como anterior do no atual
     */
    public void setPrevious(NodeXY previous) {
        this.previous = previous;
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
     * Metodo para obter o valor da coordenada X do no
     *
     * @return int
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * Metodo para obter o valor da coordenada Y do no
     *
     * @return int
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * Metodo para obter o no sucessor
     *
     * @return Node
     */
    public NodeXY getNext() {
        return next;
    }

    /**
     * Metodo para obter o no anterior
     *
     * @return Node
     */
    public NodeXY getPrevious() {
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
