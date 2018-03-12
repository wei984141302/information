package mathgroup;

import java.util.Vector;

public class Media extends Vector{

	    private String name;
	    private int number;
	    public Media(String n, int ID) {
	        name = n;
	        number = ID;
	    }//¹¹ÔìÆ÷
	    public String getName() {
	        return name;
	    }
	    public int getNumber() {
	        return number;
	    }

		public Media()
		{
			super(10,10);
		}
		public void addstring(String s)
		{
			addElement(s);
		}
		public void removestring(int index)
		{
			removeElement(index);
		}
		public void modistring(String obj,int index)
		{
			setElementAt(obj,index);
		}
		
		
	
}
