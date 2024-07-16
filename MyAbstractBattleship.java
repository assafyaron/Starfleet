package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;


public abstract class MyAbstractBattleship extends MyAbstractSpaceship {
	
	//fields
	protected List<Weapon> Weapons;
	protected static List<List<Weapon>> AllWeapons = new ArrayList<List<Weapon>>();
	
	//constructor
	MyAbstractBattleship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons)
	{
		//calling MyAbstractSpaceship constructor
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.Weapons = weapons;
		addWeapon(weapons);
		
		//updating fire power
		for (Weapon currWeapon : weapons)
		{
			this.FirePower += currWeapon.getFirePower();
		}
	}
	
	public List<Weapon> getWeapon()
	{
		return this.Weapons;
	}
	
	public void addWeapon(List<Weapon> weapons)
	{
		AllWeapons.add(weapons);
	}
	
	public int computeAnnualMaintenanceOfWeapons()
	{
		int annualCost = 0;
		for (Weapon weapon : this.getWeapon())
		{
			annualCost += weapon.getAnnualMaintenanceCost();
		}
		return annualCost;
	}
	
	public String getWeaponString()
	{
		String printMessage = "[";
		for (Weapon weapon : this.getWeapon())
		{
			printMessage += weapon.toString();
		}
		printMessage += "]";
		return printMessage;
	}
	
	public String toString()
	{
			return (this.getClass().getSimpleName()+"\n\tName="+this.getName()+"\n\tCommissionYear="+
		this.getCommissionYear()+"\n\tMaximalSpeed="+this.getMaximalSpeed()+"\n\tFirePower="+
		this.getFirePower()+"\n\tCrewMembers="+this.getCrewMembers().size()+"\n\tAnnualMaintenanceCost="+
		this.getAnnualMaintenanceCost()+"\n\tWeaponArray="+this.getWeaponString());
	}
}
