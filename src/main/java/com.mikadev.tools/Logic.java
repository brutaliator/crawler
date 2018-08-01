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

import com.mikadev.tools.database.DbOperations;
import com.mikadev.tools.domparse.Parser;
import com.mikadev.tools.html.Client;
import com.mikadev.tools.xml.Activity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Element;
import javax.lang.model.util.Elements;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Logic {
    public static  final Logger logger = LogManager.getLogger(Logic.class);
    private Config config;
    private Client client;

    public Logic(Config config) {
        this.config = config;
        this.client = new Client();
    }

    public void run() throws Exception {

        for(int i =0; i<config.getActivities().size(); i++) {
            Activity activity = config.getActivities().get(i);
            List<String > keyWords = activity.getKeywords();
            List<Order> orders = new ArrayList<>();

            //For cities

            if(!activity.getWholeRegion()) {

                //For all cities
                for(int m = 0; m<activity.getCities().size(); m++) {
                    String city = activity.getCities().get(m);
                    String noCityLink = firstRunLinkGenerate(true);
                    String cLink = cityURL(noCityLink,city);
                    String cLinkFirstPage = cLink.replace("[PN]","1");
                    //Get pages count
                    int cPages = Parser.getLastPage(client.plainGetRequest(cLinkFirstPage).getDom());
                    if (cPages <1) continue;

                    for(int h = 1; h<=cPages; h++) {
                        String thisPage = cLink.replace("[PN]",String.valueOf(h));
                        org.jsoup.select.Elements tenders = Parser.getBoxes(client.plainGetRequest(thisPage).getDom());
                            if(tenders.isEmpty()) continue;
                        for (Element tender: tenders) {
                            String id= Parser.getBoxIdOrder(tender);
                            String nameOrder = Parser.getBoxNameOrder(tender);
                            if(!checkWordsContains(keyWords,nameOrder)) continue;
                            if(isTenderInBase(id)) continue;
                            Order order = new Order();
                            order.setActivity(activity.getType());
                            order.setOrderId(id);
                            order.setOrderName(nameOrder);
                            order.setOrderLink(Parser.getBoxLinkOrder(tender));
                            order.setOrderType(Parser.getBoxTypeOrder(tender));
                            order.setOrderLaw(Parser.getBoxLawOrder(tender));
                            order.setOrderPrice(Parser.getBoxPriceOrder(tender));
                            order.setOrderStopDate(Parser.getBoxStopDate(Parser.getBoxLinkOrder(tender)));
                            order.setOrderTradePlace(Parser.getBoxLinkOrder(tender));

                            orders.add(order);

                        }
                    }
                }

                //For whole region

                String rLink = firstRunLinkGenerate(false);
                String rLinkFirstPage = rLink.replace("[PN]","1");
                int rPages = Parser.getLastPage(client.plainGetRequest(rLinkFirstPage).getDom());
                if (rPages <1) continue;

                for(int h = 1; h<=rPages; h++) {
                    String thisPage = rLink.replace("[PN]",String.valueOf(h));
                    org.jsoup.select.Elements tenders = Parser.getBoxes(client.plainGetRequest(thisPage).getDom());
                    if(tenders.isEmpty()) continue;
                    for (Element tender: tenders) {
                        String id= Parser.getBoxIdOrder(tender);
                        String nameOrder = Parser.getBoxNameOrder(tender);
                        if(!checkWordsContains(keyWords,nameOrder)) continue;
                        if(isTenderInBase(id)) continue;
                        Order order = new Order();
                        order.setActivity(activity.getType());
                        order.setOrderId(id);
                        order.setOrderName(nameOrder);
                        order.setOrderLink(Parser.getBoxLinkOrder(tender));
                        order.setOrderType(Parser.getBoxTypeOrder(tender));
                        order.setOrderLaw(Parser.getBoxLawOrder(tender));
                        order.setOrderPrice(Parser.getBoxPriceOrder(tender));
                        order.setOrderStopDate(Parser.getBoxStopDate(Parser.getBoxLinkOrder(tender)));
                        order.setOrderTradePlace(Parser.getBoxLinkOrder(tender));

                        orders.add(order);

                    }
                }
            }



        }
    }

    public Boolean checkWordsContains(List<String> keyWords, String orderName) {
        Boolean contains = false;
        for (String keyword: keyWords) {
            if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(orderName , keyword)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    private boolean isTenderInBase(String id) {
        Boolean inBase = null;
        try {
            inBase = DbOperations.checkTender(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inBase;
    }

    private String firstRunLinkGenerate(Boolean isCities) {
        String link = null;

        if(!isCities) {
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
                    "fz94=on&af=on&" +
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
