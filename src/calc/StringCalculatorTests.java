package calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTests {
	
	StringCalculator stringCalc = new StringCalculator();

	@Test
	public void Add_InputEmptyString_Returns0() {
		int expected = 0;
		int actual = stringCalc.add("");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputSingleDigit_ReturnsDigit() {
		int expected = 1;
		int actual = stringCalc.add("1");
		
		assertEquals(expected, actual);
	}

	@Test
	public void Add_InputTwoDigits_ReturnsSum() {
		int expected = 3;
		int actual = stringCalc.add("1,2");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputFiveDigits_ReturnsSum() {
		int expected = 15;
		int actual = stringCalc.add("1,2,3,4,5");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputThreeeDigitsWithNewLine_ReturnsSum() {
		int expected = 6;
		int actual = stringCalc.add("1\n2,3");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputDigitsWithCustomDelimiter_ReturnsSum() {
		int expected = 3;
		int actual = stringCalc.add("//;\n1;2");
		
		assertEquals(expected, actual);
	}
	
	@Test (expected = Exception.class)
	public void Add_InputNegativeNumber_ThrowsException() {
		int expected = 3;
		int actual = stringCalc.add("1,2,-2,3,-1");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputNumberOver1000_NumberIsIgnored() {
		int expected = 2;
		int actual = stringCalc.add("2,1001");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputWithCustomDelimiterOfAnyLength_ReturnsSum() {
		int expected = 6;
		int actual = stringCalc.add("//[***]\n1***2***3");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputWithMultipleDelimiters_ReturnsSum() {
		int expected = 6;
		int actual = stringCalc.add("//[*][%]\n1*2%3");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Add_InputWithMultipleDelimitersOfAnyLength_ReturnsSum() {
		int expected = 6;
		int actual = stringCalc.add("//[***][%%%]\n1***2%%%3");
		
		assertEquals(expected, actual);
	}
}
