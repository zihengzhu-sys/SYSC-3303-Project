
public class Instruction {
	
	private String time;
	private int floor;
	private int elevatorNum;
	
	private ButtonStatus buttonStatus;
	public enum ButtonStatus {Up,Down};
	
	public Instruction(String time, int floor, int elevatorNum, String buttonStatus)
	{
		this.time = time;
		this.floor = floor;
		this.elevatorNum = elevatorNum;
		
		if (buttonStatus.equalsIgnoreCase("Up"))
		{
			this.buttonStatus = ButtonStatus.Up;
			
		}
		else
		{
			this.buttonStatus = ButtonStatus.Down;
		}
	}
	
	public Instruction (String inputData)
	{
		String [] split = inputData.split("\\t");
		this.time = split[0];
		this.floor = Integer.parseInt(split[1]);
		
		
		if (split[2].equalsIgnoreCase("Up"))
		{
			this.buttonStatus = ButtonStatus.Up;
		}
		else
		{
			this.buttonStatus = ButtonStatus.Down;
		}
		
		this.elevatorNum = Integer.parseInt(split[3]);
		
	}

	public String getText() {
		
		return "Time:"+time+", floor"+floor+", elevator num:"+elevatorNum
				+", Button:"+buttonStatus.toString();
	}

}
