
package extras;

/**
 *
 * @author Isai
 */

public class ClientConnection {
    private String id;
    private String nick;
    private String password;
    
    public ClientConnection(String id, String nick, String password){
        this.id = id;
        this.nick = nick;
        this.password = password;
    }
    public String getId(){
        return this.id;
    }
    public String getNick(){
        return this.nick;
    }
    public String getPassword(){
        return this.password;
    }
}