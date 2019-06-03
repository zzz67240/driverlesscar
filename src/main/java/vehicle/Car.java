package vehicle;

import exception.OutOfRangeException;

public interface Car {
    void move(int xAxisDimension, int yAxisDimension, int steps) throws OutOfRangeException;
    void turnClockwise();
    String getOrientation();
    void setOrientation(int orientation);
    int getPositionX();
    void setPositionX(int positionX);
    int getPositionY();
    void setPositionY(int positionY);
}