package com.example.demo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


@RestController
public class MyController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping("/students1")
    public String insert(@RequestBody Student student) {
        String isql = "INSERT INTO student(id, name) VALUES (:id, :name)";
        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());
        namedParameterJdbcTemplate.update(isql, map);
        return "執行insert";
    }


    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        return "執行資料庫的 Create 操作";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "執行資料庫的 Read 操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        return "執行資料庫的 Update 操作";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "執行資料庫的 Delete 操作";
    }

}

//@RestController
//public class MyController {
//
//    @Autowired
//    @Qualifier("hpPrinter")
//    private  Printer printer;
//
//    @RequestMapping("/test")
//    public String test() {
//        printer.print("hello world!");
//        return "hello world";
//    }
//
//    @RequestMapping("/test1")
//    public String test1(@RequestParam int id,@RequestParam String name) {
//        int i = id + 1;
//        String se = name;
//        return "hello " + i + " " + se;
//    }
//
//    @RequestMapping("/test2")
//    public String test2(@RequestBody Student student) {
//        Integer i = student.getId() + 1;
//        String se = student.getName();
//        return "hello " + i + " " + se;
//    }
//
//    @RequestMapping("/test3")
//    public String test3(@RequestHeader String info) {
//        String se = info;
//        return "hello " + " " + se;
//    }
//
//    @RequestMapping("/test4/{id}")
//    public String test4(@PathVariable int id) {
//        int se = id + 2;
//        return "hello " + " " + se;
//    }
//
//    @RequestMapping("/product")
//    public Store product() {
//        Store store = new Store();
//        List<String> list = new ArrayList<>();
//        list.add("蘋果");
//        list.add("橘子");
//        store.setList(list);
//        return store;
//    }
//
//
//}
//
//
//
//
