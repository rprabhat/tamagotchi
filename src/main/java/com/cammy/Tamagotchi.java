package com.cammy;

import com.cammy.state.PhysicalStages;
import com.cammy.state.PhysicalState;
import com.cammy.state.LifeStages;
import com.cammy.state.LifeState;

/**
 * Simple implementation of tamagotchi.
 *
 *    Its physical behaviour and lif stage is maintained using  physicalState and  lifeState.
 *    Movement between state is driven by hungerIndex, aga and current time.
 *
 * TODO add emotional states
 *
 * Created by prabhatranjan on 15/12/2015.
 */
public class Tamagotchi {

    private PhysicalState physicalState;
    private LifeState lifeState;

    private Integer hungerIndex;
    private Integer age;

    public Tamagotchi() {
        this.lifeState = LifeStages.BABY;
        this.physicalState = PhysicalStages.SLEEPING;
        this.hungerIndex = 0;
        this.age = 0;
    }

    // feed tomagotchi. calorieIndex = food item calorie / total recommeded intake for tomagatochi.
    // TODO  take food item and calculate index by looking up calorie value.
    public void feed(Integer calorieIndex) {

        if (physicalState == PhysicalStages.AWAKE || physicalState == PhysicalStages.HUNGARY) {
            hungerIndex += (calorieIndex);
        } else {
            System.out.println("Can't eat now, I'm " + physicalState.getDescription());
        }

    }


    // loss in health due to passage of time.
    // TODO take physical activity as input and calculate calorie loss based on it.
    public void loseHealth(Integer timeInHour) {

        Integer hungerIndexLoss = Config.HUNGER_INDEX_LOSS_PER_HOUR * timeInHour;

        if (hungerIndex > 0)
            hungerIndex = hungerIndex - hungerIndexLoss;
    }

    // Force tamagotchi to sleep.
    // TODO check for other conditions too other than being DEAD. eg. can't sleep when pooping.
    public void putToBed() {

        if (lifeState != LifeStages.DEAD) {
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

    public LifeState getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
    }

    @Override
    public String toString() {
        return lifeState +
                ", " + physicalState.getDescription() +
                ", hunger=" + hungerIndex +
                ", age=" + age;
    }
}
