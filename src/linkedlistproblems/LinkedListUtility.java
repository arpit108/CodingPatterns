package linkedlistproblems;

public class LinkedListUtility {

    public static LinkedList addNode(LinkedList head, int data) {
        LinkedList newNode = new LinkedList(data, null);
        if (head == null) {
            return newNode;
        } else {
            LinkedList headNode = head;
            while (headNode.next != null)
                headNode = headNode.next;

            headNode.next = newNode;
        }
        return head;
    }

    public static LinkedList reverse(LinkedList head) {
        LinkedList prev = null;
        LinkedList current = head;
        LinkedList nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;


        }

        return prev;


    }


    public static LinkedList reverse(LinkedList head,int start,int end) {

        LinkedList currentHead=head;
        LinkedList prevHead=null;
        for(int i=1;i<start;i++) {
            prevHead=currentHead;
            currentHead = currentHead.next;
        }

        LinkedList endHead=currentHead;
        for(int i=1;i<=(end-start+1);i++)
        {
            endHead=endHead.next;
        }




        LinkedList prev = endHead;
        LinkedList current = currentHead;

        LinkedList nextNode = null;

        for(int i=1;i<end;i++) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        prevHead.next=prev;

        return head;


    }




}
