import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.util.HashMap;

public class CalculatorTest extends AppTest {
    private HashMap<String, String> calculator_element_to_key = new HashMap<String, String>() {
        {
            put("+", "op_add");
            put("-", "op_sub");
            put("/", "op_div");
            put("*", "op_mul");
            put("=", "eq");
            put("%", "op_pct");
            put(".", "dec_point");
            put("clear", "del");
            put("sin", "fun_sin");
            put("arcsin", "fun_arcsin");
            put("tan", "fun_tan");
            put("arctan", "fun_arctan");
            put("cos", "fun_cos");
            put("arccos", "fun_arccos");
            put("log", "fun_log");
            put("ln", "fun_ln");
            put("factorial", "op_fact");
            put("pi", "const_pi");
            put("e", "const_e");
            put("pow", "op_pow");
            put("sqrt", "op_sqrt");
            put("(", "lparen");
            put(")", "rparen");
            put("square", "op_sqr");
            put("10power", "fun_10pow");
            put("exp", "fun_exp");
        }
    };

    public CalculatorTest(String device_name, String platform_name, String app_package, String app_activity) {
        super(device_name, platform_name, app_package, app_activity);
    }

    private void clickDigit(int num) {
        click("digit_" + num);
    }

    public void testEquation(int a, int b, String op, String expected_result) {
        clear();
        int a_clicked = (a < 0) ? -a : a;
        if (a < 0) {
            click("op_sub");
        }
        clickDigit(a_clicked);
        click(calculator_element_to_key.get(op));
        int b_clicked = (b < 0) ? -b : b;
        if (b < 0) {
            click(calculator_element_to_key.get("("));
            click("op_sub");
        }
        clickDigit(b_clicked);
        if (b < 0) {
            click(calculator_element_to_key.get(")"));
        }
        click("eq");

        String actual_result = driver.findElementById(app_package + ":id/result").getText().replace("−", "-");

        if (actual_result.equals(expected_result)) {
            System.out.println("Test " + a + " " + op + " " + b + " = " + actual_result + "\tPassed Successfully");
        } else {
            System.err.println("Test Failed");
            System.err.println("Test: " + a + " " + op + " " + b);
            System.err.println("Actual Result: " + actual_result + "\tExpected Result: " + expected_result);
        }
    }

    public void testFunction(int num, String op, String expected_result) {
        clear();
        click(calculator_element_to_key.get(op));
        int number_clicked = (num < 0) ? -num : num;
        if (num < 0) {
            click("op_sub");
        }
        clickDigit(number_clicked);
        click("eq");

        String actual_result = driver.findElementById(app_package + ":id/result").getText().replace("−", "-");
        actual_result = (actual_result.length() > 12) ? actual_result.substring(0, 12) : actual_result;
        expected_result = (expected_result.length() > 12) ? expected_result.substring(0, 12) : expected_result;

        if (actual_result.equals(expected_result)) {
            System.out.println("Test " + op + "(" + num + ") = " + actual_result + "\tPassed Successfully");
        } else {
            System.err.println("Test Failed");
            System.err.println("Test: " + op + "(" + num + ")");
            System.err.println("Actual Result: " + actual_result + "\tExpected Result: " + expected_result);
        }
    }

    public void testFunctionWithPiOrE(boolean isPi, boolean isNegative, String op, String expected_result) {
        String constant = isPi ? "pi" : "e";
        clear();
        click(calculator_element_to_key.get(op));
        if (isNegative) {
            click("op_sub");
        }
        click(calculator_element_to_key.get(constant));

        click("eq");

        String actual_result = driver.findElementById(app_package + ":id/result").getText().replace("−", "-");
        actual_result = (actual_result.length() > 3) ? actual_result.substring(0, 3) : actual_result;
        if (actual_result.equals(expected_result)) {
            System.out.print("Test " + op + "(");
            if (isNegative) System.out.print("-");
            System.out.print(constant);
            System.out.println(") = " + actual_result + "\tPassed Successfully");
        } else {
            System.err.println("Test Failed");
            System.err.print("Test: " + op + "(");
            if (isNegative) System.err.print("-");
            System.err.println(constant + ")");
            System.err.println("Actual Result: " + actual_result + "\tExpected Result: " + expected_result);
        }
    }

    public void testFactorialOrPercentageOrSquare(String op, int num, String expected_result) {
        clear();
        int number_clicked = (num < 0) ? -num : num;
        if (num < 0) {
            click(calculator_element_to_key.get("("));
            click("op_sub");
        }
        clickDigit(number_clicked);
        if (num < 0) {
            click(calculator_element_to_key.get(")"));
        }
        click(calculator_element_to_key.get(op));
        click("eq");
        String actual_result = driver.findElementById(app_package + ":id/result").getText().replace("−", "-");
        if (actual_result.equals(expected_result)) {
            System.out.print("Test " + op);
            System.out.println("(" + num + ") = " + actual_result + "\tPassed Successfully");
        } else {
            System.err.println("Test Failed");
            System.err.println("Test: " + op + "(" + num + ")");
            System.err.println("Actual Result: " + actual_result + "\tExpected Result: " + expected_result);
        }
    }


    public void clear() {
        try {
            click("clr");
        } catch (Exception e) {

        }
    }

    public void clearLong() {
        MobileElement el = driver.findElementById(app_package + ":id/" + "del");
        AndroidTouchAction action = new AndroidTouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(el))).perform();
    }

}
