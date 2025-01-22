package com.btcag.bootcamp;

import com.btcag.bootcamp.models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;
import com.btcag.bootcamp.views.*;
import com.btcag.bootcamp.models.*;

import com.btcag.bootcamp.views.AskForSkillPoints;
import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIconnection {

    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String botURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot/";
    protected static String mapURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/maps/";
    protected static String gameURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/";
    protected static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
    protected static String robotId = "";
    protected static String gameId = "";
    protected static String playerId = "";


    public static void main(String[] args) throws IOException, InterruptedException {
        int input;
        do {
            System.out.println("""
                    Bitte wähle zwischen folgenden Möglichkeiten:
                    1 ~ gibt alle Roboter aus.
                    2 ~ gibt einen bestimmten Roboter aus.
                    3 ~ gibt alle Karten aus.
                    4 ~ erstellt einen Roboter.
                    5 ~ erstellt ein Spiel.
                    6 ~ tritt einem Spiel bei.
                    7 ~ bewege den Roboter.
                    99 ~ Beenden.
                    """);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();

            if (input == 1) {
                getAllBots();
            } else if (input == 2) {
                getSpecificBot();
            } else if (input == 3) {
                getAllMaps();
            } else if (input == 4) {
                createRobot(new Bot("test", 1, 1, 1, 1));
            } else if (input == 5) {
                createGame();
            } else if (input == 6) {
                joinGame();
            } else if (input == 7) {
                makeAMove();
            } else if (input == 99) {
                System.out.println("Programm beendet!");
            } else {
                System.out.println("error");
            }
        } while (input != 99);
    }


    public static void getAllBots() throws IOException {
        URL url = new URL(baseURL + "api/robots");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        con.disconnect();
    }

    public static void getSpecificBot() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        URL url = new URL(botURL + id);
        System.out.println(url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        con.disconnect();
    }

    public static void getAllMaps() throws IOException {
        URL url = new URL(mapURL);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        con.disconnect();
    }

    public static void createRobot(Bot bot) throws IOException {
        URL url = new URL(botURL);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", bot.name);
        jsonObject.put("health", bot.health);
        jsonObject.put("attackDamage", bot.attackDamage);
        jsonObject.put("attackRange", bot.attackRange);
        jsonObject.put("movementRate", bot.movementRate);

        String jsonInputString = jsonObject.toString();

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println(code);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            robotId = responseObject.getString("id");
            System.out.println(robotId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(con.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }

    }

    public static void createGame() throws IOException {
        URL url = new URL(gameURL);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mapId", mapId);

        String jsonInputString = jsonObject.toString();

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println(code);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            gameId = responseObject.getString("id");
            System.out.println(gameId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(con.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }
    }

    public static void joinGame() throws IOException {
        URL url = new URL(gameURL + gameId + "/join");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotId", robotId);

        String jsonInputString = jsonObject.toString();

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println(code);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            playerId = responseObject.getString("playerId");
            System.out.println(playerId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(con.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }


    }

    public static void makeAMove() throws IOException {
        String move = "";
        int mapIndex = 0;
        String alignment = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                wähle zwischen folgenden Optionen:
                1 ~ Bewegen
                2 ~ Angreifen
                3 ~ Zug beenden
                """);
        int readIn = scanner.nextInt();
        if (readIn == 1) {
            move = "MOVE";
        } else if (readIn == 2) {
            move = "ATTACK";
        } else if (readIn == 3) {
            move = "END";
        } else{
            System.out.println("error");
        }
        URL url = new URL(gameURL + gameId + "/move/player/" + robotId);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("playerId", playerId);
        jsonObject.put("movementType", move);
        jsonObject.put("mapIndex", mapIndex);
        jsonObject.put("align", alignment);
        String jsonInputString = jsonObject.toString();

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println(code);
        String response = con.getResponseMessage();
        System.out.println(response);
    }
}

class Bot{
    String name;
    int health;
    int attackDamage;
    int attackRange;
    int movementRate;

    public Bot( String name, int health, int attackDamage, int attackRange, int movementRate) {
        this.name = name;
        this.health = health;
        this.attackDamage= attackDamage;
        this.attackRange= attackRange;
        this.movementRate= movementRate;
    }
}

