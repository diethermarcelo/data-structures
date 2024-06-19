
public class LeetCode {
    public int strStr(String haystack, String needle) {
		int needleLength = needle.length();
				
		int index = -1;
		
		for(int h = 0; h < haystack.length(); h++) {
			int plusNeedleLength = h + needleLength;
			if(plusNeedleLength > haystack.length()) {
				break;
			}
			String currentHaystackSubstring = haystack.substring(h, plusNeedleLength);
			if(needle.equals(currentHaystackSubstring)){
				index = h;
				break;
			}				
		}
		
		return index;
    }
}
