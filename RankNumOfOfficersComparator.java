package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

class RankNumOfOfficersComparator implements Comparator<Map.Entry<OfficerRank, Integer>>
{
	public RankNumOfOfficersComparator()
	{
        //No initialization or logic required
	}

	@Override
	public int compare(Entry<OfficerRank, Integer> entry1, Entry<OfficerRank, Integer> entry2) {
		if (entry1.getValue() != entry2.getValue())
		{
			return Integer.compare(entry1.getValue(), entry2.getValue());
		}
		else
		{
			return Integer.compare(StarfleetManager.rankToNum(entry1.getKey()), StarfleetManager.rankToNum(entry2.getKey()));
		}
	}
}