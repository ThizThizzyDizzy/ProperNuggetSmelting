package com.thizthizzydizzy.propernuggetsmelting;
import org.bukkit.Material;
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
            int nuggets = 0;
            switch(tool.getType()){
                case IRON_AXE:
                case GOLDEN_AXE:
                    nuggets = 9*3;
                    break;
                case CHAINMAIL_BOOTS:
                case IRON_BOOTS:
                case GOLDEN_BOOTS:
                    nuggets = 9*4;
                    break;
                case CHAINMAIL_CHESTPLATE:
                case IRON_CHESTPLATE:
                case GOLDEN_CHESTPLATE:
                    nuggets = 9*8;
                    break;
                case CHAINMAIL_HELMET:
                case IRON_HELMET:
                case GOLDEN_HELMET:
                    nuggets = 9*5;
                    break;
                case IRON_HORSE_ARMOR:
                case GOLDEN_HORSE_ARMOR:
                    nuggets = 9*6;
                    break;
                case IRON_HOE:
                case GOLDEN_HOE:
                    nuggets = 9*2;
                    break;
                case CHAINMAIL_LEGGINGS:
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
            float percent = (max-tool.getDurability())/(float)max;
            if(tool.getType()==Material.IRON_HORSE_ARMOR||tool.getType()==Material.GOLDEN_HORSE_ARMOR){
                percent = 1;
            }
            switch(tool.getType()){
                case CHAINMAIL_BOOTS:
                case CHAINMAIL_CHESTPLATE:
                case CHAINMAIL_HELMET:
                case CHAINMAIL_LEGGINGS:
                    percent *= plugin.getConfig().getDouble("chainmail-multiplier");
                    break;
                case IRON_AXE:
                case IRON_BOOTS:
                case IRON_CHESTPLATE:
                case IRON_HELMET:
                case IRON_HOE:
                case IRON_HORSE_ARMOR:
                case IRON_LEGGINGS:
                case IRON_PICKAXE:
                case IRON_SHOVEL:
                case IRON_SWORD:
                    percent *= plugin.getConfig().getDouble("iron-multiplier");
                    break;
                case GOLDEN_AXE:
                case GOLDEN_BOOTS:
                case GOLDEN_CHESTPLATE:
                case GOLDEN_HELMET:
                case GOLDEN_HOE:
                case GOLDEN_HORSE_ARMOR:
                case GOLDEN_LEGGINGS:
                case GOLDEN_PICKAXE:
                case GOLDEN_SHOVEL:
                case GOLDEN_SWORD:
                    percent *= plugin.getConfig().getDouble("gold-multiplier");
                    break;
                default:
                    return;
            }
            nuggets *= percent;
            event.getResult().setAmount(Math.max(1, nuggets));
        }
    }
}
