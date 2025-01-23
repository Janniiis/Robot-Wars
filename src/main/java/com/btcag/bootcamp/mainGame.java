package com.btcag.bootcamp;

import com.btcag.bootcamp.views.AskForMenuView;
import com.btcag.bootcamp.views.IntroScreenView;

import java.io.IOException;

public class mainGame {
    public static void main(String[] args) throws IOException {
        IntroScreenView.display();
        AskForMenuView.decideInput();
    }
}
