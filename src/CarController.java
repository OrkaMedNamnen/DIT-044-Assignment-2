import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // TODO A list of cars, modify if needed
    //Volvo and Saab extend Car, thus both are stored here
    //Polymorphism
    public ArrayList<Car> cars = new ArrayList<>();

    public void startTimer() {
        this.timer.start();
    }

    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images. TODO Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Car car : cars) {
                //Move both cars
                car.move();

                //Check if car has reached wall
                int maxX = frame.drawPanel.getWidth() - 100;
                int maxY = frame.drawPanel.getHeight() - 60;

                if (car.getX() < 0 || car.getX() > maxX ||
                        car.getY() < 0 || car.getY() > maxY) {

                    car.stopEngine();

                    // Keep the car inside the panel
                    double newX = Math.max(0, Math.min(car.getX(), maxX));
                    double newY = Math.max(0, Math.min(car.getY(), maxY));

                    car.setPosition(newX, newY);

                    //Change direction
                    car.turnLeft();
                    car.turnLeft();

                    //Restart
                    car.startEngine();
                }
            }
            //int maxX = frame.drawPanel.moveit(x, y);
            //repaint() calls the paintComponent method of the panel
            //frame.drawPanel.revalidate(); unneccesary since layout does not change
            frame.drawPanel.repaint();
        }
    }

    void gas(int amount) {
            // TODO adapt to your needs

        double gas = ((double) amount) / 100;

        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {

        double brake = ((double) amount) / 100;

        for (Car car : cars) {
                car.brake(brake);
        }
    }

    void turnLeft() {
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    void turnRight(){
        for (Car car : cars){
            car.turnRight();
        }
    }

    void turboOn() {

        for (Car car : cars) {
            //check if car is Saab
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            //check if car is Saab
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void startAllCars() {
        for (Car car : cars){
            car.startEngine();
        }
    }

    void stopAllCars(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
}


