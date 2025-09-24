public class FractionAdditionAndSubtraction {
    public static String fractionAddition(String expression) {
        String[] exps = expression.split("(?=[+-])");
        long num = 0, den = 1;
        for(String subs : exps){
            String[] subsub = subs.split("/");
            long n = Long.parseLong(subsub[0]);
            long d = Long.parseLong(subsub[1]);
            num = num * d + den * n;
            den = den * d;
        }
        if(num == 0)  return "0/1";
        long gcd = gcd(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;
        return num + "/" + den;
    }
    public static long gcd(long a, long b){
        if(a == b)  return a;
        if(a > b)   return gcd(a-b, b);
        else    return gcd(a, b-a);
    }

    public static void main(String[] args) {
        String expression = "-1/2+1/2+1/3";
        System.out.println(fractionAddition(expression));
    }
}

//-1/2, 1/2
//1,2