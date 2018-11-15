package myMath;

import static org.junit.Assert.*;

import org.junit.Test;
/**This Junit is testing Monom and Polynom's methods.
 * 
 * @author yinon
 *
 */
public class polyTest {

	@Test
	public void stringTest() {
		Polynom_able p = new Polynom("0.4*x^2-8.0*x^3");
		assertTrue("0.4*x^2-8.0*x^3".equals(p.toString()));	
	}

	@Test
	public void derivativeTest() {
		Polynom_able p = new Polynom("0.4*x^2-8.0*x^3");
		Polynom_able der = new Polynom(p.derivative());
		assertTrue("0.8*x^1-24.0*x^2".equals(der.toString()));	
	}
	
	@Test
	public void copyTest() {
		Polynom_able p1 = new Polynom("0.4*x^2-8.0*x^3");
		Polynom_able p2 = new Polynom(p1);
		assertTrue(p1.toString().equals(p2.toString()));
	}
	
	@Test
	public void addPolyTest() {
		Polynom_able p1 = new Polynom("0.4*x^2-8.0*x^3");
		Polynom_able p2 = new Polynom("5*x^2-11*x^3");
		p1.add(p2);
		assertTrue(p1.toString().equals("5.4*x^2-19.0*x^3"));
	}
	 
	@Test
	public void addMonTest() {
		Polynom_able p = new Polynom("17*x^1+19.5*x^3");
		Monom m=new Monom(-7 , 2);
		p.add(m);
		assertTrue(p.toString().equals("17.0*x^1-7.0*x^2+19.5*x^3"));
	}
	
	@Test
	public void substractTest() {
		Polynom_able p1 = new Polynom("17*x^1+19.5*x^3");
		Polynom_able p2 = new Polynom("-5*x^1+3*x^3");
		p1.substract(p2);
		
		assertTrue(p1.toString().equals("22.0*x^1+16.5*x^3"));
	}
	
	@Test
	public void multiplyTest() {
		Polynom_able p1 = new Polynom("3*x^1-1*x^2");
		Polynom_able p2 = new Polynom("2*x^1-2*x^2");
		p1.multiply(p2);
		assertTrue(p1.toString().equals("6.0*x^2-8.0*x^3+2.0*x^4"));
	}
	
	@Test
	public void areaTest() {
		Polynom_able p=new Polynom ("0.2*x^4-1.5*x^3+3.0*x^2-1*x^1-5*x^0");
		double x=p.area(-0.9399999999999991, 4.839999999999943, 0.01);
		if( x != -25.183633821939992 )
			fail();
	}
	
	@Test
	public void rootTest() {
		Polynom_able p=new Polynom ("5*x^3");
		double r=p.root(-0.5, 10, Double.MIN_VALUE);
		if(r!=-2.1289799200040754E-109)
			fail();
	}
	
	@Test
	public void isZeroTest() {
		Polynom_able p=new Polynom ();
		assertTrue(p.isZero());
	}
	
	@Test
	public void equalTest() {
		Polynom_able p1 = new Polynom("3*x^1-1*x^2");
		Polynom_able p2 = new Polynom("3*x^1-1*x^2");
		if(p1.equals(p2)==false)
			fail();
	}
	@Test
	public void fTest() {
		Polynom_able p1 = new Polynom("3*x^1-1*x^2");
		double x=p1.f(1);
		if(x!=2)
			fail();
	}
	
	@Test
	public void toStringTest() {
		Polynom_able p = new Polynom();
		p.add(new Monom(3 , 1));
		p.add(new Monom(-1 , 2));
		assertTrue("3.0*x^1-1.0*x^2".equals(p.toString()));
	}
	
	// ###############################################
	@Test
	public void monStringTest() {
		Monom m1=new Monom("3*x^5");
		Monom m2=new Monom(3 , 5);
		if((m1.get_coefficient()!=m2.get_coefficient()||(m1.get_power()!=m2.get_power())))
			fail();
	}
	
	@Test
	public void monAddTest() {
		Monom m1=new Monom("3*x^5");
		Monom m2=new Monom("7*x^5");
		m1.add(m2);
		if((m1.get_coefficient()!=10)||(m1.get_power()!=5))
				fail();
	}
	
	@Test
	public void monMultTest() {
		Monom m1=new Monom("3*x^5");
		Monom m2=new Monom("7*x^5");
		m1.multiply(m2);
		if((m1.get_coefficient()!=21)||(m1.get_power()!=10))
			fail();
	}
	
	@Test
	public void monDerTest() {
		Monom m=new Monom("3*x^5");
		m.derivative();
		if((m.get_coefficient()!=15)||(m.get_power()!=4))
			fail();
	}
	@Test
	public void monfTest() {
		Monom m1=new Monom("3*x^5");
		double x=m1.f(1);
		if(x!=3)
			fail();
	}
	 
	@Test()
	public void monEqualTest() {
		Monom m1=new Monom("3*x^5");
		Monom m2=new Monom("3*x^5");
		assertTrue(m1.equals(m2));
	}
	
	@Test
	public void monCopyTest() {
		Monom m1=new Monom("3*x^5");
		Monom m2=m1.copy();
		assertTrue(m1.equals(m2));
	}
	
	
}








