package com.cammy;

import com.cammy.state.LifeState;
import com.cammy.state.PhysicalStages;
import com.cammy.state.PhysicalState;

import java.util.Scanner;

/**
 * Created by prabhatranjan on 16/12/2015.
 */
public class Simulation {

    private Integer currentHour;
    private Integer currentDay;

    private Tamagotchi tamagotchi;

    public void init(){

        tamagotchi  = new Tamagotchi();
        currentHour = 0;
        currentDay = 0;
    }

    private void userInput() {

        Scanner inputReader = new Scanner(System.in);
        String input = inputReader.next().toLowerCase();

        if (input.equals("s")) {
            step();

        } else if (input.equals("f")) {
            tamagotchi.feed(10);

        } else if (input.equals("b")) {
            tamagotchi.setPhysicalState(PhysicalStages.SLEEPING);

        } else if (input.equals("x")) {
            shutDown();

        } else {
            System.out.println("Invalid input");
        }
    }

    private void shutDown() {
        tamagotchi = null;
        System.exit(1);
    }

    // Step through simulation.
    // It simulates passage of time. Changes internal state.
    private void step() {

        LifeState lifeState = tamagotchi.getLifeState();
        PhysicalState physicalState = tamagotchi.getPhysicalState();
        Integer age = tamagotchi.getAge();
        Integer hungerIndex = tamagotchi.getHungerIndex();

        currentHour += Config.SIMULATION_STEP_HOUR;
        if(currentHour > 24) {
            currentDay =+ 1;
            currentHour = currentHour % 24;
            age =+1;
        }
        tamagotchi.setAge(age);

        // Losses energy as time passes.
        if(tamagotchi.getHungerIndex() > 0)
            tamagotchi.setHungerIndex(hungerIndex - Config.HUNGER_INDEX_LOSS_PER_STEP);

        lifeState.action(tamagotchi);
        physicalState.action(tamagotchi, currentHour);


    }

    public  void run(){

        init();

        while( true) {

            System.out.print(String.format("%-20s %-40s" , tamagotchi.getLifeState(), tamagotchi.getPhysicalState().getDescription()));
            System.out.print(String.format(" %30s", "(" + tamagotchi.getHungerIndex() + " , " + tamagotchi.getAge() + " , " +  currentDay + ":" + currentHour + ") ? "));
            userInput();
        }
    }

    public static void main(String[] args) {

        Simulation simulation = new Simulation();

        System.out.println("Please enter choice : Step through simulation (s), Feed (f), put to Bed (b), exit (x) ");
        System.out.println(String.format("%-20s %-40s %30s" , "Life Stage", "Physical Stage", "(hunger,age,day:hour)"));

        simulation.run();
    }

}
