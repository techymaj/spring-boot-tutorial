package tech.majaliwa.content_calendar.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import tech.majaliwa.content_calendar.model.Content;
import tech.majaliwa.content_calendar.model.Status;
import tech.majaliwa.content_calendar.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(
                1,
                "My first blog post",
                "Say something cool",
                Status.PUBLISHED,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "http://localhost:8080/c/1"
        );
        contentList.add(content);
    }

    public boolean existsByID(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
