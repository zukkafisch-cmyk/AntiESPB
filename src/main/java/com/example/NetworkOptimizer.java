import net.fabricmc.api.ModInitializer;
import net.minecraft.util.log.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkOptimizer implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("networkoptimizer");

    @Override
    public void onInitialize() {
        LOGGER.info("Inicializando NetworkOptimizer");
    }
}
