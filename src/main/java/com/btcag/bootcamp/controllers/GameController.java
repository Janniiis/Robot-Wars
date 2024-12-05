package com.btcag.bootcamp.controllers;

import com.btcag.bootcamp.models.*;
import com.btcag.bootcamp.enums.*;
import com.btcag.bootcamp.views.*;
import com.btcag.bootcamp.services.*;

import java.util.Random;

public class GameController {

    public static void main(String[] args) {

        IntroScreenView.display();

        // Erstellung Spieler 1
        String robotName = AskForRobotNameView.display();
        Robot robot = new Robot(robotName, 0, 0, '☼', 1, 1, 1, 1, "south");
        RobotView.display1(robot);
        AskForSkillPoints.display(robot);
        AskForSkillPoints.displayStats(robot);

        // Erstellung Spieler 2
        String robotNameP2 = AskForRobotNameView.display();
        Robot robot2 = new Robot(robotNameP2, 9, 14, '♣', 1, 1, 1, 1, "north");
        RobotView.display2(robot2);
        AskForSkillPoints.display(robot2);
        AskForSkillPoints.displayStats(robot2);

        // Random
        Random random = new Random();

        // Items
        Items items = new Items("Damage", random.nextInt(9), random.nextInt(14), random.nextInt(-2, 2), random.nextInt(2));
        Items items1 = new Items("Range", random.nextInt(9), random.nextInt(14), random.nextInt(-2, 2), random.nextInt(2));
        Items items2 = new Items("Movement", random.nextInt(9), random.nextInt(14), random.nextInt(-2, 2), random.nextInt(2));

        // Obstacles
        Obstacle[] obstacles = new Obstacle[5];

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Obstacle(random.nextInt(3, 7), random.nextInt(3, 12));
        }

