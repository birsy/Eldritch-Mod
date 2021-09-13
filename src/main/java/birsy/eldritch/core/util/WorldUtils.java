package birsy.eldritch.core.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;

public class WorldUtils {
    public static List<BlockState> getSurroundingBlocks(ServerWorld world, BlockPos pos) {
        List<BlockState> states = new ArrayList<>();

        for (int x = -1; x < 1; x++) {
            for (int y = -1; y < 1; y++) {
                for (int z = -1; z < 1; z++) {
                    if (x != 0 && y != 0 && z != 0) {
                        BlockState state = world.getBlockState(pos.offset(x, y, z));
                        states.add(state);
                    }
                }
            }
        }

        return states;
    }

    public static List<Direction> getDirectionsFromAxis(Direction.Axis axis) {
        List<Direction> directions = new ArrayList<>();
        switch (axis) {
            case X:
                directions.add(Direction.EAST);
                directions.add(Direction.WEST);
                break;
            case Y:
                directions.add(Direction.UP);
                directions.add(Direction.DOWN);
                break;
            case Z:
                directions.add(Direction.NORTH);
                directions.add(Direction.SOUTH);
                break;
        }

        return directions;
    }
}
