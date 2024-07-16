package il.ac.tau.cs.sw1.ex9.starfleet;

public class Officer extends CrewWoman {
	
	//fields
	OfficerRank OfficerRank;
	
	//constructor
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		////calling CrewWoman constructor
		super(age, yearsInService, name);
		this.OfficerRank = rank;
	}
	
	public OfficerRank getRank()
	{
		return this.OfficerRank;
	}
	
}
