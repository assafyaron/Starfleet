package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends MyAbstractSpaceship {
	
	//fields
	private int CargoCapacity;
	private int PassengerCapacity;
	protected static int NumOfManufacturedTransportShip = 0;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		//calling MyAbstractSpaceship constructor
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.CargoCapacity = cargoCapacity;
		this.PassengerCapacity = passengerCapacity;
		this.AnnualMaintenanceCost = computeAnnualMaintenanceCostOfTransportShip();
		addTransportToFleet();
	}
	
	public int getCargoCapacity()
	{
		return this.CargoCapacity;
	}
	
	public int getPassengerCapacity()
	{
		return this.PassengerCapacity;
	}
	
	public int computeAnnualMaintenanceCostOfTransportShip()
	{
		int baseCost = 3000;
		
		//computing weight-cost
		baseCost += this.CargoCapacity*5;
		
		//computing passenger-cost
		baseCost += this.PassengerCapacity*3;
		
		return baseCost;
	}
	
	public String toString()
	{
		return (this.getClass().getSimpleName()+"\n\tName="+this.getName()+"\n\tCommissionYear="+
	this.getCommissionYear()+"\n\tMaximalSpeed="+this.getMaximalSpeed()+"\n\tFirePower="+
	this.getFirePower()+"\n\tCrewMembers="+this.getCrewMembers().size()+"\n\tAnnualMaintenanceCost="+
	this.getAnnualMaintenanceCost()+"\n\targoCapacity="+this.getCargoCapacity()+"\n\tPassengerCapacity="+
	this.PassengerCapacity);
	}
	
	public void addTransportToFleet()
	{
		NumOfManufacturedTransportShip++;
	}

}
