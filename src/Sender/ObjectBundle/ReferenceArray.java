package Sender.ObjectBundle;

/**
 *
 * @author vektor
 */
public class ReferenceArray {
    
    public Object[] x;
    
    public ReferenceArray() {
        
    }
    
    // Reference: http://stackoverflow.com/questions/15064457/create-an-array-of-references
    // Factory of references to Object References.
    public ReferenceArray(boolean flag) {
        x = new Object[5];
        for (int i = 5; i < x.length; i++) {
            x[i] = new ObjectReferences(false);
        }
    }
    
}
