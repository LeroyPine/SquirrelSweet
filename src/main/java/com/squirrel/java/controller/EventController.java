package com.squirrel.java.controller;

import com.alibaba.fastjson.JSON;
import com.squirrel.java.entity.Link;
import com.squirrel.java.spring.publish.MyEventPublish;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月29日 14:12
 * @since 1.0
 */
@RestController
@RequestMapping("/12")
public class EventController {

    @Autowired
    private EventController eventController;

    @Autowired
    private MyEventPublish myEventPublish;

    /**
     * alive interface
     *
     * @return ok
     */
    @RequestMapping("/publish/event")
    @ResponseBody
    public String publishEvent() {

        myEventPublish.publishEv();
        return "success";

    }

    public static void main(String[] args) {

        List<Link>  link = Lists.newArrayList();

        String houseDetailUrl = String.format("%s/mobile-sales-restful/houseCustomer/houseDetail.html?currentUserId=%s&houseId=%s&businessType=%s","http://",123,1212,2);

        Link alink = new Link();
        alink.setHouseId("aaaaa");
        alink.setBuss(2);

        link.add(alink);

        StringBuilder contentAppBuilder = new StringBuilder();
        contentAppBuilder.append("您将于");
        contentAppBuilder.append("进行房源陪看，带看人");
        contentAppBuilder.append("，带看单");
        contentAppBuilder.append("陪看房源");
        contentAppBuilder.append("，温馨提示：\n");
        contentAppBuilder.append("1、【信息准备】为提升客户体验，维护人需提前了解房源信息、小区信息、周边配套信息、业主要求等，在陪看过程中如实讲解信息，及时解答客户相关问题。 \n");
        contentAppBuilder.append("2、【必备工具】有钥匙房源提前准备好钥匙、无钥匙房源联系业主，告知业主预计看房时间、鞋套 \n");
        contentAppBuilder.append("3、【提前沟通】带看前30分钟，沟通带看人确认客户到达时间，并告知业主客户预计到达时间 \n");
        contentAppBuilder.append("4、【职业形象】提前整理着装（着装整齐，工牌领带佩戴整齐，符合职业形象标准），给客户业主留下良好的职业形象。");
        contentAppBuilder.append("####");


        String contentAppBuilders = JSON.toJSONString(contentAppBuilder).replaceFirst("\"","");
        if (contentAppBuilders.endsWith("\"")) {
            contentAppBuilders = replaceLast(contentAppBuilders, "\"", "");
        }
        System.out.println(contentAppBuilders);
        String appContent = contentAppBuilders + JSON.toJSONString(link);

        System.out.println(appContent);


        System.out.println(String.format(HOUSE_DETAIL_LEASE_LINK_FOR_PC,1231,124));

    }
    public static final String HOUSE_DETAIL_LEASE_LINK_FOR_PC = "<a href='/sales/house/main/newLease?houseId=%d' target='_blank'>%d</a>";

    public static String replaceLast(String s, String sub, String with) {
        int i = s.lastIndexOf(sub);
        return i == -1 ? s : s.substring(0, i) + with + s.substring(i + sub.length());
    }




}
