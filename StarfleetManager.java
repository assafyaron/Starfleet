package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		
		//sorting using compare function from interface
		List<Spaceship> sortedFleet = new ArrayList<>(fleet);
		Collections.sort(sortedFleet);
		
		//changing all ships to strings
		List<String> sortedStringFleet = new ArrayList<>();
		for (int i=0;i<sortedFleet.size();i++)
		{
			sortedStringFleet.add(sortedFleet.get(i).toString());
		}
		return sortedStringFleet;
		
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		MyAbstractSpaceship.computeManufacturedMap();
		return MyAbstractSpaceship.NumOfManufactured;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalCost = 0;
		for (Spaceship currShip : fleet)
		{
			totalCost += currShip.getAnnualMaintenanceCost();
		}
		return totalCost;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponSet = new HashSet<String>();
		for (List<Weapon> weaponList : MyAbstractBattleship.AllWeapons)
		{
			for (Weapon currWeapon : weaponList)
			{
				if (!(weaponSet.contains(currWeapon.getName())))
				{
					weaponSet.add(currWeapon.getName());
				}
			}
		}
		return weaponSet;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int totalCrew = 0;
		for (Spaceship currShip : fleet)
		{
			totalCrew += currShip.getCrewMembers().size();
		}
		return totalCrew;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		double ageCnt = 0;
		double numOfOfficers = 0;
		//checking each ship
		for (Spaceship currShip : fleet)
		{
			//making a set of all Crew members
			Set<? extends CrewMember> currCrew = currShip.getCrewMembers();
			//checking every crew member
			for (CrewMember currMember : currCrew)
			{
				//only if he is an officer
				if (currMember instanceof Officer)
				{
					ageCnt += currMember.getAge();
					numOfOfficers++;
				}
			}
		}
		return (float) (ageCnt/numOfOfficers);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		//creating the hashmap and max rank cnt
		Map<Officer, Spaceship> rankShipMap = new HashMap<>();
		int rankCnt = 0;
		int rankValue = 0;
		Officer maxRankMember = new Officer("",0,0,OfficerRank.Ensign);
		
		//checking each ship
		for (Spaceship currShip : fleet)
		{
			//making a set of all Crew members
			Set<? extends CrewMember> currCrew = currShip.getCrewMembers();
			//checking every crew member
			for (CrewMember currMember : currCrew)
			{
				//only if he is an officer
				if (currMember instanceof Officer)
				{					
					//change rank to value
					rankValue = rankToNum(((Officer) currMember).getRank());
					//System.out.println(currShip.getName()+"|"+currMember.getName()+"|"+((Officer) currMember).getRank());
					//System.out.println(rankValue+"|"+rankCnt);
					//if it is higher
					if (rankValue > rankCnt)
					{
						//this is the current highest ranking officer
						maxRankMember = (Officer) currMember;
						rankCnt = rankValue;
					}
				}
			}
			//before changing ships
			rankShipMap.put(maxRankMember, currShip);
			rankCnt = 0;
		}
		return rankShipMap;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		int cnt0 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		int currRank =0;
		//checking each ship
		for (Spaceship currShip : fleet)
		{
			//making a set of all Crew members
			Set<? extends CrewMember> currCrew = currShip.getCrewMembers();
			//checking every crew member
			for (CrewMember currMember : currCrew)
			{
				//only if he is an officer
				if (currMember instanceof Officer)
				{
					currRank = rankToNum(((Officer) currMember).getRank());
					if (currRank == 0)
						cnt0++;
					else if (currRank == 1)
						cnt1++;
					else if (currRank == 2)
						cnt2++;
					else if (currRank == 3)
						cnt3++;
					else if (currRank == 4)
						cnt4++;
					else if (currRank == 5)
						cnt5++;
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> rankList = new ArrayList<Map.Entry<OfficerRank, Integer>>();
		if (cnt0 != 0)
			rankList.add(new AbstractMap.SimpleEntry<>(OfficerRank.Ensign,cnt0));
		if (cnt1 != 0)
		rankList.add(new AbstractMap.SimpleEntry<>(OfficerRank.Lieutenant,cnt1));
		if (cnt2 != 0)
		rankList.add(new AbstractMap.SimpleEntry<>(OfficerRank.LieutenantCommander,cnt2));
		if (cnt3 != 0)
		rankList.add(new AbstractMap.SimpleEntry<>(OfficerRank.Commander,cnt3));
		if (cnt4 != 0)
		rankList.add(new AbstractMap.SimpleEntry<>(OfficerRank.Captain,cnt4));
		if (cnt5 != 0)
		rankList.add(new AbstractMap.SimpleEntry<>(OfficerRank.Admiral,cnt5));
		//calling on comparator constructor
		RankNumOfOfficersComparator entryComparator = new RankNumOfOfficersComparator();
		rankList.sort(entryComparator);
		return rankList;
	}
	
	public static Set<String> getFleetShipTypeSet(Collection<Spaceship> fleet)
	{
		Set<String> allShipTypes = new HashSet<>();
		for (Spaceship currShip : fleet)
		{
			if (!(allShipTypes.contains(currShip.getClass().getSimpleName())))
			{
				allShipTypes.add(currShip.getClass().getSimpleName());
			}
		}
		return allShipTypes;
		
	}
	
	public static int rankToNum(OfficerRank rank)
	{
		if (rank.equals(OfficerRank.Ensign))
			return 0;
		else if (rank.equals(OfficerRank.Lieutenant))
			return 1;
		else if (rank.equals(OfficerRank.LieutenantCommander))
			return 2;
		else if (rank.equals(OfficerRank.Commander))
			return 3;
		else if (rank.equals(OfficerRank.Captain))
			return 4;
		else return 5;
	}
}
