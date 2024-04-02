package com.arruda.uolhost.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class CodinameServiceImpl {

    private final RestTemplate restTemplate;

    @Value("${avengers.url}")
    private String avengersUrl;
    @Value("${justiceLeague.url}")
    private String justiceLeagueUrl;
    private List<String> avengersList = new ArrayList<>();
    private List<String> justiceLeagueList = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    public void loadAvengersCodinames() {
        try{
            String codinameResponse = restTemplate.getForObject(avengersUrl, String.class);
            JsonNode jsonNode = mapper.readTree(codinameResponse);

            ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

            for(JsonNode item: avangers){
                this.avengersList.add(item.get("codinome").asText());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadJusticeLeagueCodinames() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(justiceLeagueUrl);

            NodeList codinameList = document.getElementsByTagName("codinome");

            for(int i = 0; i < codinameList.getLength(); i++){
                Element codinameElement = (Element) codinameList.item(i);
                String codiname = codinameElement.getTextContent();
                this.justiceLeagueList.add(codiname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
