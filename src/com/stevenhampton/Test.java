/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stevenhampton;

import java.util.Arrays;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;

/**
 * 
 * @author sa_ha
 */
interface api {
    public void x();
    public void y();
}

/**
 *
 * @author sa_ha
 */
public abstract class Test implements api {

    static {
        System.out.println("when does this static block get executed?");
    }

    void test() {
        System.out.println("in Test.test()");
    }

    public Test() {
        System.out.println("in Test constructor");
        System.out.println(MAX_VALUE);
    }

    /**
     * @param args the command line arguments
     */
    public static final void main(String[] args) {
        Integer iI;
        
        try {
            iI = Integer.valueOf("two");
        } catch (NumberFormatException nfe) {

        } catch (IllegalArgumentException iae) {

        } catch (Exception e) {

        }

        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s2));

        Subsubtest sst = new Subsubtest();
        System.out.println("\nCalling sst.test()... ");
        sst.test();
        System.out.println("\nCalling ((Test)sst).test()... ");
        ((Test) sst).test();
        System.out.println("\nCalling sst.superTest()... ");
        sst.superTest();

        Object[] sample;
        sample = new Object[]{34, "blue", false, 18};
        try {
            Arrays.sort(sample);
        } catch (Exception e) {
            System.out.println("Exception sorting array");
        }
        for (Object s : sample) {
            System.out.println(s);
        }
        
        float f = (float)5.5;
    }

}

abstract class Subtest extends Test {

    public Subtest() {
        System.out.println("in Subtest constructor");
    }

    @Override
    protected void test() {
        System.out.println("in Subtest.test()");
        System.out.println("Calling super.test() from Subsubtest.test() ... ");
        super.test();
    }

    public void superTest() {
        System.out.println("Calling super.test() from Subsubtest.superTest() ... ");
        super.test();
    }
}

class Subsubtest extends Subtest {

    public Subsubtest() {
        super();
        Subtest st = new Subtest() {
            @Override
            public void x() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void y() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            
        };
        System.out.println("in Subsubtest constructor");
    }

    @Override
    public void test() {
        System.out.println("in Subsubtest.test()");
        System.out.println("Calling super.test() from Subsubtest.test() ... ");
        super.test();
    }

    @Override
    public void x() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void y() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

