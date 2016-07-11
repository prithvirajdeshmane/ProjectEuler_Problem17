import java.util.Hashtable;

public class NumbersSpeltOut {

	private static Hashtable<Integer, String> table = buildBasicLookupTable();
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sumOfLengthsOfSpeltOutNumbers = 0;
		
		for (int i = 1; i <= 999; i++) {
			sumOfLengthsOfSpeltOutNumbers += findLengthOfSpeltOutNumber(i);
		}
		
		//For the number 1000
		String stringFor1000 = "onethousand";
		sumOfLengthsOfSpeltOutNumbers += stringFor1000.length();
		
		System.out.println(sumOfLengthsOfSpeltOutNumbers);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken in ms: " + (endTime - startTime));
	}
	
	private static int findLengthOfSpeltOutNumber(int num)
	{
		return spellOutNumber(num).length();
	}
	
	private static StringBuilder spellOutNumber(int num)
	{
		StringBuilder speltOut = new StringBuilder();
		
		int hundreds = num / 100;
		int twoDigitQuotient = num % 100;
		int tens = twoDigitQuotient / 10;
		int units = twoDigitQuotient % 10;
		
		if(hundreds != 0) 
		{
			speltOut.append(table.get(hundreds)).append("hundred");
		}
		if(twoDigitQuotient != 0)
		{
			if(hundreds != 0)
			{
				speltOut.append("and");
			}
			if(twoDigitQuotient >= 1 && twoDigitQuotient <= 19)
			{
				speltOut.append(table.get(twoDigitQuotient));
			}
			else
			{
				speltOut.append(table.get(tens * 10));
				
				if(units != 0)
				{
					speltOut.append(table.get(units));
				}
			}
		}
		return speltOut;
	}
	
	private static Hashtable<Integer, String> buildBasicLookupTable()
	{
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		
		table.put(1, "one");
		table.put(2, "two");
		table.put(3, "three");
		table.put(4, "four");
		table.put(5, "five");
		table.put(6, "six");
		table.put(7, "seven");
		table.put(8, "eight");
		table.put(9, "nine");
		table.put(10, "ten");
		table.put(11, "eleven");
		table.put(12, "twelve");
		table.put(13, "thirteen");
		table.put(14, "fourteen");
		table.put(15, "fifteen");
		table.put(16, "sixteen");
		table.put(17, "seventeen");
		table.put(18, "eighteen");
		table.put(19, "nineteen");
		table.put(20, "twenty");
		table.put(30, "thirty");
		table.put(40, "forty");
		table.put(50, "fifty");
		table.put(60, "sixty");
		table.put(70, "seventy");
		table.put(80, "eighty");
		table.put(90, "ninety");
		
		return table;
	}
}
