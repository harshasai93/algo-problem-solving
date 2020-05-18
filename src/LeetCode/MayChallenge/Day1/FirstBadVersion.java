package LeetCode.MayChallenge.Day1;
public class FirstBadVersion{
    public int firstBadVersion(int n) {

        // first bad version is 1 when only 1 version exists
        if(n == 1) return 1;

        // latest is the bad version
        int firstBad = n;

        // assign l,r variables for left and right boundaries of the search window
        // for Binary Search
        int l = 1;
        int r = n;

        while(l <= r){
            int m = l + (r-l)/2;
            boolean isBad = isBadVersion(m);

            // if middle is bad then store the middle in firstBad and continue
            // search in left space to the middle to find even earlier bad version
            if(isBad){
                firstBad = m;
                r = m-1;
            }else{
                // if middle is not bad search in the right space to the middle
                l = m+1;
            }
        }

        return firstBad;
    }

    private boolean isBadVersion(int m) {

        return true;
    }
}
