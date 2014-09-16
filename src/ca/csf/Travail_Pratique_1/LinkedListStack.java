package ca.csf.Travail_Pratique_1;

public class LinkedListStack implements Stack {

	private LinkedListStackNode last = null;
	private int size = -1;

	public Object Pop() {
		LinkedListStackNode object = last;
		
		if(last != null){
		last = last.getPrevious();
		size--;
		}
		else{
			
			return null;
			
		}
		
		return object.getObject();

	}

	public void Push(Object object) {
		LinkedListStackNode temp = new LinkedListStackNode(object,last);
		last = temp;
		size++;
	}

	public Object Peek() {
		if(last == null){
			
			return null;
			
		}
		return last.getObject();
	}

	public Object GetAt(int position) {

		LinkedListStackNode temp = last;
		for(int i = 0;i == position -1; ++i){
			
			temp = temp.getPrevious();
		}
		return temp.getObject();
		
	}

	public void Clear() {
		
		last = null;
		size = -1;
	}

	public boolean isEmpty() {

		if (last == null) {
			return true;
		} else {
			return false;

		}
	}

	public int getSize() {
		return size + 1;
	}

	public String toString() {
		return "a faire";
	}

}
