
public class Instruction {
	
	private String time;
	private int floor;
	private int elevatorNum;
	
	public enum ButtonStatus {Up,Down};
	private ButtonStatus buttonStatus;
	
	
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
	
	@Override
	public String toString()
	{
		String message = "Time:"+time+", Floor:"+floor+", Elevator Number:"+elevatorNum
				+", Button:"+buttonStatus.toString();
		return message;
		
	}

}
