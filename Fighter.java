package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MyAbstractBattleship {
	//fields
	protected static int NumOfManufacturedFighter = 0;
	
	//constructor
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		//calling MyBattleship constructor
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		//computing AnnualMaintenanceCost
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfFighter();
		addFighterToFleet();
	}

	public int computeAnnualMaintenanceCostOfFighter()
	{
		int baseCost = 2500;
		
		//adding weapons annual cost for each weapon
		baseCost += this.computeAnnualMaintenanceOfWeapons();
		
		//adding annual engine cost
		baseCost += Math.floor(this.getMaximalSpeed()*1000);
		
		return baseCost;
	}
	
	public void addFighterToFleet()
	{
		NumOfManufacturedFighter++;
	}
}
