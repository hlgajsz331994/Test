package com.hlg.Struts2Test;

/**
 * Created by Administrator on 2016/12/1.
 */
public class ErrorTest {
    int i ;
    public void test(){
        i = 10/0;
        System.out.println(i);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
