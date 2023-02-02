
public class Elevator extends Thread
{
	private Scheduler scheduler;
	private Instruction instruction;
	
	public Elevator (Scheduler scheduler)
	{
		this.scheduler = scheduler;
	}
	
	public void run()
	{
		
		instruction = scheduler.getInstructionForElevator();
		
		System.out.println("Elevator has received Intructions: "+instruction.getText());
		
		scheduler.sendInstructionsFromElevator(instruction);
	}

}
