package gameutil.geom;

import java.awt.geom.Line2D;

import gameutil.geom.g2D.LineR2;

public class Line {
	private Vector P1;
	private Vector P2;
	private Vector v;//the vector parallel to the line
	
	/**initializes a line that intersects the tails of the input vectors
	 * 
	 * @param v1
	 * @param v2
	 */
	public Line(Vector v1,Vector v2){
		this.P1=v1;
		this.P2=v2;
		v=P1. $S$ (P2);
	}
	
	//Test this
	public boolean intersects(Line l) {
		
		int dims;
		if (l.v.n()>v.n()) {
			//if the other line has more dimensions set number of dimensions to the dimensions that the other line exists in.
			dims=l.v.n();
		} else {
			//other wise set the number of dimensions to the dimension that the vector parallel to this line exists in (if v.n>p.n then v has higher dimensions and if v.n==p.n then they have equal dimensions)
			dims=v.n();
		}
		
		//create a list of all dimensional velocities for this line
		LineR2[] dimVs=new LineR2[dims];
				
		for (int i=0; i<dimVs.length;i++) {
			dimVs[i]=new LineR2(v.getSpds().i(i),P1.getSpds().i(i));
		}
		
		//create a list of all dimensional velocities for the other line
		LineR2[] dimVsl=new LineR2[dims];
		
		for (int i=0; i<dimVsl.length;i++) {
			dimVsl[i]=new LineR2(l.v.getSpds().i(i),l.P1.getSpds().i(i));
		}
		
		for (int i=0; i<dimVs.length;i++) {
			if (!dimVs[i].intersects(dimVsl[i])) {
				//lines don't intersect
				return false;
			}
		}
		
		//all tests passed successfully so return true
		return true;
	}
	
	public boolean getIntersectionPoint() {
		
		return false;
	}
	
	//Working on this
	public boolean containsPoint(Point p){
		
		
		int dims;
		if (p.tuple.n()>v.n()) {
			//if the point has more dimensions set number of dimensions to the dimensions that the point exists in.
			dims=p.tuple.n();
		} else {
			//other wise set the number of dimensions to the dimension that the vector parallel to this line exists in (if v.n>p.n then v has higher dimensions and if v.n==p.n then they have equal dimensions)
			dims=v.n();
		}
		
		//create a list of all dimensional velocities
		LineR2[] dimVs=new LineR2[dims];
		
		for (int i=0; i<dimVs.length;i++) {
			dimVs[i]=new LineR2(v.getSpds().i(i),P1.getSpds().i(i));
		}
		
		//check if a line that contains the specified point intersects this line at that point
		boolean intersects=true;
		for (int i=0; i<dimVs.length;i++) {
			//if (dimVs[i].in) {
				
			//}
		}
		
		
		Vector T=new Vector(p). $S$ (P1). $D$ (v);
		
		if (T.end().equals(new Tuple(T.end().n(),T.end().i(1)))) {
			return true;
		}
		
		return false;
	}
	
	public Vector equation(double t){
		return (v. $X$ (t)). $A$ (P1);
	}
}
