package com.btcag.bootcamp.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetRequests {
    protected static String baseURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String botURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot/";
    protected static String mapURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/api/maps/";
    protected static String gameURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/";
    protected static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
    protected static String robotId = "";
    protected static String gameId = "";
    protected static String playerId = "";

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
