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
package com.mikadev.tools;

import com.mikadev.tools.database.Create;
import com.mikadev.tools.database.DbOperations;
import com.mikadev.tools.domparse.Parser;
import com.mikadev.tools.html.Client;
import com.mikadev.tools.html.OtcMarketClient;
import com.mikadev.tools.html.Response;
import com.mikadev.tools.tbot.Bot;
import com.mikadev.tools.xml.Activity;
import com.mikadev.tools.xml.ConfigParser;
import org.apache.http.Header;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Crawler {
    public static  final Logger logger = LogManager.getLogger(Crawler.class);
    private static Bot bot;

    public static void main(String[] args) {

        //Tests

        Response response = new Response();
        OtcMarketClient client = new OtcMarketClient();

        Header[] headers = new Header[1];
        headers[0] = new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134");
        //headers[1] = new BasicHeader("Cookie","appLoginPage=; _ga=GA1.3.705115408.1547565963; _gid=GA1.3.841434482.1547565963; gaVisitorUuid=251b4f0d-4bb7-42c2-8cf6-58f941ba097e; __exponea_etc__=9addd26f-23a8-46c1-a89f-c8ca29644fcd; __exponea_time2__=-33.865031242370605; _pk_ses..3606=*; uechat_39545_pages_count=1; uechat_39545_first_time=1547565964936; _ym_uid=1547565961558443275; _ym_d=1547565961; _ym_visorc_18136627=w; _ym_isad=2; _ga=GA1.2.705115408.1547565963; _gid=GA1.2.841434482.1547565963; _fbp=fb.1.1547565964292.499038542");
        try {

            ConfigParser configParser = new ConfigParser();
            Config config = configParser.parse();

            /*URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("www.httpbin.org")
                    .setPath("/get")
                    .setParameter("Mika" ,"Bibika")
                    .setParameter("ctl00$MainContent$txtUserName" ,"MaminHuy")
                    .build();*/

            response = client.safeRequest(false, headers ,"http://httpbin.org/status/300", null);
            System.out.println(response.getDom());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //End tests

        logger.log(Level.INFO,"Start crawl.");
        bot = new Bot();
        try {
            //init();
        } catch (Exception e) {
            bot.sentData("Running error. Check log.");
            logger.error("Trace: ",e);
            e.printStackTrace();
        }
    }

    private static void init() throws Exception {
        File configFile = new File(System.getProperty("user.dir")+File.separator+"config.xml");
        if(!configFile.exists()) {
            throw new Exception("config.xml not found in the root directory.");
        }

        File dbFile = new File("db.h2.db");
        if(!dbFile.exists()) {
            Create.newDbCreate();
        }

        //Check if OTC cookies table is exist in DB
        DbOperations dbOperations = new DbOperations();

        if(!DbOperations.checkOtcCookiesTable()) {
            Create.createCookieTable();
        }


        ConfigParser configParser = new ConfigParser();
        Config config = configParser.parse();

        Logic logic = new Logic(config);
        //DbOperations.removeAllTenders();
        logic.run();

}
}
