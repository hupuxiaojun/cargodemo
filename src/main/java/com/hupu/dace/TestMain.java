package com.hupu.dace;

import org.codehaus.cargo.container.tomcat.*;

/**
 * Created by xiaojun on 2016/1/7.
 */
public class TestMain {
    public static void main(String[] args) {
        TomcatRuntimeConfiguration runtimeConfiguration_n1 = new TomcatRuntimeConfiguration();
        runtimeConfiguration_n1.setProperty("cargo.hostname","n1");
        runtimeConfiguration_n1.setProperty("cargo.protocol","http");
        runtimeConfiguration_n1.setProperty("cargo.remote.password","admin");
        runtimeConfiguration_n1.setProperty("cargo.remote.uri","http://n1:8080/manager/text");
        runtimeConfiguration_n1.setProperty("cargo.remote.username","admin");
        runtimeConfiguration_n1.setProperty("cargo.servlet.port","8080");

        Tomcat7xRemoteContainer remoteContainer_7x = new Tomcat7xRemoteContainer(runtimeConfiguration_n1);
        Tomcat7xRemoteDeployer remoteDeployer_7x = new Tomcat7xRemoteDeployer(remoteContainer_7x);


        TomcatRuntimeConfiguration runtimeConfiguration_n2 = new TomcatRuntimeConfiguration();
        runtimeConfiguration_n2.setProperty("cargo.hostname","n2");
        runtimeConfiguration_n2.setProperty("cargo.protocol","http");
        runtimeConfiguration_n2.setProperty("cargo.remote.password","admin");
        runtimeConfiguration_n2.setProperty("cargo.remote.uri","http://n2:8080/manager/text");
        runtimeConfiguration_n2.setProperty("cargo.remote.username","admin");
        runtimeConfiguration_n2.setProperty("cargo.servlet.port","8080");

        Tomcat8xRemoteContainer remoteContainer_8x = new Tomcat8xRemoteContainer(runtimeConfiguration_n2);
        Tomcat8xRemoteDeployer remoteDeployer_8x = new Tomcat8xRemoteDeployer(remoteContainer_8x);

//        System.out.println(remoteContainer.getState().isStopped());
        TomcatWAR tomcatWAR = new TomcatWAR("D:\\PF-Foundation-DACE\\trunk\\dace-search\\target\\dace-search.war");



        remoteDeployer_7x.redeploy(tomcatWAR);
        remoteDeployer_8x.redeploy(tomcatWAR);


    }
}
