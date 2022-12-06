package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.CardPayment;
import za.online.dao.CardPaymentDAO;
import za.online.db.ConnectToBD;

public class CardPaymentDAOImpl implements CardPaymentDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public CardPaymentDAOImpl() {
        con = ConnectToBD.getConnection();
    }

    @Override
    public boolean removeCard(CardPayment cardPayment) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from card where cardSecurityCode = ? and cardNumber = ?");
                ps.setInt(1, cardPayment.getCardSecurityCode());
                ps.setInt(2, cardPayment.getCardNumber());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To delete card:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public CardPayment addCard(CardPayment cardPayment) {
        if (con != null) {
            try {
                ps = con.prepareStatement("insert into card(customerId,cardNumber,cvv,expDate,bankName) values(?,?,?,?,?) ");
                ps.setInt(1, cardPayment.getCustomerId());
                ps.setInt(2, cardPayment.getCardNumber());
                ps.setInt(3, cardPayment.getCardSecurityCode());
                ps.setInt(4, cardPayment.getCardExpeiryDate());
                ps.setString(5, cardPayment.getBankName());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed To Add Card :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }

        return cardPayment;
    }

    @Override
    public List<CardPayment> getAllCustomerCards(int customerId) {
        List<CardPayment> cards = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("select * from card where customerId = ?");
                ps.setInt(1, customerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    CardPayment cardPayment = new CardPayment();
                    cardPayment.setCustomerId(rs.getInt("customerId"));
                    cardPayment.setCardSecurityCode(rs.getInt("cvv"));
                    cardPayment.setCardNumber(rs.getInt("cardNumber"));
                    cardPayment.setBankName(rs.getString("bankName"));
                    cardPayment.setCardExpeiryDate(rs.getInt("expDate"));
                    cardPayment.setPayId(rs.getInt("payId"));
                    cards.add(cardPayment);
                }
            } catch (Exception e) {
            } finally {
                closeIfNotNull();
            }
        }
        return cards;
    }

    @Override
    public List<CardPayment> getAllCards() {
        List<CardPayment> cards = new ArrayList<>();
        CardPayment cardPayment = new CardPayment();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from card");
                rs = ps.executeQuery();
                while (rs.next()) {
                    cardPayment.setCustomerId(rs.getInt("customerId"));
                    cardPayment.setCardSecurityCode(rs.getInt("cardSecurityCode"));
                    cardPayment.setCardNumber(rs.getInt("cardNumber"));
                    cardPayment.setBankName(rs.getString("bankName"));
                    cardPayment.setCardExpeiryDate(rs.getInt("cardExpeiryDate"));
                    cards.add(cardPayment);
                }
            } catch (SQLException e) {
                System.out.println("Failed To Get All Cards :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return cards;
    }

    @Override
    public CardPayment getOneCards(int payId) {
        CardPayment cardPayment = null;
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from card where payId = ?");
                ps.setInt(1, payId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cardPayment = new CardPayment();
                    cardPayment.setCustomerId(rs.getInt("customerId"));
                    cardPayment.setPayId(rs.getInt("payId"));
                    cardPayment.setCardSecurityCode(rs.getInt("cvv"));
                    cardPayment.setCardNumber(rs.getInt("cardNumber"));
                    cardPayment.setBankName(rs.getString("bankName"));
                    cardPayment.setCardExpeiryDate(rs.getInt("expDate"));
                }
            } catch (Exception e) {
            } finally {
                closeIfNotNull();
            }
        }
        return cardPayment;
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

    @Override
    public boolean removeAllCards() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate table payment");
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed To Delete All Payments");
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public CardPayment getLastInsertedCard(int customerId) {
        CardPayment cardPayment = null;
        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT * from card where customerId=? ORDER BY payId DESC Limit 1");
                ps.setInt(1, customerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cardPayment = new CardPayment();
                    cardPayment.setCustomerId(rs.getInt("customerId"));
                    cardPayment.setCardSecurityCode(rs.getInt("cvv"));
                    cardPayment.setCardNumber(rs.getInt("cardNumber"));
                    cardPayment.setBankName(rs.getString("bankName"));
                    cardPayment.setCardExpeiryDate(rs.getInt("expDate"));
                }
            } catch (Exception e) {
            } finally {
                closeIfNotNull();
            }
        }
        return cardPayment;

    }

}
