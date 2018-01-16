
public class PermutationPalindrome {

	static int getCharValue(char ip) {
		int a = Character.getNumericValue('a');
		int b = Character.getNumericValue('z');
		int val = Character.getNumericValue(ip);
		if (a <= val && val <= b) {
			return val - a;
		}
		return -1;
	}

	static boolean permPali(String s) {
		char[] ch = s.toCharArray();
		int countOfOdd = 0;
		int[] count = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : ch) {
			int val = getCharValue(c);
			if (val != -1) {
				count[val]++;
				if (count[val] % 2 == 1) {
					countOfOdd++;
				} else {
					countOfOdd--;
				}
			}
		}
		return (countOfOdd <= 1);
	}

	static int update(int bitVector, int index) {
		if (index < 0)
			return bitVector;
		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}

	static int getBitVector(String s) {
		char[] ch = s.toCharArray();
		int bitVector = 0;
		for (char c : ch) {
			int x = getCharValue(c);
			bitVector = update(bitVector, x);
		}
		return bitVector;
	}

	static boolean isOnlyOneOdd(int bitVector) {
		return ((bitVector & (bitVector - 1)) == 0);
	}

	static boolean isPermPali(String s) {
		int bitVector = getBitVector(s);
		return (bitVector == 0) || (isOnlyOneOdd(bitVector));
	}

	public static void main(String[] args) {
		String str = "Tactsdswcoa";
		System.out.println(permPali(str.toLowerCase()));
		System.out.println(isPermPali(str.toLowerCase()));
	}
}
