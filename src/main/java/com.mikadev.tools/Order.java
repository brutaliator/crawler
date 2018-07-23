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
 * Created by Nikolay Sviridenko on 23.07.2018.
 */
package com.mikadev.tools;

public class Order {
    private String orderId;
    private String orderName;
    private String orderLink;
    private String orderType;
    private String orderLaw;
    private String orderPrice;
    private String orderStopDate;
    private String orderTradePlace;

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderLink() {
        return orderLink;
    }

    public void setOrderLink(String orderLink) {
        this.orderLink = orderLink;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderLaw() {
        return orderLaw;
    }

    public void setOrderLaw(String orderLaw) {
        this.orderLaw = orderLaw;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStopDate() {
        return orderStopDate;
    }

    public void setOrderStopDate(String orderStopDate) {
        this.orderStopDate = orderStopDate;
    }

    public String getOrderTradePlace() {
        return orderTradePlace;
    }

    public void setOrderTradePlace(String orderTradePlace) {
        this.orderTradePlace = orderTradePlace;
    }
}
