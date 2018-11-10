/*
* Package com.rust.jvm.memorystructure 
* FileName: StandaloneMethodStack
* Author:   Rust
* Date:     2018/7/23 14:44
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/7/23  14:44             1.0                  
*===============================================================================================
*/
package com.rust.jvm.memorystructure;

import org.junit.Test;

/**
 * FileName:    StandaloneMethodStack
 * Author:      Rust
 * Date:        2018/7/23
 * Description: java 栈，本地方法栈
 */
public class StandaloneMethodStack {


    private int stackLen = 1;
    public void stackLeak(){
        stackLen++;
        stackLeak();
    }

    /**
     * 设置JVM参数：-Xss128k，报出异常：
     *Exception in thread "main" java.lang.StackOverflowError
     *打印出Stack length:1007，这里可以看出，在我的机器上128k的栈容量能承载深度为1007的方法调用。
     * 当然报这样的错很少见，一般只会出现无限循环的递归中，另外，线程太多也会占满栈区域：
     */
    @Test
    public void test(){

        StandaloneMethodStack oom = new StandaloneMethodStack();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println(String.format("StandaloneMethodStack.test.stackLen:%s", oom.stackLen));
            throw e;
        }

    }



}
