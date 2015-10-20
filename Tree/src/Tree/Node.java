package Tree;

public class Node {
	
	int value;
	
	Node leftchild;
	Node rightchild;
	
	public Node(int val){
		this.value=val;
		this.leftchild = null;
		this.rightchild = null;
	}
	
	
	public int getValue(){
		return this.value;
	}
	
	public Node getLeft(){
		return this.leftchild;
	}
	
	public Node getRight(){
		return this.rightchild;
	}
	
	public void setLeft(Node Left){
		this.leftchild=Left;
	}
	
	public void setRight(Node Right){
		this.rightchild=Right;
	}
	
	public void setValue(int val){
		this.value=val;
	}

}
