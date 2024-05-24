
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        System.out.println("Hello, World!");

    }

    public int characterReplacement(String s, int k) {
        // create variables: window bounds, condition tracking, and result
        int left = 0;
        int right = 0;
        int[] charArray = new int[26]; // to keep track of the freq of each letter
        int maxFreq = Integer.MIN_VALUE;

        // iterate through elements
        while (right < s.length()) {
            // expand window and process right element
            charArray[s.charAt(right) - 'A']++;
            // keep track of the character with max freq
            maxFreq = Math.max(maxFreq, charArray[s.charAt(right) - 'A']); 

            // check stop condition: reached the limit of k operations 
            // if the other letters # freq is greater than k
            if ((right - left + 1) - maxFreq > k) {
                
                // shrink the window and process the left element 
                charArray[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        
        return right - left;
    }
}
