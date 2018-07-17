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
package com.mikadev.tools.database;

import com.mikadev.tools.Defined;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    public Create() {
    }

    public static void newDbCreate() throws Exception {
        Class.forName("org.h2.Driver");
        DriverManager.getConnection(Defined.DB_URL);
        createTables();
    }

    public static void createTables(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(Defined.DB_URL);
            statement = connection.createStatement();

            String purchaseTableCreateQuery = "CREATE TABLE `purchases`( `id` INT(11) NOT NULL AUTO_INCREMENT, " +
                    "`activity` VARCHAR(50) NOT NULL, " +
                    "`purchaseId` BIGINT NOT NULL, " +
                    "`date` TIMESTAMP WITH TIMEZONE NOT NULL, " +
                    "PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=UTF8";

            statement.executeUpdate(purchaseTableCreateQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { connection.close(); } catch(SQLException se) {se.printStackTrace();}
            try { statement.close(); } catch(SQLException se) { se.printStackTrace();}
        }
    }
}
