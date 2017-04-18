/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Ioana
 */
public class ShareData {
    private static  String type;
    private static boolean visible;
    private static String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        ShareData.visible = visible;
    }

    public ShareData() {
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
