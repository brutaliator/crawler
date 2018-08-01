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
import com.mikadev.tools.xml.ConfigParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

import java.io.File;

public class Crawler {
    public static  final Logger logger = LogManager.getLogger(Crawler.class);

    public static void main(String[] args) {
        /*Client client = new Client();
        try {
            Response response = client.plainGetRequest("https://www.google.ru");
            System.out.println(response.getStatus());
            System.out.println(response.getDom());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() throws Exception {logger.log(Level.ERROR,"UUUHBLYA ");
        File configFile = new File("config.xml");
        if(!configFile.exists()) {
            throw new Exception("config.xml not found in the root directory.");
        }

        File dbFile = new File("db.h2.db");
        if(!dbFile.exists()) {
            Create.newDbCreate();
        }

        ConfigParser configParser = new ConfigParser();
        Config config = configParser.parse();
        //Logic logic = new Logic(config);
        //logic.run();
        Email email = EmailBuilder.startingBlank()
                .from("mika", "mika@mikadev.com")
                .to("you", "test@allaboutspam.com")
                .withSubject("hey")
                .withPlainText("HOOPS its working!)")
                .buildEmail();

                 MailerBuilder
                .withSMTPServer("localhost", 25)
                //.withTransportStrategy(TransportStrategy.SMTP_TLS)
                         //.trustingAllHosts(true)
                         //.trustingSSLHosts("localhost")
                .buildMailer()
                .sendMail(email);

        //String sslTrust = myMailer.getSession().getProperty("mail.smtp.ssl.trust");
        //System.out.println(sslTrust);


        /*String orederName = "на поставку бумаги для офисной техники для обеспечения районных судов г. Самара и г. Тольятти, районных и городских судов Самарской области, Самарского гарнизонного военного суда";
        List<String> keyWords = new ArrayList<String>();
        keyWords.add("хуй");
        keyWords.add("vrul");
        keyWords.add("бум");
        //keyWords.add("толь");

        System.out.println(logic.checkWordsContains(keyWords,orederName));
        //logic.run();
        //DbOperations.addTender("ac","3454534534");
        //System.out.println(DbOperations.checkTender("3454534534"));





        /*Client client = new Client();
        Response response = client.plainGetRequest("http://zakupki.gov.ru/epz/order/extendedsearch/results.html?searchString=&morphology=on&pageNumber=1&sortDirection=false&recordsPerPage=_50&showLotsInfoHidden=true&fz44=on&fz223=on&ppRf615=on&fz94=on&selectedSubjects=&af=true&priceFromGeneral=&priceToGeneral=&priceFromGWS=&priceToGWS=&priceFromUnitGWS=&priceToUnitGWS=&currencyIdGeneral=-1&regions=5277374&regionDeleted=false&sortBy=UPDATE_DATE&openMode=USE_DEFAULT_PARAMS");
        //Response responseDM = client.plainGetRequest("http://zakupki.gov.ru/epz/order/extendedsearch/results.html?morphology=on&pageNumber=1&sortDirection=false&recordsPerPage=_100&showLotsInfoHidden=false&fz44=on&af=true&currencyIdGeneral=-1&regionDeleted=false&deliveryAddress=%D0%94%D0%B8%D0%BC%D0%B8%D1%82%D1%80%D0%BE%D0%B2%D0%B3%D1%80%D0%B0%D0%B4&sortBy=UPDATE_DATE&openMode=USE_DEFAULT_PARAMS");
        //Response responseNR = client.plainGetRequest("http://zakupki.gov.ru/epz/order/extendedsearch/results.html?searchString=sdfg&morphology=on&pageNumber=1&sortDirection=false&recordsPerPage=_100&showLotsInfoHidden=true&fz44=on&fz223=on&ppRf615=on&fz94=on&af=true&currencyIdGeneral=-1&regions=5277374&regionDeleted=false&sortBy=UPDATE_DATE&openMode=USE_DEFAULT_PARAMS");
        //Response responseTen = client.plainGetRequest("http://zakupki.gov.ru/epz/order/extendedsearch/results.html?morphology=on&pageNumber=1&sortDirection=false&recordsPerPage=_10&showLotsInfoHidden=true&fz44=on&fz223=on&ppRf615=on&fz94=on&af=true&currencyIdGeneral=-1&regions=5277374&regionDeleted=false&sortBy=UPDATE_DATE&openMode=USE_DEFAULT_PARAMS");
        //Response response223FZ = client.plainGetRequest("http://zakupki.gov.ru/epz/order/extendedsearch/results.html?morphology=on&openMode=USE_DEFAULT_PARAMS&pageNumber=1&sortDirection=false&recordsPerPage=_50&showLotsInfoHidden=false&fz223=on&af=on&currencyIdGeneral=-1&regionDeleted=false&deliveryAddress=%D0%94%D0%B8%D0%BC%D0%B8%D1%82%D1%80%D0%BE%D0%B2%D0%B3%D1%80%D0%B0%D0%B4&sortBy=UPDATE_DATE");
        for (Element box: Parser.getBoxes(response.getDom())) {
            //String type = Parser.getBoxTypeOrder(box);
            //System.out.println(type);
            //System.out.println(Parser.getBoxLawOrder(box));
            //System.out.println(Parser.getBoxPriceOrder(box));
            //System.out.println(Parser.getBoxIdOrder(box));
            //System.out.println(Parser.getBoxLinkOrder(box));
            //System.out.println(Parser.getBoxNameOrder(box));
            //System.out.println(Parser.getBoxTradePlace(Parser.getBoxLinkOrder(box)));
            System.out.println(Parser.getBoxStopDate(Parser.getBoxLinkOrder(box)));
            //System.out.println("-------");
        }
*/
}
}
