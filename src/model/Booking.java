package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private String bookingId;
    private Date bookingDate;
    private Date startDate;
    private Date endDate;
    private String customerId;
    private String serviceId;

    public Booking(String bookingId, Date bookingDate, Date startDate, Date endDate, String customerId, String serviceId) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| %-10s | %-15s | %-15s | %-15s | %-12s | %-12s |",
                bookingId, date.format(bookingDate), date.format(startDate), date.format(endDate), customerId, serviceId);
    }

}
