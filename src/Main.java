public class Main {

    public static void main(String[] args) {

        CarModel model = new CarModel();
        CarController cc = new CarController(model);


        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.0", cc);

        cc.view = view;

        // Start the timer
        cc.start();

    }

}
