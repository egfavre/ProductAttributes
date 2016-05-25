package com.egfavre;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by user on 5/25/16.
 */
public class MainTest {
    @Test
    public void testMethod(){
        HashMap testMap = new HashMap();
        testMap.put("tiers", 4);
        testMap.put("flavor", "vanilla");
        testMap.put("frosting", "stuff");
        testMap.put("theme", "otherstuff");
        testMap.put("color", "morestuff");


        Main.save(testMap, "test.json");
        HashMap resultMap = Main.load("test.json");

        assertTrue(testMap.equals(resultMap));


    }
}