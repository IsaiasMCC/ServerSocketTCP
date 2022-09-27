
package Events;

import java.util.EventListener;

/**
 *
 * @author Isai
 */
public interface DataEventListener extends EventListener{
    public void OnRead(DataEvent ev);
}
