package Sender.ObjectBundle;

/**
 * Referenced from:
 * https://github.com/add-em/ObjectSerializer/blob/master/ObjectReferences.java
 * @author vektor
 */
public class ObjectReferences {
    public Object o1;
    public Object o2;
    
    public ObjectReferences() {
        
    }
    
    public ObjectReferences(boolean flag) {
        o1 = new PrimitiveObject(false);
        o2 = new PrimitiveObject(false);
        o1 = o2; // Hard-coded circularity. o1 is identical to o2.
    }
    
}
