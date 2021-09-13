package birsy.eldritch.common.blocks;

import birsy.eldritch.core.registry.RlyehianTags;
import birsy.eldritch.core.util.WorldUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ChiseledSeabedBlock extends DirectionalBlock {
    public final BlockState rottingBlock;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_25;
    
    public ChiseledSeabedBlock(AbstractBlock.Properties properties, BlockState rottingBlock) {
        super(properties.randomTicks());
        this.rottingBlock = rottingBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(AGE, 0));
    }
    
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getClickedFace();
        return this.defaultBlockState().setValue(FACING, direction);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        int rottenLevel = getSurroundingValidRottenBlocks(world, pos);
        if (rottenLevel >= 3 && rottenLevel <= 5) {
            ageBlock(state, pos, world);
        } else if (rottenLevel < 3 && rand.nextInt(3) == 0) {
            ageBlock(state, pos, world);
        }
    }

    public void ageBlock(BlockState state, BlockPos pos, ServerWorld world) {
        int age = world.getBlockState(pos).getValue(AGE);
        if (age == 25) {
            world.setBlock(pos, rottingBlock, 2);
        } else {
            world.setBlock(pos, state.setValue(AGE, MathHelper.clamp(0, 25, age + 1)), 2);
        }
    }

    private int getSurroundingValidRottenBlocks(ServerWorld world, BlockPos pos) {
        int num = 0;
        for (BlockState surroundingBlock : WorldUtils.getSurroundingBlocks(world, pos)) {
            if (surroundingBlock.is(RlyehianTags.SEABED_BLOCKS) || surroundingBlock.is(RlyehianTags.ROTTEN_SEABED_BLOCKS)) {
                num++;
            }
        }

        return num;
    }
    
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> stateContainer) {
        stateContainer.add(FACING, AGE);
    }
}
