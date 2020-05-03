public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        // return
        if(n == 1) return 1;
        int firstBad = n;

        int l = 1;
        int r = n;

        while(l <= r){

            int m = l + (r-l)/2;
            boolean isBad = isBadVersion(m);

            if(isBad){
                firstBad = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return firstBad;
    }
}
