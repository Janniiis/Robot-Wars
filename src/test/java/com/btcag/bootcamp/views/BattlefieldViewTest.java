package com.btcag.bootcamp.views;


import com.btcag.bootcamp.models.Battlefield;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class BattlefieldViewTest {
    @Test
    public void canSetAndGetFields() {
        Battlefield battlefield = new Battlefield(15, 10);

        battlefield.setField(1, 1, 'x');
        assertEquals('x', battlefield.getField(1, 1));

        battlefield.setField(15, 10, 'x');
        assertEquals('x', battlefield.getField(15, 10));
    }
}
