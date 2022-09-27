
package Events;

/**
 *
 * @author Isai
 */
import java.util.*;
public class DataEvent extends EventObject{
    private String data;
    
    public DataEvent(Object source,String data){
        super(source);
        this.data = data;
    }
    public String getData(){
        return this.data;
    }
}
