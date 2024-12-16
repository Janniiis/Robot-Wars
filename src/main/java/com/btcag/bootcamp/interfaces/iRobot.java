package com.btcag.bootcamp.interfaces;

import com.btcag.bootcamp.models.Robot;

public interface iRobot {
    Robot[] robots();
    Robot robotID(int robotId);
    Robot createRobot(String name, int health, int damage, int range, int movementRange);
}
