/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.aidger.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rmbl
 */
public class RuntimeTest {

    public RuntimeTest() {
        Runtime.getInstance().initialize();
    }

    /**
     * Test of getInstance method, of class Runtime.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");

        Runtime rt = Runtime.getInstance();
        assertNotNull(rt);
    }

    /**
     * Test of getOptionArray method, of class Runtime.
     */
    @Test
    public void testGetOptionArray() {
        System.out.println("getOptionArray");

        String[] str = new String[] { "test1", "test2" };

        Runtime.getInstance().setOptionArray("test", str);
        String[] result = Runtime.getInstance().getOptionArray("test");

        for (int i = 0; i < result.length; ++i) {
            assertEquals(str[i], result[i]);
        }

        Runtime.getInstance().setOption("test2", "not option array");

        result = Runtime.getInstance().getOptionArray("test2");
        assertNull(result);

        result = Runtime.getInstance().getOptionArray("non-existent");
        assertNull(result);
    }

    /**
     * Test of setOptionArray method, of class Runtime.
     */
    @Test
    public void testSetOptionArray() {
        System.out.println("setOptionArray");

        String[] str = new String[] { "test1", "test2" };

        Runtime.getInstance().setOptionArray("test", str);
        String result = Runtime.getInstance().getOption("test");

        assertEquals(result, "[test1, test2]");
    }

}