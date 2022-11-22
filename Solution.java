import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String ... args) {
        Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
        registerStatus.put(1, 30); // One Dolar, 30 bills;
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 3); // Five Dolar, 3 bills;
        registerStatus.put(10, 2); // Ten Dolar, 2 bills;
        registerStatus.put(20, 1); // twenty Dolar, 2 bills;
        registerStatus.put(50, 0); // fifhty Dolar, 2 bills;
        registerStatus.put(100, 0); // One hundred Dolar, 2 bills;

        boolean result = canIGiveChange(registerStatus, 100, 9);
        System.out.printf("Result " + result);

    }


    public static boolean canIGiveChange(Map<Integer,Integer> registerStatus, Integer customerPayment, Integer productCost) {
        int[] b = new int[]{1, 2, 5, 10, 20, 50, 100};
        int[] c = new int[b.length];
        try{
            for(int i = 0; i < b.length; i ++){
                c[i] = registerStatus.get(b[i]);
            }
        }
        catch(Exception e){}
        int sum = customerPayment - productCost;
        int t0, t1, t2, t3, t4, t5, t6;
        for(t6 = c[6]; t6 >= 0; t6--){
            if(b[6] * t6 > sum) continue;
            sum -= b[6] * t6;
            for(t5 = c[5]; t5 >= 0; t5--){
                if(t5 * b[5] > sum) continue;
                sum -= t5 * b[5];
                for(t4 = c[4]; t4 >= 0; t4--){
                    if(t4 * b[4] > sum) continue;
                    sum -= t4 * b[4];
                    for(t3 = c[3]; t3 >= 0; t3--){
                        if(t3 * b[3] > sum) continue;
                        sum -= t3 * b[3];
                        for(t2 = c[2]; t2 >= 0; t2--){
                            if(t2 * b[2] > sum) continue;
                            sum -= t2 * b[2];
                            for(t1 = c[1]; t1 >= 0; t1--){
                                if(t1 * b[1] > sum) continue;
                                sum -= t1 * b[1];
                                if(sum / b[0] <= c[0]) return true;
                                sum += t1 * b[1];
                            }
                            sum += t2 * b[2];
                        }
                        sum += t3 * b[3];
                    }
                    sum += t4 * b[4];
                }
                sum += t5 * b[5];
            }
            sum += b[6] * t6;
        }
        return false;
    }

}