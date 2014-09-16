package ca.csf.Travail_Pratique_1;

public class LinkedListStackNode {

	
	private Object object;
	private LinkedListStackNode previous;
	
	
	public LinkedListStackNode(Object object, LinkedListStackNode previousStackNode ){
		
		this.object = object;
		this.previous = previousStackNode;
	}
	
	public LinkedListStackNode getPrevious(){
		
		return this.previous;
		
	}
	
	public Object getObject(){
		
		return this.object;
		
	}
}
