
package za.online.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.online.bean.Order;
import za.online.dao.impl.OrderDAOImpl;
import za.online.service.OrderService;
import za.online.service.impl.OrderServiceImpl;


@WebServlet(name = "OrdersAdmin", urlPatterns = {"/OrdersAdmin"})
public class OrdersAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        try (PrintWriter out = response.getWriter()) {

            OrderService order = new OrderServiceImpl();
            HttpSession session = request.getSession();
            List<Order> allOrders  = new ArrayList<>(); 
            OrderDAOImpl ord = new OrderDAOImpl();
            String action = request.getParameter("action");
            
         
//         if ( action.equalsIgnoreCase("all")) {
//               allOrders =  order.getAllOrders();
//               session.setAttribute("orderUsers", allOrders);
//               response.sendRedirect("orderDashbord.jsp");
//           if(action.equalsIgnoreCase("date")){
//           allOrders =  ord.ordersByDate();
//           session.setAttribute("orderUsers", allOrders);
//           response.sendRedirect("orderDashbord.jsp");
//            }
//          
//         }
//        
//           else if (action.equalsIgnoreCase("pending") ) {
//                allOrders =  order.pendingOrders();
//              
//                session.setAttribute("orderUsers", allOrders);
//                response.sendRedirect("orderDashbord.jsp");
//           
//            }
//         
//            if (action.equalsIgnoreCase("complete")) {
//               allOrders = order.completedOrders();
//                session.setAttribute("orderUsers", allOrders);
//                response.sendRedirect("orderDashbord.jsp");
//            } 
//           
//            else{
//            
//            
//                 int id = Integer.parseInt(request.getParameter("id")); 
//                  order.deleteAnOrders(id);
//                   response.sendRedirect("orderDashbord.jsp"); 
//            }
//          

                    
                    
            
        

                    switch (action) {
                case "pending":
                allOrders =  order.pendingOrders();
              
                session.setAttribute("orderUsers", allOrders);
                response.sendRedirect("orderDashbord.jsp");
             
                    break;
                case "all":
                allOrders = order.getAllOrders();
                session.setAttribute("orderUsers", allOrders);
                response.sendRedirect("orderDashbord.jsp"); 
                  break;
                case "complete":
                 allOrders = order.completedOrders();
                session.setAttribute("orderUsers", allOrders);
                response.sendRedirect("orderDashbord.jsp"); 
                 break;
                case "dispached":
          
                response.sendRedirect("orderDashbord.jsp"); 
                break;
                default:
                    int id = Integer.parseInt(request.getParameter("id")); 
                    order.deleteAnOrders(id);
                    response.sendRedirect("orderDashbord.jsp"); 
                    
    }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

//                    
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
