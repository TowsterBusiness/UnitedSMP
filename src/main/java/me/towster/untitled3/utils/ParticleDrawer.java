package me.towster.untitled3.utils;

import jdk.incubator.vector.VectorOperators;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class ParticleDrawer {
    public static void drawLine(World world, Particle particle, Vector a, Vector b, double margin) {

        Location loc = new Location(world, a.getX(), a.getY(), a.getZ());
        Vector mult = b.clone().subtract(a).normalize().multiply(margin);

        for (int i = 0; i < (int) Math.floor(a.distance(b) / margin); i++) {
            world.spawnParticle(particle, loc.add(mult), 0, 0, 0, 0);
        }

        world.spawnParticle(particle, new Location(world, b.getX(), b.getY(), b.getZ()), 0, 0, 0, 0);
    }

    public static void drawCyl(World world, Particle particle, Vector a, Vector b, double radius, double margin) {

        Location loc = new Location(world, a.getX(), a.getY(), a.getZ());
        Vector mult = b.clone().subtract(a).normalize().multiply(margin);

        for (int i = 0; i < (int) Math.floor(a.distance(b) / margin); i++) {
            world.spawnParticle(particle, loc.add(mult), 0, 0, 0, 0);
        }

        world.spawnParticle(particle, new Location(world, b.getX(), b.getY(), b.getZ()), 0, 0, 0, 0);
    }

    public static void drawSquare(World world, Particle particle, Vector a, Vector b, double margin) {
        double aX = a.getX();
        double aY = a.getY();
        double aZ = a.getZ();
        double bX = b.getX();
        double bY = b.getY();
        double bZ = b.getZ();

        drawLine(world, particle, a, new Vector(aX, aY, bZ), margin);
        drawLine(world, particle, a, new Vector(aX, bY, aZ), margin);
        drawLine(world, particle, a, new Vector(bX, aY, aZ), margin);

        drawLine(world, particle, b, new Vector(bX, bY, aZ), margin);
        drawLine(world, particle, b, new Vector(bX, aY, bZ), margin);
        drawLine(world, particle, b, new Vector(aX, bY, bZ), margin);

        drawLine(world, particle, new Vector(aX, bY, aZ), new Vector(aX, bY, bZ), margin);
        drawLine(world, particle, new Vector(aX, bY, aZ), new Vector(bX, bY, aZ), margin);
        drawLine(world, particle, new Vector(bX, bY, aZ), new Vector(bX, aY, bZ), margin);
        drawLine(world, particle, new Vector(bX, aY, bZ), new Vector(aX, aY, bZ), margin);
        drawLine(world, particle, new Vector(aX, aY, bZ), new Vector(aX, bY, aZ), margin);

    }
}
