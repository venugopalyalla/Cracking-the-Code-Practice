import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordRemTest {
	public static final String TEST_STRING = "Thethe the test is  a new the thethe of the system of latest the thethe body";
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-zA-Z])*([a-zA-Z])\\2([a-zA-Z])*");
		Matcher m = p.matcher(TEST_STRING);
		System.out.println(m.matches());
	}
}
