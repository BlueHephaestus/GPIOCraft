package com.vdamewood.gpiocraft

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class IOPort extends Block
{
	private final boolean isPowered;
	
	public IOPort(boolean isPowered)
	{
		super(Material.redstoneLight);
		this.setHardness(0.5f);
		this.isPowered = isPowered;
		
		//currently only changing texture based on passed value, need to figure out onNeighborBlockChange and setBlockMetaDataWithNotify
        if (isPowered){
        	this.setLightLevel(1.0F);
        }
	}
	@Override
    public void onBlockAdded(World world, int x, int y, int z) {
        if (!world.isRemote) {
            if (this.isPowered && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.scheduleBlockUpdate(x, y, z, this, 4);
            } else if (!this.isPowered && world.isBlockIndirectlyGettingPowered(x, y, z)) {
                world.setBlock(x, y, z, IOPortMain.ioPortOn, 0, 2);
            }
        }
    }
	@Override
    public void onNeighborBlockChange(World varWorld, int x, int y, int z, Block block)
    {
        if (!varWorld.isRemote)
        {
            if (this.isPowered && !varWorld.isBlockIndirectlyGettingPowered(x, y, z))
            {
                varWorld.scheduleBlockUpdate(x, y, z, this, 4);
            }
            else if (!this.isPowered && varWorld.isBlockIndirectlyGettingPowered(x, y, z))
            {
                varWorld.setBlock(x, y, z, IOPortMain.ioPortOn, 0, 2);
            }
        }
    }
    @Override
    public void updateTick(World varWorld, int x, int y, int z, Random rand)
    {
        if (!varWorld.isRemote && this.isPowered && !varWorld.isBlockIndirectlyGettingPowered(x, y, z))
        {
            varWorld.setBlock(x, y, z, IOPortMain.ioPortOff, 0, 2);
        }
    }
}
