package com.btcag.bootcamp.services;

import com.btcag.bootcamp.enums.Alignments;
import com.btcag.bootcamp.models.Battlefield;
import com.btcag.bootcamp.models.Items;
import com.btcag.bootcamp.models.Obstacle;
import com.btcag.bootcamp.models.Robot;

import java.util.Objects;
import java.util.Random;

public class RobotService {
    public static boolean checkCollision(Robot robot, Robot robot2){
        return (robot.getRoboterPositionX() == robot2.getRoboterPositionX() && robot.getRoboterPositionY() == robot2.getRoboterPositionY());
    }

    public static boolean checkGameOver(Robot robot, Robot robot2) {
        return(robot.getHp() < 0) || checkCollision(robot, robot2) || robot2.getHp() < 0;
    }

    public static boolean checkPlayerTurn(Robot robot, Robot robot2){
        if (robot.getMovementRange() > robot2.getMovementRange()){
            return true;
        } else if (robot.getMovementRange() == robot2.getMovementRange()) {
            Random random = new Random();
            return random.nextBoolean();
        } else {
            return false;
        }
    }

    public static boolean checkIfPlayerInRange(Robot robot, Robot robot2){
        if (robot.getRoboterPositionX() + robot.getAttackRange() >= robot2.getRoboterPositionX() && robot2.getRoboterPositionX() >= robot.getRoboterPositionX() && robot.getRoboterPositionY() + robot.getAttackRange() >= robot2.getRoboterPositionY() && robot2.getRoboterPositionY() >= robot.getRoboterPositionY()
        || (robot.getRoboterPositionX() + robot.getMovementRange() >= robot2.getRoboterPositionX() && robot2.getRoboterPositionX() >= robot.getRoboterPositionX()) && (robot.getRoboterPositionY() - robot.getMovementRange() <= robot2.getRoboterPositionY() && robot2.getRoboterPositionY() <= robot.getRoboterPositionY()
        || (robot.getRoboterPositionX() - robot.getAttackRange() <= robot2.getRoboterPositionX() && robot2.getRoboterPositionX() <= robot.getRoboterPositionX()) && (robot.getRoboterPositionY() + robot.getAttackRange() >= robot2.getRoboterPositionY() && robot2.getRoboterPositionY() >= robot.getRoboterPositionY())
        || (robot.getRoboterPositionX() - robot.getAttackRange() <= robot2.getRoboterPositionX() && robot2.getRoboterPositionX() <= robot.getRoboterPositionX()) && (robot.getRoboterPositionY() - robot.getAttackRange() <= robot2.getRoboterPositionY() && robot2.getRoboterPositionY() <= robot.getRoboterPositionY()))){
            return true;
        }else{
            return false;
        }
    }

    public static boolean CheckIfPlayerCollectsItem(Robot robot, Robot robot2, Items items, Items items1, Items items2){
        if(robot.getRoboterPositionX() == items.getItemPositionX() && robot.getRoboterPositionY() == items.getItemPositionY() ||
        robot.getRoboterPositionX() == items1.getItemPositionX() && robot.getRoboterPositionY() == items1.getItemPositionY() ||
        robot.getRoboterPositionX() == items2.getItemPositionX() && robot.getRoboterPositionY() == items2.getItemPositionY() ||
        robot2.getRoboterPositionX() == items.getItemPositionX() && robot2.getRoboterPositionY() == items.getItemPositionY() ||
        robot2.getRoboterPositionX() == items1.getItemPositionX() && robot2.getRoboterPositionY() == items1.getItemPositionY() ||
        robot2.getRoboterPositionX() == items2.getItemPositionX() && robot2.getRoboterPositionY() == items2.getItemPositionY())
        {
            return true;
        }
        return false;
    }

    public static boolean checkIfRobotIsInHorizontalFOV(Robot robot, Robot robot2){
        if (Objects.equals(robot.getAlignment(), "WEST")){
            if (robot2.getRoboterPositionX() < robot.getRoboterPositionX() && robot.getRoboterPositionY() == robot2.getRoboterPositionY()){
                return true;
            }
            return false;
        }

        else if (Objects.equals(robot.getAlignment(), "OST")){
            if (robot2.getRoboterPositionX() > robot.getRoboterPositionX() && robot.getRoboterPositionY() == robot2.getRoboterPositionY()){
                return true;
            }
            return false;
        }
        else return false;
    }

    public static boolean checkIfRobotIsInVerticalFOV(Robot robot, Robot robot2){
        if (Objects.equals(robot.getAlignment(), "NORD")){
            if (robot2.getRoboterPositionY() < robot.getRoboterPositionY() && robot.getRoboterPositionX() == robot2.getRoboterPositionX()){
                return true;
            }
            return false;
        }

        if (Objects.equals(robot.getAlignment(), "SUED")){
            if (robot2.getRoboterPositionY() > robot.getRoboterPositionY() && robot.getRoboterPositionX() == robot2.getRoboterPositionX()){
                return true;
            }
            return false;
        }
        else return false;
    }

    public static boolean checkIfRobotIsInDiagonalFOV(Robot robot, Robot robot2){
        if (Objects.equals(robot.getAlignment(), "NORDWEST")){
            if (robot2.getRoboterPositionY() < robot.getRoboterPositionY() && robot2.getRoboterPositionX() < robot.getRoboterPositionX() && checkDiagonal(robot, robot2)){
                return true;
            }
            return false;
        }
        else if (Objects.equals(robot.getAlignment(), "SUEDWEST")) {
            if (robot2.getRoboterPositionY() > robot.getRoboterPositionY() && robot2.getRoboterPositionX() < robot.getRoboterPositionX() && checkDiagonal(robot, robot2)){
                return true;
            }
            return false;
        }
        else if (Objects.equals(robot.getAlignment(), "SUEDOST")) {
            if (robot.getRoboterPositionX() < robot2.getRoboterPositionX() && robot.getRoboterPositionX() < robot2.getRoboterPositionX() && checkDiagonal(robot, robot2)){
                return true;
            }
            return false;
        }
        else if (Objects.equals(robot.getAlignment(), "NORDOST")) {
            if (robot2.getRoboterPositionY() < robot.getRoboterPositionY() && robot2.getRoboterPositionX() > robot.getRoboterPositionX() && checkDiagonal(robot, robot2)){
                return true;
            }
            return false;

        }
        else return false;
    }

    public static boolean checkDiagonal(Robot robot, Robot robot2){
        int valueOne;
        int valueTwo;
        valueOne = robot.getRoboterPositionX() - robot2.getRoboterPositionX();
        valueTwo = robot.getRoboterPositionY() - robot2.getRoboterPositionY();
        if (Math.abs(valueOne) == Math.abs(valueTwo)) {
            return true;
        }
        return false;
    }
}