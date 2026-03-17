package DesignPatterns.SOLID_Pattern.One_SingleResponsibilityPrinciple;

public class SaveToDataBase {
    public void saveToDB(Invoice invoice) {
        System.out.println("Saving to DB for invoice: " + invoice.getId());
    }
}
