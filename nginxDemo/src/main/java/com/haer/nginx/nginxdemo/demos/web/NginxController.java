package com.haer.nginx.nginxdemo.demos.web;


import com.haer.nginx.nginxdemo.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@RestController
public class NginxController {

    @GetMapping("/a/b")
    public String a(){
        return "aaaa";
    }

    @Resource
    private Service1 service1;

    @GetMapping("/a/b/c")
    public String b(){
        return  service1.action1("bbb");
    }


    @GetMapping("/a/c")
    public String c(){
        return "cccc";
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\28014\\Desktop\\新建 文本文档.txt"));
        List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表
        String readLine = null;
        while((readLine = br.readLine()) != null){
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");  //过滤出只含有字母的
            for (String word : wordsArr1) {
                if(word.length() != 0){  //去除长度为0的行
                    lists.add(word);
                }
            }
        }

        br.close();

        Map<String, Integer> wordsCount = new TreeMap<String,Integer>();  //存储单词计数信息，key值为单词，value为单词数

        //单词的词频统计
        for (String li : lists) {
            if(wordsCount.get(li) != null){
                wordsCount.put(li,wordsCount.get(li) + 1);
            }else{
                wordsCount.put(li,1);
            }

        }

        SortMap(wordsCount);    //按值进行排序

    }

    //按value的大小进行排序
    public static void SortMap(Map<String,Integer> oldmap){

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();  //降序
            }
        });

        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());
        }
    }

}
