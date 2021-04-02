package com.github.alburnus.javastuff.service;

import com.github.alburnus.javastuff.model.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserCsvFileServiceTest {

    @Autowired
    private UserCsvFileService userCsvFileService;

    @Test
    void shouldGenerateCsv() throws IOException {
        // Given
        File resourceFile = new ClassPathResource("user.csv").getFile();
        String employees = new String(
                Files.readAllBytes(resourceFile.toPath()));

        User user = User
                .builder()
                .firstName("Adam")
                .lastName("Kowalski")
                .build();

        // When
        byte[] bytes = userCsvFileService.createFile(user);

        // Then
        assertThat(bytes).isNotEmpty();
        assertThat(bytes).isEqualTo(employees.getBytes(StandardCharsets.UTF_8));
    }

}