package pl.lisowski.newsstack.client.vote;

import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.lisowski.newsstack.domain.api.DTO.DiscoveryVoteDto;
import pl.lisowski.newsstack.domain.api.service.DiscoveryVoteService;

import java.io.IOException;

@WebServlet("/discovery/vote")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class DiscoveryVoteController extends HttpServlet {
    private DiscoveryVoteService voteService = new DiscoveryVoteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DiscoveryVoteDto discoveryVote = createDiscoveryVote(request);
        voteService.addVote(discoveryVote);
        response.sendRedirect(request.getContextPath());
    }

    private DiscoveryVoteDto createDiscoveryVote(HttpServletRequest request) {
        Integer discoveryId = Integer.valueOf(request.getParameter("id"));
        String voteType = request.getParameter("type");
        String username = request.getUserPrincipal().getName();
        DiscoveryVoteDto discoveryVote = new DiscoveryVoteDto(username, discoveryId, voteType);
        return discoveryVote;
    }
}
