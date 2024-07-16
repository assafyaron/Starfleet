package il.ac.tau.cs.sw1.ex9.starfleet;

public interface CrewMember {
	
	/* @pre: crewMember != null */
	public String getName();
	
	/* @pre: crewMember != null 
	 * @post: $ret >= 0 */
	public int getAge();
	
	/* @pre: crewMember != null */
	public int getYearsInService();
	
}
