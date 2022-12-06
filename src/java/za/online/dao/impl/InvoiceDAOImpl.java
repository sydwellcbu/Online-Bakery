package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Invoice;
import za.online.bean.Order;
import za.online.dao.InvoiseDAO;
import za.online.db.ConnectToBD;

public class InvoiceDAOImpl implements InvoiseDAO {

    Order order = new Order();
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    Invoice invoice;

    public InvoiceDAOImpl() {
        con = ConnectToBD.getConnection();
    }

    @Override
    public Invoice createInvoice(int orderId) {

        if (con != null) {
            try {
                ps = con.prepareStatement("Insert into invoice(invoiceId,orderId)  values(null,?)");
                ps.setInt(1, orderId);

                if (ps.executeUpdate() > 0) {
                    ps.close();
                    ps = con.prepareStatement("SELECT invoiceId,orderId from invoice ORDER BY invoiceId DESC Limit 1");
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        invoice = new Invoice();
                        invoice.setInvoiceId(rs.getInt(1));
                        invoice.setOrderId(rs.getInt("orderId"));
                    }
                 
                }
            } catch (SQLException ex) {
                System.out.println("Failed to create Invoice :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return invoice;
    }

    @Override
    public boolean deleteInvoice(int invoiceId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from invoice where invoiceId = ?");
                ps.setInt(1, invoiceId);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed To Delete invoice From Invoice Table");
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public Invoice viewOneInvoice(int invoiceId) {
        if (con != null) {
            try {
                ps = con.prepareStatement("Select * from invoice where invoiceId  = ?");
                ps.setInt(1, invoiceId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    invoice = new Invoice();
                    invoice.setInvoiceId(rs.getInt("invoiceId"));
                    invoice.setOrderId(rs.getInt("orderId"));
                }
            } catch (Exception e) {
            }
        }
        return invoice;
    }

    @Override
    public List<Invoice> viewAllInvoices() {
        List<Invoice> invoiceList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("Select * from invoice");
                rs = ps.executeQuery();
                while (rs.next()) {
                    invoice = new Invoice();
                    invoice.setInvoiceId(rs.getInt("invoiceId"));
                    invoice.setOrderId(rs.getInt("orderId"));
                    invoiceList.add(invoice);
                }
            } catch (Exception e) {
            }
        }
        return invoiceList;
    }

    private void closeIfNotNull() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Prepared Statement :" + ex.getMessage());
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Results Set :" + ex.getMessage());
            }
        }
    }

    public Invoice getLastId() {

        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT invoiceId,orderId from invoice ORDER BY invoiceId DESC Limit 1");
                rs = ps.executeQuery();
                if (rs.next()) {
                    invoice = new Invoice();
                    invoice.setInvoiceId(rs.getInt(1));
                    invoice.setOrderId(rs.getInt("orderId"));
                }

            } catch (SQLException ex) {
                System.out.println("Failed to SelectMax invoiceid :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return invoice;
    }

    @Override
    public boolean deleteAllInvoices() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate Table invoice");
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed To Delete All Invoices From Invoice Table");
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

}
