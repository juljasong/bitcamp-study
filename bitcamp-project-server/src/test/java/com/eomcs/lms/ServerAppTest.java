/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.eomcs.lms;

import org.junit.Test;
import static org.junit.Assert.*;

public class ServerAppTest {
    @Test public void testAppHasAGreeting() {
        ServerApp classUnderTest = new ServerApp();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
