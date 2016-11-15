/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
       
package cpsc501_a3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom2.Document;

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

    private static void createInstances(Map table, List<?> objectList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void assignFieldValues(Map table, List<?> objectList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
