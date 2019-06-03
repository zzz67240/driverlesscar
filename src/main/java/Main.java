import exception.OutOfRangeException;
import place.CarPark;
import vehicle.DriverlessCar;

import java.util.Scanner;

public class Main {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        CarPark carPark = new CarPark();
        DriverlessCar driverlessCar = new DriverlessCar();

        //Set dimension for the car park
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
            System.out.println("Where is the car facing to? 0=North, 1=East, 2=South, 3=West. ");
            String oriInput = scanner.nextLine();
            if(isInt(xInput) && isInt(yInput) && isInt(oriInput)){
                int x = Integer.parseInt(xInput);
                int y = Integer.parseInt(yInput);
                int o = Integer.parseInt(oriInput);
                if(x > 0 && x <= carPark.getxAxisDimension() &&
                        y > 0 && y <= carPark.getyAxisDimension()){
                    if(o >= 0 && o <= 3){
                        driverlessCar.setPositionX(x);
                        driverlessCar.setPositionY(y);
                        driverlessCar.setOrientation(o);
                        System.out.println("Car is placed at: " + driverlessCar.getPositionX() + ", " + driverlessCar.getPositionY()
                                + " and facing: " + driverlessCar.getOrientationString());
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
            int oriSwitch = 0;
            if(isInt(turnOriInput)){
                switch (Integer.parseInt(turnOriInput)){
                    case 0:
                        System.out.println("Keep current orientation: " + driverlessCar.getOrientationString());
                        break;
                    case 1:
                        driverlessCar.turnClockwise();
                        oriSwitch = 1;
                        System.out.println("Turn the car clockwise, it's facing: " + driverlessCar.getOrientationString());
                        break;
                    default:
                        System.out.println("Wrong input range. Please input again.");
                        continue;
                }
            } else {
                System.out.println("Wrong format. Please input again.");
                continue;
            }
            System.out.println("How many steps would you like to move?");
            String stepsInput = scanner.nextLine();
            if(isInt(stepsInput) && Integer.parseInt(stepsInput) >= 0){
                try {
                    driverlessCar.move(carPark.getxAxisDimension(), carPark.getyAxisDimension(), Integer.parseInt(stepsInput));
                } catch (OutOfRangeException e) {
                    e.printStackTrace();
                    //As this app is for demonstration, so we catch the exception and printStackTrace but keep the program running.
                    //It can stop the program by uncommenting "break;" and commenting out the following paragraph in catch block.
                    //break;
                    if(driverlessCar.getPositionX() > carPark.getyAxisDimension()){
                        driverlessCar.setPositionX(driverlessCar.getPositionX() - Integer.parseInt(stepsInput));
                    } else if (driverlessCar.getPositionX() <= 0){
                        driverlessCar.setPositionX(driverlessCar.getPositionX() + Integer.parseInt(stepsInput));
                    } else if (driverlessCar.getPositionY() > carPark.getyAxisDimension()){
                        driverlessCar.setPositionY(driverlessCar.getPositionY() - Integer.parseInt(stepsInput));
                    } else {
                        driverlessCar.setPositionY(driverlessCar.getPositionY() + Integer.parseInt(stepsInput));
                    }
                    if(oriSwitch == 1){
                        driverlessCar.turnCounterclockwise();
                    }
                    System.out.println("The car is out of car park range. We've moved the car back.");
                }
            } else {
                if(oriSwitch == 1){
                    driverlessCar.turnCounterclockwise();
                }
                System.out.println("Wrong format or input range. Please input again.");
            }
            System.out.println("Current location of the car is: " + driverlessCar.getPositionX() + ", " + driverlessCar.getPositionY()
                    + ". And it's facing: " + driverlessCar.getOrientationString());
            System.out.println("The dimension of the car park is: " + carPark.getxAxisDimension() + ", " + carPark.getyAxisDimension());
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