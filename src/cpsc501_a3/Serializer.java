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
    // serialize(..) and serialzeHelper(..) from "Java: Reflection in Action"

    // Going to start with adapting textbook snippets, and then
    // refactoring. Test completed methods before/after refactoring.
    /**
     *
     * @param obj
     * @return Serialized object in XML format
     * @throws java.lang.Exception
     */
    public Document serialize(Object obj) throws Exception {
        // Wrapper of serializeHelper(..)
        return serializeHelper(obj, new Document(new Element("serialized")), new IdentityHashMap());  
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

    /**
     * 
     * @param obj
     * @param document
     * @param identityHashMap
     * @return
     * @throws Exception 
     */
    private static Document serializeHelper(Object obj, Document document, IdentityHashMap identityHashMap) throws Exception {
        // Step 1: Create unique identifier number for object being serialized
        String id = Integer.toString(identityHashMap.size());
        identityHashMap.put(obj, id);   // Object is the "source", Document is the "target"
        Class classObject = obj.getClass();
        // End Step 1.
        // Step 2: Create XML element for the source.
        Element objectElement = new Element("object");
        objectElement.setAttribute("class", classObject.getName());
        objectElement.setAttribute("id", id);
        document.getRootElement().addContent(objectElement);
        // End Step 2.
        // Step 3: Handle field elements
        if (!classObject.isArray()) {
            // Step 4: Get nonstatic fields
            Field[] fields = classObject.getDeclaredFields();
            // End Step 4.
            for (Field f : fields) {
                if (!Modifier.isPublic(f.getModifiers())) {
                    f.setAccessible(true); // Step 5: Make fields accessible, if required.
                } 
                // Step 6: Create new XML elements from field elements
                Element fieldElement = new Element("field");
                fieldElement.setAttribute("name", f.getName());
                Class declaringClass = f.getDeclaringClass();
                fieldElement.setAttribute("declaringclass", declaringClass.getName());
                Class fieldType = f.getType();
                Object child = f.get(obj);
                
                if (Modifier.isTransient(f.getModifiers())) {
                    child = null;
                }
                fieldElement.addContent(serializeVariable(fieldType, child, document, identityHashMap));
                objectElement.addContent(fieldElement);
            }
            // Step 7: Add array components to XML document
        } else {
            Class componentType = classObject.getComponentType();
            int length = Array.getLength(obj);
            objectElement.setAttribute("length", Integer.toString(length));
            for (int i = 0; i < length; i++) {
                objectElement.addContent(serializeVariable(componentType, Array.get(obj, i), document, identityHashMap));
            }
        }
        return document;
    }
   // This method does not create two separate serializeVariable templates now
    
    /**
     * 
     * @param fieldType
     * @param child
     * @param document
     * @param identityHashMap
     * @return
     * @throws Exception 
     */
    private static Element serializeVariable(Class fieldType, Object child, Document document, IdentityHashMap identityHashMap) throws Exception {
        if (child == null) {
            return new Element("null");
        } else if (!fieldType.isPrimitive()) {
            Element reference = new Element("reference");
            if (identityHashMap.containsKey(child)) {
                reference.setText(identityHashMap.get(child).toString());
            } else {
                reference.setText(Integer.toString(identityHashMap.size()));
                serializeHelper(child, document, identityHashMap);
            }
            return reference;
        } else {
            Element value = new Element("value");
            value.setText(child.toString());
            return value;
        }
    }
    
    // At this point, noted that serialize(..) is the only method
    // for which tests are being generated. This is because each
    // subsequent helper method is ultimately returning a Document,
    // instead of an object of type Element. So, when the constituent
    // test suite is being generated, it is being done so for serialize(..),
    // since this is where the "pointer" or "reference" to the actual Document
    // is being passed to. In the future, when test objects are created,
    // we will only be testing them against this method. If the test passes,
    // it will be a consequence that all helper methods are doing their jobs
    // correctly.
    
}
