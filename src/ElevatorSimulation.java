
public class ElevatorSimulation {
	
	public static void main (String [] args)
	{
		
		Thread scheduler = new Scheduler ();
		Thread elevator = new Elevator ((Scheduler) scheduler);
		Thread floor = new Floor ((Scheduler) scheduler, "InputInstructions.txt");
		
		scheduler.start();
		elevator.start();
		floor.start();
		
		
		
	}

}
