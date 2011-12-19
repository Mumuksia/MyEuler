package com.euler.utils;

import java.util.Comparator;

public class PointComparator implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		if (o1.length < o2.length) return 1;
		else if (o1.length > o2.length) return -1;		
		return 0;
	}

}
