import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		System.setIn(new FileInputStream("test/test_cases.txt"));
		
		
		Scanner sc = new Scanner(System.in);
		
		int test_cases = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 0; test_case < test_cases; test_case++) {
				
			String line = sc.nextLine();
			boolean isValid = isValidParenthesisThree(line);
			System.out.printf("%s is %s \n", line, isValid);
		}
		
	}
	
	public static boolean willPop(Character symbol, Character previousSymbol) {
//		System.out.println("Symbol: " + symbol);
//		System.out.println("Previous Symbol: " + previousSymbol);
		
		if(
			(symbol.equals(')') && previousSymbol.equals('(')) || 
			(symbol.equals('}') && previousSymbol.equals('{')) || 
			(symbol.equals(']') && previousSymbol.equals('[')) 
		) {
			return true;
		}
			
		return false;
	}
	
	public static boolean isFirstParenthesis(Character symbol) {
		if(symbol.equals('(') || symbol.equals('[') || symbol.equals('{')) return true;
		return false;
	}

	public static boolean isLastParenthesis(Character symbol) {
		if(symbol.equals(')') || symbol.equals(']') || symbol.equals('}')) return true;
		return false;
	}
	
	public static boolean isValidParenthesisFour(String symbols) {
		boolean isValid = false;
		
		Stack<Character> newStack = new Stack<>();
		char[] symbolsArr = symbols.toCharArray();

		
		for(int i = 0; i < symbolsArr.length; i++) {
			Character symbol = symbols.charAt(i);
			if(isFirstParenthesis(symbol)) {
				newStack.push(symbol); 
				continue;				
			}
			
			if(isLastParenthesis(symbol)) {
				System.out.println("symbol" + symbol);
				Character previousSymbol = newStack.lastElement();
				if(willPop(symbol, previousSymbol)){ 
					System.out.println("popped");
					newStack.pop();
				} else {
					break;
				}
			}
				
			
		}
		
		if(newStack.isEmpty()) {
			isValid = true;
		}
		
		
		return isValid;
	}
	
	public static boolean isValidParenthesisThree(String symbols) {
		boolean isValid = false;
		
		Stack<Character> newStack = new Stack<>();
		char[] symbolsArr = symbols.toCharArray();

		
		for(int i = 0; i < symbolsArr.length; i++) {
			Character symbol = symbols.charAt(i);
			if(isFirstParenthesis(symbol)) {
				newStack.push(symbol); 
				continue;				
			}
			
			if(newStack.isEmpty()) {
				newStack.push(symbol);
				break;
			}
				
			Character previousSymbol = newStack.lastElement();
			
			if(willPop(symbol, previousSymbol)){ 
				newStack.pop();
				continue;
			} 
			break;
		}
		
		if(newStack.isEmpty()) {
			isValid = true;
		}
		
		
		return isValid;
	}
	
	public static boolean isValidParenthesisTwo(String symbols) {
		boolean isValid = false;
		
		Stack<Character> newStack = new Stack<>();
		
		for(Character symbol: symbols.toCharArray()) {
			newStack.push(symbol);
		}
		
		
		while(!newStack.isEmpty()) {
			Character closing = newStack.pop();

			if(newStack.isEmpty()) break;
				
			Character opening = newStack.pop();	
			

			boolean isLast = newStack.isEmpty();
			
			boolean isStillValid = false;
			
			switch (closing) {
			case '}':
				isStillValid = opening.equals('{');
				break;
			case ')':
				isStillValid = opening.equals('(');
				break;
			case ']':
				isStillValid = opening.equals('[');
				break;
			}
			if(isStillValid && isLast) isValid = true;
		}
		
		return isValid;
	}
	
	public static boolean IsValidParenthesis(String symbols) {
		boolean isValid = true;
		
		Stack<Character> newStack = new Stack<>();
		
		for(int i = 0; i < symbols.length() - 1; i+=2){
			

			if(newStack.isEmpty()) {		
				newStack.push(symbols.charAt(i));
				continue;
			}
			
			Character poppedSymbol = newStack.pop();
			System.out.println("Popped Symbol: " + poppedSymbol);
			
			char mustNextSymbol = Character.MIN_VALUE;
			
			switch(poppedSymbol) {
				case '(':
					mustNextSymbol = ')';
					break;
				case '[':
					mustNextSymbol = ']';
					break;
				case '{':
					mustNextSymbol = '}';
					break;
			}
			
			
			if(symbols.charAt(i + 1) != mustNextSymbol) isValid = false;
		}
		
		return isValid;
	}
}
