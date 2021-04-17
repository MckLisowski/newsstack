package pl.lisowski.newsstack.client.signup;

import jakarta.servlet.annotation.WebServlet;
import pl.lisowski.newsstack.domain.api.service.UserService;
import pl.lisowski.newsstack.domain.api.DTO.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = getUserData(request);
        userService.register(userDto);
        response.sendRedirect(request.getContextPath());
    }

    private UserDto getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new UserDto(username, email, password);
    }
}
