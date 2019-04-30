package lru_cache_imp;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int actualSize;
    private Map<Integer, Node> map;
    private DoubleLinkedList linkedList;

    LRUCache(){
        this.map = new HashMap<>();
        this.linkedList = new DoubleLinkedList();
    }

    void put(int id, String data){

        if(map.containsKey(id)){
            Node node = this.map.get(id);
            node.setData(data);
            System.out.println("Inside put: "+data);

            //update the node to be the head (cache feature)
            update(node);
            return;
        }

        Node newNode = new Node(id, data);

        if(this.actualSize < Constant.CAPACITY)
            this.actualSize++;
        else
            removeTail();

        add(newNode);
     }

    private void add(Node node) {
        node.setPreviousNode(null);
        node.setNextNode(linkedList.getHeadNode());

        if(linkedList.getHeadNode() != null)
            linkedList.getHeadNode().setPreviousNode(node);

        linkedList.setHeadNode(node);

        if(linkedList.getTailNode() == null)
            linkedList.setTailNode(node);

        this.map.put(node.getId(), node);
    }

    private void removeTail() {

        Node lastNode = map.get(linkedList.getTailNode().getId());

        linkedList.setTailNode(linkedList.getTailNode().getPreviousNode());
        if(linkedList.getTailNode() != null)
            linkedList.getTailNode().setNextNode(null);

        lastNode = null;

    }

    public Node get(int d){

        if(!this.map.containsKey(d))return null;

        Node node = this.map.get(d);
        update(node);
        return node;

    }

    private void update(Node node) {

        if(node == null) return;

        Node previous = node.getPreviousNode();
        Node next = node.getNextNode();

       if(previous != null)
            previous.setNextNode(next);
        else
            linkedList.setHeadNode(next);

        if(next != null)
            next.setPreviousNode(previous);
        else
            linkedList.setTailNode(previous);

        add(node);

    }

    void show(){

        Node actualNode = linkedList.getHeadNode();

        while (actualNode != null){
            System.out.print(actualNode+" <-> ");
            actualNode = actualNode.getNextNode();
        }
    }
}
