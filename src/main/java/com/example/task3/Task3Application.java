package com.example.task3;

import com.example.task3.model.TextDocument;
import com.example.task3.service.ElasticsearchTextDocumentService;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

@SpringBootApplication
@EnableElasticsearchRepositories
public class Task3Application implements CommandLineRunner {


    private final Options options;

    private final ElasticsearchTextDocumentService elasticsearchTextDocumentService;

    Task3Application(Options options, ElasticsearchTextDocumentService elasticsearchTextDocumentService) {
        this.options = options;
        this.elasticsearchTextDocumentService = elasticsearchTextDocumentService;
    }

    public static void main(String[] args) throws ParseException {

        SpringApplication.run(Task3Application.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        if (args == null || args.length == 0) return;

        CommandLine commandLine = new PosixParser().parse(options, args);

        String valueOfEOption = commandLine.getOptionValue("e");

        String textForOperation = commandLine.getOptionValue("s");

        if (valueOfEOption.equals("add")) {
            TextDocument textDocument = new TextDocument();
            textDocument.setText(textForOperation);
            elasticsearchTextDocumentService.addDocumentToDB(textDocument);
        } else if (valueOfEOption.equals("search")) {
            List<TextDocument> listOfDocument =
                    elasticsearchTextDocumentService.searchAllDocumentsByFullTextSearch(textForOperation);
            listOfDocument.forEach(System.out::println);
        } else {

            System.out.println("Not correct value");
        }

    }
}
