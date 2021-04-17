package pl.lisowski.newsstack.client.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pl.lisowski.newsstack.domain.api.DTO.CategoryNameDto;
import pl.lisowski.newsstack.domain.api.DTO.DiscoveryBasicInfoDto;
import pl.lisowski.newsstack.domain.api.service.DiscoveryService;
import pl.lisowski.newsstack.domain.api.service.CategoryService;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {

    private DiscoveryService discoveryService = new DiscoveryService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiscoveryBasicInfoDto> discoveries = discoveryService.findAll();
        request.setAttribute("discoveries", discoveries);
        List<CategoryNameDto> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
