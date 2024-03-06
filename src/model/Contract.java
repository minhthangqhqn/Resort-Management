package model;

public class Contract {
    private String contractId;
    private String bookingId;
    private double prePayment;
    private double totalAmount;

    public Contract(String contractId, String bookingId, double prePayment, double totalAmount) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.prePayment = prePayment;
        this.totalAmount = totalAmount;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getPrePayment() {
        return prePayment;
    }

    public void setPrePayment(double prePayment) {
        this.prePayment = prePayment;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-12s | %-15s | %-15s |", contractId, bookingId, prePayment, totalAmount);
    }
}
