//Time: O(NM) //number of elements
//Space: O(1)

//This is the dp top-down in-place approach

import java.util.*;

class Triangle3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        
        int n = triangle.size();
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                }
                else if( j == i){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                }
                else{
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j-1)));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int k: triangle.get(n - 1)){
            min = Math.min(min, k);
        }
        
        return min;
    }
}