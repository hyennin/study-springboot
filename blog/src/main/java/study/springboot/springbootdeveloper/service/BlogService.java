package study.springboot.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springboot.springbootdeveloper.domain.Article;
import study.springboot.springbootdeveloper.dto.AddArticleRequest;
import study.springboot.springbootdeveloper.dto.UpdateArticleRequest;
import study.springboot.springbootdeveloper.repository.BlogRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return  blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
