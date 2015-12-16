package com.cammy.state;

import com.cammy.Tamagotchi;

/**
 * Created by prabhatranjan on 15/12/2015.
 */
public interface PhysicalState {

    public String getDescription();
    public void action(final Tamagotchi tamagotchi, Integer currentHour);
}
