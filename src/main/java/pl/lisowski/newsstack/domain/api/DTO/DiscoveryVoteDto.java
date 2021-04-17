package pl.lisowski.newsstack.domain.api.DTO;

public class DiscoveryVoteDto {
    private String username;
    private Integer discoveryId;
    private String type;

    public DiscoveryVoteDto(String username, Integer discoveryId, String type) {
        this.username = username;
        this.discoveryId = discoveryId;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public Integer getDiscoveryId() {
        return discoveryId;
    }

    public String getType() {
        return type;
    }
}
