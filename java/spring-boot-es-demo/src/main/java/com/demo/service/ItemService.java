package com.demo.service;

import com.demo.entity.Item;
import com.demo.repo.ItemRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gan
 * @date: 2020/10/14
 */
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void index() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.zq.com/13123.jpg");
        itemRepository.save(item);
    }

    public void saveAll() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.zq.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.zq.com/3.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    public List<Item> findByPriceBetween() {
        return itemRepository.findByPriceBetween(3000, 4000);
    }

    public Page<Item> search() {
        Item item = new Item();
        item.setId(1L);
        String[] field = new String[1];
        field[0] = "title";
        Pageable pageable = Pageable.unpaged();
        return itemRepository.searchSimilar(item, field, pageable);
    }

    public Page<Item> nativeSearch() {
        ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();


        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));
        // 执行搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 打印总条数
        System.out.println(items.getTotalElements());
        // 打印总页数
        System.out.println(items.getTotalPages());
        items.forEach(System.out::println);
        return items;
    }
}
