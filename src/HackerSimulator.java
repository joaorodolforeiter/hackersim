import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class HackerSimulator {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        new login();

    }



}