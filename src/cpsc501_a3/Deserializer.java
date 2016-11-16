/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
       
package cpsc501_a3;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
    // Method calls such as "Mopex" changed to reflective ones.
    
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

    private static void assignFieldValues(Map table, List<?> objectList) throws Exception {
        for (int i = 0; i < objectList.size(); i++) {
            Element objectElement = (Element) objectList.get(i);
            Object instance = table.get(objectElement.getAttributeValue("id"));
            List fieldElements = objectElement.getChildren();
            
            if (!instance.getClass().isArray()) {
                for (int j = 0; j < fieldElements.size(); j++) {
                    Element fieldElement = (Element) fieldElements.get(j);
                    String className = fieldElement.getAttributeValue("declaringclass");
                    Class fieldDeclaring = Class.forName(className);
                    String fieldName = fieldElement.getAttributeValue("name");
                    Field f = fieldDeclaring.getDeclaredField(fieldName);
                    
                    if (!Modifier.isPublic(f.getModifiers())) {
                        f.setAccessible(true);
                    }
                    Element e = (Element) fieldElement.getChildren().get(0);
                    f.set(instance, deserializeValue(e, f.getType(), table));                    
                }
            } else {
                Class componentType = instance.getClass().getComponentType();
                for (int j = 0; j < fieldElements.size(); j++) {
                    Array.set(instance, j, deserializeValue((Element) fieldElements.get(j), componentType, table));
                }
            }
        }
    }

    private static Object deserializeValue(Element e, Class<?> type, Map table) {
        String elementType = e.getName();
        if (elementType.equals("null")) {
            return null;
        } else if (elementType.equals("reference")) {
            return table.get(e.getText());
        } else {
            
        }
    }
    
}
