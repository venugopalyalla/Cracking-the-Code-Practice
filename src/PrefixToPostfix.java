import java.util.Stack;

public class PrefixToPostfix {
	static String[] prefixToPostfix(String[] prefixes) {
        String[] postfixes = new String[prefixes.length];
        if(prefixes == null || prefixes.length == 0) return postfixes;
        
        for(int i =0; i< prefixes.length; i++){
            String prefix = prefixes[i];
            if(prefix == null || prefix.isEmpty())
                postfixes[i] = null;
            else
                postfixes[i] = getPostFix(prefixes[i]);
        }
        return postfixes;
    }

    static String getPostFix(String prefix){
        int prefixLength = prefix.length();
        Stack<String> stack = new Stack<>();
        
        for(int i = prefixLength -1; i >= 0 ; i--){
            char ch = prefix.charAt(i);
            if(!isOperator(ch)) stack.push(ch+"");
            else{
            	if(stack.size()>=2) {
                    String top1 = stack.pop();
                    String top2 = stack.pop();
                    
                    String newTop = top1 + top2 + ch;
                    stack.push(newTop);
            	} else {
            		return "Invalid prefix expression : " + prefix;
            	}
            }
            
        }
        StringBuffer postFix = new StringBuffer();
        while(!stack.isEmpty()) {
            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

    static boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch =='/') return true;
        return false;
    }
    public static void main(String[] args) {
    	String[] strings = new String[1];
    	strings[0] = "+AB";
    	String[] postfixes = prefixToPostfix(strings);
    	System.out.println(postfixes[0]);
    }
}
