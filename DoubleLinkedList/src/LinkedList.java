import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {
    //you can record the size additionally but since this is beginning example i leave it here
    Node head;
    Node tail;
    public void pushFront(int data){
        Node pushFront=new Node(data);
        pushFront.setPrevious(null);
        if(pushFront==null){
            head=pushFront;
            tail=pushFront;
        }
        else{
            pushFront.setNext(head);
            head.setPrevious(pushFront);
        }
        head=pushFront;
    }
    public void pushBack(int data){
        Node pushBack=new Node(data);
        pushBack.setNext(null);
        if(head==null){
            head=pushBack;
            tail=pushBack;
        }
        else{
            tail.setPrevious(pushBack);
            pushBack.setNext(tail);
        }
        tail=pushBack;
    }
    public int popFront(){
        if(head==null){
            tail=null;
            throw new NoSuchElementException();
        }
        int data=head.getData();
        if(head==tail){//if there is only one element'if they are pointing to the same object in memory
            head=tail=null;
        }
        head=head.getNext();
        if(head!=null){
            head.setPrevious(null);
        }
        else{
            tail=null;
        }
        return data;
    }
    public int popBack(){
        if(tail==null){
            head=null;
            throw new NoSuchElementException();
        }
        int data=tail.getData();
        if(tail==head){
            tail=head=null;
        }
        tail=tail.getPrevious();
        if(tail!=null){
            tail.setNext(null);
        }
        else{
            head=null;
        }
        return data;
    }
    public void traverse(){
        if(head==null){
            tail=null;
            throw new NoSuchElementException();
        }
        Node tmp=head;
        while(tmp!=null){
            System.out.print(tmp.getData()+" ");
            tmp=tmp.getNext();
        }
    }
    public void traverseBackward(){//also o(n)
        if (tail == null) {
            head=null;
            throw new NoSuchElementException();
        }
        Node tmp=tail;
        while(tmp!=null){
            System.out.println(tmp.getData()+" ");
                tmp=tmp.getPrevious();
        }
    }
    public int getByIndex(int nth){
        //get nth index out of linked list
        if(head==null){
            tail=null;
            throw new NoSuchElementException();
        }
        Node tmp=head;
        int index=0;
        while(tmp!=null){
             if(index==nth){
                 return tmp.getData();
             }
             tmp=tmp.getNext();
             index++;
         }
        throw new IndexOutOfBoundsException();
    }
    //control it when come back from outside code is not over yet
    public int getIndexOfFirstOccurence(int data){
        if(head==null){
            tail=null;
            throw new NoSuchElementException();
        }
            Node tmp=head;
            int counter=0;
            while(tmp!=null){
                if(data==tmp.getData()){
                    return counter;
                }
                ++counter;
            }
            throw new NoSuchElementException();
    }
    public int size(){
        int counter=0;
        if (tail == null) {
            head=null;
            return counter;
        }
        Node tmp=head;
        while(tmp!=null){
            counter++;
            tmp=tmp.getNext();
        }
        return counter;
    }
    public List<Integer> getIndexesOfOccurrence(int data) {
        Node tmp = head;
        int counter = 0;
        List<Integer> indexes = new ArrayList<>();

        if (head == null) {
            throw new NoSuchElementException("The list is empty.");
        }

        while (tmp != null) {
            if (data == tmp.getData()) {
                indexes.add(counter);
            }
            ++counter;
            tmp = tmp.next;
        }
        if(indexes.size()==0){
            throw new NoSuchElementException("There is no such element");
        }
        return indexes;
    }
    public void  deleteList(){
       head=null;
       tail=null;
    }
}
