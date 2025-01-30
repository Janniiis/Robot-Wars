package com.btcag.bootcamp.services;

import com.btcag.bootcamp.enums.Directions;
import com.btcag.bootcamp.models.Bot;
import com.btcag.bootcamp.views.AskForAlignmentView;
import com.btcag.bootcamp.views.AskForMoveActionView;
import com.btcag.bootcamp.views.MoveRobotView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

//import static com.btcag.bootcamp.services.GetRequests.getMapIndex;

public class PostRequests {
    protected static String baseURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String botURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot/";
    protected static String mapURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/api/maps/";
    protected static String gameURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/";
    protected static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
    protected static String robotId = "";
    protected static String gameId = "";
    protected static String playerId = "";
    protected static String direction = "";

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
        jsonObject.put("name", bot.getName());
        jsonObject.put("health", bot.getHealth());
        jsonObject.put("attackDamage", bot.getAttackDamage());
        jsonObject.put("attackRange", bot.getAttackRange());
        jsonObject.put("movementRate", bot.getMovementRate());

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = con.getOutputStream()) {
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

        try (OutputStream os = con.getOutputStream()) {
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

        Scanner scanner = new Scanner(System.in);
        String gameId = scanner.nextLine();
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

        try (OutputStream os = con.getOutputStream()) {
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

    public static void makeAMove(Bot bot) throws IOException {
        String move = "";
        String alignment = bot.getAlignment();


        move = AskForMoveActionView.display(bot);
        if (move == "ALIGN"){
            alignment = AskForAlignmentView.display();
            bot.setAlignment(alignment);
        } else if (move == "MOVE") {
           direction = MoveRobotView.display();
        }
        URL url = new URL(gameURL + gameId + "/move/player/" + playerId);
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
        jsonObject.put("mapIndex", getMapIndex());
        jsonObject.put("align", alignment);
        String jsonInputString = jsonObject.toString();

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println(code);
        String response = con.getResponseMessage();
        System.out.println(response);
    }

    public static int getMapIndex(){
        int mapIndex = 0;
        if (direction.equals("w")){
            mapIndex -= 9;
        } else if (direction.equals("s")){
            mapIndex += 9;
        } else if (direction.equals("a")){
            mapIndex--;
        } else if (direction.equals("d")){
            mapIndex++;
        } else if (direction.equals("q")){
            mapIndex -= 10;
        } else if (direction.equals("e")){
            mapIndex -= 8;
        } else if (direction.equals("y")){
            mapIndex += 8;
        } else if (direction.equals("c")){
            mapIndex += 10;
        }
        return mapIndex;
    }



}
