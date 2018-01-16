public class FibRev {
	public static int f(int n){
	    if (n <= 1)
	        return n;
	    else 
	        return f(n-1) + f(n-2);
	}

	static void printReverseFib(int x){
	    if(x <= 1)
	        System.out.println(f(x));
	    else{
	        System.out.println(f(x));
	        printReverseFib(x-1);
	    }
	}

    public static void main(String[] args) {
        printReverseFib(5);
    }
}