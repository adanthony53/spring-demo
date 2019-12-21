package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> res = new ArrayList<>();
        for (Question question : questionList) {
            //System.out.println(question.getCreator());
            User user = userMapper.findById(question.getCreator());
            //System.out.println(user.getId());
            //System.out.println(user.getName());
            //System.out.println(user.getAvatarUrl());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO); //set all the properties of Question to QuestionDTO
            questionDTO.setUser(user);
            res.add(questionDTO);
        }
        return res;
    }
}



