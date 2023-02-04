import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FloorSubsystem extends Thread
{

	private Scheduler scheduler;
	private String inputLoc;
	private List<Instruction> instructions;
	
	public FloorSubsystem(Scheduler scheduler, String inputLoc)
	{
		this.scheduler = scheduler;
		this.inputLoc = inputLoc;
		instructions = new ArrayList<>();
	}
	
	
	public void run()
	{
		readInput();
		
		for (int i = 0; i < instructions.size(); i++)
		{
			sendInstruction(instructions.get(i));
			getInstruction();
		}
		
		System.exit(0);
			
	}
	
	private void sendInstruction(Instruction newInstruction)
	{
		System.out.println("FloorSubsystem sending instructions, "+newInstruction);
		scheduler.setInstructionsFromFloor(newInstruction);
	}
	
	private void getInstruction()
	{
		Instruction newInstruction = scheduler.getInstructionForFloor();
		System.out.println("FloorSubsystem has received Intructions: "+ newInstruction + "\n");
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
				instructions.add(new Instruction(data));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
