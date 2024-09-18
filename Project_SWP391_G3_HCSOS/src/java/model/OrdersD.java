/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


    public class OrdersD {
    private int orderID;
    private int customerID;
    private int shipperID;
    private String orderDate;
    private String shippedDate;
    private double shippingTotal;
    private String shipAddress;
    private int status;

    // Default constructor
    public OrdersD() {
    }

    // Constructor without orderID
    public OrdersD(int customerID, int shipperID, String orderDate, String shippedDate, double shippingTotal, String shipAddress, int status) {
        this.customerID = customerID;
        this.shipperID = shipperID;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shippingTotal = shippingTotal;
        this.shipAddress = shipAddress;
        this.status = status;
    }

    
     public OrdersD(int orderID,int customerID, int shipperID, String orderDate, String shippedDate, double shippingTotal, String shipAddress, int status) {
        this .orderID = orderID;
         this.customerID = customerID;
        this.shipperID = shipperID;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shippingTotal = shippingTotal;
        this.shipAddress = shipAddress;
        this.status = status;
    }
//    // Constructor with orderID
//   // Private constructor to enforce the use of the Builder
//    private OrdersD(Builder builder) {
//        this.orderID = builder.orderID;
//        this.customerID = builder.customerID;
//        this.shipperID = builder.shipperID;
//        this.orderDate = builder.orderDate;
//        this.shippedDate = builder.shippedDate;
//        this.shippingTotal = builder.shippingTotal;
//        this.shipAddress = builder.shipAddress;
//        this.status = builder.status;
//    }
//
//    // Static inner Builder class
//    public static class Builder {
//        private int orderID;
//        private int customerID;
//        private int shipperID;
//        private String orderDate;
//        private String shippedDate;
//        private double shippingTotal;
//        private String shipAddress;
//        private int status;
//
//        public Builder setOrderID(int orderID) {
//            this.orderID = orderID;
//            return this;
//        }
//
//        public Builder setCustomerID(int customerID) {
//            this.customerID = customerID;
//            return this;
//        }
//
//        public Builder setShipperID(int shipperID) {
//            this.shipperID = shipperID;
//            return this;
//        }
//
//        public Builder setOrderDate(String orderDate) {
//            this.orderDate = orderDate;
//            return this;
//        }
//
//        public Builder setShippedDate(String shippedDate) {
//            this.shippedDate = shippedDate;
//            return this;
//        }
//
//        public Builder setShippingTotal(double shippingTotal) {
//            this.shippingTotal = shippingTotal;
//            return this;
//        }
//
//        public Builder setShipAddress(String shipAddress) {
//            this.shipAddress = shipAddress;
//            return this;
//        }
//
//        public Builder setStatus(int status) {
//            this.status = status;
//            return this;
//        }
//
//        public OrdersD build() {
//            return new OrdersD(this);
//        }
//    }
//
//   


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public double getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(double shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
