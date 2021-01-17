package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>(); // holds all heavenly entities
    private static Set<HeavenlyBody> planets = new HashSet<>(); // holds planetary entities only

    public static void main(String[] args) {
//        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Venus", 225);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Earth", 365);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon);
//
//        temp = new HeavenlyBody("Mars", 687);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        tempMoon = new HeavenlyBody("Deimos", 1.3);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Mars
//
//        tempMoon = new HeavenlyBody("Phobos", 0.3);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Mars
//
//        temp = new HeavenlyBody("Jupiter", 4332);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        tempMoon = new HeavenlyBody("Io", 1.8);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        tempMoon = new HeavenlyBody("Europa", 3.5);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        tempMoon = new HeavenlyBody("Ganymede", 7.1);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        tempMoon = new HeavenlyBody("Callisto", 16.7);
//        solarSystem.put(tempMoon.getKey(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        temp = new HeavenlyBody("Saturn", 10759);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Uranus", 30660);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Neptune", 165);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Pluto", 248);
//        solarSystem.put(temp.getKey(), temp);
//        planets.add(temp);
//
//        System.out.println("Planets");
//        for(HeavenlyBody planet : planets) {
//            System.out.println("\t" + planet.getKey());
//        }
//
//        HeavenlyBody body = solarSystem.get("Mars");
//        System.out.println("Moons of " + body.getKey());
//        for(HeavenlyBody moon: body.getSatellites()) {
//            System.out.println("\t" + moon.getName());
//        }
//
//        Set<HeavenlyBody> moons = new HashSet<>();
//        for(HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites()); // intersection of planets and their moons
//        }
//
//        System.out.println("All Moons");
//        for(HeavenlyBody moon : moons) {
//            System.out.println("\t" + moon.getName());
//        }
//
//        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
//        planets.add(pluto);
//
//        for (HeavenlyBody planet : planets) {
//            // pluto appears twice!
//            // both pluto objects are not totally equal (oribtalPeriods are different but names are the same)
//            // they do not compare equal
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
//        }
//
//        Object o = new Object();
//        o.equals(o);
//        "pluto".equals("");
    }
}