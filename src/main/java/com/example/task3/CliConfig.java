package com.example.task3;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CliConfig {
    @Bean
    public Options commandLineOptions() {
        Options options = new Options();

        Option textOption = new Option("s", true, "some text");
        textOption.setArgs(1);
        textOption.setOptionalArg(false);

        Option operationOption = new Option("e", true, "operation type");
        operationOption.setArgs(1);
        operationOption.setOptionalArg(false);

        options.addOption(textOption);
        options.addOption(operationOption);

        return options;
    }


}
