package vehicle;

import exception.OutOfRangeException;

public class DriverlessCar implements Car{

    private int orientation;
    private int positionX;
    private int positionY;

    public void move(int xAxisDimension, int yAxisDimension, int steps) throws OutOfRangeException {
        switch (orientation){
            case 1:
                positionY+=steps;
            case 2:
                positionX+=steps;
            case 3:
                positionY-=steps;
            case 4:
                positionX-=steps;
        }
        if(positionX > xAxisDimension || positionX <= 0 ||
                positionY > yAxisDimension || positionY <= 0){
            throw new OutOfRangeException();
        }
    }

    public void turnClockwise(){
        orientation++;
        if(orientation > 4){
            orientation = 1;
        }
    }

    public String getOrientation() {
        switch (orientation){
            case 1:
                return "North";
            case 2:
                return "East";
            case 3:
                return "South";
            case 4:
                return "West";
        }
        return null;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}