package ca.csf.Travail_Pratique_1;

public class ArrayStack implements Stack{

	private int size = 0;
	private int arrayTotalSize = 3;
	private Object[] array = new Object[3];
	
	public ArrayStack(int i) {
	
		Object[] temp = new Object[i];
		array = temp;
		
		arrayTotalSize = i;
	}


	public Object Pop() {
	
	if(size == 0){
		return null;
	
	}	
	    Object temp = array[size - 1];
	    array[size - 1] = null;
	    --size;
		return temp;
	}

	
	public void Push(Object object) {
		
		if(arrayTotalSize == size){
		
			Object[] temp = new Object[arrayTotalSize + 1];
			for(int i = 0;i < size ;++i){
				
				temp[i] = array[i];
				
				
			}	
			
		arrayTotalSize++;
		array = temp;
		}
		size++;
		array[size - 1] = object;
		
		
	}

	
	public Object Peek() {
		
		if(size == 0){
			
			return null;
		}
		
		return array[size- 1];
	}

	
	public Object GetAt(int position) {
	
		return array[size - 1 - position];
	}

	
	public void Clear() {
	
		Object[] arrayTemp = new Object[3];
		array = arrayTemp;
		size = 0;
		arrayTotalSize = 3;
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
