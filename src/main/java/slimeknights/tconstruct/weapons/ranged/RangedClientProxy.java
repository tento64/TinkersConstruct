package slimeknights.tconstruct.weapons.ranged;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import slimeknights.tconstruct.common.ClientProxy;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.tools.client.renderer.RenderShuriken;
import slimeknights.tconstruct.tools.entity.EntityShuriken;

public class RangedClientProxy extends ClientProxy {

  @Override
  protected void registerModels() {
    super.registerModels();

    // entities
    RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new IRenderFactory<EntityShuriken>() {
      @Override
      public Render<? super EntityShuriken> createRenderFor(RenderManager manager) {
        return new RenderShuriken(manager);
      }
    });
  }

  @Override
  public void init() {
    super.init();

    registerToolBuildInfo();
  }

  private void registerToolBuildInfo() {
    ToolBuildGuiInfo info;

    // shuriken
    info = new ToolBuildGuiInfo(TinkerRangedWeapons.shuriken);
    info.addSlotPosition(32 - 12, 41 - 12); // top left
    info.addSlotPosition(32 + 12, 41 - 12); // top right
    info.addSlotPosition(32 + 12, 41 + 12); // bot left
    info.addSlotPosition(32 - 12, 41 + 12); // bot right
    TinkerRegistryClient.addToolBuilding(info);
  }
}
