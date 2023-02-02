import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Floor extends Thread
{

	
	private Scheduler scheduler;
	private String inputLoc;
	private Instruction instruction;
	
	public Floor(Scheduler scheduler, String inputLoc)
	{
		this.scheduler = scheduler;
		this.inputLoc = inputLoc;
	}
	
	
	public void run()
	{
		readInput();
		System.out.println("Floor sending instructions");
		scheduler.sendInstructionsFromFloor(instruction);
		
		instruction = scheduler.getInstructionForFloor();
		
		System.out.println("Floor has received Intructions: "+instruction.getText());
		
		
	}
	
	private void readInput()
	{
		try {
			File inputInstructions = new File(inputLoc);
			Scanner scan = new Scanner(inputInstructions);
			
			scan.nextLine();
			while (scan.hasNextLine())
			{
				String data = scan.nextLine();
				instruction = new Instruction(data);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
