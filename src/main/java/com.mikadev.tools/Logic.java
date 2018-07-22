/*
 * Copyright 2018 mikadev.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created by Nikolay Sviridenko on 22.07.2018.
 */
package com.mikadev.tools;

import com.mikadev.tools.html.Client;
import com.mikadev.tools.xml.Activity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;

public class Logic {
    public static  final Logger logger = LogManager.getLogger(Logic.class);
    private Config config;
    private Client client;

    public Logic(Config config) {
        this.config = config;
        this.client = new Client();
    }

    public void run() {
        for(int i =0; i<config.getActivities().size(); i++) {
            Activity activity = config.getActivities().get(i);

            //For cities

            if(!activity.getWholeRegion()) {
                for(int m = 0; m<activity.getCities().size(); m++) {
                    String city = activity.getCities().get(m);
                    String noCityLink = firstRunLinkGenerate(activity);
                    String cLink = cityURL(noCityLink,city);

                    //Get pages count
                }
            }
        }
    }

    private String firstRunLinkGenerate(Activity activity) {
        String link = null;

        if(activity.getWholeRegion()) {
            link = "http://zakupki.gov.ru/epz/order/extendedsearch/results.html?" +
                    "morphology=on&" +
                    "openMode=USE_DEFAULT_PARAMS&" +
                    "pageNumber=[PN]&" +
                    "sortDirection=false&" +
                    "recordsPerPage=_100&" +
                    "showLotsInfoHidden=false&" +
                    "fz44=on&" +
                    "fz223=on&" +
                    "ppRf615=on&" +
                    "fz94=on&af=on&" +
                    "currencyIdGeneral=-1&" +
                    "region_regions_5277374=region_regions_5277374&" +
                    "regions=5277374&" +
                    "regionDeleted=false&" +
                    "sortBy=UPDATE_DATE";
        } else {
            link = "http://zakupki.gov.ru/epz/order/extendedsearch/results.html?" +
                    "morphology=on&" +
                    "openMode=USE_DEFAULT_PARAMS&" +
                    "pageNumber=[PN]&" +
                    "sortDirection=false&" +
                    "recordsPerPage=_100&" +
                    "showLotsInfoHidden=false&" +
                    "fz44=on&" +
                    "fz223=on&" +
                    "ppRf615=on&" +
                    "af=on&" +
                    "currencyIdGeneral=-1&" +
                    "regionDeleted=false&" +
                    "deliveryAddress=[CITY]&" +
                    "sortBy=UPDATE_DATE";
        }
        return link;
    }

    private String cityURL(String rawUrl, String city) {
        String response = null;

        try {
            response = rawUrl.replace("[CITY]",java.net.URLEncoder.encode(city ,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.ERROR,e);
        }
        return response;
    }

    private Integer getAllPagesCount(String firstLink) {
        Integer response = null;

        try {
            String body = client.plainGetRequest(firstLink).getDom();
        } catch (Exception e) {
            logger.log(Level.ERROR,e);
        }
        return response;
    }
}
