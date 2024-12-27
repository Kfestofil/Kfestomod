package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Entity.Arrow404Renderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ClientEntityInit {
    public static void init() {
        EntityRendererRegistry.register(EntityInit.ARROW404, Arrow404Renderer::new);
    }
}
