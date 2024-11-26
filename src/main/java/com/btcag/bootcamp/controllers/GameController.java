package com.btcag.bootcamp.controllers;

import com.btcag.bootcamp.models.*;
import com.btcag.bootcamp.enums.*;
import com.btcag.bootcamp.views.*;
import com.btcag.bootcamp.services.*;

public class GameController {
    public static void main(String[] args) {
        IntroScreenView.display();

        String robotName = AskForRobotNameView.display();
        Robot robot = new Robot(robotName, 7,0,'0');
        RobotView.display(robot);

        Battlefield battlefield = new Battlefield(10,15);
        battlefield.setField(robot.getRoboterPositionX(), robot.getRoboterPositionY(), robot.getRoboterSymbol());
        BattlefieldView.display(battlefield);

        int newX;
        int newY;
        do {
            Directions direction = MoveRobotView.display();
            newX = robot.getRoboterPositionX() + direction.getX();
            newY = robot.getRoboterPositionY() + direction.getY();
        }while (!battlefield.isValidField(newX, newY));

        battlefield.setField(robot.getRoboterPositionX(), robot.getRoboterPositionY(), ' ');
        robot.setPosition(newX, newY);
        battlefield.setField(robot.getRoboterPositionX(), robot.getRoboterPositionY(), robot.getRoboterSymbol());

        BattlefieldView.display(battlefield);
    }
}
