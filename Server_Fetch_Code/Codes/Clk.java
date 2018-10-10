/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnidemojava;

/**
 *
 * @author jinesh
 */
class Clk {

    //private native double nativePrint();
    /*static {
     System.load("/home/jinesh/NetBeansProjects/JNIDemoCdl/dist/libJNIDemoCdl.so");
     }*/
    static double clkTcs() {
        double test = new Main().nativePrint();
        //System.out.println(test);
        return test;
    }
}
