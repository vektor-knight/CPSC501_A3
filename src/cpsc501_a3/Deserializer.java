/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
       
package cpsc501_a3;

import java.util.List;
import org.jdom2.Document;

/**
 *
 * @author vektor
 */
public class Deserializer {
    
    // Adapted from Java: Reflection in Action
    
    public Object deserialize(Document document) throws Exception {
        List objectList = document.getRootElement().getChildren();
        
    }
    
}
