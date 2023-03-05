package com.example.gb.controller;

import com.example.gb.model.BaseResult;
import com.example.gb.model.Enum.ResultEnum;
import com.example.gb.model.po.Administrator;
import com.example.gb.model.repository.AdministratorRepository;
import com.example.gb.service.AdministratorService;
import com.example.gb.tool.StringTool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdministratorController.class)
class AdministratorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AdministratorService administratorService;
    @MockBean
    private AdministratorRepository administratorRepository;

    //register
        //used name
        //unusable params
        //empty params
        //success
    //login
        //wrong params
        //success

    @Test
    void register_success() throws Exception {
        String request = StringTool.toJson(new Administrator("rayhsl", "12345678"));
        Mockito.when(administratorRepository.findByAccount(any())).thenReturn(null);
        Mockito.when(administratorRepository.save(any())).thenReturn(null);
        Mockito.when(administratorService.insert(any())).thenReturn(null);
        ResultActions perform = mockMvc.perform(
                post("/administrator/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request));
        checkResult(perform, BaseResult.success());
    }

    @Test
    void register_inputEmptyParam_false() throws Exception {
        String request = StringTool.toJson(new Administrator("", "12345678"));
        ResultActions perform = mockMvc.perform(
                post("/administrator/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        checkResult(perform, BaseResult.error(ResultEnum.INVALID_PARAMS));
    }

    @Test
    void register_duplicateName_false() throws Exception {
        String request = StringTool.toJson(new Administrator("rayhsl", "12345678"));
        Mockito.when(administratorRepository.findByAccount(any())).thenReturn(new Administrator("rayhsl", "123123"));
        Mockito.when(administratorService.findByAccount(any())).thenReturn(new Administrator("rayhsl", "123123"));
        ResultActions perform = mockMvc.perform(
                post("/administrator/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        checkResult(perform, BaseResult.error(ResultEnum.NAME_EXISTS));
    }

    @Test
    void register_inValidParams_false() throws Exception {
        String request = StringTool.toJson(new Administrator("rayhsl", "123"));
        ResultActions perform = mockMvc.perform(
                post("/administrator/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request));
        checkResult(perform, BaseResult.error(ResultEnum.INVALID_PARAMS));
    }

    @Test
    void insertAdministrator() {
    }

    @Test
    void updateAdministrator() {
    }

    @Test
    void deleteAdministrator() {
    }

    private void checkResult(ResultActions perform, BaseResult result) throws Exception {
        perform.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(result.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(result.getMessage()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(result.getSuccess()));
    }
}