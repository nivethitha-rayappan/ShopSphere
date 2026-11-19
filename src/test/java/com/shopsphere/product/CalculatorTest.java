package com.shopsphere.product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void shouldAddTwoNumbers(){
        Calculator calculator =new Calculator();
        int result = calculator.add(10,20);
        assertEquals(30,result);
    }
}
