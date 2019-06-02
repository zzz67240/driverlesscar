package vehicle;

public class DriverlessCar implements Car{

    private int orientation;
    private int positionX;
    private int positionY;

    public void move(String command) {

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