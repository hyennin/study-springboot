package study.springboot.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springboot.springbootdeveloper.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {
}