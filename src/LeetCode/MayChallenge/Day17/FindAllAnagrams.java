package LeetCode.MayChallenge.Day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();

        if(pLen > sLen) return new ArrayList<>();
        //rolling window problem
        // calculate p signature
        HashMap<Character,Integer> pSig = new HashMap<>();
        for(int i = 0; i < pLen; i++){
            pSig.put(p.charAt(i), pSig.getOrDefault(p.charAt(i),0)+1);
        }

        // calculate initial s signature
        HashMap<Character,Integer> sSig = new HashMap<>();
        for(int i = 0; i < pLen; i++){
            sSig.put(s.charAt(i), sSig.getOrDefault(s.charAt(i),0)+1);
        }

        List<Integer> result = new ArrayList<>();

        if(sSig.equals(pSig)){
            result.add(0);
        }

        for(int i = pLen; i < sLen; i++){
            sSig.put(s.charAt(i- pLen), sSig.getOrDefault(s.charAt(i- pLen),0)-1);
            if(sSig.get(s.charAt(i- pLen)) == 0) sSig.remove(s.charAt(i- pLen));
            sSig.put(s.charAt(i), sSig.getOrDefault(s.charAt(i),0)+1);

            if(sSig.equals(pSig)){
                result.add(i-pLen+1);
            }
        }
        return result;
    }
}