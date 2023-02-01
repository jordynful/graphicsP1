import java.awt.FlowLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class App extends JPanel {
    private BufferedImage canvas;

    public App(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        loop();
        // fillCanvas(Color.BLUE);
        drawPoint(15, 15);
        drawPoint(30, 30);
    
    }

    public void loop() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter x_0");
        int x0 = keyboard.nextInt();
        System.out.println("Enter y_0");
        int y0 = keyboard.nextInt();
        drawPoint(x0,y0);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
        
    }

    public void drawPoint(int x, int y) {
        int col = Color.BLACK.getRGB();
        canvas.setRGB(x, y, col);
        repaint();
    } 

    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }
    public static void main(String[] args) 
    {
        // Scanner keyboard = new Scanner(System.in);
        int width = 600;
        int height = 400;
        App d = new App(width, height);
        JFrame f = new JFrame("Display Graphic Drawings");
        f.add(d);
        f.pack();
    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }
}