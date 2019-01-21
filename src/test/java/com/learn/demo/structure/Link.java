package com.learn.demo.structure;

/**
 * 单向链表
 */
public class Link {
    public  int iData;
    public  double dData;
    public  Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink(){
        System.out.println("{" + iData + ", " + dData + "}");
    }
}
class LinkList{

    private Link  first;

    public LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id,double dd){
        Link newLink = new Link(id,dd);
        newLink.next = first;
        first = newLink;
    }

    public Link  find(int key){
        Link current = first;
        while (current.iData != key){
            if(current.next == null){
                return null;
            }else{
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.iData != key){
            if(current.next == null){
                return null;
            }else{
                previous = current;
                current = current.next;
            }
        }
        if (current == first){
            first = first.next;
        }else{
            previous.next = current.next;
        }
        return current;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first --> last:");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    public static  void main(String[] args){
        LinkList theList = new LinkList();

        theList.insertFirst(22 ,2.99);
        theList.insertFirst(44 ,4.99);
        theList.insertFirst(66 ,6.99);
        theList.insertFirst(88 ,8.99);

        theList.displayList();

        while ( !theList.isEmpty()){
            Link aLink = theList.deleteFirst();
            System.out.print("Delete ");
            aLink.displayLink();

            System.out.println(" ");
        }
        theList.displayList();
    }
}