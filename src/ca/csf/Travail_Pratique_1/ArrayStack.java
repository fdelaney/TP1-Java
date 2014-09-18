package ca.csf.Travail_Pratique_1;

public class ArrayStack implements Stack{

	private int size = 0;
	private Object[] array = new Object[18];
	
	public ArrayStack(int i) {
	
		
		
	}


	public Object Pop() {
	
	if(size == 0){
		return null;
	
	}	
	    Object temp = array[size - 1];
	    array[size - 1] = null;
	    size--;
		return temp;
	}

	
	public void Push(Object object) {
		
		
		array[size] = object;
		size++;
		
	}

	
	public Object Peek() {
		
		if(size == 0){
			
			return null;
		}
		
		return array[size - 1];
	}

	
	public Object GetAt(int position) {
	
		return array[position];
	}

	
	public void Clear() {
	
		Object[] arrayTemp = new Object[3];
		array = arrayTemp;
		size = 0;
	}

	
	public boolean isEmpty() {
		if(size == 0){
		return true;
		}
		return false;
	}

	
	public int getSize() {
		
		return size;
	}

}
