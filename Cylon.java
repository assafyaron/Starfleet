package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends MyAbstractCrewMember {
	//fields
	private int ModelNumber; //between 1 and 12
	
	//constructor
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		//calling MyAbstractCrewMember constructor
		super(age, yearsInService, name);
		this.ModelNumber = modelNumber;
	}
	
	public int getModelNumber()
	{
		return this.ModelNumber;
	}

}
