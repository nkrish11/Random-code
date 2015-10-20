package Tree;

import java.io.*;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree(int value){
		this.root.setValue(value);
		this.root.setRight(null);
		this.root.setLeft(null);
	}

	public BinarySearchTree(){
		root=null;
		
	}

	public void insert(int value){
		if(root==null){
			root=new Node(value);
		}
		else{
			this.addNode(root,value);
		}
	}

	public void addNode(Node current,int value){
		if(value > current.getValue()){
			if(current.getRight() == null){

				Node newnode=new Node(value);
				current.setRight(newnode);
				return;
			}else{
				addNode(current.getRight(),value);
				return;
			}
		}else if(value < current.getValue()){
			if(current.getLeft() == null){

				Node newnode=new Node(value);
				current.setLeft(newnode);
				return;
			}else{
				addNode(current.getLeft(),value);
				return;
			}
		}


	}

	public void traverse() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Inorder \n"+"2.Preorder \n"+"3.Postorder");
		int ch=Integer.parseInt(br.readLine());
		switch(ch){
		case 1 :
			System.out.println("");
			this.inorder(root);
			break;
		case 2: 
			System.out.println("");
			this.preorder(root);
			break;
		case 3:
			System.out.println("");
			this.postorder(root);
			break;
		default :
			System.out.println("Input the correct numbers \n");
		}
	}

	public void inorder(Node current){
		if(current==null){
			return;
		}else{

			inorder(current.getLeft());

			System.out.print(current.getValue()+"  ");

			inorder(current.getRight());

		}
	}
	
	public void preorder(Node current){
		if(current == null){
			return;
		}else{
			System.out.print(current.getValue()+"  ");
			preorder(current.getLeft());
			preorder(current.getRight());
		}
	}
	
	public void postorder(Node current){
		if(current == null){
			return;
		}else{
			postorder(current.getLeft());
			postorder(current.getRight());
			System.out.print(current.getValue()+"  ");
		}
	}
	
	public Node search(Node current, int value){
		if(value == current.getValue()){
			return current;
		}else if(value < current.getValue() && current.getLeft()!=null){
			return this.search(current.getLeft(),value);
			
		}else if(value > current.getValue() && current.getRight()!=null){
			return this.search(current.getRight(), value);
			
		}
		
		return null;
		
		
	}

	public Node getParent(Node current,Node child){

		if(child == root || current == null){
			return null;
		}
		if(current.getLeft()== child || current.getRight() == child){
			return current;
		}else if(current.getValue() < child.getValue()){
			return this.getParent(current.getRight(), child);
			
		}else if(current.getValue()> child.getValue()){
			return this.getParent(current.getLeft(), child);
		}
		
		return null;
	}


	
	
	public void lookup(int value){
		if(this.search(root, value)!=null){
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}
		
		
	}
	
	public Node findMinRight(Node node){
		Node current = node.getRight();
		while(current.getLeft() != null){
			current = current.getLeft();
		}
		return current;
	}
	
	public void delete(int value){
		Node del = this.search(root,value);
		
		if(del == null){
			System.out.println("Node not found");
			return;
		}
		
		Node parent = this.getParent(root,del);
		
		if(del == root){    // Case for root
			Node minright = findMinRight(root);
			Node parentmr = getParent(root, minright);
			
			if(parentmr.getLeft() == minright){
				parentmr.setLeft(null);
			}else{
				parentmr.setRight(null);
			}
			minright.setLeft(root.getLeft());
			minright.setRight(root.getRight());
			
			root = minright;
			return;
			
		}else if(del.getLeft()==null && del.getRight()==null){ //Case for leaf node
			
			
			if(parent.getLeft() == del){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
			return;
		}else if(del.getLeft()==null || del.getRight()==null){ //Case for the node having one child
			if(parent.getLeft() == del){
				if(del.getLeft() != null){
					parent.setLeft(del.getLeft());
				}else{
					parent.setLeft(del.getRight());
				}
			}else{
				if(del.getLeft() != null){
					parent.setRight(del.getLeft());
				}else{
					parent.setRight(del.getRight());
				}
			}
			return;
		}else if(del.getLeft()!=null && del.getRight()!=null){ //Case for the node having two children
			Node minright = findMinRight(del);
			Node parentmr = getParent(root,minright);
			if(parentmr.getLeft() == minright){
				parentmr.setLeft(null);
			}else{
				parentmr.setRight(null);
			}
			minright.setLeft(del.getLeft());
			minright.setRight(del.getRight());
			if(parent.getLeft() == del){
				parent.setLeft(minright);
			}else{
				parent.setRight(minright);
			}
			return;
		}
		
		
		
		
	}
	
	


}
