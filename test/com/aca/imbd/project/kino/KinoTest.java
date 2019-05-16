package com.aca.imbd.project.kino;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KinoTest {

    @Test
    void getRating() {
        Kino kino=new Kino("AX",2.4);
        kino.setRating(1.0);
        assertEquals(3.4,kino.getRating());
    }
}