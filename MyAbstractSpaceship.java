package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class MyAbstractSpaceship implements Spaceship {
	
	//fields 
	private String Name;
	private int CommissionYear;
	private float MaximalSpeed;
	protected int FirePower;
	private Set<? extends CrewMember> CrewMembers;
	protected int AnnualMaintenanceCost;
	protected static Map<String,Integer> NumOfManufactured = new HashMap<>();
	
	//constructor
	MyAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers)
	{
		this.Name = name;
		this.CommissionYear = commissionYear;
		this.MaximalSpeed = maximalSpeed;
		this.CrewMembers = crewMembers;
		//default for all ships
		this.FirePower = 10;
	}
	
	//methods implementing interface
	
	public String getName()
	{
		return this.Name;
	}
	
	public int getCommissionYear()
	{
		return this.CommissionYear;
	}
	
	public float getMaximalSpeed()
	{
		return this.MaximalSpeed;
	}
	
	public int getFirePower()
	{
		return this.FirePower;
	}
	
	public Set<? extends CrewMember> getCrewMembers()
	{
		return this.CrewMembers;
	}
	
	public int getAnnualMaintenanceCost()
	{
		return this.AnnualMaintenanceCost;
	}
	
	public static void computeManufacturedMap()
	{
		MyAbstractSpaceship.NumOfManufactured.put("Bomber", Bomber.NumOfManufacturedBomber);
		MyAbstractSpaceship.NumOfManufactured.put("ColonialViper", ColonialViper.NumOfManufacturedColonialViper);
		MyAbstractSpaceship.NumOfManufactured.put("CylonRaider", CylonRaider.NumOfManufacturedCylonRaider);
		MyAbstractSpaceship.NumOfManufactured.put("Fighter", Fighter.NumOfManufacturedFighter-StealthCruiser.NumOfManufacturedStealthCruiser);
		MyAbstractSpaceship.NumOfManufactured.put("TransportShip", TransportShip.NumOfManufacturedTransportShip);
		MyAbstractSpaceship.NumOfManufactured.put("StealthCruiser", StealthCruiser.NumOfManufacturedStealthCruiser);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAbstractSpaceship other = (MyAbstractSpaceship) obj;
		return Objects.equals(Name, other.Name);
	}
	
	@Override
	public int compareTo(Spaceship otherSpaceship)
	{
		if (!(this.FirePower == otherSpaceship.getFirePower()))
		{
			return Integer.compare(otherSpaceship.getFirePower(), this.FirePower);
		}
		else if (!(this.CommissionYear == otherSpaceship.getCommissionYear()))
		{
			return Integer.compare(otherSpaceship.getCommissionYear(), this.CommissionYear);
		}
		else
		{
			return this.Name.compareTo(otherSpaceship.getName());
		}
	}
}
