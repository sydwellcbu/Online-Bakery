package za.online.email;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import za.online.bean.Customer;
import za.online.bean.Order;
import za.online.bean.OrderLineItem;

public class Email {

    //"C:\\temp\\syd.pdf"
    //"sydwellcbu7@gmail.com"
    public void sendEmeail(String email, String path,List<OrderLineItem> mycart,Customer customer,Order order) {
        // Recipient's email ID needs to be mentioned.
        String to = email;
        // Sender's email ID needs to be mentioned
        String from = "sydwellcbu7@gmail.com";
        // Assuming you are sending email from through gmails smtp
        final String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "epehvpkashlysfzj");  //special GMAIL generated password for your email account
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Order details confirmation");
            // Now set the actual message
            message.setText("Hello Syddie ---- I have it working.");
            // ----------------------------------------------
            //This is to send an attachemnet --
            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();
            
            
//ORDER CONFIRMATION
//Hi Sydwell sibusiso ,
//Thanks for ordering! Confirmation of your order is shown below.
//Order Reference Number: Sydwell4261022

            try {
                String recipe = "";
                 for(OrderLineItem cart : mycart){
                recipe =recipe+ (String.valueOf(cart.getQuantity())+"x"+cart.getProductName()+"                             "+String.valueOf(cart.getProductPrice())+"\n\n");
                
                 }
                
                File f = new File("C:\\temp\\syd.pdf");
               attachmentPart.attachFile(f);
           
                  textPart.setText("ORDER CONFIRMATION \n\n"
                                   +"Delivery Address :"+customer.getAddress()+"\n\n"
                                   +"Hi "+customer.getFirstName()+" "+customer.getLastName()+",\n\n"
                                   +"Thanks for ordering! Confirmation of your order is shown below. \n\n\n"
                                   +"Order Reference Number: "+order.getOrderId()+"\n\n\n"
                                   + "YOU'VE ORDERED \n\n\n "+recipe);
            
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);
            } catch (IOException e) {
                e.printStackTrace();
            }
            message.setContent(multipart);
            // ----------------------------------------------
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
