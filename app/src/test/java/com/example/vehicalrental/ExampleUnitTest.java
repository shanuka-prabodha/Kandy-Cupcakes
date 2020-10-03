package com.example.vehicalrental;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private static credit creditob;
    private static float discout;
    private static float tax;

    @BeforeClass
    public static void inicreadit(){
        creditob=new credit();
    }

    @Before
    public void setup(){
        discout=0.0f;
        tax =0.0f;
    }

    @Test
    public void discountcorrect(){
        discout = creditob.discount(20000);
        assertEquals(600.0,discout,0.1);
    }

    @Test
    public void taxcorrect(){

        tax = creditob.cardtax(20000);
        assertEquals(21000.0,tax,0.1);
    }

    @After
    public void clear(){
        tax=0.0f;
        discout=0.0f;
    }

    @AfterClass
    public static void clearAll(){

        creditob=null;
    }

}