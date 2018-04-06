package com.mrcrayfish.vehicle.entity;

import com.mrcrayfish.vehicle.init.ModItems;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Author: MrCrayfish
 */
public class EntityDuneBuggy extends EntityVehicle
{
    /**
     * ItemStack instances used for rendering
     */
    @SideOnly(Side.CLIENT)
    public ItemStack handleBar;

    public EntityDuneBuggy(World worldIn)
    {
        super(worldIn);
        this.setMaxSpeed(10);
        this.setSize(0.75F, 0.75F);
        this.stepHeight = 0.5F;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();

        if(world.isRemote)
        {
            body = new ItemStack(ModItems.DUNE_BUGGY_BODY);
            handleBar = new ItemStack(ModItems.DUNE_BUGGY_HANDLE_BAR);
            wheel = new ItemStack(ModItems.DUNE_BUGGY_WHEEL);
        }
    }

    @Override
    public SoundEvent getMovingSound()
    {
        return ModSounds.ATV_ENGINE_MONO;
    }

    @Override
    public SoundEvent getRidingSound()
    {
        return ModSounds.ATV_ENGINE_STEREO;
    }

    @Override
    public double getMountedYOffset()
    {
        return 3.25 * 0.0625;
    }
}
