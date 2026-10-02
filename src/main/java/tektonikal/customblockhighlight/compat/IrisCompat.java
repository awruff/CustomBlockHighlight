package tektonikal.customblockhighlight.compat;

//? if >=1.21.5 {
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import net.fabricmc.loader.api.FabricLoader;

public final class IrisCompat {
	private static final boolean PRESENT = FabricLoader.getInstance().isModLoaded("iris");

	public static void assign(RenderPipeline pipeline, boolean lines) {
		if (PRESENT) {
			Hook.assign(pipeline, lines);
		}
	}

	private static final class Hook {
		static void assign(RenderPipeline pipeline, boolean lines) {
			try {
				net.irisshaders.iris.api.v0.IrisApi.getInstance().assignPipeline(pipeline, lines
						? net.irisshaders.iris.api.v0.IrisProgram.LINES
						: net.irisshaders.iris.api.v0.IrisProgram.BASIC);
			} catch (IllegalStateException alreadyClaimed) {
			}
		}
	}
}
//?}
