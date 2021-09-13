package birsy.eldritch.common.blocks;

import birsy.eldritch.core.registry.RlyehianTags;
import birsy.eldritch.core.util.WorldUtils;
import birsy.eldritch.core.util.noise.FastNoiseLite;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class RottingBlock extends Block {
    public final BlockState rottingBlock;
    private final float rottingLevel;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    private FastNoiseLite noise;

    public RottingBlock(Properties properties, BlockState rottingBlock, float rottingLevel) {
        super(properties.randomTicks());
        this.rottingBlock = rottingBlock;
        this.rottingLevel = rottingLevel;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        initNoise();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        if (noise.GetSeed() != (int) world.getSeed()) {
            noise.SetSeed((int) world.getSeed());
        }

        float rotAmount = ((this.noise.GetNoise(pos.getX(), pos.getY() * 0.5F, pos.getZ()) + 1.0F) * 0.5F) * 3.0F;
        if (rotAmount > rottingLevel) {
            this.ageBlock(state, pos, world);
        }
    }

    public void ageBlock(BlockState state, BlockPos pos, ServerWorld world) {
        int age = world.getBlockState(pos).getValue(AGE);
        if (age == 15) {
            world.setBlock(pos, rottingBlock, 2);
        } else {
            world.setBlock(pos, state.setValue(AGE, MathHelper.clamp(0, 15, age + 1)), 2);
        }
    }

    private void initNoise() {
        this.noise = new FastNoiseLite();
        this.noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        this.noise.SetFrequency(0.3F);
        this.noise.SetFractalType(FastNoiseLite.FractalType.None);
        this.noise.SetDomainWarpType(FastNoiseLite.DomainWarpType.BasicGrid);
        this.noise.SetDomainWarpAmp(100.0F);
        this.noise.SetRotationType3D(FastNoiseLite.RotationType3D.ImproveXZPlanes);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> stateContainer) {
        stateContainer.add(AGE);
    }
}
