package org.darkdev5.lib.swing.text.listeners;

import org.apache.commons.lang3.StringUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class NumberListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        if (!StringUtils.isNumeric(String.valueOf(e.getKeyChar()))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
