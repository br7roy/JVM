/*
 * Package com.rust.jvm.construct FileName: CommonTest Author: Rust Date: 2018/7/23 13:53
 * Description: History:
 * ===============================================================================================
 * author： time： version： desc： Rust 2018/7/23 13:53 1.0
 * ===============================================================================================
 */
package com.rust.jvm.memorystructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * FileName: JavaHeapOOM Author: Rust Date: 2018/7/23 Description:JAVA 堆
 */
public class JavaHeapOOM {

  /**
   * 测试堆溢出
   */
  @Test
  public void test() {

    /**
     * 加上JVM参数-verbose:gc -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+HeapDumpOnOutOfMemoryError，就能很快报出OOM： Exception in thread "main" java.lang.OutOfMemoryError:
     * Java heap space 并且能自动生成Dump
     */

    List<OOMObject> list = new ArrayList<>();

    for (;;) {

      list.add(new OOMObject());

    }



  }


}
