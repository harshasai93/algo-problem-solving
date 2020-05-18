package LeetCode.MayChallenge.Day18;

import java.util.HashMap;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        int s1Len = s1.length();
        HashMap<Character, Integer> s1Sig = new HashMap<>();

        for(int i = 0; i < s1Len; i++){
            s1Sig.put(s1.charAt(i), s1Sig.getOrDefault(s1.charAt(i), 0)+1);
        }

        int start = 0, end = 0;
        int matched = 0;

        while(end < s2.length()){
            if(matched < s1Len) {
                if (s1Sig.containsKey(s2.charAt(end))) {
                    if (s1Sig.get(s2.charAt(end)) > 0) {
                        matched++;
                    }
                    s1Sig.put(s2.charAt(end), s1Sig.get(s2.charAt(end)) - 1);
                }
            }
            while(matched == s1Len){
                if(s1Len == end-start+1){
                    return true;
                }
                if(s1Sig.containsKey(s2.charAt(start))){
                    if(s1Sig.get(s2.charAt(start)) >= 0){
                        matched--;
                    }
                    s1Sig.put(s2.charAt(start), s1Sig.get(s2.charAt(start)) + 1);
                }
                start++;
            }
            end++;
        }
        return false;
    }
}
