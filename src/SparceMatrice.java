/**
 * @author Gustavo Henriques Vieira
 * @version 2.1.0
 */

import org.jetbrains.annotations.NotNull;

public class SparceMatrice extends NodeXY implements MyMatrices<SparceMatrice> {

    private NodeXY root;

    /**
     * Metodo que verifica se a matriz esta vazia
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
    private @NotNull NodeXY createNode(double key) {
        NodeXY response = new NodeXY();
        response.setKey(key);
        return response;
    }

    /**
     * Metodo que cria um novo no e acrescenta ele para a matriz, conforme as coordenadas
     *
     * @param key Chave do no que sera inserido
     * @param x   Coordenada X do no que sera inserido
     * @param y   Coordenada Y do no que sera inserido
     * @return boolean
     */
    @Override
    public boolean setCoordinatedNode(double key, int x, int y) {
        NodeXY newNode = createNode(key);
        newNode.setCoordinateX(x);
        newNode.setCoordinateY(y);
        if (this.isEmpty()) {
            root = newNode;
            return true;
        }
        NodeXY aux = root;
        NodeXY previous = null;
        while (aux != null && (aux.getCoordinateX() < x || (aux.getCoordinateX() == x && aux.getCoordinateY() < y))) {
            previous = aux;
            aux = aux.getNext();
        }
        if (previous == null) {
            newNode.setNext(root);
            root = newNode;
        } else {
            newNode.setNext(aux);
            previous.setNext(newNode);
        }
        return true;
    }

    /**
     * Metodo que remove um no da matriz, mantendo as propriedades de uma arvore binaria de busca
     *
     * @param key Chave para a exclusao
     * @return boolean
     */
    @Override
    public boolean removeNode(double key) {
        if (this.isEmpty()) {
            return false;
        }
        NodeXY aux = root;
        NodeXY previous = null;
        while (aux != null && aux.getKey() != key) {
            previous = aux;
            aux = aux.getNext();
        }
        if (aux == null) {
            return false;
        }
        if (aux == root) {
            root = aux.getNext();
        } else {
            previous.setNext(aux.getNext());
        }

        aux.setNext(null);
        aux.setCoordinateX(Integer.MIN_VALUE);
        aux.setCoordinateY(Integer.MIN_VALUE);

        return true;
    }

    /**
     * Metodo que modifica um no existente da matriz, dada a chave passdada como parametro e
     * muda seu valor para uma nova chave
     *
     * @param oldKey Valor da chave antiga
     * @param newKey Valor da chave nova
     * @return boolean
     */
    @Override
    public boolean modifyNode(double oldKey, double newKey) {
        //   NodeXY aux = findNode(oldKey); Caso queira aproveitar algo como registro, etc
        NodeXY aux = findNode(oldKey);
        return removeNode(oldKey) && setCoordinatedNode(newKey, aux.getCoordinateX(), aux.getCoordinateY());
    }

    /**
     * Metodo que procura por um no na matriz, dada a chave passada como parametro
     *
     * @param key Chave para a busca
     * @return Node
     */
    @Override
    public NodeXY findNode(double key) {
        NodeXY aux = root;
        while (aux != null) {
            if (aux.getKey() == key) {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    /**
     * Metodo que exibe a matriz
     */
    @Override
    public void printNodes() {
        NodeXY aux = root;
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
        NodeXY aux = findNode(key);
        if (aux == null) {
            System.out.println("No nao existe!");
            return;
        }
        System.out.printf("Chave: %.2f / Coordenada X: %d / Coordenada Y: %d / Possui proximo? %b%n",
                aux.getKey(), aux.getCoordinateX(), aux.getCoordinateY(), aux.hasNext());
    }

    /**
     * Metodo que verifica se um no com uma chave presente na matriz existe
     *
     * @param key Chave do no que sera procurado
     * @return boolean
     */
    @Override
    public boolean containsNode(double key) {
        NodeXY aux = findNode(key);
        return aux != null;
    }

    /**
     * Metodo que anexa novo nos para a sublista dentro de um intervalo especifico
     *
     * @param node         No iterador de cada funcao
     * @param response     No raiz que sera retornado
     * @param coordinatesX Arranjo de posicoes limitantes [x, X]
     * @param coordinatesY Arranjo de posicoes limitantes [y, Y]
     */
    private void generateSublist(NodeXY node, SparceMatrice response, int[] coordinatesX, int[] coordinatesY) {
        while (node != null) {
            if (node.getCoordinateX() >= coordinatesX[0] && node.getCoordinateY() >= coordinatesY[0] &&
                    node.getCoordinateX() < coordinatesX[1] && node.getCoordinateY() < coordinatesY[1]) {
                response.setCoordinatedNode(node.getKey(), node.getCoordinateX(), node.getCoordinateY());
            }
            node = node.getNext();
        }
    }

    /**
     * Metodo que retorna uma nova matriz a partir de uma sublista dentro de um intervalo
     * especifico
     *
     * @param fromX Valor em que comeca a lista
     * @param toX   Valor em que a lista acaba (toIndex - 1)
     * @param fromY Valor em que comeca a lista
     * @param toY   Valor em que a lista acaba (toIndex - 1)
     * @return SparceMatrice
     */
    @Override
    public SparceMatrice subList(int fromX, int toX, int fromY, int toY) {
        SparceMatrice response = new SparceMatrice();
        int[] coordinatesX = {fromX, toX};
        int[] coordinatesY = {fromY, toY};
        generateSublist(root, response, coordinatesX, coordinatesY);
        return response;
    }

    /**
     * Metodo que exibe a maior chave a partir de uma matriz
     *
     * @param sparceMatrice Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMax(SparceMatrice sparceMatrice) {
        if (sparceMatrice.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            NodeXY aux = sparceMatrice.root;
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
     * Metodo que exibe a menor chave a partir de uma matriz
     *
     * @param sparceMatrice Tipo da lista utilizada
     * @return double
     */
    @Override
    public double findMin(SparceMatrice sparceMatrice) {
        if (sparceMatrice.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            NodeXY aux = sparceMatrice.root;
            double response = Integer.MAX_VALUE;
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
