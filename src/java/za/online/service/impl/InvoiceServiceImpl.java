package za.online.service.impl;

import java.util.List;
import za.online.bean.Invoice;
import za.online.bean.Order;
import za.online.dao.InvoiseDAO;
import za.online.dao.impl.InvoiceDAOImpl;
import za.online.service.InvoiceService;

public class InvoiceServiceImpl implements InvoiceService {

    InvoiseDAO invoiceDAO;

    public InvoiceServiceImpl() {
        this.invoiceDAO = new InvoiceDAOImpl();
    }

    @Override
    public Invoice createInvoice(int orderId) {
        if (orderId <= 0) {
            return null;
        }
        return invoiceDAO.createInvoice(orderId);
    }

    @Override
    public boolean deleteInvoice(int orderId) {
        return (orderId < 0) ? false : invoiceDAO.deleteInvoice(orderId);
    }

    @Override
    public Invoice viewOneInvoice(int orderId) {
        return (orderId < 0) ? null : invoiceDAO.viewOneInvoice(orderId);
    }

    @Override
    public List<Invoice> viewAllInvoices() {
        return invoiceDAO.viewAllInvoices();
    }

   

}
