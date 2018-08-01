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
 * Created by Nikolay Sviridenko on 27.07.2018.
 */
package com.mikadev.tools.database;

import com.mikadev.tools.Defined;
import org.h2.message.DbException;

import java.math.BigInteger;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DbOperations {

    public static void addTender(String activity, String tenderId) throws Exception {
        Connection con = null;
        Statement  statement = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            con = DriverManager.getConnection(Defined.DB_URL);
            statement = con.createStatement();
            String insert = "INSERT INTO purchases (`activity`, `purchaseId`, `date` ) VALUES ('"+activity+"','"+new BigInteger(tenderId)+"','"+timestamp.toString()+"',)";
            statement.executeUpdate(insert);
        } catch (SQLException e) {
            throw new Exception(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new Exception(e.toString());
            }

            if (con!=null) try {con.close();}catch (Exception ignore) {}
        }

    }

    public static boolean checkTender(String tenderId) throws Exception {
        Boolean isExist = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DriverManager.getConnection(Defined.DB_URL);
            preparedStatement = con.prepareStatement("SELECT id FROM purchases WHERE purchaseId = ?");
            preparedStatement.setString(1,tenderId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            throw new Exception(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new Exception(e.toString());
            }

            if (con!=null) try {con.close();}catch (Exception ignore) {}
        }
        return isExist;
    }
}
