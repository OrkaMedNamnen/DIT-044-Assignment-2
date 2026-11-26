import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap; //?

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private ArrayList<Car> cars;
    private HashMap<String, BufferedImage> carImages = new HashMap<>();

    public DrawPanel(int x, int y, ArrayList<Car> cars){
        this.cars =cars;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension (x, y));
        this.setBackground(Color.GREEN);

    // Initializes the panel and reads the images
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.GREEN);

        // Print an error message in case file is not found with a try/catch block
        try {
            carImages.put("Volvo240",
                    ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));

            carImages.put("Saab95",
                    ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        // This method is called each time the panel updates/refreshes/repaints itself
        // TODO: Change to suit your needs.
        //draw the cars

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);

            for (Car car : cars) {
                BufferedImage image = carImages.get(car.getModelName());
                if (image != null) {
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());

                    g.drawImage(image, x, y, null);
                }
            }
        }
    }
