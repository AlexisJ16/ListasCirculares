import sun.awt.windows.WPrinterJob;

import javax.naming.Name;

public class CircularList {

    private Node head;
    public void addNode(Node node){
        if(head == null){
            head = node;
            head.setNext(head);
            head.setPrevious(head);
        }else{
            Node tail = head.getPrevious();
            node.setNext(head);
            head.setPrevious(node);
            tail.setNext(node);
            node.setPrevious(tail);
        }
    }

    public void print(){
        if(head == null) System.out.println("La lista se encuentra vacia");
        System.out.println(head.getName());
        print(head.getNext());
    }

    private void print(Node current){
        if(current.equals(head)) return;
        System.out.println(current.getName());
        print(current.getNext());
    }

    public void delete(String name){
        if(head.getName().equals(name)){
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            this.head = head.getNext();
            return;
        }
        deleteNode(head.getNext() ,name);
    }

    private void deleteNode(Node current, String name){
        if(current.equals(head)) return;
        if(current.getName().equals(name)){
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }
        deleteNode(current.getNext() ,name);
    }

}
