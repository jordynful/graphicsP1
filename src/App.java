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
import java.lang.Math;
/**
 * TO do:
 * need to finish simple line algorithm
 * Comment code well
 * make video 
 * write report 5 pg
 */
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
                System.out.println(x0);
                System.out.println(y0);
                System.out.println(x1);
                System.out.println(y1);
         
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
                System.out.println(x0);
                System.out.println(y0);
                System.out.println(x1);
                System.out.println(y1);


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
        //Used only notes from class to build these algorithms
        double dX = x1 - x0;
        double dY = y1 - y0;


        if (dX > 0 && dY>=0 && Math.abs(dX)>=Math.abs(dY)) {
            double m = dY/dX;
            for (int i = 0; i < dX; i++) {
                int x = x0 + i;
                double y = (m*i) + y0;
                drawPoint(x, (int)y);
            }
  

        }
        else if (dX >= 0 && dY>0 && Math.abs(dX)<Math.abs(dY)) {
            double m = dX/dY;
            for (int i = 0; i < dY; i++) {
                int y = y0 + i;
                double x = (m*i) + x0;
                drawPoint((int)x, y);
            }

        }


        /**
         * DX negative, DY positive, DX > DY and DX < DY
         */
        else if (dX < 0 && dY>=0 && Math.abs(dX)>=Math.abs(dY)) {
            double m = dY/dX;
            drawPoint(x1, y1);
            for (int i = 0; i < -dX; i++) {
                int x = x1 + i;
                double y = (m*i) + y1;
                drawPoint(x, (int)y);
            }

        }

        else if (dX < 0 && dY>0 && Math.abs(dX)< Math.abs(dY)) {
            double m = dX/dY;
            drawPoint(x1, y1);
            for (int i = 0; i < dY; i++) {
                int y = y1 - i;
                double x = x1 - (m*i);
                drawPoint((int)x, y);
            }

        }

        /**
         * DX positive, DY negative, DX > DY and DX < DY
         */
        else if (dX > 0 && dY < 0 && Math.abs(dX)>=Math.abs(dY)) {
            double m = dY/dX;
            for (int i = 0; i < dX; i++) {
                int x = x0 + i;
                double y = y0 + (m*i);
                drawPoint(x, (int)y);
            }

        }

        else if (dX >= 0 && dY < 0 && Math.abs(dX)<Math.abs(dY)) {
            double m = dX/dY;
            for (int i = 0; i < -dY; i++) {
                int y = y1 + i;
                double x = (m*i) + x1;
                drawPoint((int)x, y);
            }

        }

        /**
         * DX negative, DY negative, DX > DY and DX < DY
         */
        else if (dX < 0 && dY < 0 && Math.abs(dX)>=Math.abs(dY)) {
            double m = dY/dX;
            for (int i = 0; i < -dX; i++) {
                int x = x1 + i;
                double y = y1 + (m*i) ;
                drawPoint(x, (int)y);
            }
  

        }


        else if (dX < 0 && dY < 0 && Math.abs(dX)< Math.abs(dY)) {

            double m = dX/dY;
            for (int i = 0; i < -dY; i++) {
                int y = y1 + i;
                double x = x1 + (m*i) ;
                drawPoint((int)x, y);
            }
  

        }
        
    }

