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

    
}
