package rostelecom.web;

import rostelecom.model.ColorItem;
import rostelecom.repository.ColorRepository;
import rostelecom.service.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ColorsServlet extends HttpServlet {

    private ColorRepository colorRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        colorRepository = Config.get().getColorRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ColorItem> items = colorRepository.getAllSorted();
        req.setAttribute("items", items);
        req.getRequestDispatcher("/colors.jsp").forward(req, resp);
    }
}
