import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by michaeldorin on 4/7/17.
 */
@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    Customer customer = new Customer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("name", "Jared");

        String template = Resources.toString(Resources.getResource("mytemplate.html"), Charsets.UTF_8);

        String renderedTemplate = jinjava.render(template, context);


        try (PrintWriter writer = response.getWriter()) {
            writer.println(renderedTemplate);

        }
    }
}
