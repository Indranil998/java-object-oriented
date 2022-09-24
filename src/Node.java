public class Node<Type extends Comparable<Type>> {
    public Type element;
    public Node next;

    /**
     * creates node for data structure with element of Type 
     * and Type class should be extends Comparable and override abstract method toCompare
     * this node has capability of storing or pointing one another node
     * @param element
     */    
    Node(Type element) {
        this.element = element;
        this.next = null;
    }
}
