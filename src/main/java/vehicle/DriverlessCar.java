package vehicle;

import exception.OutOfRangeException;

public class DriverlessCar implements Car{

    private int orientation;
    private int positionX;
    private int positionY;

    public void move(int xAxisDimension, int yAxisDimension, int steps) throws OutOfRangeException {
        switch (orientation){
            case 0:
                positionY+=steps;
                break;
            case 1:
                positionX+=steps;
                break;
            case 2:
                positionY-=steps;
                break;
            case 3:
                positionX-=steps;
                break;
        }
        if(positionX > xAxisDimension || positionX <= 0 ||
                positionY > yAxisDimension || positionY <= 0){
            throw new OutOfRangeException();
        }
    }

    public void turnClockwise(){
        orientation++;
        if(orientation > 3){
            orientation = 0;
        }
    }

    public void turnCounterclockwise(){
        orientation--;
        if(orientation < 0){
            orientation = 3;
        }
    }

    public int getOrientation(){
        return orientation;
    }

    public String getOrientationString() {
        switch (orientation){
            case 0:
                return "North";
            case 1:
                return "East";
            case 2:
                return "South";
            case 3:
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