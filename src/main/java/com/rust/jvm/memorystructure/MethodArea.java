/*
* Package com.rust.jvm.memorystructure 
* FileName: MethodArea
* Author:   Rust
* Date:     2018/7/23 14:17
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/7/23  14:17             1.0                  
*===============================================================================================
*/
package com.rust.jvm.memorystructure;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.junit.Test;

import com.sun.jmx.remote.security.MBeanServerAccessController;

/**
 * FileName:    MethodArea
 * Author:      Rust
 * Date:        2018/7/23
 * Description: 方法区
 */
public class MethodArea implements MethodAreaOOM {

    /**
     * 方法区是存放虚拟机加载类的相关信息，如类、静态变量和常量，
     * 大小由-XX:MetaspaceSize和-XX:MaxMetaspaceSize来调节，类太多有可能撑爆永久带：
     */
    @Test
    public void test() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        for (int i = 0; ; ) {
            ObjectName objectName = new ObjectName("rust:name=OOMTESTTING" + "" + ++i);
            //server.registerMBean(this, objectName);
            objectName.setMBeanServer(new MBeanServerAccessController() {
                @Override
                protected void checkRead() {

                }

                @Override
                protected void checkWrite() {

                }
            });

        }
    }

}
