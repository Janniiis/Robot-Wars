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
        Robot robot = new Robot(robotName, 0, 0, '☼', 1, 1, 1, 1);
        RobotView.display1(robot);
        AskForSkillPoints.display(robot);
        AskForSkillPoints.displayStats(robot);

        // Erstellung Spieler 2
        String robotNameP2 = AskForRobotNameView.display();
        Robot robot2 = new Robot(robotNameP2, 9, 14, '♣', 1, 1, 1, 1);
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
        Obstacle obstacle = new Obstacle(random.nextInt(9), 14 );
        Obstacle obstacle1 = new Obstacle(random.nextInt(9), 14 );

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
        board.placeSymbol(obstacle.getObstaclePositionX(), obstacle.getObstaclePositionY(), '¤');
        board.placeSymbol(obstacle1.getObstaclePositionX(), obstacle1.getObstaclePositionY(), '¤');
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
            if (RobotService.checkPlayerTurn(robot, robot2) && !RobotService.checkIfPlayerCrossesObstacle(robot, robot2, obstacle, obstacle1)) {
                playMove = AskForActionView.displayPlayerOne(robot);
                if (playMove == 1) {
                    if (RobotService.checkIfPlayerInRange(robot, robot2)) {
                        int tempHp = robot2.getHp();
                        tempHp -= robot.getAttackDamage();
                        robot2.setHp(tempHp);
                    } else {
                        System.out.println("Entweder ist das Ziel nicht in Reichweite oder es ist etwas im weg!");
                    }
                } else if (playMove == 2) {

                    do {

                        Directions direction = MoveRobotView.display();
                        newX = robot.getRoboterPositionX() + direction.getX();
                        newY = robot.getRoboterPositionY() + direction.getY();

                    } while (!board.isValidField(newX, newY) && !RobotService.checkIfPlayerCrossesObstacle(robot, robot2, obstacle, obstacle1));

                    // Items
                    if(RobotService.CheckIfPlayerCollectsItem(robot, robot2, items, items1, items2)){
                        itemUsageView.display();
                        int randomEffect = new Random().nextInt(2);
                        switch (randomEffect) {
                            case 0:
                                int temp = robot.getAttackDamage();
                                temp += items.getItemEffect();
                                robot.setAttackDamage(temp);
                                break;
                            case 1:
                                int temp1 = robot.getAttackRange();
                                temp1 += items.getItemEffect();
                                robot.setAttackRange(temp1);
                                break;
                            case 2:
                                int temp2 = robot.getMovementRange();
                                temp2 += items.getItemEffect();
                                robot.setMovementRange(temp2);
                                break;
                            default:
                                break;

                        }
                    };
                    board.placeSymbol(robot.getRoboterPositionX(), robot.getRoboterPositionY(), '.');
                    robot.setPosition(newX, newY);
                    board.placeSymbol(robot.getRoboterPositionX(), robot.getRoboterPositionY(), robot.getRoboterSymbol());





                } else {
                    System.out.println("fehler");
                }
                board.printBoard();


            // Zug - Spieler 2
            } else {
                playMove = AskForActionView.displayPlayerTwo(robot2);
                if (playMove == 1) {
                    if (RobotService.checkIfPlayerInRange(robot, robot2) && !RobotService.checkIfPlayerCrossesObstacle(robot, robot2, obstacle, obstacle1)) {
                        int tempHp = robot.getHp();
                        tempHp -= robot2.getAttackDamage();
                        robot.setHp(tempHp);
                    } else {
                        System.out.println("Entweder ist das Ziel nicht in Reichweite oder es ist etwas im weg!");
                    }
                } else if (playMove == 2) {

                    do {

                        Directions direction = MoveRobotView.display();
                        new_X = robot2.getRoboterPositionX() + direction.getX();
                        new_Y = robot2.getRoboterPositionY() + direction.getY();

                    } while (!board.isValidField(new_X, new_Y) && !RobotService.checkIfPlayerCrossesObstacle(robot, robot2, obstacle, obstacle1));

                    // Items
                    if(RobotService.CheckIfPlayerCollectsItem(robot, robot2, items, items1, items2)){
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
                    };

                    board.placeSymbol(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), '.');
                    robot2.setPosition(new_X, new_Y);
                    board.placeSymbol(robot2.getRoboterPositionX(), robot2.getRoboterPositionY(), robot2.getRoboterSymbol());

                } else {
                    System.out.println("fehler");
                }
                board.printBoard();


            }

            // Win condition
        }while (!RobotService.checkGameOver(robot, robot2)) ;
    }
}