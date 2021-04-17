package pl.lisowski.newsstack.client.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pl.lisowski.newsstack.domain.api.DTO.CategoryFullInfoDto;
import pl.lisowski.newsstack.domain.api.service.CategoryService;
import pl.lisowski.newsstack.domain.api.DTO.DiscoveryBasicInfoDto;
import pl.lisowski.newsstack.domain.api.service.DiscoveryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final DiscoveryService discoveryService = new DiscoveryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        CategoryFullInfoDto category = categoryService.findById(categoryId)
                .orElseThrow(); //noSuchElemException
        request.setAttribute("category", category);
        List<DiscoveryBasicInfoDto> discoveries = discoveryService.findAllByCategory(categoryId);
        request.setAttribute("discoveries", discoveries);
        request.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(request, response);
    }
}
