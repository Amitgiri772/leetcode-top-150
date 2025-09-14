package contests.biweekly_165;

import java.util.HashMap;
import java.util.Map;

public class MinimumDiscardsToBalanceInventory {

  public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
    int i = 0;
    int j = 0;
    int discarded = 0;
    Map<Integer, Integer> freqMap = new HashMap<>();

    // To not to remove a value that was not added to the map
    boolean[] added = new boolean[arrivals.length];
    while (j < arrivals.length) {
      int arrived = arrivals[j];
      freqMap.computeIfAbsent(arrived, k -> 0);

      if (j - i == w) {
        if (added[i]) {
          int removalItem = arrivals[i];
          freqMap.computeIfPresent(removalItem, (item, itemFreq) -> itemFreq - 1);
        }
        i++;
      }

      int freq = freqMap.get(arrived);
      if (freq < m) {
        // allowed to keep the item
        freqMap.computeIfPresent(arrived, (item, itemFreq) -> itemFreq + 1);
        added[j] = true;
      } else {
        // Item must be discarded
        discarded++;
      }
      j++;
    }
    return discarded;
  }
}
