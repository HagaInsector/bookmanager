package com.example.bookmanager.history;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private JdbcTemplate jdbcTemplate;

    //コンストラクタ
    @Autowired
    public HistoryController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //一覧画面の表示
    @GetMapping
    public String index(Model model) {
        String sql = "SELECT * FROM history";
        List<Map<String, Object>> loglist = jdbcTemplate.queryForList(sql);
        model.addAttribute("loglist", loglist);
        return "history";
    }
}