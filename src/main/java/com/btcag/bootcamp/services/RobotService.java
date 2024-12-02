package com.btcag.bootcamp.services;

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
}
