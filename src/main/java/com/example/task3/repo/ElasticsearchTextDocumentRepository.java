package com.example.task3.repo;

import com.example.task3.model.TextDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticsearchTextDocumentRepository extends ElasticsearchRepository<TextDocument, String> {
    public List<TextDocument> searchTextDocumentsByText(String text);

}
