public class Solution{
    public int reverse(int x) {
        int result = 0;

        while(x!=0) {
            int newResult = result*10 + x%10;
            x /= 10;
            if (newResult/10 != result) {
                result = 0;
                break;
            }
            result = newResult;
        }
        return result;
    }
}
