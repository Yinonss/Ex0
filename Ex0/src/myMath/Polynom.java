package myMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Yinon
 *
 */
public class Polynom implements Polynom_able{

	// ********** add your code below ***********
	
     ArrayList<Monom> poly;
	
	// Constractors :
     
     /**Empty Constructor - create an empty ArrayList
      * 
      */
	public Polynom () {
		poly=new ArrayList<Monom>();
	}
	/**Copy Constructor - create an identical ArrayList
	 * 
	 * @param p The copied polynom.
	 */
	public Polynom(Polynom_able p) {
		poly=new ArrayList<Monom>();
		if(p!=null) {
		Iterator<Monom> m=p.iteretor(); 
		while(m.hasNext()) {
			this.poly.add(m.next()); }
		}
	}
	
	
	
	/**String constructor - turn a string into a polynom. 
	 * String must be a sum of monoms(must be separated with +/-).
	 * The function break the polynom string into several strings and check them individually.
	 * Monom must be written by this pattern : a*x^b (a - double , b - integer)
	 * @param s String which represent polynom.
	 */
	public Polynom(String s) {
	poly=new ArrayList<Monom>();
	int start=0,end=0,i=1;
	for(;i<s.length();i++) {
		if((s.charAt(i)=='+')||(s.charAt(i)=='-')||(i==s.length()-1))
		{
		if(i==s.length()-1)	
			end=i+1;
		else
		    end=i;
		String cut=s.substring(start,end);
	Monom check=stringCheck(cut);
	if(check!=null)
		this.add(check);
	else {
		ArrayList<Monom> emptyList=new ArrayList<Monom>();
		this.poly=emptyList;
		break;
	}
	if(s.charAt(i)=='-')
		start=end;
	else
	   start=end+1;
    }
	}
	}
	/**String Checker:
	 * This function helps the string constructor spot strings
	 * which do not match with the monom pattern (a*x^b).
	 * The function create a monom if the string follow the pattern.
	 * @param cut The checked string
	 * @return Monom if the String is matched, if not return null.
	 */
	private Monom stringCheck(String cut) {
	    double coe;
		boolean ok=true;
		int c=0,pow;
		while((cut.charAt(c)!='*')&&(c<cut.length()))
			c++;
		if(c>cut.length()-3)
			ok=false;
		if(ok) {
			
		try {
		    coe=Double.parseDouble(cut.substring(0,c));}
		catch(Exception e) {
			System.out.println("Error, invalid input!");
			return null;
		}finally {}
		if((cut.charAt(c+1)!='x')&&(cut.charAt(c+2)!='^')) {
			System.out.println("Error, invalid input!");
			return null;
		}
			
		c=c+3;
			try {
			pow=Integer.parseInt(cut.substring(c,cut.length()));
			return new Monom(coe,pow);
		}catch(Exception e) {
			System.out.println("Error, invalid input!");
			return null;
		}finally {}}
		else
			return null;
		
	}
	
	// Math functions:
	/**Add function:
	 * This function adds a monom into a polynom.
	 * If this monom's power fits into another monom's power
	 * then they're added. if not, added as a new monom.
	 * @param m1 The added monom.
	 */
	public void add(Monom m1) {
		if(this.isZero())
			this.poly.add(m1);
		else {
	 	boolean added=false;
		Iterator<Monom> m2=this.iteretor();
		while((m2.hasNext())&&(added==false)) {    
			Monom check =m2.next();
			double c=check.get_coefficient();
			check.add(m1);
			if(c!=check.get_coefficient()) 
				added=true;
		}
	if(added==false) 
		this.poly.add(m1);		
	}
	}
	/**Add function:
	 * The function going through the polynom p1 (monom by monom)
	 * and adds them into the polynom.
	 * @param p1 The added polynom.
	 */
	public void add(Polynom_able p1 ) {
		Iterator<Monom> m1= p1.iteretor();
		while(m1.hasNext()) {
			this.add(m1.next());			
		}
}
	/**Substract function:
	 * This function multiply a polynom by -1*x^0 - which
	 * makes it the same (but negative) , and them adds
	 * it to other polynom.
	 * @param p1 The reducer polynom.
	 */
	public void substract(Polynom_able p1) {
		Monom negMaker=new Monom(-1,0);
	    Iterator<Monom> m=p1.iteretor();
	    while(m.hasNext()) {
	    	Monom check=m.next();    	
	    	check.multiply(negMaker);
	    	this.add(check);
	    }
	}
	/**Multiply function:
	 * This function going through two polynom (monom by monom)
	 * and multiplied them.
	 * @param p1 Multiplied polynom.
	 */
	public void multiply(Polynom_able p1) {
		Polynom temp=new Polynom();		
		Iterator<Monom> m2=this.iteretor(); 
		while(m2.hasNext()) {
			Iterator<Monom> m1=p1.iteretor();
			Monom mult2=m2.next();
			while(m1.hasNext()) {
				Monom mult1=new Monom(m1.next());
				mult1.multiply(mult2);
		    	temp.add(mult1);
			}
		}
		this.poly.clear();
		this.poly=temp.poly;
	}
	/**The function check if the polynom is empty or not.
	 * @return false - if empty , true - if not.
	 */
	public boolean isZero() {
	return this.poly.isEmpty();
    }
	
	
	/**This function checks if two polynoms are equal.
	 * @return true - if they are equal , false - if they are not.
	 */
	public boolean equals (Polynom_able p1) {
		Iterator<Monom> m=this.iteretor();
		Iterator<Monom> m1=p1.iteretor();
		while ((m1.hasNext())&&(m.hasNext())) {
			Monom check=m.next();
			Monom check1=m1.next();
			if(check.equals(check1)==false)
				return false;
		}
		if(m1.hasNext()!=m.hasNext())
			return false;
		return true;
	}

