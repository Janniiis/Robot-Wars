package com.btcag.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.btcag.bootcamp.models.*;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIconnection {

    // GLOBALE VARIABLEN

    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String botURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot/";
    protected static String mapURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/maps/";
    protected static String gameURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/";
    protected static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
    protected static String robotId = "";
    protected static String gameId = "";
    protected static String playerId = "";

    // MAN BEKOMMT ALLE BOTS AUSGEGEBEN

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

    // MAN BEKOMMT EINEN BESTIMMTEN BOT AUSGEGEBEN

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

    // MAN BEKOMMT ALLE MAPS AUSGEGEBEN

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

    // ERSTELLUNG EINES ROBOTERS

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

    // EIN SPIEL ERSTELLEN

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

    // EINEM SPIEL BEITRETEN

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

    // EIN SPIELZUG TÄTIGEN

    public static void makeAMove(Bot bot) throws IOException {
        String move = "";
        int mapIndex = 0;
        String alignment = "N";
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                wähle zwischen folgenden Optionen:
                1 ~ Bewegen
                2 ~ Angreifen
                3 ~ Zug beenden
                """);

        int readIn = scanner.nextInt();
        if (readIn == 1) {
            if (bot.getMovementRate() != 0) {
                move = "MOVE";
            } else if(bot.getMovementRate() <= 0) {
                move = "END";
            }
        } else if (readIn == 2) {
            move = "ATTACK";
        } else if (readIn == 3) {
            move = "END";
        } else {
            System.out.println("error");
        }
        getMapIndex();
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
        jsonObject.put("mapIndex", mapIndex);
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

    // MAN BEKOMMT ALLE ERSTELLTEN SPIELE ZURÜCK

    public static void getAllGames() throws IOException {
        URL url = new URL(baseURL + "/api/games");

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

    // MAN BEKOMMT EINE BESTIMMTE KARTE

    public static void getSpecificMap() throws IOException {
        URL url = new URL(baseURL + "/api/maps/map/" + mapId);

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

    // MAN BEKOMMT EIN BESTIMMTES SPIEL

    public static void getSpecificGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        gameId = scanner.nextLine();

        URL url = new URL(baseURL + "api/games/game/" + gameId);

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

    // MAN BEKOMMT DEN MAPINDEX

    public static void getMapIndex() throws IOException {
        URL url = new URL(baseURL + "api/games/game/" + gameId);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        String contentString = content.toString();
        Pattern pattern = Pattern.compile("\"mapIndex\":\\s*(\\d+)");
        Matcher matcher = pattern.matcher(contentString);
        if (matcher.find()) {
            String mapIndex = matcher.group(1);
            System.out.println("Index: " + mapIndex);
        } else {
            System.out.println("Index nicht gefunden.");
        }
    }
}


