package com.github.alburnus.javastuff.service;

import com.github.alburnus.javastuff.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class UserCsvFileService {

    public byte[] createFile(User user) {
        StringWriter out = new StringWriter();
        try {

            try (CSVPrinter csvPrinter = new CSVPrinter(out, CSVFormat.RFC4180)) {
                csvPrinter.printRecord("First name", "Last name");
                csvPrinter.printRecord(user.getFirstName(), user.getLastName());
                csvPrinter.flush();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return out.toString().getBytes(StandardCharsets.UTF_8);
    }
}
