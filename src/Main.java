public class Main {
    public static void main(String[] args) {
        MyLists<DoubleLinkedList> listaduplamenteligada = new DoubleLinkedList();
        listaduplamenteligada.addNode(1);
        listaduplamenteligada.addNode(2);
        listaduplamenteligada.addNode(3);
        listaduplamenteligada.printNodes();
        System.out.println(" ");
        listaduplamenteligada.removeNode(1);
        listaduplamenteligada.printNodes();
    }
}