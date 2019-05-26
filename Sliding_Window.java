import java.util.HashMap;

/**
 * 
 */
/**
 * @author jitengirdhar
 *
 */


public class Sliding_Window{
	//Sliding window approach 
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int lenSubstring = 0;
        
        HashMap<Character, Integer> h = new HashMap<>();
        
        for(int i =0, j=0;j<n;j++)
        {
            if(h.containsKey(s.charAt(j))) //if the next string character is already in the substring.
            {
                i = Math.max(h.get(s.charAt(j)),i); //where the window starts from next
            }
            
            lenSubstring = Math.max(lenSubstring, j - i + 1); // when a new character is found.
            h.put(s.charAt(j),j+1); //put the new character in the hashmap.
            //the new substring starts from the next index where the repeating charcter was "first" found
        }
        
        return lenSubstring;
    }
	
	
}