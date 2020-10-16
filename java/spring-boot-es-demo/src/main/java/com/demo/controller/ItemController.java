package com.demo.controller;

import com.demo.entity.Item;
import com.demo.service.ItemService;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author: gan
 * @date: 2020/10/14
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/addItem")
    public void addItem() {
        itemService.index();
    }

    @GetMapping("/saveAll")
    public void saveAll() {
        itemService.saveAll();
    }

    @GetMapping("/findByPrice")
    @ResponseBody
    public List<Item> findByPrice() {
        return itemService.findByPriceBetween();
    }

    @GetMapping("/search")
    @ResponseBody
    public Page<Item> search() {
        return itemService.search();
    }


    @GetMapping("/t/save")
    @ResponseBody
    public boolean save() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("key1", "String");
        hashMap.put("key2", 1);
        elasticsearchRestTemplate.save(hashMap, IndexCoordinates.of("person"));
        return true;
    }
    @GetMapping("/t/search")
    @ResponseBody
    public SearchHits<HashMap> searchT() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));

      return   elasticsearchRestTemplate.search(queryBuilder.build(),HashMap.class);

    }

}
