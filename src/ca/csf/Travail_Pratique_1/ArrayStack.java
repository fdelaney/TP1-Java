package ca.csf.Travail_Pratique_1;

public class ArrayStack implements Stack{

	private int size = 0;
	private Object[] array = new Object[3];
	
	public Object Pop() {
	
		
		return array[size];
	}

	
	public void Push(Object object) {
		
		
		array[size] = object;
		
	}

	
	public Object Peek() {
		
		return null;
	}

	
	public Object GetAt(int position) {
	
		return null;
	}

	
	public void Clear() {
	
		
	}

	
	public boolean isEmpty() {
		
		return false;
	}

	
	public int getSize() {
		
		return 0;
	}

}