        // Spielfeld (Grafisch)
        String redValue = Colors.RED.getValue();
        String blueValue = Colors.BLUE.getValue();
        String resetValue = Colors.RESET.getValue();
        Battlefield board = new Battlefield(10, 15);
        board.placeSymbol(robot.getRoboterPositionX(), robot.getRoboterPositionY(), robot.getRoboterSymbol());
        board.placeSymbol(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), robot2.getRoboterSymbol());
        board.placeSymbol(items.getItemPositionX(), items.getItemPositionY(), '�');
        board.placeSymbol(items1.getItemPositionX(), items1.getItemPositionY(), '�');
        board.placeSymbol(items2.getItemPositionX(), items2.getItemPositionY(), '�');
        for (Obstacle obstacle : obstacles) {
            board.placeSymbol(obstacle.getObstaclePositionX(), obstacle.getObstaclePositionY(), '■');
        }
        board.printBoard();


        // Spielgeschehen
        do {

            // Variablen neuer playMove
            int playMove;
            int newX;
            int newY;
            int new_X;
            int new_Y;

            // Zug - Spieler 1
            if (RobotService.checkPlayerTurn(robot, robot2)) {
                playMove = AskForActionView.displayPlayerOne(robot);
                if (playMove == 1) {
                    if (RobotService.checkIfRobotIsInDiagonalFOV(robot2, robot) || RobotService.checkIfRobotIsInHorizontalFOV(robot, robot2) || RobotService.checkIfRobotIsInVerticalFOV(robot, robot2) && RobotService.checkIfPlayerInRange(robot, robot2)) {
                        int tempHp = robot2.getHp();
                        tempHp -= robot.getAttackDamage();
                        robot2.setHp(tempHp);
                    } else {
                        System.out.println("Entweder ist das Ziel nicht in Reichweite, es ist etwas im weg oder du bist nicht richtig ausgerichtet!");
                    }
                } else if (playMove == 2) {

                    do {

                        Directions direction = MoveRobotView.display();
                        newX = robot.getRoboterPositionX() + direction.getX();
                        newY = robot.getRoboterPositionY() + direction.getY();

                    } while (!board.isValidField(newX, newY, obstacles));

                    // Items
                    if (RobotService.CheckIfPlayerCollectsItem(robot, robot2, items, items1, items2)) {
                        itemUsageView.display();
                        int randomEffect = new Random().nextInt(2);
                        switch (randomEffect) {
                            case 0:
                                int temp = robot.getAttackDamage();
                                temp += items.getItemEffect();
                                robot.setAttackDamage(temp);
                                board.placeSymbol(items.getItemPositionX(), items.getItemPositionY(), '.');
                                break;
                            case 1:
                                int temp1 = robot.getAttackRange();
                                temp1 += items1.getItemEffect();
                                robot.setAttackRange(temp1);
                                board.placeSymbol(items1.getItemPositionX(), items1.getItemPositionY(), '.');
                                break;
                            case 2:
                                int temp2 = robot.getMovementRange();
                                temp2 += items2.getItemEffect();
                                robot.setMovementRange(temp2);
                                board.placeSymbol(items2.getItemPositionX(), items2.getItemPositionY(), '.');
                                break;
                            default:
                                break;

                        }
                    }
                    ;
                    board.placeSymbol(robot.getRoboterPositionX(), robot.getRoboterPositionY(), '.');
                    robot.setPosition(newX, newY);
                    board.placeSymbol(robot.getRoboterPositionX(), robot.getRoboterPositionY(), robot.getRoboterSymbol());

                } else if (playMove == 3) {
                    robot.setAlignment(AskForAlignmentView.display());
                    robot.setMovementRange(robot.getMovementRange() - 1);
                } else {
                    System.out.println("fehler");
                }

                board.printBoard();
                System.out.println(robot.getAlignment());


                // Zug - Spieler 2
            } else {
                playMove = AskForActionView.displayPlayerTwo(robot2);
                if (playMove == 1) {
                    if (RobotService.checkIfRobotIsInDiagonalFOV(robot2, robot) || RobotService.checkIfRobotIsInHorizontalFOV(robot2, robot) || RobotService.checkIfRobotIsInVerticalFOV(robot2, robot) && RobotService.checkIfPlayerInRange(robot, robot2)) {
                        int tempHp = robot.getHp();
                        tempHp -= robot2.getAttackDamage();
                        robot.setHp(tempHp);
                    } else {
                        System.out.println("Entweder ist das Ziel nicht in Reichweite, es ist etwas im weg oder du bist nicht richtig ausgerichtet!");
                    }
                } else if (playMove == 2) {

                    do {

                        Directions direction = MoveRobotView.display();
                        new_X = robot2.getRoboterPositionX() + direction.getX();
                        new_Y = robot2.getRoboterPositionY() + direction.getY();

                    } while (!board.isValidField(new_X, new_Y, obstacles));

                    // Items
                    if (RobotService.CheckIfPlayerCollectsItem(robot, robot2, items, items1, items2)) {
                        itemUsageView.display();
                        int randomEffect = new Random().nextInt(2);
                        switch (randomEffect) {
                            case 0:
                                int temp = robot2.getAttackDamage();
                                temp *= items.getItemEffect();
                                robot.setAttackDamage(temp);
                                break;
                            case 1:
                                int temp1 = robot2.getAttackRange();
                                temp1 *= items.getItemEffect();
                                robot.setAttackRange(temp1);
                                break;
                            case 2:
                                int temp2 = robot2.getMovementRange();
                                temp2 *= items.getItemEffect();
                                robot.setMovementRange(temp2);
                                break;
                            default:
                                break;

                        }
                    }
                    ;

                    board.placeSymbol(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), '.');
                    robot2.setPosition(new_X, new_Y);
                    board.placeSymbol(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), robot2.getRoboterSymbol());

                } else if (playMove == 3) {
                    robot2.setAlignment(AskForAlignmentView.display());
                    robot2.setMovementRange(robot2.getMovementRange() - 1);
                } else {
                    System.out.println("fehler");
                }
                board.printBoard();
                System.out.println(robot2.getAlignment());


            }

            // Win condition
        } while (!RobotService.checkGameOver(robot, robot2));
    }
}