import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("test/test_cases.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int test_cases = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 0; test_case < test_cases; test_case++ ) {
			String line = sc.nextLine();
			System.out.println("line: " + line);
			String[] splittedLine = line.split(" ");
			checkFirstOccurence(splittedLine[0], splittedLine[1]);
			
		}
		
		sc.close();
		
	}

	public static void checkFirstOccurence(String haystack, String needle) {

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
		
		System.out.println("Index is " + index);
	}
}