    public Polynom_able copy() {
     Polynom clone=new Polynom();
     Iterator<Monom> m = this.iteretor();
     while(m.hasNext()) {
    	 Monom temp=m.next();
    	 clone.add(temp.copy()); }
     return clone;
} 
    /**This function computes the polynom's derivative.
     * Polynom mustn't contain a monom that has power less
     * than 1.
     * @return polynom's derivative (polynom type).
     */
    public Polynom_able derivative() {
    	Polynom_able der=new Polynom();
    	Iterator<Monom> m=this.iteretor();
    	while(m.hasNext()) {
    		Monom check=new Monom (m.next());
    		try {
    		Monom check1=new Monom(check);
    		check.derivative();
    		if(check1.equals(check)) {
    			System.out.println("Error!cannot compute monom with power below 1.");
    			return null; }
    		 der.add(check);	
    		}
    	 catch(Exception e) {
    		System.out.println("Error!cannot compute monom with power below 1.");
    		return null;
    	}finally {}}
    	return der;
    }
    
    /**This function compute the value of the polynom.
	 * 
	 * @param x value of parameter x.
	 * @return the polynom's value.
	 */
    public double f(double x) {
    	double sum=0;
    	Iterator<Monom> m=this.iteretor();
    	while(m.hasNext()) 
    		sum=sum+m.next().f(x);
    	return sum;
    }
    
    /**Iterator function:
     * Sorts the ArrayList using Monom_Comperator class.
     * @return Iterartor<Monom>
     */
    
    public Iterator<Monom> iteretor(){
    	   Collections.sort(this.poly , new Monom_Comperator());
    	return this.poly.iterator();
    }
    
    /**This function returning a polynom as a string.
     * If it function adds '+' to the string only
     * if it positive (the monom).
     * @return Polynom as a string.
     */
    public String toString() {
    	String p="";
    	boolean first=true;
    	Iterator<Monom> m=this.iteretor();
    	while(m.hasNext()) {
    		Monom temp=m.next();
    		
    		if((temp.get_coefficient()<0)||(first==true)) {
    			first=false;
    			p=p+temp.get_coefficient()+"*x^"+temp.get_power();
    		}
    		else {
    			first=false;
    			p=p+"+"+temp.get_coefficient()+"*x^"+temp.get_power();
    	}
    	}
    	return p;
   
}
    /**
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps
	 * assuming (f(x0)*f(x1)<=0, returns f(x2) such that:
	 * *	(i) x0<=x2<=x2 && (ii) f(x2)<eps
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps step (positive) value
	 * @return
	 */
   
    public double root(double x0, double x1, double eps)  {
    	if (f(x0)*f(x1)<=0) {
			double middle = (x0+x1)/2;
			if (Math.abs(f(middle))<eps) 
				return middle;
			if (f(x0)==0) 
				return x0;
			else if (f(x1)==0) 
				return x1;
			if (f(middle)<0) 
				x0 = middle;
			else if (f(middle) > 0) 
				x1 = middle;	}
		else 
			{throw new IllegalArgumentException("exponent cannot be calculate ");}
		return root(x0, x1, eps);
	}
    
    /**
	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
	 */
    public double area(double x0, double x1, double eps) {		
    	
    	double a=0,i=0;
    	while(i<(x1-x0)/eps) {
    		a=a+f(i*eps+x0)*eps;
    		i++; }
    	return a;
    }
    
    
    
}

