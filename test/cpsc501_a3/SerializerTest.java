/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsc501_a3;

import Sender.ObjectBundle.PrimitiveObject;
import Sender.Serializer;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
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
    
    @Test
    public void testPrimitiveObject() throws Exception {
        PrimitiveObject x;
        x = new PrimitiveObject(1);
        
        String expResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<serialized>\n" +
                                "  <object class=\"Sender.ObjectBundle.PrimitiveObject\" id=\"0\">\n" +
                                "    <field name=\"integerField\" declaringclass=\"Sender.ObjectBundle.PrimitiveObject\">\n" +
                                "      <value>1</value>\n" +
                                "    </field>\n" +
                                "  </object>\n" +
                            "</serialized>";
        Serializer instance = new Serializer();
        XMLOutputter output = new XMLOutputter();
        
        Document result = instance.serialize(x);
        String toTest = output.outputString(result);
        assertEquals(expResult, toTest);
    }

    /**
     * Test of serialize method, of class Serializer.
     */
    @Test
    public void testSerialize() throws Exception {
        System.out.println("serialize");
        Object obj = new PrimitiveObject(5);
        Serializer instance = new Serializer();
   //     Document expResult = new Serializer().serialize(obj);
        String expResult = "<[Document:  No DOCTYPE declaration, Root is [Element: <serialized/>]]>";
        Document result = instance.serialize(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
