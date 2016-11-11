package jugendfeuerwehrleitstelle;

import java.awt.Image;
import javax.swing.ImageIcon;
import jugendfeuerwehrleitstelle.forms.Login;

/**
 *
 * @author Timo 
 */
public class JugendfeuerwehrLeitstelle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login log = new Login();
        
        Image icon = new ImageIcon( "img/icon.png" ).getImage();
        
        log.setIconImage(icon);
        
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.setFocusable(true);
        
    }
    
}
