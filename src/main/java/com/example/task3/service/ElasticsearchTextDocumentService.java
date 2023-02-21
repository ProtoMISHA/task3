package com.example.task3.service;

import com.example.task3.model.TextDocument;

import java.util.List;

public interface ElasticsearchTextDocumentService {
    void addDocumentToDB(TextDocument textDocument);

    List<TextDocument> searchAllDocumentsByFullTextSearch(String text);


}
