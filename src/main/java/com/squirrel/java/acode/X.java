package com.squirrel.java.acode;

import com.alibaba.excel.util.StringUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
class X {

    private String nodeUid;
    private String path;

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime sendTime = new Date(1684841348000L).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


        LocalDateTime showingTIme = new Date(1684927748000L).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println(now.compareTo(sendTime) >= 0 && now.compareTo(showingTIme) < 0);
    }


    public static boolean isEffectiveHour(LocalTime target, String startHour, String endHour) {
        if (target != null && !StringUtils.isBlank(startHour) && !StringUtils.isBlank(endHour) && !startHour.equals(endHour)) {
            Integer start = Integer.valueOf(startHour);
            Integer end = Integer.valueOf(endHour);
            if (end.equals(0)) {
                end = 23;
            } else {
                end = end - 1;
            }

            LocalTime startTime = LocalTime.of(start, 0, 0);
            LocalTime endTime = LocalTime.of(end, 59, 59);
            if (startTime.compareTo(endTime) > 0) {
                if (target.compareTo(startTime) >= 0 || target.compareTo(endTime) <= 0) {
                    return true;
                }
            } else if (startTime.compareTo(endTime) < 0 && target.compareTo(startTime) >= 0 && target.compareTo(endTime) <= 0) {
                return true;
            }

            return false;
        } else {
            return false;
        }
    }

}