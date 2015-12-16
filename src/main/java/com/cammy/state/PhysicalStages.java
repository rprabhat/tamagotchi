package com.cammy.state;

import com.cammy.Config;
import com.cammy.Tamagotchi;

/**
 * Created by prabhatranjan on 16/12/2015.
 */
public enum PhysicalStages implements PhysicalState {

    AWAKE {
        public String getDescription() {
            return "Awake..        ";
        }

        public void action(Tamagotchi tamagotchi, Integer currentHour) {

            if (currentHour >= Config.SLEEP_HOUR_START || currentHour <= Config.SLEEP_HOUR_END) {
                tamagotchi.setPhysicalState(SLEEPING);
            } else if (tamagotchi.getHungerIndex() >= 100 || currentHour == Config.EVENING_POOP_TIME || currentHour == Config.MORNING_POOP_TIME) {
                tamagotchi.setPhysicalState(POOPING);
            } else if (tamagotchi.getHungerIndex() > Config.HIGH_ENERGY_LEVEL && tamagotchi.getHungerIndex() < 100) {
                tamagotchi.setPhysicalState(EXICTED);
            } else if (tamagotchi.getHungerIndex() < Config.HUNGER_LEVEL) {
                tamagotchi.setPhysicalState(HUNGARY);
            }

        }
    },
    HUNGARY {

        public String getDescription() {
            return "Hungary.. feed me";
        }

        public void action(Tamagotchi tamagotchi, Integer currentHour) {

            if (tamagotchi.getHungerIndex() > Config.HIGH_ENERGY_LEVEL && tamagotchi.getHungerIndex() < 100.00)
                tamagotchi.setPhysicalState(EXICTED);
            else if (tamagotchi.getHungerIndex() > Config.HUNGER_LEVEL && tamagotchi.getHungerIndex() < Config.HIGH_ENERGY_LEVEL)
                tamagotchi.setPhysicalState(AWAKE);
            else if (tamagotchi.getHungerIndex() <= 0.0)
                tamagotchi.setLifeState(LifeStages.DEAD);
        }
    },
    EXICTED {

        public String getDescription() {
            return "Excited.. Jumping in joy";
        }

        public void action(Tamagotchi tamagotchi, Integer currentHour) {

            // engery loss due to jumping
            tamagotchi.setHungerIndex(tamagotchi.getHungerIndex() - 10);

            // if energy less than threshold, change stage
            if (tamagotchi.getHungerIndex() < Config.HUNGER_LEVEL)
                tamagotchi.setPhysicalState(HUNGARY);
            else if (tamagotchi.getHungerIndex() > Config.HUNGER_LEVEL &&
                    tamagotchi.getHungerIndex() < Config.HIGH_ENERGY_LEVEL)
                tamagotchi.setPhysicalState(AWAKE);
        }
    },
    POOPING {

        public String getDescription() {  return "Pooping.. please look away :)";
        }
        public void action(Tamagotchi tamagotchi, Integer currentHour) {
            tamagotchi.setPhysicalState(AWAKE);
        }
    },
    SLEEPING {

        public String getDescription() {
            return "Sleeping.. don't disturb";
        }

        public void action(Tamagotchi tamagotchi, Integer currentHour) {
            if(currentHour < Config.SLEEP_HOUR_START && currentHour > Config.SLEEP_HOUR_END)
                tamagotchi.setPhysicalState(AWAKE);
        }
    }
}
