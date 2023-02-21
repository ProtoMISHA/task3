package com.example.task3.integration;

import com.example.task3.model.TextDocument;
import com.example.task3.repo.ElasticsearchTextDocumentRepository;
import com.example.task3.service.ElasticsearchTextDocumentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElasticSearchTextDocumentIntegrationTest {


    private final ElasticsearchTextDocumentService elasticsearchTextDocumentService;

    private final ElasticsearchTextDocumentRepository elasticsearchTextDocumentRepository;


    public ElasticSearchTextDocumentIntegrationTest(ElasticsearchTextDocumentService elasticsearchTextDocumentService,
                                                    ElasticsearchTextDocumentRepository elasticsearchTextDocumentRepository) {
        this.elasticsearchTextDocumentService = elasticsearchTextDocumentService;
        this.elasticsearchTextDocumentRepository = elasticsearchTextDocumentRepository;
    }


    @BeforeAll
    public void prepareDB() {
        elasticsearchTextDocumentRepository.deleteAll();

        elasticsearchTextDocumentRepository.saveAll(textDocuments());

    }

    @Test
    public void addTwoDocument_shouldOK() {

        TextDocument textDocument = new TextDocument();
        textDocument.setText("один два три");

        TextDocument textDocument2 = new TextDocument();
        textDocument.setText("один три три");

        long countOfDocumentsBeforeSave = elasticsearchTextDocumentRepository.count();


        elasticsearchTextDocumentService.addDocumentToDB(textDocument);
        elasticsearchTextDocumentService.addDocumentToDB(textDocument2);


        long countOfDocumentsAfterSave = elasticsearchTextDocumentRepository.count();


        assertEquals(countOfDocumentsBeforeSave + 2, countOfDocumentsAfterSave);

    }

    @Test
    public void searchTwoDocumentsBytext_shouldOK() {
        String searchedText = "какой-то текст номер";
        elasticsearchTextDocumentService.searchAllDocumentsByFullTextSearch(searchedText);


    }


    private List<TextDocument> textDocuments() {
        TextDocument textDocument1 = new TextDocument();
        textDocument1.setText("Какой-то текст номер один");

        TextDocument textDocument2 = new TextDocument();
        textDocument2.setText("Какой-то текст номер два");

        TextDocument textDocument3 = new TextDocument();
        textDocument3.setText("Ехал грека через реку видит грека в реке рак");


        return List.of(textDocument1, textDocument2, textDocument3);

    }
}


