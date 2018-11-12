
package myMath;



/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	
	// Constractors :
	/**This function constructs monom from two parameters.
	 * 
	 * @param a represents the monom's coefficient.
	 * @param b represents the monom's power.
	 */
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	/**This function constructs monom from a string.
	 * 
	 * @param s String which includes monom.
	 */
	public Monom (String s) {
		int c=0;
		while(s.charAt(c)!='*')
			c++;
		this.set_coefficient(Double.parseDouble(s.substring(0, c)));
		c=c+3;
		int k=c;
		while(c!=s.length()) 
			c++;
		this.set_power(Integer.parseInt(s.substring(k,c)));
	}

	/**This function copys & constructs monom .
	 * 
	 * @param ot Monom
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	
	// ***************** add your code below **********************
   
	/**This function compute the value of the monom.
	 * 
	 * @param x value of parameter x.
	 * @return the monom's value.
	 */
	public double f(double x) {
		return this.get_coefficient()*Math.pow(x, this.get_power());
	}
	/**This function computes the monom's derivative.
	 * the power of the monom must be positive.
	 * @return The monom's derivative (Monom type).
	 */
	
	public Monom derivative() {
		Double coe;
		int pow;
		if(this.get_power()>0) {
			coe=this.get_coefficient()*(double)this.get_power();
			pow=this.get_power()-1;
			Monom der=new Monom(coe,pow);
			return der;
		}
		return new Monom(this.get_coefficient(),this.get_power());
	}
	
	
	/**This function add monom to another monom.
	 * Must have the same power.
	 * @param ot The added Monom
	 */
	public void add(Monom ot) {
		if(this.get_power()==ot.get_power()) 
			this.set_coefficient(this.get_coefficient()+ot.get_coefficient());
		}
	/**This function multipy monom by other monom.
	 * 
	 * @param ot The multiplier monom
	 */
	public void multiply(Monom ot) {
		
		this.set_coefficient(this.get_coefficient()*ot.get_coefficient());
		this.set_power(this.get_power()+ot.get_power());
		
	}
	
	
	//****************** Private Methods and Data *****************
	/**Check if two monoms are equal.
	 * 
	 * @param m1 The checked monom
	 * @return true: if they're equal, false : if they're not.
	 */
	public boolean equals(Monom m1) {
		if((this.get_coefficient()==m1.get_coefficient())&&(this.get_power()==m1.get_power()))
			return true;
		else
			return false;
	}
	/**This function execute a deep copy by
	 *  constructing a new monom.
	 * @return An identical monom.
	 */
	public Monom copy() {
		Monom clone=new Monom(this.get_coefficient(),this.get_power());
		return clone;
	}
	/**Coefficient setter:
	 * changes the value of the monom's coefficient.
	 * @param c The new value.
	 */
	private void set_coefficient(double c){
		this._coefficient = c;
	}
	/**Coefficient getter:
	 * 
	 * @return The coefficient value 
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	
	/**Power setter:
	 * changes the value of the monom's power.
	 * @param p The new value.
	 */
	private void set_power(int p) {
		this._power = p;	
	}
	/** Power getter:
	 * 
	 * @return The power value.
	 */
	public int get_power() {
		return this._power;
	}
	
	
	private double _coefficient; // 
	private int _power; 
	
}
