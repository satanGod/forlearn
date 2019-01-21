package com.learn.demo.structure;

/**
 * 双端链表
 */
public class DoubleLink {

    public long dData;

    public DoubleLink next;

    public DoubleLink(long dData) {
        this.dData = dData;
    }

    public void displayLink(){
        System.out.println(dData + " ");
    }

}
class DoubleLinkList{

    private DoubleLink first;

    private DoubleLink last;

    public DoubleLinkList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(long dd){
        DoubleLink newLink = new DoubleLink(dd);

        if(isEmpty()){
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd){
        DoubleLink newLink = new DoubleLink(dd);

        if(isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;//双端设置
        }
        last = newLink;
    }

    public void displayList(){
        System.out.println("List (first --> last):");
        DoubleLink current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    public long deleteFirst(){
        long temp = first.dData;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }

    public static void main(String[] args){
        DoubleLinkList theList = new DoubleLinkList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}
