/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;

import game.state.State;
import input.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Display extends JFrame {
    
    private Canvas canvas;
    private Renderer renderer;
    
    public Display(int width, int height, Input input) {
        setTitle("yawa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        this.renderer = new Renderer();
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();
        
        canvas.createBufferStrategy(3);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void render(State state) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        renderer.render(state, graphics);
        
        graphics.dispose();
        bufferStrategy.show();
    }
}
