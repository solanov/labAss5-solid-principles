package invoice;

public class PdfInvoiceGenerator implements InvoiceGenerator {
    @Override
    public void generateInvoice(String fileName) {
        System.out.println("PDF Invoice generated: " + fileName);
    }
}