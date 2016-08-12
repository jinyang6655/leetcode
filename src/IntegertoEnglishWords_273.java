/**
 * Created by yjin on 8/11/16.
 */
public class IntegertoEnglishWords_273 {
    public String numberToWords(int num) {
        String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
        if(num==0) return "Zero";
        int w=1000000000;
        String result="";
        for(int i=3;i>=0;i--){
            int val=num/w;
            if(val!=0){
                result+=this.translateHundreds(val,LESS_THAN_20,TENS);
                result+=" "+THOUSANDS[i]+" ";
                num=num-val*w;
            }
            w=w/1000;
        }
        return result.trim();
    }

    public String translateHundreds(int num,String[] LESS_THAN_20,String[] TENS){
        StringBuffer buffer=new StringBuffer();
        int hundreds=num/100;
        if(hundreds!=0){
            buffer.append(LESS_THAN_20[hundreds]+" Hundred ");
        }
        num=num-hundreds*100;
        if(num<20){
            buffer.append(LESS_THAN_20[num]+" ");
            return buffer.toString().trim();
        }
        int tens=num/10;
        buffer.append(TENS[tens]+" ");
        num=num-tens*10;
        if(num==0) return buffer.toString().trim();
        buffer.append(LESS_THAN_20[num]);
        return buffer.toString().trim();
    }

    public static void main(String[] args){
        int num=1234560000;
        IntegertoEnglishWords_273 sol=new IntegertoEnglishWords_273();
        System.out.println(sol.numberToWords(num));
    }

}
