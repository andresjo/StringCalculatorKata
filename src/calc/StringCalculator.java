package calc;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringCalculator {

	public int add(String inString) {
		if (inString.length() > 0){
			if (inString.length() == 1){
				return Integer.parseInt(inString);
			}else{
				if (inString.startsWith("//")){
					
					if (inString.contains("[")){
						String delimiter = "";
						
						while (inString.contains("[")){
							int startBracketPosition = inString.indexOf("[");
							int endBracketPosition = inString.indexOf("]");
							
							delimiter += inString.substring(startBracketPosition+1, endBracketPosition);
							inString = inString.substring(endBracketPosition+1);
						}
						
						String numbers = inString.substring(1);
						
						return splitAndSumNumbers(numbers, delimiter);
					}
					
					String delimiter = ""+inString.charAt(2);
					String numbers = inString.substring(4);
					
					return splitAndSumNumbers(numbers, delimiter);
				}
				String delimiter = ",|\n";
				return splitAndSumNumbers(inString, delimiter);
			}
		}
		return 0;
	}

	private int splitAndSumNumbers(String inString, String delimiter) {
		ArrayList<Integer> numbersList = splitNumbers(inString, delimiter);
		
		return  sumNumbers(numbersList);
	}

	private int sumNumbers(ArrayList<Integer> numbersList) {
		int sum = 0;
		
		for (Integer number : numbersList) {
			if ( number < 0){
				handleNegativeNumbers(numbersList);
			}else if(number < 1001){
				sum += number;
			}
		}
		
		return sum;
	}

	private ArrayList<Integer> splitNumbers(String inString, String delimiter) {
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		
		StringTokenizer tokenizedString = new StringTokenizer(inString);
		while(tokenizedString.hasMoreElements()){
			String currentNumb = tokenizedString.nextToken(delimiter);
			numbersList.add(Integer.parseInt(currentNumb));
		}
		return numbersList;
	}
	
	private void handleNegativeNumbers(ArrayList<Integer> numbersList) {
		String illegalArguments = "";
		
		for (Integer number : numbersList) {
			if (number < 0){
				illegalArguments += number+" ";
			}
		}
		
		throw new IllegalArgumentException("Negatives not allowed: "+illegalArguments);
	}

}