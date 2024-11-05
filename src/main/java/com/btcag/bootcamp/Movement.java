package com.btcag.bootcamp;

import java.awt.*;

public class Movement {

    Roboter roboter = new Roboter(0, 0, 0,null, null);

    public static void moveTopLeft(){
        if (Roboter.y > 0 && Roboter.x > 0){
            Roboter.x -= Roboter.movementSpeed;
            Roboter.y -= Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

    public static void moveTop(){
        if (Roboter.y > 0){
            Roboter.y -= Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

    public static void moveTopRight(){
        if (Roboter.y > 0 && Roboter.x < 15){
            Roboter.x += Roboter.movementSpeed;
            Roboter.y -= Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

    public static void moveLeft(){
        if (Roboter.x > 0){
            Roboter.x -= Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

    public static void moveRight(){
        if (Roboter.x < 15){
            Roboter.x += Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

    public static void moveBottomLeft(){
        if (Roboter.y < 15 && Roboter.x < 0){
            Roboter.x -= Roboter.movementSpeed;
            Roboter.y += Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }

    }

    public static void moveBottom(){
        if (Roboter.y < 15){
            Roboter.y += Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

    public static void moveBottomRight(){
        if (Roboter.y < 15 && Roboter.x < 15){
            Roboter.x += Roboter.movementSpeed;
            Roboter.y += Roboter.movementSpeed;
        }
        else {
            System.out.println("Invalider Spielzug, versuche erneut!");
        }
    }

}
