
public class Scheduler extends Thread
{
	Instruction instruction;
	private boolean instructionForElevator;
	private boolean instructionForFloor;
	
	public Scheduler()
	{
		instruction = null;
		instructionForElevator = false;
		instructionForFloor = false;
	}
	
	public void run()
	{
		while(true)
		{
			
		}
	}

	public synchronized void setInstructionsFromFloor(Instruction instruction) 
	{
		while (instructionForFloor || instructionForElevator)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		System.out.println("Scheduler received instructions from floor");
		this.instruction = instruction;
		instructionForElevator = true;
		notifyAll();
	}

	public synchronized Instruction getInstructionForElevator() 
	{
		while (!instructionForElevator)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		System.out.println("Scheduler sending instructions to elevator");
		instructionForElevator = false;
		notifyAll();
		return instruction;
	}

	public synchronized void setInstructionsFromElevator(Instruction instruction) {
		
		while (instructionForElevator)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		System.out.println("Scheduler received instructions from elevator");
		this.instruction = instruction;
		instructionForFloor = true; 
		notifyAll();
		
	}
	
	public synchronized Instruction getInstructionForFloor() 
	{
		while (!instructionForFloor)
		{
			try { 
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
		}
		
		System.out.println("Scheduler sending instructions to Floor");
		instructionForFloor = false;
		notifyAll();
		return instruction;
	}
	
}
