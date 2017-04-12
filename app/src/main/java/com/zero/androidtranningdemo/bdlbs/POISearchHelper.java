package com.zero.androidtranningdemo.bdlbs;

/**
 * 采用Web API的方式
 * Created by hui_deng on 17-4-12.
 */

public class POISearchHelper {

    private static final String BASE_URL = "https://api.map.baidu.com/place/v2/search";

    private static final String QUERY_VALUE = "餐馆$酒店$咖啡厅$银行$交通设施$超市$医院$药店$电影院$景点";

    private static final String AK = "MNCURTZVtupSwv4lRyQL896tGWNXkyue";

    private String LOCATION = "22.539316,113.961241";

    String url = BASE_URL + "?query=" + QUERY_VALUE
            + "&page_size=20&page_num=0&scope=2"
            + "&location=" + LOCATION
            + "&radius=1000&output=json"
            + "&ak=" + AK;
}
