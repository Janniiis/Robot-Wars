package com.btcag.bootcamp.controllers;

import com.btcag.bootcamp.models.*;
import com.btcag.bootcamp.enums.*;
import com.btcag.bootcamp.views.*;
import com.btcag.bootcamp.services.*;

import java.util.Random;
import java.util.random.*;

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

        Battlefield board = new Battlefield(10, 15);
        Random random = new Random();
        board.placeSymbol(0, 0, robot.getRoboterSymbol());
        board.placeSymbol(9, 14, robot2.getRoboterSymbol());
        board.placeSymbol(random.nextInt(9), random.nextInt(14), '?');
        board.placeSymbol(random.nextInt(9), random.nextInt(14), '?');
        board.placeSymbol(random.nextInt(9), random.nextInt(14), '?');
        board.placeSymbol(random.nextInt(9), random.nextInt(14), '?');
        board.placeSymbol(random.nextInt(9), random.nextInt(14), 'x');
        board.placeSymbol(random.nextInt(9), random.nextInt(14), 'x');

        board.printBoard();

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

                    } while (!board.isValidField(newX, newY));


                    board.placeSymbol(newX, newY, robot.getRoboterSymbol());



                } else {
                    System.out.println("fehler");
                }
                board.printBoard();


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

                    } while (!board.isValidField(new_X, new_Y));


                    board.placeSymbol(new_X, new_Y, robot2.getRoboterSymbol());

                } else {
                    System.out.println("fehler");
                }
                board.printBoard();


            }
        }while (!RobotService.checkGameOver(robot, robot2)) ;
    }
}