package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class StealthCruiser extends Fighter {
	//fields
	protected static int NumOfManufacturedStealthCruiser = 0;
	private static List<StealthCruiser> ListOfCruisers = new ArrayList<>();

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		//calling MyAbstractBattleship constructor
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfStealthCruiser();
		
		//adding new ship to fleet and updating annual maintenance cost for others
		addStealthCruiserToFleet();
		updateStealthFleetMaintenence();
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		//case where we only have laser cannons
		//calling MyAbstractBattleship constructor
		super(name,commissionYear,maximalSpeed,crewMembers,new ArrayList<>(List.of(new Weapon("Laser Cannons",10,100))));
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfStealthCruiser();
		
		//adding new ship to fleet and updating annual maintenance cost for others
		addStealthCruiserToFleet();
		updateStealthFleetMaintenence();
	}

	public int computeAnnualMaintenanceCostOfStealthCruiser()
	{
		//basic maintenance cost of a fighter
		//->
		int baseCost = 2500;
		
		//adding weapons annual cost for each weapon
		baseCost += this.computeAnnualMaintenanceOfWeapons();
		
		//adding annual engine cost
		baseCost += Math.floor(this.getMaximalSpeed()*1000);
		//<-
		
		//computing cost per engine
		baseCost += NumOfManufacturedStealthCruiser*50;
		return baseCost;
	}
	
	public void addStealthCruiserToFleet()
	{
		NumOfManufacturedStealthCruiser++;
		ListOfCruisers.add(this);
	}
	
	public void updateStealthFleetMaintenence()
	{
		for (StealthCruiser currCruiser : ListOfCruisers)
		{
			currCruiser.AnnualMaintenanceCost = currCruiser.computeAnnualMaintenanceCostOfStealthCruiser();
		}
	}
}
