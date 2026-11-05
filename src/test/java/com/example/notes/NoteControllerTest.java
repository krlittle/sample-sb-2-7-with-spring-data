package com.example.notes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class NoteControllerTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void savesReadsAndDeletesANote() {
        Note saved = rest.postForObject("/notes", new Note("buy milk"), Note.class);
        String path = "/notes/" + saved.getId();

        assertThat(rest.getForObject(path, Note.class).getText()).isEqualTo("buy milk");

        rest.delete(path);

        assertThat(rest.getForEntity(path, Note.class).getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
