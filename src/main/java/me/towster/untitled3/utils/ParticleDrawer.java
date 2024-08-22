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
}
