
public class Scheduler extends Thread
{
	Instruction instruction;
	private boolean workToDoForElevator;
	private boolean workToDoForFloor;
	
	public Scheduler()
	{
		instruction = null;
		workToDoForElevator = false;
		workToDoForFloor = false;
	}
	
	public void run()
	{
		while(true)
		{
			
		}
	}

	public synchronized void sendInstructionsFromFloor(Instruction instruction) 
	{
		while (instruction != null && workToDoForFloor)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		this.instruction = instruction;
		workToDoForElevator = true;
		System.out.println("Scheduler has instructions from floor");
		notifyAll();
	}

	public synchronized Instruction getInstructionForElevator() 
	{
		while (!workToDoForElevator)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		System.out.println("Scheduler sending instructions to elevator");
		workToDoForElevator = false;
		notifyAll();
		return instruction;
	}

	public synchronized void sendInstructionsFromElevator(Instruction instruction) {
		
		while (workToDoForElevator)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		this.instruction = instruction;
		workToDoForElevator = false;
		workToDoForFloor = true;
		System.out.println("Scheduler received instructions from elevator");
		notifyAll();
		
	}
	
	public synchronized Instruction getInstructionForFloor() 
	{
		while (!workToDoForFloor)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		System.out.println("Scheduler sending instructions to Floor");
		workToDoForFloor = false;
		notifyAll();
		return instruction;
	}
	
}
