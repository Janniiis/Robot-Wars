package com.btcag.bootcamp.services;

import com.btcag.bootcamp.models.Items;
import com.btcag.bootcamp.models.Obstacle;
import com.btcag.bootcamp.models.Robot;
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

    public static boolean checkIfPlayerCrossesObstacle(Robot robot, Robot robot2, Obstacle obstacle, Obstacle obstacle2){
        if(robot.getRoboterPositionX() == obstacle.getObstaclePositionX() && robot.getRoboterPositionY() == obstacle.getObstaclePositionY() ||
        robot.getRoboterPositionX() == obstacle2.getObstaclePositionX() && robot.getRoboterPositionY() == obstacle2.getObstaclePositionY() ||
        robot2.getRoboterPositionX() == obstacle.getObstaclePositionX() && robot2.getRoboterPositionY() == obstacle.getObstaclePositionY() ||
        robot2.getRoboterPositionX() == obstacle2.getObstaclePositionX() && robot2.getRoboterPositionY() == obstacle2.getObstaclePositionY()){
            return true;
        }
        return false;
    }
}
