package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends MyAbstractBattleship {
	
	//fields
	protected static int NumOfManufacturedColonialViper = 0;

	
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		//calling MyAbstractBattleship constructor
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfColonialViper();
		addViperToFleet();
	}
	
	public int computeAnnualMaintenanceCostOfColonialViper()
	{
		int baseCost = 4000;
		
		//computing weapons annual cost
		baseCost += this.computeAnnualMaintenanceOfWeapons();
		
		//computing cost of crew
		baseCost += (this.getCrewMembers().size())*500;
		
		//computing cost of engine
		baseCost += this.getMaximalSpeed()*500;
		
		return baseCost;
	}
	
	public void addViperToFleet()
	{
		NumOfManufacturedColonialViper++;
	}
}
