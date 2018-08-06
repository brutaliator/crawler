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
 * Created by Nikolay Sviridenko on 17.07.2018.
 */
package com.mikadev.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Defined {
    public static final String  DB_URL = "jdbc:h2:file:./db;AUTO_SERVER=TRUE;MV_STORE=FALSE;MVCC=FALSE";

    public static String getSimpleMoment() {
        String out = "";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        out = format.format(date);
        return out;
    }
}
