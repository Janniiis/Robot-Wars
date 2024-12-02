package com.btcag.bootcamp.controllers;

import com.btcag.bootcamp.models.*;
import com.btcag.bootcamp.enums.*;
import com.btcag.bootcamp.views.*;
import com.btcag.bootcamp.services.*;

public class GameController {

    public static void main(String[] args) {

        IntroScreenView.display();

        String robotName = AskForRobotNameView.display();
        Robot robot = new Robot(robotName, 7, 0, '☼', 1, 1, 1, 1);
        RobotView.display(robot);
        AskForSkillPoints.display(robot);
        AskForSkillPoints.displayStats(robot);

        String robotNameP2 = AskForRobotNameView.display();
        Robot robot2 = new Robot(robotNameP2, 7, 14, '♣', 1, 1, 1, 1);
        RobotView.display(robot2);
        AskForSkillPoints.display(robot2);
        AskForSkillPoints.displayStats(robot2);

        Battlefield battlefield = new Battlefield(10, 15);
        Battlefield.display(battlefield, robot, robot2);

        int playMove;
        int newX;
        int newY;
        int new_X;
        int new_Y;

        do {
            if (RobotService.checkPlayerTurn(robot, robot2)) {
                playMove = AskForActionView.display();
                if (playMove == 1) {
                    if (RobotService.checkIfPlayerInRange(robot, robot2)) {
                        int tempHp = robot2.getHp();
                        tempHp -= robot.getAttackDamage();
                        robot2.setHp(tempHp);
                    } else {
                        System.out.println("Ziel nicht in Reichweite");
                    }
                } else if (playMove == 2) {

                    do {

                        Directions direction = MoveRobotView.display();
                        newX = robot.getRoboterPositionX() + direction.getX();
                        newY = robot.getRoboterPositionY() + direction.getY();

                    } while (!battlefield.isValidField(newX, newY));

                    battlefield.setField(robot.getRoboterPositionX(), robot.getRoboterPositionY(), '☼');
                    robot.setPosition(newX, newY);
                    battlefield.setField(robot.getRoboterPositionX(), robot.getRoboterPositionY(), robot.getRoboterSymbol());

                    Battlefield.display(battlefield, robot, robot2);
                } else {
                    System.out.println("fehler");
                }


            } else {
                playMove = AskForActionView.display();
                if (playMove == 1) {
                    if (RobotService.checkIfPlayerInRange(robot, robot2)) {
                        int tempHp = robot.getHp();
                        tempHp -= robot2.getAttackDamage();
                        robot.setHp(tempHp);
                    } else {
                        System.out.println("Ziel nicht in Reichweite");
                    }
                } else if (playMove == 2) {

                    do {

                        Directions direction = MoveRobotView.display();
                        new_X = robot2.getRoboterPositionX() + direction.getX();
                        new_Y = robot2.getRoboterPositionY() + direction.getY();

                    } while (!battlefield.isValidField(new_X, new_Y));

                    battlefield.setField(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), '♣');
                    robot2.setPosition(new_X, new_Y);
                    battlefield.setField(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), robot2.getRoboterSymbol());

                    Battlefield.display(battlefield, robot, robot2);

                }


            }
        }while (!RobotService.checkGameOver(robot, robot2)) ;
    }
}