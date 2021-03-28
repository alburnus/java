package com.github.alburnus.javastuff.boundry;

import com.github.alburnus.javastuff.model.User;
import com.github.alburnus.javastuff.service.UserCsvFileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserCsvFileService userCsvFileService;

    public UserController(UserCsvFileService userCsvFileService) {
        this.userCsvFileService = userCsvFileService;
    }

    @GetMapping(value = "user", produces = "text/csv")
    public ResponseEntity<Resource> getUsers() {
        User user = new User();
        user.setFirstName("Adam");
        user.setLastName("Kowalski");

        byte[] data = userCsvFileService.createFile(user);
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=file.csv")
                .body(new ByteArrayResource(data));
    }
}
