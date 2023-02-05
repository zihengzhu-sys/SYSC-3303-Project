# SYSC-3303-Project
For this project we have the following java classes:

Elevator.java
This class represents the Elevator Subsystem which emulates an elevator car. It makes calls to the scheduler and receives works to be done from the scheduler.

Floor.java
This classs represents the Floor Subsystem which emulates a floor in a building. The floor Subsystem exchanges messages with the scheduler.

Scheduler.java
This class receives instructions form the floor and send it to elevator class. It is used to schedule the elevator cars. 

Instruction.java
This class represents the instructions to the elevator using the format shown as: time, floor, elevator number, and button status(up or down).

ElevatorSimulation.java
This class is the simulation of the process of running the elevator. This class contains the main method used to run the code.
