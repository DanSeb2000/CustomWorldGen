package me.danseb.customworldgen;

import me.danseb.customworldgen.populators.Grass;
import me.danseb.customworldgen.populators.Lakes;
import me.danseb.customworldgen.populators.Trees;
import me.danseb.customworldgen.populators.Veins;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {
    int currentHeight = 50;

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.006D);

        if ((chunkX < 125 && chunkZ < 125) && (chunkX >= -125 && chunkZ >= -125)){
            for (int X = 0; X < 16; X++)
                for (int Z = 0; Z < 16; Z++) {
                    currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z,
                            0.5D, 0.15D)*15D+50D);
                    chunk.setBlock(X, currentHeight, Z, Material.GRASS_BLOCK);
                    chunk.setBlock(X, currentHeight-1, Z, Material.DIRT);
                    for (int i = currentHeight-2; i > 0; i--)
                        chunk.setBlock(X, i, Z, Material.STONE);
                    chunk.setBlock(X, 0, Z, Material.BEDROCK);
                    for (int i = 256; i >= 0; i--)
                        biome.setBiome(X, i, Z, Biome.PLAINS);
                }
        } else {
            for (int X = 0; X < 16; X++)
                for (int Z = 0; Z < 16; Z++){
                    for (int Y = 32; Y > 0; Y--)
                        chunk.setBlock(X, Y, Z, Material.WATER);
                    chunk.setBlock(X, 0, Z, Material.BEDROCK);
                }
        }
        return chunk;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(/*new Trees(), new Grass(), new Lakes(), new Veins()*/);
    }
}
