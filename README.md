Coding Test: Driverless Car

Author: Xin Yang

Version: 1.0

Introduction:
1. This tiny app is designed as the concept of driverless car.
2. It's a console app which needs keyboard input to demonstrate.
3. User can define the dimension of the car park with X and Y axis.
4. Put the car in the car park with X and Y axis coordinates.
5. Move the car with:

    (1.) Turn clockwise or not. 
    
    (2.) Steps to move forward.
6. This app will catch common operating errors.
7. For better demonstration, this app will not interupt when catching exception ifthe car goes out of the car park range, it will move the car back to the last position.

Due to it's a coding test, we don't show too much detail here, but it should meet following acceptance criteria:

- Given the Car is in position X = 1 and Y = 1 and facing North, when the Car turns clockwise, then the Car is still in the same position but is now facing East

- Given the Car is in position X = 1 and Y = 1 and facing North, when the Car moves forward, then the Car is still facing North but is now in position X = 1 and Y = 2

- Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward, then the Car is still facing East but is now in position X = 2 and Y = 1

- Given the Car is in position X = 1 and Y = 1 and facing West, when the Car moves forward, then an exception is thrown

- Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward twice, then the Car is still facing East but is now in position X = 3 and Y = 1

Notes:

·  Acceptance criteria is what we can verify the functionalities of the application. They should be easy, automatic, repeatable ran and built for maintainability purpose.
