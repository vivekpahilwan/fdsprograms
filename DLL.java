class DLL {

    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public static void displayall(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // 4 10 2 99 13
        Node a = Node(4);
        Node b = Node(10);
        Node c = Node(2);
        Node d = Node(99);
        Node e = Node(13);

        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.next = null;
        displayall(a);
    }
}