package ca.csf.Travail_Pratique_1;

public interface Stack {

	
	
	public abstract Object Pop ();
	public abstract void Push (Object object);
	public abstract Object Peek ();
	public abstract Object GetAt (int position);
	public abstract void Clear ();
	public abstract boolean isEmpty();
	public abstract int getSize();
	public abstract String toString();
	
}
