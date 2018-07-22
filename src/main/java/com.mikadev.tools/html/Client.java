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
 * Created by Nikolay Sviridenko on 14.07.2018.
 */
package com.mikadev.tools.html;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    public static  final Logger logger = LogManager.getLogger(Client.class);

    private List<String> proxies;

    public Client() {
        init();
    }

    private void init() {

    }

    public void setProxies(List<String> list) {
        this.proxies = list;
    }

    public Response plainGetRequest(String url) throws Exception {
        Boolean keepTrying = true;
        Response data = new Response();
        int tryNum = 0;

        while(keepTrying) {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            tryNum++;

            try {
                String rawStatus = response.getStatusLine().toString();
                String status = parseServerStatus(rawStatus);

                switch (status) {
                    case "OK": keepTrying = false;
                    break;
                    case "WHAIT" :
                        if(tryNum == 1) {
                            logger.log(Level.INFO,"Server problem at 1 time. Will whait 1 minute. Server code: "+rawStatus);
                            Thread.sleep(60000);
                        }

                        if(tryNum == 2) {
                            logger.log(Level.INFO,"Server problem at 2 time. Will whait 5 minute. Server code: "+rawStatus);
                            Thread.sleep(300000);
                        }

                        if(tryNum == 3) {
                            logger.log(Level.INFO,"Server problem at 3 time. Will whait 10 minute. Server code: "+rawStatus );
                            Thread.sleep(600000);
                        }

                        if(tryNum == 4) {
                            logger.log(Level.INFO,"Server problem at 4 time. Will terminate. Server code: "+rawStatus);
                            logger.log(Level.ERROR,"Server problem. Terminate. Server code: "+rawStatus);
                            java.lang.System.exit(0);

                        }
                        break;
                    case "DROP" :
                        logger.log(Level.ERROR,"Unknown problem. Terminate. Server code: "+rawStatus);
                        java.lang.System.exit(0);
                        break;
                    case "BAD_PARSE_CODE" :
                        logger.log(Level.ERROR,"Parse server code error. Terminate. Server code: "+rawStatus);
                        java.lang.System.exit(0);
                        break;


                }

                HttpEntity html = response.getEntity();
                data.setStatus(rawStatus);
                data.setDom(EntityUtils.toString(html));
                EntityUtils.consume(html);
            } catch (Exception e) {
                logger.log(Level.ERROR, e);
                throw new Exception(e);
            }finally {
                response.close();
            }
        }

        return  data;
    }

    public Response singleProxyPlainGetRequest(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);

        if(proxies.size()<1) {
            throw new Exception("Empty proxies list.");
        }

        String[] rawProxy = proxies.get(0).split(":",2);
        HttpHost proxy = new HttpHost(rawProxy[0], Integer.parseInt(rawProxy[1]));
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setRoutePlanner(routePlanner)
                .build();

        CloseableHttpResponse response = httpclient.execute(httpGet);
        Response data = new Response();

        try {
            data.setStatus(response.getStatusLine().toString());
            HttpEntity html = response.getEntity();
            data.setDom(EntityUtils.toString(html));
            EntityUtils.consume(html);
        } finally {
            response.close();
        }

        return  data;

    }

    private String parseServerStatus(String code) {
        String response = null;

        String pattern = "\\d{3}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(code);

        if(m.find()) {
            switch (m.group().substring(0,1)) {
                case "2": response = "OK";
                break;
                case  "3": response = "DROP";
                break;
                case  "4": response = "WHAIT";
                break;
                case "5": response = "WHAIT";
                break;
            }

        } else {
            response = "BAD_PARSE_CODE";
        }
        return response;
    }
}
