import com.cammy.Config;
import com.cammy.Tamagotchi;
import com.cammy.state.LifeStages;
import com.cammy.state.LifeState;
import com.cammy.state.PhysicalStages;
import com.cammy.state.PhysicalState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prabhatranjan on 17/12/2015.
 */
public class TamagotchiTest {

    private Integer currentHour;
    private Integer currentDay;

    private Tamagotchi tamagotchi;

    @Before
    public void setup() {
        tamagotchi = new Tamagotchi();
        currentHour = 0;
        currentDay = 0;


    }

    @After
    public void tearDown() {

        tamagotchi = null;
    }


    @Test
    public void testLifeStatges() {

        LifeState currentState = tamagotchi.getLifeState();
        assertEquals(LifeStages.BABY, currentState);

        tamagotchi.setAge(Config.BABY_AGE_LIMIT); currentState.action(tamagotchi);
        assertEquals(LifeStages.CHILD, tamagotchi.getLifeState());

        currentState = tamagotchi.getLifeState();
        tamagotchi.setAge(Config.CHILD_AGE_LIMIT); currentState.action(tamagotchi);
        assertEquals(LifeStages.TEEN, tamagotchi.getLifeState());

        currentState = tamagotchi.getLifeState();
        tamagotchi.setAge(Config.TEEN_AGE_LIMIT); currentState.action(tamagotchi);
        assertEquals(LifeStages.ADULT, tamagotchi.getLifeState());

        currentState = tamagotchi.getLifeState();
        tamagotchi.setAge(Config.ADULT_AGE_LIMIT); currentState.action(tamagotchi);
        assertEquals(LifeStages.OLD, tamagotchi.getLifeState());

        currentState = tamagotchi.getLifeState();
        tamagotchi.setAge(Config.MAX_AGE); currentState.action(tamagotchi);
        assertEquals(LifeStages.DEAD, tamagotchi.getLifeState());

    }

    @Test
    public void testPhysicalStatges() {

        PhysicalState currentState = tamagotchi.getPhysicalState();
        assertEquals(PhysicalStages.SLEEPING, currentState);

        currentState.action(tamagotchi, Config.SLEEP_HOUR_END + 1);
        assertEquals(PhysicalStages.AWAKE, tamagotchi.getPhysicalState());

        currentState = tamagotchi.getPhysicalState();
        tamagotchi.setHungerIndex(Config.HIGH_ENERGY_LEVEL);
        currentState.action(tamagotchi,Config.SLEEP_HOUR_START + 1);
        assertEquals(PhysicalStages.SLEEPING, tamagotchi.getPhysicalState());

    }

    @Test
    public void testPoopOnFixedTime() {

        PhysicalState currentState = tamagotchi.getPhysicalState();
        assertEquals(PhysicalStages.SLEEPING, currentState);

        currentState.action(tamagotchi, Config.SLEEP_HOUR_END + 1);
        assertEquals(PhysicalStages.AWAKE, tamagotchi.getPhysicalState());

        currentState = tamagotchi.getPhysicalState();
        //tamagotchi.setHungerIndex(90);
        currentState.action(tamagotchi, Config.MORNING_POOP_TIME);
        assertEquals(PhysicalStages.POOPING, tamagotchi.getPhysicalState());

    }

    @Test
    public void testPoopOverEating() {

        PhysicalState currentState = tamagotchi.getPhysicalState();
        assertEquals(PhysicalStages.SLEEPING, currentState);

        currentState.action(tamagotchi, Config.SLEEP_HOUR_END + 1);
        assertEquals(PhysicalStages.AWAKE, tamagotchi.getPhysicalState());

        currentState = tamagotchi.getPhysicalState();
        tamagotchi.setHungerIndex(101);
        currentState.action(tamagotchi, Config.AFTERNOON);
        assertEquals(PhysicalStages.POOPING, tamagotchi.getPhysicalState());

    }


}
