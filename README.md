# Tamagotchi  #

A sample project to demonstrate [tamagotchi](http://en.wikipedia.org/wiki/Tamagotchi) behaviour through time.

Currently following has been implemented :

 - Growing old with time ( life cycle, BABY, CHILD, TEEN, ADULT, OLD )
 - Changing physical state through the day. ( AWAKE, HUNGARY, EXICTED, POOPING,  SLEEPING)
 - Can die  either due to hunger or old age.
 - Poop at scheduled time or in case of over eating.



### Installation dependencies ###

The following dependencies are necessary: 

 - Java 8
 - maven 3
 
 Only external dependency is on junit, which is used for unit testing.


### Building and starting the server ###

To build the application, run the following command on the root folder of the repository:

    mvn clean install 


### Implemantion Overview ###

Tamagotchi changes  behaviour based on internal state. 
Tamagotchi internal state ( both life cycle and physical ) is implemented using state pattern.
Currently, tt run in single thread only prompting user to take action. 
User can step through simulation, feed, put it bed or exit the application.
Each step in simulation is equivalent to 4 hours ( Config.SIMULATION_STEP_HOUR ) of time.


### Testing code coverage ###

Test case covers basic life stages and physical stages.

