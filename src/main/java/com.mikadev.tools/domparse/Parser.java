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
 * Created by Nikolay Sviridenko on 23.07.2018.
 */
package com.mikadev.tools.domparse;

import com.mikadev.tools.Defined;
import com.mikadev.tools.MailTemplate;
import com.mikadev.tools.Order;
import com.mikadev.tools.html.Client;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.annotation.Documented;
import java.util.List;

public class Parser {
    public static  final Logger logger = LogManager.getLogger(Parser.class);

    public static int getLastPage(String dom) {

        int response = 0;
        Document doc = Jsoup.parse(dom);
        Elements allPagings = doc.getElementsByClass("paging");
        Elements noRecords = doc.getElementsByClass("noRecords");

        if(allPagings.size()<1 && noRecords.size()<1) {
            response = 1;
        }

        if(allPagings.size()>0) {
            Element paging = allPagings.get(0);
            Elements lis = paging.getElementsByTag("li");
            Elements link = lis.get(lis.size()-1).getElementsByTag("a");
            response  = Integer.parseInt(link.get(0).attr("data-pagenumber"));
        }
        return response;
    }

    public static Elements getBoxes(String dom) {
        Elements boxes = new Elements();
        Document doc = Jsoup.parse(dom);
        boxes = doc.getElementsByClass("registerBoxBank");

        return boxes;
    }

    private static Element getTenderTd(Element box) {
        return box.getElementsByClass("tenderTd").get(0);
    }

    private static Element getDescriptTender(Element box) {
        return box.getElementsByClass("descriptTenderTd").get(0);
    }

    public static String getBoxTypeOrder(Element box) {
        Element tenderTd = getTenderTd(box);
        Elements lines = tenderTd.getElementsByTag("dl");
        return lines.get(0).getElementsByTag("dt").get(0).getElementsByTag("strong").text();
    }

    public static String getBoxLawOrder(Element box) {
        Element tenderTd = getTenderTd(box);
        //Elements lines = tenderTd.getElementsByTag("dl");
        //return lines.get(0).getElementsByTag("dt").get(1).getElementsByTag("span").get(1).text();
        Element spanFZ = tenderTd.select("span:matches((.*)Подача заявок(.*))").first();
        String fz = spanFZ.getElementsByClass("orange").first().text();

        if(fz.isEmpty()) {
            fz = "Get data problem!";
        }
        return fz;
    }

    public static String getBoxPriceOrder(Element box) {
        Element tenderTd = getTenderTd(box);
        Elements lines = tenderTd.getElementsByTag("dl");
        String prise = lines.get(0).getElementsByTag("dd").get(1).getElementsByTag("strong").text();

        if(!prise.isEmpty()) {
            prise = prise+" руб.";
        } else {
            prise = "Нет цены.";
        }
        return prise;
    }

    public static String getBoxIdOrder(Element box) {
        String id = null;
        Element descriptTender = getDescriptTender(box);
        Elements lines = descriptTender.getElementsByTag("dl");
        id = lines.get(0).getElementsByTag("dt").get(0).getElementsByTag("a").text().replace(" ","").replace("№","");
        return id;
    }

    public static String getBoxLinkOrder(Element box) {
        String link = null;
        Element descriptTender = getDescriptTender(box);
        Elements lines = descriptTender.getElementsByTag("dl");

        if(!lines.get(0).getElementsByTag("dt").get(0).getElementsByTag("a").attr("href").contains("http://zakupki.gov.ru")) {
            link = "http://zakupki.gov.ru"+lines.get(0).getElementsByTag("dt").get(0).getElementsByTag("a").attr("href");
        } else {
            link = lines.get(0).getElementsByTag("dt").get(0).getElementsByTag("a").attr("href");
        }

        return link;
    }

    public static String getBoxNameOrder(Element box) {
        Element descriptTender = getDescriptTender(box);
        Elements lines = descriptTender.getElementsByTag("dl");
        return lines.get(0).getElementsByTag("dd").get(1).text();
    }

    private static Element goGetInstantBox(String link) {
        Element instantBox = null;
        Client client = new Client();
        try {
            String dom = client.plainGetRequest(link).getDom();
            if(!dom.isEmpty()) {
                Document doc = Jsoup.parse(dom);

                if(doc.getElementsByClass("noticeTabBox").size() > 0) {
                    instantBox = doc.getElementsByClass("noticeTabBox").get(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.ERROR,e);
        }
        return instantBox;
    }


    public static String getBoxTradePlace(String link) {
        String response = null;

        Element instantBox = goGetInstantBox(link);
        if(instantBox == null) return "Bad page";

        Elements nameHolderTr = instantBox.select("td:matches((.*)Адрес электронной площадки(.*))");
        if(!nameHolderTr.isEmpty()) {
            response = nameHolderTr.get(0).nextElementSibling().getElementsByTag("a").attr("href");
        } else {
            response = "В бумажном виде.";
        }
        return response;
    }

    public static String getBoxStopDate(String link) {
        String response = null;
        Element instantBox = goGetInstantBox(link);

        if(instantBox == null) return "Bad page";

        Elements nameHolderTr = instantBox.select("td:matches((.*)окончания подачи|окончания срока подачи(.*))");
        if(nameHolderTr.get(0).nextElementSibling() != null) {
            if(nameHolderTr.get(0).nextElementSibling().hasText()) {
                response = nameHolderTr.get(0).nextElementSibling().text();
            } else {
                response = "Bad stop date";
            }
        } else {
            response = "Bad stop date";
        }



        return response;
    }

    //Prepare HTML mail methods

    public static String HTMLsetDate(String dom) {
        return dom.replace("Date",Defined.getSimpleMoment());
    }

    public static String HTMLsetActivity(String dom, String activity) {
        return dom.replace("Activity",activity);
    }

    public static String HTMLsetOrderds (List<Order> orders) {
        String response = "";

        for (Order order:orders) {
            String orderRow = MailTemplate.ORDER_ROW;
            orderRow = orderRow.replace("Summ",order.getOrderPrice());
            orderRow = orderRow.replace("Stop date",order.getOrderStopDate());
            orderRow = orderRow.replace("Link text","<a href=\""+order.getOrderLink()+"\">"+order.getOrderName()+"</a>");
            if(!order.getOrderTradePlace().equals("В бумажном виде.")) {
                orderRow = orderRow.replace("Trade palce","<a href=\""+order.getOrderTradePlace()+"\">Торговая площадка</a>");
            } else {
                orderRow = orderRow.replace("Trade palce",order.getOrderTradePlace());
            }
            response = response+orderRow;
        }

        return response;
    }
}
