
public class ElevatorSimulation {
	
	public static void main (String [] args)
	{

		Thread elevatorThread, schedulerThread, floorThread;
		
		Scheduler scheduler = new Scheduler ();
		ElevatorSubsystem elevatorSubsytem = new ElevatorSubsystem (scheduler);
		FloorSubsystem floorSubsystem = new FloorSubsystem (scheduler, "InputInstructions.txt");
		
		elevatorThread = new Thread (elevatorSubsytem);
		floorThread = new Thread (floorSubsystem);
		schedulerThread = new Thread (scheduler);
		
		schedulerThread.start();
		elevatorThread.start();
		floorThread.start();
		
	}

}
