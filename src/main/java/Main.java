public class Main {
    public static void main(String[] args) {
        /* Test Default Calculator App of Android API 26
          Based On Input Space Partitioning Test
          and Coverage Type is Each Choice Coverage
          3 Partition for each number: 0, <0 , >0
         */
        CalculatorTest test = new CalculatorTest("emulator-5554", "android", "com.android.calculator2", ".Calculator");

        // Test Add
        test.testEquation(1, 2, "+", String.valueOf(1 + 2));
        test.testEquation(-1, -2, "+", String.valueOf((-1) + (-2)));
        test.testEquation(0, 0, "+", String.valueOf(0 + 0));

        // Test Subtract
        test.testEquation(1, 2, "-", String.valueOf(1 - 2));
        test.testEquation(-1, -2, "-", String.valueOf((-1) - (-2)));
        test.testEquation(0, 0, "-", String.valueOf(0 - 0));

        // Test multiplication
        test.testEquation(1, 2, "*", String.valueOf(1 * 2));
        test.testEquation(-1, -2, "*", String.valueOf((-1) * (-2)));
        test.testEquation(0, 0, "*", String.valueOf(0 * 0));

        // Test Division
        test.testEquation(1, 2, "/", String.valueOf((1.0) / 2));
        test.testEquation(-1, -4, "/", String.valueOf((-1.0) / -4));
        test.testEquation(0, 0, "/", "Can't divide by 0");
        test.clearLong();

        // Test Cosine
        test.testFunction(0, "cos", String.valueOf((int) Math.cos(0)));
        test.testFunctionWithPiOrE(true, true, "cos", String.valueOf((int) Math.cos(-Math.PI)));
        test.testFunctionWithPiOrE(true, false, "cos", String.valueOf((int) Math.cos(Math.PI)));

        // Test Sinus
        test.testFunction(0, "sin", String.valueOf((int) Math.sin(0)));
        test.testFunctionWithPiOrE(true, true, "sin", String.valueOf(0));
        test.testFunctionWithPiOrE(true, false, "sin", String.valueOf(0));

        // Test Tan
        test.testFunction(0, "tan", String.valueOf((int) Math.tan(0)));
        test.testFunctionWithPiOrE(true, true, "tan", String.valueOf(0));
        test.testFunctionWithPiOrE(true, false, "tan", String.valueOf(0));

        // Test Logarithm
        test.testFunction(0, "log", "Not a number");
        test.clearLong();
        test.testFunction(1, "log", String.valueOf((int) Math.log(1)));
        test.testFunction(-1, "log", "Not a number");
        test.clearLong();

        // Test Ln
        test.testFunction(0, "ln", "Not a number");
        test.clearLong();
        test.testFunctionWithPiOrE(false, false, "ln", String.valueOf(1.0));
        test.testFunction(-1, "ln", "Not a number");
        test.clearLong();

        // Test Factorial
        test.testFactorialOrPercentageOrSquare("factorial", 5, String.valueOf(120));
        test.testFactorialOrPercentageOrSquare("factorial", 0, String.valueOf(1));
        test.testFactorialOrPercentageOrSquare("factorial", -5, "Not a number");
        test.clearLong();

        // Test Percentage
        test.testFactorialOrPercentageOrSquare("%", 5, String.valueOf(5.0 / 100));
        test.testFactorialOrPercentageOrSquare("%", 0, String.valueOf(0 / 100));
        test.testFactorialOrPercentageOrSquare("%", -5, String.valueOf(-5.0 / 100));

        // Test Radical
        test.testFunction(4, "sqrt", String.valueOf((int) Math.sqrt(4)));
        test.testFunction(0, "sqrt", String.valueOf((int) Math.sqrt(0)));
        test.testFunction(-4, "sqrt", "Not a number");
        test.clearLong();

        // Test Power
        test.testEquation(2, 3, "pow", String.valueOf((int) Math.pow(2, 3)));
        test.testEquation(0, 0, "pow", String.valueOf((int) Math.pow(0, 0)));
        test.testEquation(-2, -1, "pow", String.valueOf( Math.pow(-2, -1)));
        test.clear();

        test.click("toggle_inv"); // switch to alternative functions

        // Test ArcSinus
        test.testFunction(1, "arcsin", String.valueOf(Math.PI / 2));
        test.testFunction(0, "arcsin", String.valueOf(0));
        test.testFunction(-1, "arcsin", String.valueOf(-Math.PI / 2));

        // Test ArcCos
        test.testFunction(1, "arccos", String.valueOf(0));
        test.testFunction(0, "arccos", String.valueOf(Math.PI / 2));
        test.testFunction(-1, "arccos", String.valueOf(Math.PI));

        // Test ArcTan
        test.testFunction(1, "arctan", String.valueOf(Math.PI / 4));
        test.testFunction(0, "arctan", String.valueOf(0));
        test.testFunction(-1, "arctan", String.valueOf(-Math.PI / 4));

        // Test Square
        test.testFactorialOrPercentageOrSquare("square", 2, String.valueOf((int) Math.pow(2, 2)));
        test.testFactorialOrPercentageOrSquare("square", 0, String.valueOf((int) Math.pow(0, 2)));
        test.testFactorialOrPercentageOrSquare("square", -2, String.valueOf((int) Math.pow(-2, 2)));

        // Test 10^x
        test.testFunction(2, "10power", String.valueOf((int) Math.pow(10, 2)));
        test.testFunction(0, "10power", String.valueOf((int) Math.pow(10, 0)));
        test.testFunction(-1, "10power", String.valueOf( Math.pow(10, -1)));

        // Test e^x
        test.testFunction(2, "exp", String.valueOf(Math.pow(Math.E, 2)));
        test.testFunction(0, "exp", String.valueOf((int) Math.pow(Math.E, 0)));
        test.testFunction(-1, "exp", String.valueOf(Math.pow(Math.E, -1)));

        test.clear();

    }
}
