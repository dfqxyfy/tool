package cn.ccs.springboot;

import com.google.common.collect.Maps;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class SprintRestFul {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8001/ab";
        MultiValueMap<String, String> header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        Map<String, String> map = Maps.newHashMap();
        map.put("name","afdassa");
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class,map);
        String s = exchange.toString();
        System.out.println(s);
    }
}
