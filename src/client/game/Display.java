/*
    Display window for the client
    
    copied this from single player 2d game i made a while back
    credit to codenmore from youtube for helping me learn how to make this originally
    
    Written by Kane Templeton Nov 2, 2015
 */

package client.game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Display {

    private JFrame gameFrame;
    private String title;
    private int width,height;
    private Canvas canvas;
    
    public Display(String t, int w, int h) {
        title = t;
        width = w;
        height = h;
        //createDisplay();
    }
    
    /* createDisplay():
        launches the JFrame window and sets its properties
    
    */
    public void createDisplay() {
        gameFrame = new JFrame();
        gameFrame.setTitle(title);
        gameFrame.setSize(width, height);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(false); //set to false until graphics initialize
        
        canvas = new Canvas();
        Dimension pref = new Dimension(width,height);
        Dimension min = new Dimension(300,300);
        Dimension max = new Dimension(700,700);
        canvas.setPreferredSize(pref);
        canvas.setMaximumSize(max);
        canvas.setMinimumSize(min);
        canvas.setFocusable(false);
        
        gameFrame.add(canvas);
        gameFrame.pack();
    }
    
    
    
    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame() {
        return gameFrame;
    }
    
    
    public void setVisible(boolean vis) {
        gameFrame.setVisible(vis);

    }
    
   

}

