package za.online.service;

import java.util.List;
import za.online.bean.Invoice;
import za.online.bean.Order;

public interface InvoiceService {

    public Invoice createInvoice(int orderId);

    public boolean deleteInvoice(int orderId);

    public Invoice viewOneInvoice(int orderId);

    public List<Invoice> viewAllInvoices();

}
