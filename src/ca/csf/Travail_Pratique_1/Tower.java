package ca.csf.Travail_Pratique_1;

public class Tower {
	private Stack towerStack;

	public Tower(Stack stack){
		towerStack = stack;
	}
	
	public void addDisk(Disk disk){
		towerStack.Push(disk);
	}
	public Disk removeDisk(){
		return (Disk)towerStack.Pop();
	}
	public Disk getDiskOnTop(){
		return (Disk)towerStack.GetAt(0);
	}
	public Disk getDiskAt(int position){
		return (Disk)towerStack.GetAt(position);
	}
	public int getSize(){
		return towerStack.getSize();
	}
	public void clear(){
		towerStack.Clear();
	}
	
}
