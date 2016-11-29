package noQ;

import static com.googlecode.objectify.ObjectifyService.ofy;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class DismissHostServlet extends HttpServlet {
	static {

        ObjectifyService.register(Customer.class);


    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if(Customer.customerWaiting>0){
			Customer.served += 1;
			Customer.customerWaiting-=1;
		}
			resp.sendRedirect("/host.jsp?nextCustomer");
	}
}