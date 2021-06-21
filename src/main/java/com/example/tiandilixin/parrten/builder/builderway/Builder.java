package com.example.tiandilixin.parrten.builder.builderway;


import com.example.tiandilixin.parrten.builder.commonway.*;

public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦Markdown-Resume-master
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

    public static void main(String[] args) {
            Builder builder = new Builder();
            // 豪华欧式
            System.out.println(builder.levelOne(132.52D).getDetail());
            // 轻奢田园
            System.out.println(builder.levelTwo(98.25D).getDetail());
            // 现代简约
            System.out.println(builder.levelThree(85.43D).getDetail());
    }

}