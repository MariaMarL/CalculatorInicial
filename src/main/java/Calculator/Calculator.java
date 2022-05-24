package Calculator;

public class Calculator {

    public static Double multiply(Double a, Double b){

        Double result = (b>0) ? (a + multiply(a, b - 1))
                : (b < 0) ? (-a + multiply(a, b + 1))
                : 0;

        return result;
    };

    public static Double division(Double a, Double b){

        if(a < 0 && b<0){
            return 1 + division(a-b, b);
        } else if (a > 0 && b>0) {
            return 1 + division(a-b, b);
        } else if (a < 0 && b>0) {
            return -1 + division(a+b, b);
        } else if (a > 0 && b<0) {
            return -1 + division(a+b, b);
        } else if(b==0)  {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Double a=12.0;
        Double b=4.0;

        //sum
        iOperation sum=(x,y)-> x+y;
        System.out.println("The result of: "+ a + " + " + b+ ": " + sum.calculate(a,b));
        //minus
        iOperation rest=(x,y)-> x-y;
        System.out.println("The result of: "+ a + " - " + b+ ": " +rest.calculate(a,b));
        //multiply
        iOperation multi=(x,y)-> multiply(x,y);
        System.out.println("The result of: "+ a + " * " + b+ ": " +multi.calculate(a,b));
        //divide
        iOperation div=(x,y)-> division(x,y);
        System.out.println("The result of: "+ a + " / " + b+ ": " +div.calculate(a,b));
    }

}
