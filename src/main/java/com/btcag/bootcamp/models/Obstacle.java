package com.btcag.bootcamp.models;

public class Obstacle {
    private final int obstaclePositionX;
    private final int obstaclePositionY;

        public Obstacle(int obstaclePositionX, int obstaclePositionY) {
            this.obstaclePositionX = obstaclePositionX;
            this.obstaclePositionY = obstaclePositionY;
        }

    public int getObstaclePositionX() {
        return obstaclePositionX;
    }

    public int getObstaclePositionY() {
        return obstaclePositionY;
    }
}
