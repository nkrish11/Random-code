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


}
