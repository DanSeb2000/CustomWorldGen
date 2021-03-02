package me.danseb.customworldgen.populators;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class Grass extends BlockPopulator {
    @Override
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextBoolean()) {
            int amount = random.nextInt(14)+1;  // Amount of trees
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;
                for (Y = 128-1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--){
                    if (chunk.getBlock(X, Y-1, Z).getType() == Material.GRASS_BLOCK)
                        chunk.getBlock(X, Y+1, Z).setType(Material.GRASS);
                }

            }
        }
    }
}
