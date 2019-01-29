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
 * Created by Nikolay Sviridenko on 15.07.2018.
 */
package com.mikadev.tools.xml;

import com.mikadev.tools.Config;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class ConfigParser {
    private final static String CONFIG_PATH = "config.xml";
    private List<Activity> activities;


    public ConfigParser() {
        this.activities = new ArrayList<>();
    }


    public Config parse() throws Exception {

        Config config = new Config();

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(CONFIG_PATH);
        Node root = document.getDocumentElement();
        NodeList activitiesNode = root.getFirstChild().getNextSibling().getChildNodes();

        for(int i =0; i<activitiesNode.getLength(); i++) {
            Node node = activitiesNode.item(i);
            if(node.getNodeType() != Node.TEXT_NODE ) {
                //New activity
                Activity activity = new Activity();
                //Set type of activity
                activity.setType(node.getAttributes().getNamedItem("type").getNodeValue());
                //Get internal nodes

                NodeList insideActivity = node.getChildNodes();

                for(int m = 0; m<insideActivity.getLength(); m++) {
                    Node insideActivityNode = insideActivity.item(m);

                    //Find district node
                    if(insideActivityNode.getNodeType() != Node.TEXT_NODE && insideActivityNode.getNodeName().equals("District")) {
                        //Set region
                        String region = insideActivityNode.getFirstChild().getNextSibling().getTextContent();
                        activity.setWholeRegion(region.equals("1"));

                        //Find and set cities

                        NodeList citiesNodes = insideActivityNode.getLastChild().getPreviousSibling().getChildNodes();
                        List<String> cities = new ArrayList<>();

                        for(int f= 0; f < citiesNodes.getLength(); f++) {
                            if(citiesNodes.item(f).getNodeType() !=Node.TEXT_NODE) {
                                Node cityNode = citiesNodes.item(f);
                                cities.add(cityNode.getTextContent());
                            }
                        }

                        activity.setCities(cities);

                    }

                    //Find keywords node

                    if(insideActivityNode.getNodeType() != Node.TEXT_NODE && insideActivityNode.getNodeName().equals("Keywords")) {
                        NodeList keysNode = insideActivityNode.getChildNodes();
                            List<String> keys = new ArrayList<>();

                            for(int g = 0; g< keysNode.getLength(); g++ ) {
                                if(keysNode.item(g).getNodeType() == Node.TEXT_NODE) continue;
                                keys.add(keysNode.item(g).getTextContent());
                            }

                            activity.setKeywords(keys);
                    }

                    //Find emails node
                    if(insideActivityNode.getNodeType() != Node.TEXT_NODE && insideActivityNode.getNodeName().equals("Emails")) {
                        NodeList emailsNode = insideActivityNode.getChildNodes();
                        List<String> emails = new ArrayList<>();

                        for(int h = 0; h< emailsNode.getLength(); h++ ) {
                            if(emailsNode.item(h).getNodeType() == Node.TEXT_NODE) continue;
                            emails.add(emailsNode.item(h).getTextContent());
                        }

                        activity.setEmails(emails);
                    }

                    //Find OTC market params and set it
                    if(insideActivityNode.getNodeType() != Node.TEXT_NODE && insideActivityNode.getNodeName().equals("OtcParams") ) {
                        NodeList otcParamsNode = insideActivityNode.getChildNodes();
                        for(int j = 0; j< otcParamsNode.getLength(); j++ ) {
                            if(otcParamsNode.item(j).getNodeType() != Node.TEXT_NODE && otcParamsNode.item(j).getNodeName().equals("OtcUser")) {
                                activity.setOtcUser(otcParamsNode.item(j).getFirstChild().getTextContent());
                            }

                            if(otcParamsNode.item(j).getNodeType() != Node.TEXT_NODE && otcParamsNode.item(j).getNodeName().equals("OtcPassword")) {
                                activity.setOtcPassword(otcParamsNode.item(j).getFirstChild().getTextContent());
                            }

                        }
                    }
                }

                //Find telegram node and set it
                activity.setTelegramBot(node.getLastChild().getPreviousSibling().getTextContent().equals("1"));

                //Put activity to activities list
                activities.add(activity);
            }
        }
        config.setActivities(activities);

        return config;
    }
}
