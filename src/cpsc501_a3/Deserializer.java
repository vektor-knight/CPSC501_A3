/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
       
package cpsc501_a3;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author vektor
 */
public class Deserializer {
    
    // Adapted from Java: Reflection in Action
    
    public static Object deserialize(Document document) throws Exception {
        List<?> objectList;
        objectList = document.getRootElement().getChildren();
        Map table = new HashMap();
        
        createInstances(table, objectList);
        assignFieldValues(table, objectList);
        return table.get("0");  
    }

    private static void createInstances(Map table, List<?> objectList) throws Exception{
        for (int i = 0; i < objectList.size(); i++) {
            Element objectElement = (Element) objectList.get(i);
            Class c = Class.forName(objectElement.getAttributeValue("class"));
            Object instance = null;
            
            if (!c.isArray()) {
                Constructor x = c.getDeclaredConstructor(null);
                if (!Modifier.isPublic(x.getModifiers())) {
                    x.setAccessible(true);
                }
                instance = x.newInstance(null);
            } else {
                instance = Array.newInstance(c.getComponentType(), Integer.parseInt(objectElement.getAttributeValue("length")));
            }
            table.put(objectElement.getAttributeValue("id"), instance);
        }
    }

    private static void assignFieldValues(Map table, List<?> objectList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
