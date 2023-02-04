
public class ElevatorSubsystem extends Thread
{
	private Scheduler scheduler;
	private Instruction instruction;
	
	public ElevatorSubsystem (Scheduler scheduler)
	{
		this.scheduler = scheduler;
	}
	
	public void run()
	{
		while (true)
		{
			getInstructions();
			sendInstructions();
		}
		
	}
	
	private void getInstructions()
	{
		instruction = scheduler.getInstructionForElevator();
		System.out.println("ElevatorSubsystem received Intructions: "+instruction);
	}
	
	private void sendInstructions()
	{
		System.out.println("ElevatorSubsystem sending instructions");
		scheduler.setInstructionsFromElevator(instruction);
	}

}
