public class Doubly{
    private Node first;
    private Node last;

    public Doubly(TitanicData data) {
        first = new Node(data);
        last = first;
    }
    public Doubly() {
    }

    public void add(TitanicData data) {
        Node node = new Node(data);
        node.next = null;
        if (first == null && last == null){
            first = node;
        }
        else {
            node.prev = last;

            if (last != null)
                last.next = node;

        }
        last = node;
    }

    public TitanicData get(long index) {
        long i = 0;
        Node node = first;

        while (i != index) {
            node = node.next;
            i++;
        }
        return node.data;
    }

    public void remove(long index) {
        long i = 0;
        Node node = first;

        while (i != index) {
            node = node.next;
            i++;
        }

        if (node.prev != null)
            node.prev.next = node.next;
        else
            first = node.next;

        if(node.next != null)
            node.next.prev = node.prev;
        else
            last = node.prev;

        node = null;
    }

    public long size() {
        if (first == null)
            return 0;
        Node node = first;
        long i = 1;
        while (node.next != null) {
            node = node.next;
            i++;
        }
        return i;
    }

    void put(long index, TitanicData data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        }
        else if (index == size()) {
            newNode.prev = last;
            last = newNode;
        }
        else {
            Node node = first;
            for (long i = 0; i != index; i++)
                node = node.next;

            newNode.next = node;
            newNode.prev = node.prev;

            node.prev.next = newNode;
            node.prev = newNode;
        }
    }

}
