package LinkedList;

public class LLOps {
	
	Node head =new Node();
	
	
	public LLOps(){
		head =null;
		
	}
	
	public void AddNode(int data){
		
		if (head==null){
		//	head.set_Next(current);
		//	head = new Node(data,null);
	//		head.set_Next(null);
//			System.out.println("head == null");
			Node n = new Node();
			n.set_Data(data);
			n.set_Next(null);
			head =n;
		}else{
			Node current=head;
			while(current.get_Next() != null){
				current = current.get_Next();
			}
			Node n=new Node(data,null);
			current.set_Next(n);
				

			
		}
		
	}
	
	public void print_List(){
		Node n = head;
		while(n != null){
			
			System.out.println(n.get_Data());
			n=n.get_Next();
		}
//		System.out.println(n.get_Data());
		
	}
	
/*	public Node getTop(){
		return head;
	}*/
	
	public void deleteNode(int data){
		if(head != null){
			if(head.get_Data() == data){
				head = head.get_Next();
			}else{
				Node n = head;
				Node previous = head;
				while (n != null){
					if (n.get_Data() == data){
						previous.set_Next(n.get_Next());
					}
					previous = n;
					n=n.get_Next();
				}
			}
		}else{
			System.out.println("List is empty");
		}

	}

}
