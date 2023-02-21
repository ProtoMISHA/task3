package com.example.task3.service;


import com.example.task3.model.TextDocument;
import com.example.task3.repo.ElasticsearchTextDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticsearchTextDocumentServiceImpl implements ElasticsearchTextDocumentService {


    private final ElasticsearchTextDocumentRepository elasticsearchTextDocumentRepository;

    public ElasticsearchTextDocumentServiceImpl(ElasticsearchTextDocumentRepository elasticsearchTextDocumentRepository) {
        this.elasticsearchTextDocumentRepository = elasticsearchTextDocumentRepository;
    }


    @Override
    public void addDocumentToDB(TextDocument textDocument) {
        elasticsearchTextDocumentRepository.save(textDocument);
    }

    @Override
    public List<TextDocument> searchAllDocumentsByFullTextSearch(String textDocument) {
        return elasticsearchTextDocumentRepository.searchTextDocumentsByText(textDocument);
    }


}
