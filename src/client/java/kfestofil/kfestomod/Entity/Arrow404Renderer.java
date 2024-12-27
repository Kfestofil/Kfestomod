package kfestofil.kfestomod.Entity;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ArrowEntityRenderState;
import net.minecraft.util.Identifier;

public class Arrow404Renderer extends ProjectileEntityRenderer<Arrow404Entity, ArrowEntityRenderState> {
    public static final Identifier TEXTURE = Kfestomod.id("textures/entity/arrow404.png");

    public Arrow404Renderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public ArrowEntityRenderState createRenderState() {
        return new ArrowEntityRenderState();
    }

    @Override
    protected Identifier getTexture(ArrowEntityRenderState arrowEntityRenderState) {
        return TEXTURE;
    }
}
