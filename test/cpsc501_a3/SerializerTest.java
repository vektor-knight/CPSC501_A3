/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsc501_a3;

import Sender.ObjectBundle.PrimitiveObject;
import Sender.Serializer;
import org.jdom2.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vektor
 */
public class SerializerTest {
    
    public SerializerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of serialize method, of class Serializer.
     */
    @Test
    public void testSerialize() throws Exception {
        System.out.println("serialize");
        Object obj = new PrimitiveObject(5);
        Serializer instance = new Serializer();
        Document expResult = null;
        Document result = instance.serialize(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
