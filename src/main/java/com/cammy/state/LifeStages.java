package com.cammy.state;

import com.cammy.Config;
import com.cammy.Tamagotchi;

/**
 * Created by prabhatranjan on 16/12/2015.
 */
public enum LifeStages implements LifeState {

    BABY {
        public void action(final Tamagotchi tamagotchi) {

            if (tamagotchi.getAge() >= Config.BABY_AGE_LIMIT) {
                tamagotchi.setLifeState(LifeStages.CHILD);
            }
        }
    },
    CHILD {
        public void action(Tamagotchi tamagotchi) {

            if(tamagotchi.getAge() >= Config.CHILD_AGE_LIMIT){
                tamagotchi.setLifeState(LifeStages.TEEN);
            }
        }
    },
    TEEN {
        public void action(Tamagotchi tamagotchi) {

            if(tamagotchi.getAge() >= Config.TEEN_AGE_LIMIT){
                tamagotchi.setLifeState(LifeStages.ADULT);
            }
        }
    },
    ADULT {
        public void action(Tamagotchi tamagotchi) {
            if (tamagotchi.getAge() >= Config.ADULT_AGE_LIMIT) {
                tamagotchi.setLifeState(LifeStages.OLD);
            }
        }
    },
    OLD {
        public void action(Tamagotchi tamagotchi) {
            if(tamagotchi.getAge() >= Config.MAX_AGE){
                tamagotchi.setLifeState(LifeStages.DEAD);
            }
        }
    },
    DEAD {
        // No action , when dead
        public void action(Tamagotchi tamagotchi) {

        }
    }

}


