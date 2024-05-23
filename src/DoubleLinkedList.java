import org.jetbrains.annotations.NotNull;

public class DoubleLinkedList extends Node implements MyLists<DoubleLinkedList>{

    private Node root;

    public DoubleLinkedList(){
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private @NotNull Node createNode(double key) {
        Node response = new Node();
        response.setKey(key);
        return response;
    }

    @Override
    public void addNode(double key) {
        Node newNode = createNode(key);
        if (this.isEmpty()) {
            this.setKey(key);
            root = this;
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
                } else {
                    aux.setNext(newNode);
                    newNode.setPrevious(aux);
                }
            } else if (!aux.hasNext()) {
                aux.setNext(newNode);
                newNode.setPrevious(aux);
            } else {
                Node node = aux.getNext();
                newNode.setNext(node);
                newNode.setPrevious(aux);
                aux.setNext(newNode);
                node.setPrevious(newNode);
            }
        }
    }

    @Override
    public void removeNode(double key) {
        Node aux = findNode(key);
        if (aux == root) {
            aux.getNext().setPrevious(null);
            root = aux.getNext();
            aux.setNext(null);
        } else if (!aux.hasNext()) {
            aux.getPrevious().setNext(null);
            aux.setPrevious(null);
        } else {
            aux.getPrevious().setNext(aux.getNext());
            aux.getNext().setPrevious(aux.getPrevious());
            aux.setNext(null);
            aux.setPrevious(null);
        }
    }

    @Override
    public void modifyNode(double oldKey, double newKey) {
        // Node aux = findNode(oldKey);
        removeNode(oldKey);
        addNode(newKey);
    }

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

    @Override
    public void printNodes() {
        Node aux = root;
        while (aux != null) {
            System.out.print(aux.getKey() + " ");
            aux = aux.getNext();
        }
    }

    @Override
    public void printNode(double key) {
        Node aux = findNode(key);
        if (aux == null) {
            System.out.println("No nao existe!");
            return;
        }
        System.out.printf("Chave: " + aux.getKey() + " / Possui proximo? " + aux.hasNext() + " / Possui anterior? " + aux.hasPrevious());
    }

    @Override
    public boolean containsNode(double key) {
        Node aux = findNode(key);
        return aux != null;
    }
}
