import java.util.*;
public class Solution {
    public String convert(String s, int numRows) {
        String res = "";
        
        ArrayList<List<String>> list = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<String>());
        }

        char[] charArr = s.toCharArray();
        
        int[] pattern = getIndexPattern(numRows);

        for (int i=0; i<charArr.length;i++){
            int row = pattern[i%pattern.length];
            list.get(row).add(String.valueOf(charArr[i]));
        }
        
        for (int i=0; i<list.size(); i++){
            StringBuilder sb = new StringBuilder();
            for (Object o: list.get(i)){
                sb.append(o);
            }
            res += sb;
        }
        
        return res;
    }
    
    public int[] getIndexPattern(int n){
        
        if (n == 1){
          int[] indexPattern = {0};
          return indexPattern;
        }
        
        int size = (n-1)*2;
        int[] indexPattern = new int[size];
        for (int i=0;i<size;i++){
            if(i<n){
                indexPattern[i] = i;
            }
            else{
                indexPattern[i] = (n-1)-(i-(n-1));
            }
        }
        return indexPattern;
    }

    public static void Solution(String args[]) {
        Solution s = new Solution();
        String res = s.convert("APPLE",3);
        System.out.println(res);
    }
}