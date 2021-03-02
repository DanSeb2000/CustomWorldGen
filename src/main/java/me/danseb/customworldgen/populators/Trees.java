package me.danseb.customworldgen.populators;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class Trees extends BlockPopulator {
    @Override
    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextBoolean()) {
            int tries = 3;
            TreeType treeType = TreeType.TREE;

            for (int i = 1; i < 8; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;

                for (Y = 128-1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--){

                    switch (chunk.getBlock(X, Y, Z).getBiome()){
                        case PLAINS:
                        case SUNFLOWER_PLAINS:
                            tries = random.nextInt(2)+1;
                            break;
                        case FOREST:
                        case FLOWER_FOREST:
                            tries = random.nextInt(6)+1;
                            break;
                        case TAIGA:
                        case SNOWY_TUNDRA:
                        case TAIGA_HILLS:
                        case SNOWY_TAIGA:
                        case SNOWY_TAIGA_HILLS:
                        case TAIGA_MOUNTAINS:
                            treeType = TreeType.REDWOOD;
                            tries = random.nextInt(3)+1;
                            break;
                        case SWAMP:
                        case SWAMP_HILLS:
                            treeType = TreeType.SWAMP;
                            tries = random.nextInt(3)+1;
                            break;
                        case MUSHROOM_FIELDS:
                        case MUSHROOM_FIELD_SHORE:
                            treeType = TreeType.RED_MUSHROOM;
                            tries = random.nextInt(3)+1;
                            break;
                        case WOODED_HILLS:
                        case WOODED_BADLANDS_PLATEAU:
                            tries = random.nextInt(1)+1;
                            break;
                        case JUNGLE:
                        case JUNGLE_HILLS:
                            treeType = TreeType.JUNGLE;
                            tries = random.nextInt(7)+1;
                            break;
                        case JUNGLE_EDGE:
                            treeType = TreeType.SMALL_JUNGLE;
                            tries = random.nextInt(1)+1;
                            break;
                        case BIRCH_FOREST:
                        case BIRCH_FOREST_HILLS:
                            treeType = TreeType.BIRCH;
                            tries = random.nextInt(3)+1;
                            break;
                        case DARK_FOREST:
                            treeType = TreeType.DARK_OAK;
                            tries = random.nextInt(4)+1;
                            break;
                        case GIANT_TREE_TAIGA:
                        case GIANT_TREE_TAIGA_HILLS:
                        case GIANT_SPRUCE_TAIGA:
                        case GIANT_SPRUCE_TAIGA_HILLS:
                            treeType = TreeType.MEGA_REDWOOD;
                            tries = random.nextInt(3)+1;
                            break;
                        case SAVANNA:
                        case SAVANNA_PLATEAU:
                        case SHATTERED_SAVANNA:
                        case SHATTERED_SAVANNA_PLATEAU:
                            treeType = TreeType.ACACIA;
                            tries = random.nextInt(3)+1;
                            break;
                        case MODIFIED_JUNGLE:
                            treeType = TreeType.JUNGLE;
                            tries = random.nextInt(3)+1;
                            break;
                        case MODIFIED_JUNGLE_EDGE:
                            treeType = TreeType.SMALL_JUNGLE;
                            tries = random.nextInt(3)+1;
                            break;
                        case TALL_BIRCH_FOREST:
                        case TALL_BIRCH_HILLS:
                            treeType = TreeType.TALL_BIRCH;
                            tries = random.nextInt(3)+1;
                            break;
                        case DARK_FOREST_HILLS:
                            treeType = TreeType.DARK_OAK;
                            tries = random.nextInt(3)+1;
                            break;
                        case SNOWY_TAIGA_MOUNTAINS:
                            treeType = TreeType.TALL_REDWOOD;
                            tries = random.nextInt(1)+1;
                            break;
                        case BAMBOO_JUNGLE:
                        case BAMBOO_JUNGLE_HILLS:
                            treeType = TreeType.JUNGLE;
                            tries = random.nextInt(2)+1;
                            break;
                    }

                    if (tries < i)
                        world.generateTree(chunk.getBlock(X, Y, Z).getLocation(), treeType);
                }
            }
        }
    }
}
