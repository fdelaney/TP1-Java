package ca.csf.Travail_Pratique_1;

public class Tower {
	private LinkedListStack towerListStack;
	private ArrayStack towerArrayStack;

	Tower(LinkedListStack linkedListStack){
		towerListStack = linkedListStack;
	}
	
	public void addDisk(Disk disk){
		towerListStack.Push(disk);
	}
	public Disk removeDisk(){
		return towerListStack.Pop();
	}
	public Disk getDiskOnTop(){
		return towerListStack.GetAt(0);
	}
	public Disk getDiskAt(int position){
		return towerListStack.GetAt(position);
	}
	public int getSize(){
		return towerListStack.getSize();
	}
	public void clear(){
		towerListStack.Clear();
	}
	
}
