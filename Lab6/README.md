# lab6
    
# SOLID Principles
Single-responsibility principle (SRP)
    
    I changed the classes to have each of them their specific responsibility, 
    one class does not have a massive list of actions and code inside of it, 
    it has just one responsibility to fulfill.

Open-closed principle (OCP)
    
    I made classes possible to extend its functionality by extensions not directly 
    modifying it by brute forcing the code.

Liskov substitution principle (LSP)
    
    The actions performed by a parent class can be made by the child class too.

Interface segregation principle (ISP)

    I made different interfaces for specific purposes in order to not having a class 
    implementing an interface that is not needing.

Dependency inversion Principle (DIP)

    Made classes independent by implementing different interfaces.
    
# Design Pattern
    Implemented MVC archictectural pattern, made a pacakge for each Model, View and Controller.
    All the terminal output is in the View package, the Model updates View with information from Model.
    The model designs based on the MVC architecture follow MVC design pattern. The application logic is 
    separated from the user interface while designing the software using model designs.