import java.util.LinkedList;

public class EnglishInt {

	static String[] smalls = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen"};
	static String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String[] bigs = {"", "thousand", "million", "billion"};
	static String hundred = "hundred";
	static String negative = "negative";

	static String listToString(LinkedList<String> list) {
		StringBuilder sb = new StringBuilder();
		while(list.size() > 1) {
			sb.append(list.pop() + " ");
		}
		sb.append(list.pop());
		return sb.toString();
	}
	static String convertChunk(int num) {
		LinkedList<String> parts = new LinkedList<String>();
		if(num>=100) {
			parts.addLast(smalls[num/100]);
			parts.addLast(hundred);
			num %= 100;
		}
		if(num>=10 && num<=19) {
			parts.addLast(smalls[num]);
		} else {
			parts.addLast(tens[num/10]);
			num %= 10;
		}
		if(num>=1 && num<=9) {
			parts.addLast(smalls[num]);
		}
		return listToString(parts);
	}
	static String convert(int num) {
		if(num == 0) {
			return smalls[0];
		} else if(num <0) {
			return ("negative " + convert(-1*num));
		}
		LinkedList<String> parts = new LinkedList<String>();
		int count = 0;
		while(num > 0) {
			if(num %1000 != 0) {
				String chunk = convertChunk(num%1000) + " " + bigs[count];
				parts.addFirst(chunk);
			}
			num = num/1000;
			count++;
		}
		return listToString(parts);
	}
	public static void main(String[] args) {
		System.out.println(convert(1119));
	}
}
