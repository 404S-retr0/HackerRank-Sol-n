import java.util.Scanner;
class LinkedList 
{
    static Node head;
    static class Node 
    {
        int data;
        Node next, prev;
        Node(int d)
        {
            data = d;
            next = prev = null;
        }
    }
    void reverse()
    {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) 
        {
            head = temp.prev;
        }
    }
    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.prev = null;
        new_node.next = head;
        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
    }
 
    void printList(Node node)
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        Scanner myInput = new Scanner(System.in);
        int n = myInput.nextInt();
        for(int i=0;i<n;i++)
        {
            int input = myInput.nextInt();
            list.push(input);
        }
        System.out.println("Original linked list");
        list.printList(head);
        list.reverse();
        System.out.println("\nThe reversed Linked List is");
        list.printList(head);
    }
}
