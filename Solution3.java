package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Solution3 {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSumClosest(nums,1));
    }

    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> sums = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i!=j && j!=i && i!=k && k!=i){
                        sum = nums[i]+nums[j]+nums[k];
                        if (sum==target && sum!=0){
                            return sum+1;
                        }
                    }

                }
            }
        }
        return 0;
    }

}
