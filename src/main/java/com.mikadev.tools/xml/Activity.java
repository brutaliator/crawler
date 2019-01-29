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

import java.util.List;

public class Activity {
        private String type;
        private Boolean wholeRegion;
        private List<String> cities;
        private List<String> keywords;
        private List<String> emails;
        private String otcUser;
        private String otcPassword;
        private Boolean telegramBot;

    public Activity() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getWholeRegion() {
        return wholeRegion;
    }

    public void setWholeRegion(Boolean wholeRegion) {
        this.wholeRegion = wholeRegion;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Boolean getTelegramBot() {
        return telegramBot;
    }

    public void setTelegramBot(Boolean telegramBot) {
        this.telegramBot = telegramBot;
    }

    public String getOtcUser() {
        return otcUser;
    }

    public void setOtcUser(String otcUser) {
        this.otcUser = otcUser;
    }

    public String getOtcPassword() {
        return otcPassword;
    }

    public void setOtcPassword(String otcPassword) {
        this.otcPassword = otcPassword;
    }
}
