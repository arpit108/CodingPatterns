package linkedlistproblems;

public class TestClass {
    public static void main(String[] args) {
        LinkedList head=LinkedListUtility.addNode(null,10);
        head=LinkedListUtility.addNode(head,20);
        head=LinkedListUtility.addNode(head,30);
        head=LinkedListUtility.addNode(head,40);
        head=LinkedListUtility.addNode(head,50);
        LinkedList current=head;
        while(current!=null)
        {
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("");
        System.out.println("After reverse ....");


        LinkedList lst=LinkedListUtility.reverse(head,2,4);

        while(lst!=null)
        {
            System.out.print(lst.data+" -> ");
            lst=lst.next;
        }


    }




}
