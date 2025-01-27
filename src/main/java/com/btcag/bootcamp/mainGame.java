package com.btcag.bootcamp;

import com.btcag.bootcamp.views.IntroScreenView;
import com.btcag.bootcamp.views.MainMenuView;

import java.io.IOException;

public class mainGame {
    public static void main(String[] args) throws IOException, InterruptedException {
        IntroScreenView.display();
        Thread.sleep(5000);
        MainMenuView.display();

    }
}
