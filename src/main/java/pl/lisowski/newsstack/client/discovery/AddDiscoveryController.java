package pl.lisowski.newsstack.client.discovery;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.lisowski.newsstack.domain.api.DTO.CategoryNameDto;
import pl.lisowski.newsstack.domain.api.service.CategoryService;
import pl.lisowski.newsstack.domain.api.DTO.DiscoverySaveRequestDto;
import pl.lisowski.newsstack.domain.api.service.DiscoveryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/discovery/add")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class AddDiscoveryController extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    private DiscoveryService discoveryService = new DiscoveryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryNameDto> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/add-discovery.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscoverySaveRequestDto saveRequest = createSaveRequest(request);
        discoveryService.add(saveRequest);
        response.sendRedirect(request.getContextPath());
    }

    private DiscoverySaveRequestDto createSaveRequest(HttpServletRequest request) {
        String loggedInUsername = request.getUserPrincipal().getName();
        return new DiscoverySaveRequestDto(
                request.getParameter("title"),
                request.getParameter("url"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("categoryId")),
                loggedInUsername
        );
    }
}
