/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsc501_a3;

// JDOM dependencies added; works
import org.jdom2.*;

// Required Java libraries
import java.lang.reflect.*;
import java.util.*;

/**
 *
 * @author vektor
 */
public class Serializer {
    
    // Assignment specification:
    // Serialization will be invoked with the following method:

    /**
     *
     * @param obj
     * @return Serialized object in XML format
     */
    public Document serialize(Object obj) {
        //
        return null;  
    }
    
    // Programming Plan:
            // The element "object" will have two attributes:
                // Class: Name of the object's class (eg. *.class) -> Get reflectively 
                // ID: Unique identifier number of the object -> IdentityHashMap
            
            // Each "object" element will have >=0 "field" elements
                // Attributes:
                    // Name
                    // Declaring Class -> get reflectively
                        // If field type is primitive, store as "value" element
    
    
    
}
