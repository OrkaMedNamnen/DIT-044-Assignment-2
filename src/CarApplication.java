public class CarApplication{

    public static void main(String[] args) {

        // Instance of this class
        CarController cc = new CarController();

        // TODO uncomment, and adapt if necessary
        //Create cars

        Volvo240 volvo = new Volvo240();
        volvo.setPosition(100, 100);

        Saab95 saab = new Saab95();
        saab.setPosition(100,250);

        cc.cars.add(volvo);
        cc.cars.add(saab);

        // Start a new view and send a reference to the controller
        cc.frame = new CarView("CarSim 1.0", cc);
        //Start timer
        cc.startTimer();
    }
}