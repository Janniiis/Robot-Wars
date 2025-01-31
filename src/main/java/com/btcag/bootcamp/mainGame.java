package com.btcag.bootcamp;

import com.btcag.bootcamp.models.Battlefield;
import com.btcag.bootcamp.models.Bot;
import com.btcag.bootcamp.services.GetRequests;
import com.btcag.bootcamp.views.IntroScreenView;
import com.btcag.bootcamp.views.MainMenuView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static com.btcag.bootcamp.services.GetRequests.getMapIndex;
import static com.btcag.bootcamp.views.GameMenuView.bot;

@SpringBootApplication
public class mainGame {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(mainGame.class, args);
        IntroScreenView.display();
        Thread.sleep(5000);
        MainMenuView.display();
    }
}
