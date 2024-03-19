import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int p) {
        HashMap<Character, Integer> mp = new HashMap<>();
        
        for (char ch : tasks) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for (int count : mp.values()) {
            pq.add(count);
        }
        
        int time = 0;
        
        while (!pq.isEmpty()) {
            int interval = p + 1;
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < interval; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }
            
            for (int count : temp) {
                if (--count > 0) {
                    pq.add(count);
                }
            }
            
            time += pq.isEmpty() ? temp.size() : interval;
        }
        
        return time;
    }
}
