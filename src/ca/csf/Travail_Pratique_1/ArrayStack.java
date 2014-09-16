package ca.csf.Travail_Pratique_1;

public class ArrayStack implements Stack{

	private int size = -1;
	private Object[] array = new Object[3];
	
	public Object Pop() {
	
		
		return array[size];
	}

	
	public void Push(Object object) {
		
		
		array[size] = object;
		
	}

	
	public Object Peek() {
		
		return array[size];
	}

	
	public Object GetAt(int position) {
	
		return array[position];
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
