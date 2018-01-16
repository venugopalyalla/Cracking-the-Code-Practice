class Point {
	double x;
	double y;
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
class Line {
	double slope;
	double yintercept;
	Line(Point start, Point end) {
		double deltaX = end.x - start.x;
		double deltaY = end.y - start.y;
		slope = deltaY/deltaX;
		yintercept = end.y - slope*end.x;
	}
}
public class PointIntersection {

	static void swap(Point start, Point end) {
		double x = start.x;
		double y = start.y;
		start.x = end.x;
		start.y = end.y;
		end.x = x;
		end.y = y;
	}
	static boolean isBetween(double start,double middle, double end) {
		if(start > end) {
			return end<= middle && middle <= start;
		} else {
			return start <= middle && middle <= end;
		}
	}
	static boolean isBetween(Point start, Point middle, Point end) {
		return isBetween(start.x,middle.x,end.x) && isBetween(start.y,middle.y,end.y);
	}
	static Point intersection(Point start1, Point end1, Point start2, Point end2) {
		if(start1.x > end1.x) swap(start1,end1);
		if(start2.x > end2.x) swap(start2,end2);
		if(start1.x > start2.x) {
			swap(start1,start2);
			swap(end1,end2);
		}
		Line line1 = new Line(start1,end1);
		Line line2 = new Line(start2,end2);
		if(line1.slope==line2.slope) {
			if(line1.yintercept==line2.yintercept && isBetween(start1,start2,end1)) {
				return start2;
			}
			return null;
		}
		double x = (line2.yintercept-line1.yintercept)/(line1.slope-line2.slope);
		double y = line1.slope*x + line1.yintercept;
		Point res = new Point(x,y);
		if(isBetween(start1,res,end1) && isBetween(start2,res,end2)) {
			return res;
		}
		return null;
	}
	public static void main(String[] args) {
		Point s1 = new Point(2,10);
		Point e1 = new Point(5,7);
		Point s2 = new Point(1,2);
		Point e2 = new Point(8,16);
		Point i = intersection(s1,e1,s2,e2);
		if(i != null) {
			System.out.println("(" + i.x + "," + i.y + ")");			
		}
	}
}
