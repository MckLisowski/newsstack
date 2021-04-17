package pl.lisowski.newsstack.domain.api.service;

import pl.lisowski.newsstack.domain.api.DTO.DiscoveryBasicInfoDto;
import pl.lisowski.newsstack.domain.api.DTO.DiscoverySaveRequestDto;
import pl.lisowski.newsstack.domain.discovery.Discovery;
import pl.lisowski.newsstack.domain.discovery.DiscoveryDao;
import pl.lisowski.newsstack.domain.user.UserDao;
import pl.lisowski.newsstack.domain.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DiscoveryService {
    private final DiscoveryDao discoveryDao = new DiscoveryDao();
    private final DiscoveryMapper discoveryMapper = new DiscoveryMapper();

    public void add(DiscoverySaveRequestDto saveRequest) {
        Discovery discoveryToSave = discoveryMapper.map(saveRequest);
        discoveryDao.save(discoveryToSave);
    }

    public List<DiscoveryBasicInfoDto> findAll() {
        return discoveryDao.findAll()
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    public List<DiscoveryBasicInfoDto> findAllByCategory(int categoryId) {
        return discoveryDao.findByCategory(categoryId)
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    private static class DiscoveryMapper {
        private final UserDao userDao = new UserDao();
        private final VoteDao voteDao = new VoteDao();

        DiscoveryBasicInfoDto map(Discovery d) {        //DAO->DTO
            return new DiscoveryBasicInfoDto(
                    d.getId(),
                    d.getTitle(),
                    d.getUrl(),
                    d.getDescription(),
                    d.getDateAdded(),
                    voteDao.countByDiscoveryId(d.getId()),
                    userDao.findById(d.getUserId()).orElseThrow().getUsername()
            );
        }

        Discovery map(DiscoverySaveRequestDto ds) {      //DTO->DAO
            return new Discovery(
                    ds.getTitle(),
                    ds.getUrl(),
                    ds.getDescription(),
                    LocalDateTime.now(),
                    ds.getCategoryId(),
                    userDao.findByUsername(ds.getAuthor())
                            .orElseThrow()
                            .getId()
            );
        }
    }
}
