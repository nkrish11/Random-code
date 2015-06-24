package LinkedList;

public class Node {
	
	private int data;
	private Node next;
	
	public Node(){
		
	}
	
	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public int get_Data(){
		return this.data;
	}
	
	public void set_Data(int data){
		this.data=data;
	}
	
	public Node get_Next(){
		return this.next;
	}
	
	public void set_Next(Node next){
		
		this.next=next;
	}
	
	public void set_Next_Null(){
		
		this.next=null;
	}

}
