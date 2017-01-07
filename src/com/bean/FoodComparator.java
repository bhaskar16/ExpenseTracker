package com.bean;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FoodComparator implements Comparator<Food>{

	
		 
	    private List<Comparator<Food>> listComparators;
	 
	    @SafeVarargs
	    public FoodComparator(Comparator<Food>... comparators) {
	        this.listComparators = Arrays.asList(comparators);
	    }
	 
	    
	
	@Override
	public int compare(Food o1, Food o2) {
		for (Comparator<Food> comparator : listComparators) {
            int result = comparator.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
	}

}
