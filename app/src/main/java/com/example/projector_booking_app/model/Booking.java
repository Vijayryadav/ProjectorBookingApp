package com.example.projector_booking_app.model;

public class Booking {
    String bookingTime, userUid, bookingUid, ProjectorUid, bookingDate;
    public Booking(){

    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getBookingUid() {
        return bookingUid;
    }

    public void setBookingUid(String bookingUid) {
        this.bookingUid = bookingUid;
    }

    public String getProjectorUid() {
        return ProjectorUid;
    }

    public void setProjectorUid(String projectorUid) {
        this.ProjectorUid = projectorUid;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
