package com.cammy;

import com.cammy.state.PhysicalStages;
import com.cammy.state.PhysicalState;
import com.cammy.state.LifeStages;
import com.cammy.state.LifeState;

/**
 * Created by prabhatranjan on 15/12/2015.
 */
public class Tamagotchi {

    private PhysicalState physicalState;
    private LifeState lifeState;

    //TODO
    // private EmotionalStage emotionalStage;


    private Integer hungerIndex;
    private Integer age;

    public Tamagotchi() {
        this.lifeState = LifeStages.BABY;
        this.physicalState = PhysicalStages.SLEEPING;
        this.hungerIndex = 0;
        this.age = 0;
    }

    public void feed(Integer calorie) {

        if( physicalState == PhysicalStages.AWAKE || physicalState == PhysicalStages.HUNGARY){
            hungerIndex += ( calorie);
        } else {
            System.out.println("Can't eat now, I'm " + physicalState.getDescription());
        }

    }

    public void putToBed() {

        if(lifeState != LifeStages.DEAD) {
            this.physicalState = PhysicalStages.SLEEPING;
        }
    }

    public PhysicalState getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(PhysicalState physicalState) {
        this.physicalState = physicalState;
    }

    public Integer getHungerIndex() {
        return hungerIndex;
    }

    public void setHungerIndex(Integer hungerIndex) {
        this.hungerIndex = hungerIndex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LifeState getLifeState() {   return lifeState;   }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
    }

    @Override
    public String toString() {
        return  lifeState +
                ", " + physicalState.getDescription() +
                ", hunger=" + hungerIndex +
                ", age=" + age;
    }
}
