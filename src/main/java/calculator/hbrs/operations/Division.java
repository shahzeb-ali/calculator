package calculator.hbrs.operations;

public class Division implements Operation{

	@Override
	public double op(double x, double y) throws ArithmeticException {

		if(y==0) {
			throw new ArithmeticException();
		}
		else {
			return x/y;
		}
		
	}

}
