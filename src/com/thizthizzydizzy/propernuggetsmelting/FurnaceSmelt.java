package com.thizthizzydizzy.propernuggetsmelting;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;
public class FurnaceSmelt implements Listener{
    private final ProperNuggetSmelting plugin;
    public FurnaceSmelt(ProperNuggetSmelting plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event){
        event.getBlock().getBlockData().getAsString();
        if(event.getResult().getType()==Material.IRON_NUGGET||event.getResult().getType()==Material.GOLD_NUGGET){//smelting something to nugget
            if(event.getResult().getAmount()>1)return;
            ItemStack tool = event.getSource();
            short max = tool.getType().getMaxDurability();
            float percent = (max-tool.getDurability())/(float)max;
            int nuggets = 0;
            switch(tool.getType()){
                case IRON_AXE:
                case GOLDEN_AXE:
                    nuggets = 9*3;
                    break;
                case CHAINMAIL_BOOTS:
                    percent*=plugin.getConfig().getDouble("chainmail-multiplier");
                case IRON_BOOTS:
                case GOLDEN_BOOTS:
                    nuggets = 9*4;
                    break;
                case CHAINMAIL_CHESTPLATE:
                    percent*=plugin.getConfig().getDouble("chainmail-multiplier");
                case IRON_CHESTPLATE:
                case GOLDEN_CHESTPLATE:
                    nuggets = 9*8;
                    break;
                case CHAINMAIL_HELMET:
                    percent*=plugin.getConfig().getDouble("chainmail-multiplier");
                case IRON_HELMET:
                case GOLDEN_HELMET:
                    nuggets = 9*5;
                    break;
                case IRON_HORSE_ARMOR:
                case GOLDEN_HORSE_ARMOR:
                    nuggets = 9*6;
                    percent = 1;
                    break;
                case IRON_HOE:
                case GOLDEN_HOE:
                    nuggets = 9*2;
                    break;
                case CHAINMAIL_LEGGINGS:
                    percent*=plugin.getConfig().getDouble("chainmail-multiplier");
                case IRON_LEGGINGS:
                case GOLDEN_LEGGINGS:
                    nuggets = 9*7;
                    break;
                case IRON_PICKAXE:
                case GOLDEN_PICKAXE:
                    nuggets = 9*3;
                    break;
                case IRON_SHOVEL:
                case GOLDEN_SHOVEL:
                    nuggets = 9;
                    break;
                case IRON_SWORD:
                case GOLDEN_SWORD:
                    nuggets = 9*2;
                    break;
                default:
                    return;
            }
            nuggets*=percent;
            event.getResult().setAmount(Math.max(1,nuggets));
        }
    }
}