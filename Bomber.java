package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends MyAbstractBattleship{

	//fields
	private int NumOfTechnicians;
	protected static int NumOfManufacturedBomber = 0;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		//calling MyAbstractBattleship constructor
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.NumOfTechnicians = numberOfTechnicians;
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfBomber();
		addBomberToFleet();
	}
	
	public int getNumberOfTechnicians()
	{
		return this.NumOfTechnicians;
	}
	
	public int computeAnnualMaintenanceCostOfBomber()
	{
		int baseCost = 5000;
		//computing cost of weapons
		double weaponCost = this.computeAnnualMaintenanceOfWeapons();

		//computing technicians discount
		double discountPercent = (double) this.NumOfTechnicians/10;
		double actualDiscount = discountPercent*weaponCost;
		weaponCost = Math.floor(weaponCost-actualDiscount);
		return (int) (baseCost + weaponCost);
	}
	
	public void addBomberToFleet()
	{
		NumOfManufacturedBomber++;
	}
	
	@Override
	public String toString()
	{
		return (this.getClass().getSimpleName()+"\n\tName="+this.getName()+"\n\tCommissionYear="+
	this.getCommissionYear()+"\n\tMaximalSpeed="+this.getMaximalSpeed()+"\n\tFirePower="+
	this.getFirePower()+"\n\tCrewMembers="+this.getCrewMembers().size()+"\n\tAnnualMaintenanceCost="+
	this.getAnnualMaintenanceCost()+"\n\tWeaponArray="+this.getWeaponString()+"\n\tNumberOfTechnicians="+
	this.NumOfTechnicians);
	}
}


