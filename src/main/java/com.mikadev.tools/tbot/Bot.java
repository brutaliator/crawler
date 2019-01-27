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
 * Created by Nikolay Sviridenko on 06.08.2018.
 */
package com.mikadev.tools.tbot;

import com.mikadev.tools.html.Client;
import com.mikadev.tools.html.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Bot {
    public static final String KEY = "bot680912472:AAHjwQqBijYQVqW0V3LluX8bBBni7uT9iyg";
    public static String mainLink = "https://api.telegram.org/"+KEY+"/";
    public Bot() {

    }

    public void sentData(String data) {
        Client client = new Client();
        String link = mainLink+"sendMessage?&parse_mode=Markdown&chat_id=-296215351&text=";
        try {
            data = URLEncoder.encode(data ,"UTF-8");
            link = link+data;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //link = link.replace(" ","%20");
        System.out.println(link);

        try {
            Response response = client.simplyRequest(link);
            System.out.println(response.getStatus());
            System.out.println(response.getDom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
