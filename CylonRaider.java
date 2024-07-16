package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends MyAbstractBattleship {

	//fields
	protected static int NumOfManufacturedCylonRaider = 0;
	
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		//calling MyAbstractBattleship constructor
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfCylonRaider();
		addCylonRaiderToFleet();
	}
	
	public int computeAnnualMaintenanceCostOfCylonRaider()
	{
		int baseCost = 3500;
		
		//computing weapons annual cost
		baseCost += this.computeAnnualMaintenanceOfWeapons();
		
		//computing cost of crew
		baseCost += (this.getCrewMembers().size())*500;
		
		//computing cost of engine
		baseCost += this.getMaximalSpeed()*1200;
				
		return baseCost;
	}

	public void addCylonRaiderToFleet()
	{
		NumOfManufacturedCylonRaider++;
	}

}
