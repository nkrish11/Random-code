package Tree;

import java.io.*;


public class Wrapper {

	public static void main(String[] args) throws NumberFormatException, IOException{
		int ch=1,c;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BinarySearchTree bt=new BinarySearchTree();
		
		bt.insert(4);
		bt.insert(20);
		bt.insert(10);
		bt.insert(3);
		bt.insert(1);
		bt.insert(22);
		while(ch == 1){

			System.out.println("1.Insert a new Node \n"+"2.Traverse the tree \n"+"3.Search the tree \n"+"4.Delete a node");
			c=Integer.parseInt(br.readLine());
			switch(c){
			case 1 :
				int value;
				System.out.println("Enter a value");
				value=Integer.parseInt(br.readLine());
				bt.insert(value);
				break;
			case 2 :
				bt.traverse();
				break;
			case 3 : 
				
				System.out.println("Enter a value");
				value=Integer.parseInt(br.readLine());
				bt.lookup(value);
				break;
			case 4 : 
				System.out.println("Enter a value");
				value=Integer.parseInt(br.readLine());
				bt.delete(value);
				break;
			}
			System.out.println("\nEnter 1 to continue ");
			ch=Integer.parseInt(br.readLine());



		}


	}

}
