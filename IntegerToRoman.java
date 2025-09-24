public class IntegerToRoman {
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        process(sb, 'M', 'M', 'M', num / 1000);
        num = num % 1000;

        process(sb, 'C', 'D', 'M', num / 100);
        num %= 100;

        process(sb, 'X', 'L', 'C', num / 10);
        num %= 10;

        process(sb, 'I', 'V', 'X', num);

        return sb.toString();
    }

    public void process(StringBuilder sb, char minor, char mid, char major, int num){
        if(num <= 3){
            for(int i=1; i<=num; i++){
                sb.append(minor);
            }
        }
        else if(num == 4){
            sb.append(minor);
            sb.append(mid);
        }else if(num == 5){
            sb.append(mid);
        }
        else if(num <= 8){
            sb.append(mid);
            for (int i = 6; i <= num; i++) {
                sb.append(minor);
            }
        }else if(num == 9){
            sb.append(minor);
            sb.append(major);
        }
    }

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        int n = 58;
        System.out.println(itr.intToRoman(n));


    }

}
