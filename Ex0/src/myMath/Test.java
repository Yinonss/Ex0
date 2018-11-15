
package myMath;

import java.util.Iterator;

public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testA();
		
	}
	/**This function testing polynom class' methods.
	 * 
	 */
	public static void testA() {
 
		//String constructor test:
		System.out.println("String constructor test : ");
		Polynom_able p1 = new Polynom("0.4*x^2-8*x^3");
		Polynom_able p2 = new Polynom("5*x^0+7.5*x^1-3*x^2");
		
		System.out.println("Print :0.4*x^2-8*x^3  -> "+p1.toString());
		System.out.println("Print :5*x^0+7.5*x^1-3*x^2  -> "+p2.toString());
		Polynom_able incorrectPoly1 = new Polynom("4*x^3.2");
		Polynom_able incorrectPoly2 = new Polynom("erw*x^3+0.2*x^5");
		Polynom_able incorrectPoly3 = new Polynom("3.3.4*x^6");
		Polynom_able incorrectPoly4 = new Polynom("6*^x9");
		
		//Equals , isZero ,copy and Empty constructors test:
		System.out.println();
		System.out.println("Equals , isZero & copy tests:");
		Polynom_able clone = new Polynom(p1); 
		System.out.println("Print : 0.4*x^2-8*x^3  -> "+clone.toString());
		System.out.println("Print : true ->"+clone.equals(p1));
		Polynom_able empPoly = new Polynom();
		System.out.println("Print : true -> "+empPoly.isZero());
		System.out.println();
	  
		
		//Iterator test:
		System.out.println("Iterator test:");
		Polynom_able iteratorTester = new Polynom("3*x^7+5*x^5-4*x^1-2.6*x^3+99.3*x^4");
		Iterator<Monom> iterator = iteratorTester.iteretor();
		System.out.println("Print : 1 3 4 5 7 -> ");
		while(iterator.hasNext())
			System.out.print("  "+iterator.next().get_power());
		System.out.println();
		
		
		//Math Functions:
		//Derivative test:
		System.out.println();
		System.out.println("Derivative test");
		Polynom_able der1 = new Polynom(p1.derivative());
		System.out.println("Print : 0.8*x^1-24*x^2 ->"+der1.toString());
		System.out.println("Print Error :");
		Polynom_able der2 = new Polynom(p2.derivative());
		System.out.println();
		
		//Add test:
		System.out.println("Add test:");
		Polynom_able mathPoly1 = new Polynom();
		Polynom_able mathPoly2 = new Polynom();
		mathPoly1.add(new Monom(8.2,1));
		mathPoly1.add(new Monom(0.2,2));
		mathPoly1.add(new Monom(-4,3));
		mathPoly2.add(new Monom(-7,2));
		mathPoly2.add(new Monom(6,3));
		mathPoly1.add(mathPoly2);
		System.out.println("Print : 8.2*x^1-6.8*x^2-10*x^3 -> "+mathPoly1.toString());
		System.out.println();

		
		System.out.println("Subtract test");
		// Subtract test:
		mathPoly1.substract(mathPoly2);
		System.out.println("Print : 8.2*x^1-0.2*x^2+4*x^3 -> "+mathPoly1.toString());
		System.out.println();
		
		//Multiply test:
		System.out.println("Multiply test:");
		Polynom_able mult1 = new Polynom("4.2*x^2-2*x^1");
		Polynom_able mult2 = new Polynom("-7*x^2+9.5*x^3");
		mult1.multiply(mult2);
		System.out.println("Print : 14*x^3-48.4*x^4+39.9*x^5 -> "+mult1.toString());
        System.out.println();
	    
       //Area test:
        System.out.println("Area test:");
	    Polynom_able areaTester=new Polynom("2*x^0-3*x^2+1*x^3");
     	double eps=0.0000001;
    	System.out.println("Print :1.25 -> "+areaTester.area(0, 1, eps));
    	System.out.println("Print :-64.4 -> "+areaTester.area(-6.1, -5.9, eps));
    	System.out.println("Print :263 -> "+areaTester.area(4, 7, eps));
    	
   
        //Root test:
        System.out.println("Root test:");
        eps=Double.MIN_VALUE;
        Polynom_able rootTester=new Polynom("5*x^3");
        System.out.println("Print : -2.12 -> "+rootTester.root(-0.5, 10, eps));
        System.out.println("Print : 0 -> "+rootTester.root(0, 2, eps));
        System.out.println("Print : 8.515 -> "+rootTester.root(-1,2 , eps));
        System.out.println();
       
        //Graph test:
        Polynom_able p=new Polynom ("0.2*x^4-1.5*x^3+3.0*x^2-1*x^1-5*x^0");
	    System.out.println("Graph test:");
	    drawFunction frame = new drawFunction(p);
	    frame.setVisible(true);    
	    
	  
		
	}
}