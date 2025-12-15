/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.panda.mathutil.core;

//import static com.panda.mathutil.core.MathUtil.*;
import static com.panda.mathutil.core.MathUtil.getFactorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author LoiDinh
 */
public class MathUtilTest {
    // DDT => Data Driver Testing 
    // Tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử

    // Chuẩn bị 1 bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 120}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData")
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

//    @Test 
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(24, getFactorial(4));
//    }
    // Bắt ngoại lệ khi đưa data cà chớn !!! => TDD
    
    
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //Anonymus
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//              }
//        };
        // Lambda Expression  
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }

}
