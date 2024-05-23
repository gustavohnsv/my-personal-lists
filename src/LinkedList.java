import org.jetbrains.annotations.NotNull;
public class LinkedList extends Node implements MyLists<LinkedList> {

    private Node root;

    public LinkedList() {
        this.root = null;
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
        }
        else {
            Node aux = root;
            Node previous = null;
            while (aux != null && aux.getKey() < key) {
                previous = aux;
                aux = aux.getNext();
            }
            if (previous == null) {
                newNode.setNext(root);
                root = newNode;
            }
            else if (aux == null) {
                previous.setNext(newNode);
            }
            else {
                previous.setNext(newNode);
                newNode.setNext(aux);
            }
        }
    }

    @Override
    public void removeNode(double key) {
        Node aux = findNode(key);
        if (aux == null) {
            return;
        }
        if (aux.hasPrevious()) {
            aux.getPrevious().setNext(aux.getNext());
        }
        if (aux.hasNext()) {
            aux.getNext().setPrevious(aux.getPrevious());
        }
    }

    @Override
    public void modifyNode(double oldKey, double newKey) {
        //   Node aux = findNode(oldKey); Caso queira aproveitar algo como registro, etc
        removeNode(oldKey);
        addNode(newKey);
    }

    @Override
    public Node findNode(double key) {
        Node aux = root;
        while (aux.hasNext()) {
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
        while (aux.hasNext()) {
            System.out.print(aux.getKey() + " ");
            aux = aux.getNext();
        }
        System.out.print(aux.getKey());
        System.out.println(" ");
    }

    @Override
    public void printNode(double key) {
        Node aux = findNode(key);
        if (aux == null) {
            System.out.println("No nao existe!");
            return;
        }
        System.out.printf("Chave: " + aux.getKey() + " / Possui proximo? " + aux.hasNext());
    }

    @Override
    public boolean containsNode(double key) {
        Node aux = findNode(key);
        return aux != null;
    }

}
