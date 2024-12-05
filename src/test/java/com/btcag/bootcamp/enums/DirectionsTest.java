package com.btcag.bootcamp.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionsTest {

    @Test
    void testFromUserInput() {
        assertEquals(Directions.NORD, Directions.fromUserInput('w'));
        assertEquals(Directions.SUED, Directions.fromUserInput('x'));
        assertEquals(Directions.OST, Directions.fromUserInput('d'));
        assertEquals(Directions.WEST, Directions.fromUserInput('a'));
        assertEquals(Directions.NORDWEST, Directions.fromUserInput('q'));
        assertEquals(Directions.NORDOST, Directions.fromUserInput('e'));
        assertEquals(Directions.SUEDWEST, Directions.fromUserInput('y'));
        assertEquals(Directions.SUEDOST, Directions.fromUserInput('c'));
        assertNull(Directions.fromUserInput('z'));
    }

    @Test
    void testGetX() {
        assertEquals(0, Directions.NORD.getX());
        assertEquals(1, Directions.OST.getX());
        assertEquals(-1, Directions.WEST.getX());
        assertEquals(1, Directions.SUEDOST.getX());
    }

    @Test
    void testGetY() {
        assertEquals(-1, Directions.NORD.getY());
        assertEquals(1, Directions.SUED.getY());
        assertEquals(0, Directions.OST.getY());
        assertEquals(1, Directions.SUEDOST.getY());
    }
}
