package ca.csf.Travail_Pratique_1;

public class LinkedListStack implements Stack {

	private LinkedListStackNode last = null;
	private int size = -1;

	public Object Pop() {
		Object object = last;
		
		if(last != null){
		last = last.getPrevious();
		}
		return object;

	}

	public void Push(Object object) {
		LinkedListStackNode temp = new LinkedListStackNode(object,last);
		last = temp;
	}

	public Object Peek() {
		return last;
	}

	public Object GetAt(int position) {
		if(size < position ){
			
			return null;
			
		}
		LinkedListStackNode temp = last;
		for(int i = 0;i == position - 1; ++i){
			
			temp = temp.getPrevious();
		}
		return temp;
		
	}

	public void Clear() {
		
		last = null;
	}

	public boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {
			return false;

		}
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		return "a faire";
	}

}
