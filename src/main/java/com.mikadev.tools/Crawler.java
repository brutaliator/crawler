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

import com.mikadev.tools.html.Client;
import com.mikadev.tools.html.Response;

public class Crawler {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            Response response = client.plainGetRequest("https://www.google.ru");
            System.out.println(response.getStatus());
            System.out.println(response.getDom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
