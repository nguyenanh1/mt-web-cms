/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Asus
 */
public class CustomToken {
    private Integer id;
    private String username;
    private Integer role;
    private long timeLogin;
    private long timeOut;

    public CustomToken() {
    }
    
    public CustomToken(String token) {
         decode(token);
    }
    
     private void decode(String token){
         String[] mTokens = token.split(",");
         setId(Integer.parseInt(mTokens[0]));
         setUsername(mTokens[1]);
         setRole(Integer.parseInt(mTokens[2]));
         setTimeLogin(Long.parseLong(mTokens[3]));
         setTimeOut(Long.parseLong(mTokens[4]));
     }

    public CustomToken(Integer id, String username, Integer role, long timeLogin, int timeOut) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.timeLogin = timeLogin;
        this.timeOut = timeOut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(long timeLogin) {
        this.timeLogin = timeLogin;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
    
    public String getToken(){
        return id+","+username+","+role+","+timeLogin+","+timeOut;
    }
    
    public boolean tokenTimeout(){
        long timeout = System.currentTimeMillis()-getTimeLogin()-getTimeOut();
        System.out.println(timeout);
        return timeout>0;
    }
}
