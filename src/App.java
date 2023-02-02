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
        System.out.println("Which function would you like to use? \n 1 - Basic-Alg \n 2 - Bresenham");
        int choice = keyboard.nextInt();
        System.out.println("How many lines would you like to draw");
        int n = keyboard.nextInt();
        Random rand = new Random();
        int x0;
        int y0;
        int x1;
        int y1;
        drawGraph();
        if (choice == 1) {
            for (int i = 0; i < n; i++) {
                x0 = rand.nextInt(380);
                y0 = rand.nextInt(380);
                x1 = rand.nextInt(380);
                y1 = rand.nextInt(380);
                basicAlg(x0, y0, x1, y1);

            }
            //randomly generate for N here and send each to basicAlg()
        }
        else {
            for (int i = 0; i < n; i++) {
                x0 = rand.nextInt(380);
                y0 = rand.nextInt(380);
                x1 = rand.nextInt(380);
                y1 = rand.nextInt(380);
                brz(x0, y0, x1, y1);

            }
            //randomly generate for N here and send each to BRz()
        }

    }

    //used for testing
    public void test() {
        Scanner keyboard = new Scanner(System.in);
        drawGraph();
        System.out.println("Enter x_0");
        int x0 = keyboard.nextInt();
        System.out.println("Enter y_0");
        int y0 = keyboard.nextInt();
        System.out.println("Enter x_1");
        int x1 = keyboard.nextInt();
        System.out.println("Enter y_1");
        int y1 = keyboard.nextInt();
        drawPoint(x0,y0);
        drawPoint(x1,y1);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }
    //Got this part of the code from https://stackoverflow.com/questions/3325546/how-to-color-a-pixel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
        
    }

    public void drawPoint(int x, int y) {
        int col = Color.BLACK.getRGB();
        //Graph starts at x=10 y=380
        x = x + 10;
        y = 380 - y;
        canvas.setRGB(x, y, col);
        repaint();
    } 
//Got this part of the code from https://stackoverflow.com/questions/3325546/how-to-color-a-pixel
    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void drawGraph() {
        int color = Color.BLACK.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.setRGB(x, 380, color);
        }
        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.setRGB(10, y, color);
        }

    }

    public void basicAlg(int x0, int y0, int x1, int y1) {
        //some stuff here
        drawPoint(x1, y1);
        
    }

    public void brz(int x0, int y0, int x1, int y1) {
        //some stuff here
        drawPoint(x1, y1);
    }

    public static void main(String[] args) 
    {
        // Scanner keyboard = new Scanner(System.in);
        //Got this part of the code from https://stackoverflow.com/questions/3325546/how-to-color-a-pixel
        int width = 400;
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