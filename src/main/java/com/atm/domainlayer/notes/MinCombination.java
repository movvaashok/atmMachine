package com.atm.domainlayer.notes;

import java.util.*;

public class MinCombination {

    public List<Integer> getResult(int amount, List<Integer> notes) {
        Map<Integer, List<Integer>> memoization = new HashMap<Integer, List<Integer>>() {
        };
        return minCombination(amount, notes, memoization);
    }

    private List<Integer> minCombination(int amount, List<Integer> notes, Map<Integer, List<Integer>> memoization) {
        if (memoization.get(amount) != null) return memoization.get(amount);
        if (amount == 0) return Collections.emptyList();
        if (amount < 0) return null;

        List<Integer> minCombination = null;

        for (Integer noteValue : notes) {
            final int remainder = amount - noteValue;
            //todo
            final List<Integer> remainderCombination = minCombination(remainder, notes, memoization);
            if (remainderCombination != null) {
                List<Integer> combination = new ArrayList(Arrays.asList(remainderCombination.toArray()));
                combination.add(noteValue);
                if (minCombination == null || (combination.size() < minCombination.size())) {
                    minCombination = combination;
                }
            }
        }
        memoization.put(amount, minCombination);
        return minCombination;
    }
}
