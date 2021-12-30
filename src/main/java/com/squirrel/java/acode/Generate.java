package com.squirrel.java.acode;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Generate {

    private Top top;
    private List<Indicator> indicatorList;
    private Detail detail;


    public static void main(String[] args) {
        Top top = new Top();
        top.setLeftTitle("有效客源");
        top.setValue("1,1241");
        top.setRightTitle("进入客源管理");
        top.setRoute(Route.builder().routeUrl("ziroomCustomer://zrMeetingModule/MeetingModuleListActivity").build());

        List<Indicator> indicatorList = new ArrayList<>();

        Indicator indicator = new Indicator();
        indicator.setName("今日入住客源/已签");
        indicator.setValue("18");
        indicator.setAchievementValue("2");
        indicator.setDesc("准确率90%");
        indicator.setSelected(true);

        Indicator indicator1 = new Indicator();
        indicator1.setName("今日计划带看/实际带看");
        indicator1.setValue("18");
        indicator1.setAchievementValue("2");
        indicator1.setDesc("准确率94%");


        indicatorList.add(indicator);
        indicatorList.add(indicator1);

        Items items = new Items();
        items.setLeftDesc("霍营业务组");
        items.setRightDesc("准确率100%");
        items.setValue("18");
        items.setAchievementValue("8");
        items.setRoute(Route.builder().routeUrl("ziroomCustomer://zrMeetingModule/MeetingModuleListActivity").build());

        Items items1 = new Items();
        items1.setLeftDesc("张晴");
        items1.setRightDesc("准确率90%");
        items1.setValue("5");
        items1.setAchievementValue("2");
        items1.setRoute(Route.builder().routeUrl("ziroomCustomer://zrMeetingModule/MeetingModuleListActivity").build());

        Items items2 = new Items();
        items2.setLeftDesc("杨可可");
        items2.setRightDesc("准确率23%");
        items2.setValue("5");
        items2.setAchievementValue("2");
        items2.setRoute(Route.builder().routeUrl("ziroomCustomer://zrMeetingModule/MeetingModuleListActivity").build());

        List<Items> items3 = new ArrayList<>();
        items3.add(items);
        items3.add(items1);
        items3.add(items2);


        Detail detail = new Detail();
        detail.setLeftTitle("组织名称");
        detail.setRightTitle("今日入住客源/已签");
        detail.setType("GROUP");
        detail.setList(items3);


        Generate generate = new Generate();
        generate.setTop(top);
        generate.setDetail(detail);
        generate.setIndicatorList(indicatorList);

        System.out.println(JSONObject.toJSONString(generate));


    }


}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Route {
    private String routeUrl;
    private String routeType;
}

@Data
class Top {
    private String leftTitle;
    private String value;
    private String rightTitle;
    private Route route;
}

@Data
class Indicator {
    private String name;
    private String value;
    private String achievementValue;
    private String desc;
    private boolean selected;
}

@Data
class Detail {

    private String leftTitle;
    private String rightTitle;
    private String type;
    private List<Items> list;

}

@Data
class Items {
    private String value;
    private String achievementValue;
    private String leftDesc;
    private String rightDesc;
    private Route route;


    /*

    介绍一下评价项目吧？

    评价项目现在的整体结构是由几个模块构成的:
    1.评价API服务, 由客户端直接调用
    2.评价Dubbo服务提供者:
    3.评价后台管理的服务
    4.评价定时任务服务
    5.然后数据存储采用 Mysql + Es

    评价系统目前

    一个评价完整的流程是: 业务线调用评价系统的创建评价单的接口-在评价系统生成一个评价单
    评价系统把评价链接返回给业务线。



    评价这个项目经过两期重构,
        一期重构的背景是 评价当时三套系统并行以及使用Oracle数据库和Mysql数据库一起并行使用  然后当时公司要进行去0,还有三套系统并行维护起来难度大
        一期的重构的结果是去除了Oracle数据库以及将三套系统合并为一套系统。至于为啥是三个系统我来的时候问过同事,说之前系统被别人重构过两波,但都没有重构完。导致了三个系统一起跑。然后Oracle也没去掉。
        二期的重构是因为随着业务线接入放越来越多,一年不到评价单表将近1000万,评价答案表将近2000多万,为了支持更多的业务线接入,
        进行了分表。















     */
}