package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public interface Spaceship extends Comparable<Spaceship> {
	
	/* @pre: spaceship != null */
	public String getName();
	
	/* @pre: spaceship != null */
	public int getCommissionYear();
	
	/* @pre: spaceship != null
	 * @post: $ret <= 10 && $ret >= 0 */
	public float getMaximalSpeed();
	
	/* @pre: spaceship != null
	 * @post: $ret >= 10 */
	public int getFirePower();
	
	/* @pre: spaceship != null
	 * @post: $ret > ? */
	public Set<? extends CrewMember> getCrewMembers();
	
	/* @pre: spaceship != null
	 * @post: $ret >= 0 */
	public int getAnnualMaintenanceCost();
	
	public int compareTo(Spaceship otherSpaceship);
}
