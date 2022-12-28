package hayk.harutyunyan.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hayk.harutyunyan.shop.bean.BookDto;
import hayk.harutyunyan.shop.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

        @Autowired
        MockMvc mockMvc;

        @Autowired
        ObjectMapper objectMapper;

        @MockBean
        BookService bookService;

        @Test
        void shouldLoadUploadedFile() throws Exception {

            BookDto record = BookDto.builder()
                    .title("John Doe")
                    .price(47)
                    .build();
            when(bookService.create(any(BookDto.class))).thenReturn(record);

            mockMvc.perform(post("/api/book")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(record)))
                    .andExpect(status().isOk());
        }



}
