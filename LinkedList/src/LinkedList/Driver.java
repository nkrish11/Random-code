package LinkedList;

public class Driver {
	public static void main(String args[]){
		
		LLOps obj=new LLOps();
		
		for(int i=0; i<4;i++){
			obj.AddNode(i);
			
		}
		
		obj.printList();
		
		obj.deleteNode(0);
		obj.deleteNode(2);
		obj.deleteNode(3);
		
		
		obj.printList();
	}

}
