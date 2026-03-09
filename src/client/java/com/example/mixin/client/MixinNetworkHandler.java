import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RaycastContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinNetworkHandler {

    @Shadow @Final private ClientWorld world;

    @Inject(method = "onBlockUpdate", at = @At("TAIL"))
    public void onBlockUpdate(BlockPos pos, int stateId, CallbackInfo ci) {
        BlockPos playerPos = world.getPlayer().getBlockPos();
        BlockPos center = pos.midCenter();
        boolean blocked = world.raycast(new RaycastContext(playerPos, center, RaycastContext.ShapeType.OUTLINE, FluidShapeManager.getRegionTypeTester(FluidShapeManager.FluidType.MASKED), player -> true)).getType() != RaycastContext.ResultType.MISS;
        if (blocked) {
            ci.cancel();
        }
    }
}
