package MESSAGE;

public class Consumer implements Runnable{

	SyncStack theStack;
	public Consumer(SyncStack s)
	{
		theStack=s;
	}
	public void run()
	{
		char c;
    	for(int i=0;i<20;i++)
    	{
    		c=theStack.pop();
    		System.out.println("Consuned: "+c);
    		try{
    			Thread.sleep((int)(Math.random()*1000));
    		}
    		catch(InterruptedException e){}
    	}
		
	}
}
