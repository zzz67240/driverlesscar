import exception.OutOfRangeException;
import place.CarPark;
import vehicle.DriverlessCar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        CarPark carPark = new CarPark();
        DriverlessCar driverlessCar = new DriverlessCar();

        //Set dimension of the car park
        System.out.println("Let's set the dimension of the car park first.");
        while (true){
            System.out.println("Please input the X axis dimension:");
            String xInput = scanner.nextLine();
            System.out.println("Please input the Y axis dimension:");
            String yInput = scanner.nextLine();
            if(isInt(xInput) && Integer.parseInt(xInput) > 0 &&
                    isInt(yInput) && Integer.parseInt(yInput) > 0 ){
                carPark.setxAxisDimension(Integer.parseInt(xInput));
                carPark.setyAxisDimension(Integer.parseInt(yInput));
                System.out.println("Car park dimension is set to: " + carPark.getxAxisDimension() + ", " + carPark.getyAxisDimension());
                break;
            } else {
                System.out.println("Wrong input format or input equals to or smaller than 0. Please input again.");
            }
        }

        //Place the car
        System.out.println("Let's place the car in the car park.");
        while (true){
            System.out.println("Please input the X coordinate:");
            String xInput = scanner.nextLine();
            System.out.println("Please input the Y coordinate:");
            String yInput = scanner.nextLine();
            System.out.println("Where is the car facing to? 1=North, 2=East, 3=South, 4=West. ");
            String orientationInput = scanner.nextLine();
            if(isInt(xInput) && isInt(yInput) && isInt(orientationInput)){
                int x = Integer.parseInt(xInput);
                int y = Integer.parseInt(yInput);
                int o = Integer.parseInt(orientationInput);
                if(x > 0 && x <= carPark.getxAxisDimension() &&
                        y > 0 && y <= carPark.getyAxisDimension()){
                    if(o >= 1 && o <= 4){
                        driverlessCar.setPositionX(x);
                        driverlessCar.setPositionY(y);
                        driverlessCar.setOrientation(o);
                        System.out.println("Car is place at: " + driverlessCar.getPositionX() + ", " + driverlessCar.getPositionY()
                                + " and facing: " + driverlessCar.getOrientation());
                        break;
                    } else {
                        System.out.println("Incorrect orientation. Please input again.");
                    }
                } else {
                    System.out.println("The position is too small or out of car park range. Please input again.");
                }
            } else {
                System.out.println("Wrong input format. Please input again.");
            }
        }

        //Move the car
        while (true){
            System.out.println("Let's move the car.");
            System.out.println("Would you like to turn the car clockwise? 0=No, 1=Yes.");
            String turnOriInput = scanner.nextLine();
            if(isInt(turnOriInput)){
                switch (Integer.parseInt(turnOriInput)){
                    case 0:
                        System.out.println("Keep current orientation.");
                        break;
                    case 1:
                        driverlessCar.turnClockwise();
                        System.out.println("Turn the car clockwise, it's facing: " + driverlessCar.getOrientation());
                        break;
                    default:
                        System.out.println("Wrong input range. Please input again.");
                }
            } else {
                System.out.println("Wrong format. Please input again.");
            }
            System.out.println("How many steps would you like to move?");
            String stepsInput = scanner.nextLine();
            if(isInt(stepsInput)){
                try {
                    int steps = Integer.parseInt(stepsInput);
                    driverlessCar.move(carPark.getxAxisDimension(), carPark.getyAxisDimension(), steps);
                } catch (OutOfRangeException e) {
                    e.printStackTrace();
                    if(driverlessCar.getPositionX() > carPark.getyAxisDimension()){
                        driverlessCar.getPositionX()-=Integer.parseInt(stepsInput);
                    } else if (driverlessCar.getPositionX() < 0){
                        driverlessCar.getPositionX()+=steps;
                    } else if (driverlessCar.getPositionY() > carPark.getyAxisDimension()){
                        driverlessCar.getPositionY()-=step
                    }
                }
            } else {
                System.out.println("Wrong format. Please input again.");
            }
        }

    }

    private static boolean isInt(String string){

        try{
            Integer.parseInt(string);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}