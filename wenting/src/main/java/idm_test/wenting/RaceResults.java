package idm_test.wenting;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class RaceResults {

	HashMap<String, TimeDuration> raceResults;

	public RaceResults() {
		this.raceResults = new HashMap<String, TimeDuration>();
	}

	public void onNewResult(String tagNumber, TimeDuration resultTime) {
		this.raceResults.put(tagNumber, resultTime);
	}

	public void printResults() {
		List<Map.Entry<String, TimeDuration>> list = new LinkedList<Map.Entry<String, TimeDuration>>(
				this.raceResults.entrySet());

		Collections.sort(list,
				new Comparator<Map.Entry<String, TimeDuration>>() {
					public int compare(Entry<String, TimeDuration> o1,
							Entry<String, TimeDuration> o2) {
						return o1.getValue().getSeconds()
								- o2.getValue().getSeconds();
					}

				});
		
		if (list.size() == 0) {
			System.out.println("no result.");
		}

		else {
			int rank = 1;
			System.out.println("# 1 : contestant " + list.get(0).getKey()
					+ ", duration: " + list.get(0).getValue().getSeconds());

			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getValue().getSeconds() > list.get(i - 1)
						.getValue().getSeconds()) {
					rank++;
				}

				System.out.println("# " + rank + " : contestant "
						+ list.get(i).getKey() + ", duration: "
						+ list.get(i).getValue().getSeconds());

			}
		}
	}
	
	// When two contestants have the same TimeDuration, they tie for the same place, and have the same rank.
	public static void main(String[] args) throws BadBadValueException {

		RaceResults re = new RaceResults();

		re.onNewResult("1", new TimeDuration(150));
		re.onNewResult("2", new TimeDuration(150));
		re.onNewResult("3", new TimeDuration(180));
		re.onNewResult("4", new TimeDuration(122));
		re.onNewResult("5", new TimeDuration(190));
		re.onNewResult("6", new TimeDuration(200));

		System.out.println("Race Result : ");
		re.printResults();
	}
}
