import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class freqCount {

    //brute force using Nested for loop
    public static String frequencySortBrute(String s) {
        int[] freq = new int[128]; // ASCII

        
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        StringBuilder result = new StringBuilder();

        while (result.length() < s.length()) {
            int maxFreq = 0;
            char maxChar = 0;

            for (int i = 0; i < 128; i++) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxChar = (char) i;
                }
            }

          
            for (int i = 0; i < maxFreq; i++) {
                result.append(maxChar);
            }

            freq[maxChar] = 0; 
        }

        return result.toString();
    }
    //optimal solution using Map

    public String frequencySortBetter(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> charList = new ArrayList<>(freqMap.keySet());
        charList.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            int freq = freqMap.get(c);
            while (freq-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }

    //Optimal solution
    
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        // Build result from highest freq to lowest
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Hello";
        String result = frequencySortBrute(str);
        System.out.println(result);
    }
}

