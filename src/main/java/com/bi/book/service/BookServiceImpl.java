package com.bi.book.service;

import com.bi.book.entity.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;

@Service
public class BookServiceImpl {

    public BookList sendReqeustBookApi(BookReqeustInfo reqInfo) {
        BookList rtnInfo = null;
        ResponseEntity response;
        String type = reqInfo.getType();
        try {
            String searchFlag = "K";
            response = KakaoBookApi(reqInfo);
            if (response == null || !HttpStatus.OK.equals(response.getStatusCode())) {
                response = NaverBookApi(reqInfo);
                searchFlag = "N";
            }

            ObjectMapper mapper = new ObjectMapper();
//            System.out.println(response.getBody().toString());
            if ("K".equals(searchFlag)) {
                rtnInfo = mapper.readValue(response.getBody().toString(), new TypeReference<KBookInfo>(){});
            } else {
                if ("isbn".equals(type)) {
                    rtnInfo = readXml(response.getBody().toString());
                } else {
                    rtnInfo = mapper.readValue(response.getBody().toString(), new TypeReference<NBookInfo>(){});
                }
            }
            rtnInfo.setBookData();

            int pageCnt = rtnInfo.getTotal()==0? 1 : (rtnInfo.getTotal()/reqInfo.getSize() + (rtnInfo.getTotal()%reqInfo.getSize()!=0 ? 1: 0));
            rtnInfo.setPageCnt(pageCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtnInfo;
    }

    private ResponseEntity KakaoBookApi(BookReqeustInfo reqInfo) {
        String type = reqInfo.getType();
        String keyword= reqInfo.getKeyword();
        int size = reqInfo.getSize();
        int page = reqInfo.getPage();
        String apiURL = "https://dapi.kakao.com/v3/search/book";
        String header = "KakaoAK dea18bc3a6879f5062e4912103aee309";

        ResponseEntity response = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", header);
        HttpEntity entity = new HttpEntity("parameters", headers);
        try {
            keyword = URLEncoder.encode(keyword, "UTF-8");
            apiURL = apiURL + "?target=" + type + "&query=" + keyword + "&size="+size+"&page="+page;
            URI uri = URI.create(apiURL);
            response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    private ResponseEntity NaverBookApi(BookReqeustInfo reqInfo) {
        String type = reqInfo.getType();
        String keyword= reqInfo.getKeyword();
        int display = reqInfo.getSize();
        int start = reqInfo.getPage();
        String apiURL = "";
        String apiListURL = "https://openapi.naver.com/v1/search/book.json?query=";
        String apiDetailURL = "https://openapi.naver.com/v1/search/book_adv.xml?d_isbn=";
        String headerId = "Y1Ocm31CqXg5K9JGkkN0";
        String headerSecret = "Xo2IwAzA7Z";

        ResponseEntity response = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        try {
            if ("isbn".equals(type)) {
                headers.setContentType(MediaType.APPLICATION_XML);
                apiURL = apiDetailURL;
            } else {
                headers.setContentType(MediaType.APPLICATION_JSON);
                apiURL = apiListURL;
            }
            headers.set("X-Naver-Client-Id", headerId);
            headers.set("X-Naver-Client-Secret", headerSecret);
            HttpEntity entity = new HttpEntity("parameters", headers);

            keyword = URLEncoder.encode(keyword, "UTF-8");
            apiURL += keyword + "&display="+display+"&start="+start;
            URI uri = URI.create(apiURL);

            response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private BookList readXml(String xmlStr) {
        BookList result = null;
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Rss.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Rss rss = (Rss)unmarshaller.unmarshal(new StringReader(xmlStr));
            result = rss;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
