package pl.lisowski.newsstack.domain.api.DTO;

public class DiscoverySaveRequestDto {   //info z formularza do zapisania znaleziska
    private String title;
    private String url;
    private String description;
    private Integer categoryId;
    private String author;

    public DiscoverySaveRequestDto(String title,
                                String url,
                                String description,
                                Integer categoryId,
                                String author) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.categoryId = categoryId;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getAuthor() {
        return author;
    }
}
