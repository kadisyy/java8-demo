package basic;

/**
 * 单链表
 */
public class NodeTest {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.append(n2);
        n2.append(n3);

        // System.out.println(n1.next.getData());
        n2.insertNext(new Node(4));
        //n1.removeNext();
        n1.show();


    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public void append(Node n) {
        this.next = n;
    }

    public int getData() {
        return this.data;
    }

    public void show() {
        Node currentNode = this;
        while(true){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
            if(currentNode == null) {
                break;
            }
        }
    }

    public void removeNext() {
        Node newNext = next.next;
        this.next = newNext;
    }

    public void insertNext(Node node){
        node.next = this.next;
        this.next = node;
    }
}
