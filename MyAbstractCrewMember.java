package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class MyAbstractCrewMember implements CrewMember {
	
	//fields
	private int Age;
	private int YearsInService;
	private String Name;
	
	//constructor
	MyAbstractCrewMember(int age, int yearsInService, String name)
	{
		this.Age = age;
		this.YearsInService = yearsInService;
		this.Name = name;
	}
	
	//methods implementing interface

	public String getName()
	{
		return this.Name;
	}
	
	public int getAge()
	{
		return this.Age;
	}
	
	public int getYearsInService()
	{
		return this.YearsInService;
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
		MyAbstractCrewMember other = (MyAbstractCrewMember) obj;
		return Objects.equals(Name, other.Name);
	}
}
