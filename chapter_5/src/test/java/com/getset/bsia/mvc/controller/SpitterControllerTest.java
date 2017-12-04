package com.getset.bsia.mvc.controller;

import com.getset.bsia.mvc.dao.SpitterRepository;
import com.getset.bsia.mvc.dao.SpitterRepositoryImpl;
import com.getset.bsia.mvc.entity.Spitter;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {
    @Test
    public void shouldShowRegisterPage() throws Exception {
        SpitterRepository spitterRepository = mock(SpitterRepositoryImpl.class);
        MockMvc mockMvc = standaloneSetup(new SpitterController(spitterRepository)).build();
        mockMvc.perform(get("/spitter/register"))
            .andExpect(view().name("registerSpitter"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository spitterRepository = mock(SpitterRepositoryImpl.class);
        Spitter unsaved = new Spitter("San", "Zhang", "zhangsan", "123456");
        Spitter saved = new Spitter(12L, "San", "Zhang", "zhangsan", "123456");
        when(spitterRepository.save(unsaved)).thenReturn(saved);
        MockMvc mockMvc = standaloneSetup(new SpitterController(spitterRepository)).build();
        mockMvc.perform(post("/spitter/register")
            .param("firstName", "San")
            .param("lastName", "Zhang")
            .param("username", "zhangsan")
            .param("password", "123456"))
                .andExpect(redirectedUrl("/spitter/zhangsan"));
        verify(spitterRepository, atLeastOnce()).save(unsaved);
    }
}
