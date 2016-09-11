package com.euler;

import com.euler.utils.Point;
import com.euler.utils.PointComparator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Pr_247 {

    private List<Point> squares = new ArrayList<Point>();
    //	private List<Point> potentialSq = new ArrayList<Point>();
    private PriorityQueue<Point> prQueue;

    public void init() {
        Point p0 = new Point(1, 0);
        p0.hx = 0;
        p0.hy = 0;
        p0.length = 1;
//		potentialSq.add(p0);
        Comparator<Point> comparator = new PointComparator();
        prQueue =
                new PriorityQueue<Point>(10000, comparator);
        prQueue.add(p0);
    }

    //get point from current point to 1/x (line 45 degree
    // 1/x = x+a-b
    public Point getCrossPoint(Point p) {
        double r = (p.y - p.x);
        double a = (r + Math.sqrt(r * r + 4)) / 2;

        return new Point(1 / a, a);
    }

    public Point[] getPotentialPoints(Point p1, Point p2) {
        Point[] pp = new Point[2];
        pp[0] = new Point(p1.x, p2.y);
        pp[0].hy = p1.hy + 1;
        pp[0].hx = p1.hx;
        pp[0].length = Point.getDistance(pp[0], getCrossPoint(pp[0]));
        pp[1] = new Point(p2.x, p1.y);
        pp[1].hx = p1.hx + 1;
        pp[1].hy = p1.hy;
        pp[1].length = Point.getDistance(pp[1], getCrossPoint(pp[1]));


        return pp;
    }

    @Test
    public void doPriorityQueue() {
        init();
        int count = 0;
        while (true) {
            Point x = prQueue.poll();

            squares.add(x);
            Point[] ppp = getPotentialPoints(x, getCrossPoint(x));
            prQueue.add(ppp[0]);
            prQueue.add(ppp[1]);
            if (count > 800000) break;
            count++;
            if (x.hx == 3 && x.hy == 3) System.out.println("RESULT " + squares.size());
        }
        System.out.println(squares.get(49).hx + " " + squares.get(49).hy);
    }

//	@Test
//	public void doTest(){
//		init();
//		int count = 0;
//		while (true){
//			double max = 0;
//			Point x = new Point(0,0);
//			for (Point p : potentialSq) {
//				if (p.length>max) {
//					max  = p.length;
//					x = p;
//				}
//			
//			}
// 			potentialSq.remove(x);
//			squares.add(x);
//			Point[] ppp = getPotentialPoints(x, getCrossPoint(x));
//			potentialSq.add(ppp[0]);
//			potentialSq.add(ppp[1]);
//			if (count > 10000) break;
//			count ++;
//			if (x.hx == 3 && x.hy == 3) System.out.println("RESULT " + squares.size());
//		}
//		System.out.println(squares.get(49).hx + " " + squares.get(49).hy);
//	}

    public void addPointToPrQueue(Point p) {

    }

}
