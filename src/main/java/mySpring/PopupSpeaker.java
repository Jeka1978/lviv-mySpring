package mySpring;

import javax.swing.*;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