//used https://www.javatpoint.com/computer-graphics-bresenhams-line-algorithm to help build code
    public void brz(int x0, int y0, int x1, int y1) {
        //some stuff here
        // drawPoint(x1, y1);
        int dX = x1-x0;
        int dY = y1-y0;
        int E = 2*dY - dX;
        int inc1 = 2*dY;
        int inc2 = 2*(dY-dX);
       
        /**
         * DX positive, DY positive, DX > DY and DX < DY
         */
        if (dX > 0 && dY>=0 && Math.abs(dX)>=Math.abs(dY)) {
            int y = y0;
            int x = x0;
            while (x < x1) {
                drawPoint(x, y);
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    y = y + 1;
                    E = E + inc2;
                }
                x = x + 1;
            }


        }
        else if (dX >= 0 && dY>0 && Math.abs(dX)<Math.abs(dY)) {
            System.out.println("dx pos dy pos dy greater than dx");
            int y = y0;
            int x = x0;
            E = 2*dX - dY;
            inc1 = 2*dX;
            inc2 = 2*(dX-dY);
            while (y < y1) {
                drawPoint(x, y);
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    x = x + 1;
                    E = E + inc2;
                }
                y = y + 1;
            }


        }


        /**
         * DX negative, DY positive, DX > DY and DX < DY
         */
        else if (dX < 0 && dY>=0 && Math.abs(dX)>=Math.abs(dY)) {
            E = 2*dY - Math.abs(dX);
            inc1 = 2*dY;
            inc2 = 2*(dY-Math.abs(dX));
            int y = y0;
            int x = x0;
            while (x > x1) {
                drawPoint(x, y);
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    y = y + 1;
                    E = E + inc2;
                }
                x = x - 1;
            }


        }

        else if (dX < 0 && dY>0 && Math.abs(dX)< Math.abs(dY)) {
            E = 2*Math.abs(dX) - dY;
            inc1 = 2*Math.abs(dX);
            inc2 = 2*(Math.abs(dX)-dY);
            int y = y0;
            int x = x0;
            while (y < y1) {
                drawPoint(x, y);
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    x = x - 1;
                    E = E + inc2;
                }
                y = y + 1;
            }


        }

        /**
         * DX positive, DY negative, DX > DY and DX < DY
         */
        else if (dX > 0 && dY < 0 && Math.abs(dX)>=Math.abs(dY)) {
            E = 2*Math.abs(dY) - dX;
            inc1 = 2*Math.abs(dY);
            inc2 = 2*(Math.abs(dY)-dX);
            int y = y0;
            int x = x0;
            while (x < x1) {
                drawPoint(x, y);
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    y = y - 1;
                    E = E + inc2;
                }
                x = x + 1;
            }

        }

        else if (dX >= 0 && dY < 0 && Math.abs(dX)<Math.abs(dY)) {
            E = 2*dX - Math.abs(dY);
            inc1 = 2*Math.abs(dX);
            inc2 = 2*(dX - Math.abs(dY));
            int y = y0;
            int x = x0;
            while (y > y1) {
                drawPoint(x, y);
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    x = x + 1;
                    E = E + inc2;
                }
                y = y - 1;
            }

        }

        /**
         * DX negative, DY negative, DX > DY and DX < DY
         * Used https://www.javatpoint.com/computer-graphics-bresenhams-line-algorithm for help
         */
        else if (dX < 0 && dY < 0 && Math.abs(dX)>=Math.abs(dY)) {
            inc1 = 2*Math.abs(dY);
            inc2 = 2*(Math.abs(dY) - Math.abs(dX));
            int y = y1;
            int x = x1;
            int xEnd = x0;
            E = 2 * Math.abs(dY) - Math.abs(dX);
            drawPoint(x, y);
            while (x < xEnd) {
                
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    y = y + 1;
                    E = E + inc2;
                }
                x = x + 1;

            }
        }


        else if (dX < 0 && dY < 0 && Math.abs(dX)< Math.abs(dY)) {
            inc1 = 2*Math.abs(dX);
            inc2 = 2*(Math.abs(dX) - Math.abs(dY));
            int y = y1;
            int x = x1;
            int yEnd = y0;
            E = 2 * Math.abs(dX) - Math.abs(dY);
            drawPoint(x, y);
            while (y < yEnd) {
                
                if (E<0) {
                    E = E + inc1;
                }
                else {
                    x = x + 1;
                    E = E + inc2;
                }
                y = y + 1;
                drawPoint(x, y);
            }
        }
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