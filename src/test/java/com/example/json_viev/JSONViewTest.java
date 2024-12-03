package com.example.json_viev;

import com.example.json_viev.custom.Status;
import com.example.json_viev.model.Order;
import com.example.json_viev.model.User;
import com.example.json_viev.model.Views;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class JSONViewTest {

    private final Order order = new Order(1L, null, Status.COMPLETED);
    private final User user = new User(1L, "Ivan", "Ivan@mail.ru", List.of(order));

    @Test
    public void testUserSummaryViews() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writerWithView(Views.UserSummary.class)
                .writeValueAsString(user);

        assertThat(result, containsString("id"));
        assertThat(result, containsString("name"));
        assertThat(result, containsString("email"));
        assertThat(result, not(containsString("orders")));
    }

    @Test
    public void testUserDetailsViews() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writerWithView(Views.UserDetails.class)
                .writeValueAsString(user);

        assertThat(result, containsString("id"));
        assertThat(result, containsString("name"));
        assertThat(result, containsString("email"));
        assertThat(result, containsString("orders"));
    }
}
