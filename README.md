# bff-rover

## Java Projects with Maven
This project is using Maven to build

### Java Projects with Spring Boot
this project is using Spring boot to deploy

The implementation was written in Java using the Spring Tool IDE, Java version jdk-11.0.10 and the Runtime: Java(TM) SE Runtime Environment 11.0.10

The folder structure contains the source code

--------------------------------------
- Explanation of the solution chosen -
--------------------------------------

This solution was created using REST as backend:

------------------------------------------------------------------------------------------------------------------
route:

..../rover/doUploadFile => this is for a upload a .txt File

..../rover/doUploadData => this is for a load dada by a JSON

First was created a class called "roversContollers" this class does is expose all route to received the data to move de Rovers,
then is instanced a model call "Program" who received the instructions for rover's move, this class should not
contain complexity regarding the rover, the complexity is confined to the rover and thus any actions taking place that directly 
affect the rover were kept within the rover class.

Rover.java is a class used to define the properties and actions which a rover has or can conduct

I created several objects to maintain the code most clean possible, that help to understand how was implemented
 
