package com.demo.service;

import com.demo.entity.Article;
import com.demo.entity.Author;
import com.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author: gan
 * @date: 2020/11/26
 */
@Service
public class ElasticSearchService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    public void index() {
        elasticsearchOperations.indexOps(Article.class).create();


    }

    public void save() {
        Author author = new Author("zhang san");
        Article article = new Article();
        article.setId("1");
        article.setTitle("si xiang ping de");
        article.setAuthors(Collections.singletonList(author));
        articleRepository.save(article);
    }

    public Object select() {
        Pageable pageable = Pageable.unpaged();
        Page articlePageable = articleRepository.findByAuthorsName("zhang san", pageable);
        return articlePageable;
    }
}
