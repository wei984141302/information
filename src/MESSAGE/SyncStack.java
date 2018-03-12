package MESSAGE;

public class SyncStack {

	/**
	 * @param args
	 */
	private int index=0;
	private char buffer[]=new char[6];
	
	public synchronized void push(char c)
	{
		while(index==buffer.length)
		{
			try{
				this.wait();
			}
			catch(InterruptedException e)
			{}
		}
		this.notify();
		buffer[index]=c;
		index++;
	}
	public synchronized char pop()
	{
		while(index==0)
		{
			try{
				this.wait();
			}
			catch(InterruptedException e){}
		}
		this.notify();
		index--;
		return buffer[index];
	}
	
}
