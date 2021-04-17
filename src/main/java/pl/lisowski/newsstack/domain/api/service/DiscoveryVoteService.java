package pl.lisowski.newsstack.domain.api.service;

import pl.lisowski.newsstack.domain.api.DTO.DiscoveryVoteDto;
import pl.lisowski.newsstack.domain.user.User;
import pl.lisowski.newsstack.domain.user.UserDao;
import pl.lisowski.newsstack.domain.vote.Vote;
import pl.lisowski.newsstack.domain.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.Optional;

public class DiscoveryVoteService {
    private VoteDao voteDao = new VoteDao();
    private DiscoveryVoteMapper voteMapper = new DiscoveryVoteMapper();

    public void addVote(DiscoveryVoteDto vote) {
        Vote voteToSave = voteMapper.map(vote);
        voteDao.save(voteToSave);
    }

    private static class DiscoveryVoteMapper {
        private final UserDao userDao = new UserDao();

        Vote map(DiscoveryVoteDto vote) {                    //DTO->DAO
            Optional<User> user = userDao.findByUsername(vote.getUsername());
            return new Vote(
                    user.orElseThrow().getId(),
                    vote.getDiscoveryId(),
                    Vote.Type.valueOf(vote.getType()),
                    LocalDateTime.now()
            );
        }
    }
}
