package com.matchPreview.IplMatchPreview.Controllers;

import com.matchPreview.IplMatchPreview.Model.IplPerc;
import com.matchPreview.IplMatchPreview.Model.IplPreview;
import com.matchPreview.IplMatchPreview.Services.IplPreviewService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IplPreviewController {
    @Autowired
    IplPreviewService iplPreviewService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/getMatchPreviewByTeam")
    public List<IplPreview> getMatchPreviewByTeam(@RequestParam String team, @RequestParam String year){
        return iplPreviewService.getMatchPreviewByTeam(team,year);
    }

    @PostMapping("/UploadCsvFile")
    public String UploadCsvFile(@RequestParam("file")MultipartFile file) throws Exception{
        List<IplPreview> list = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setHeaderExtractionEnabled(true);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<Record> allRecords = csvParser.parseAllRecords(inputStream);
        allRecords.forEach(record -> {
            IplPreview iplPreview = new IplPreview();
            iplPreview.setSeason(record.getString("season"));
            iplPreview.setCity(record.getString("city"));
            iplPreview.setMatchType(record.getString("match_type"));
            iplPreview.setVenue(record.getString("venue"));
            iplPreview.setTeam1(record.getString("team1"));
            iplPreview.setTeam2(record.getString("team2"));
            iplPreview.setWinner(record.getString("winner"));
            list.add(iplPreview);
        });

        String resp =  iplPreviewService.UploadCsvFile(list);
        return resp;
    }

    @RequestMapping("/getTeams")
    public List<String> getTeams(){
        return iplPreviewService.getTeams();
    }
    @RequestMapping("/getSeason")
    public List<String> getSeason(){
        return iplPreviewService.getSeason();
    }

    @RequestMapping("/getMatchPerc")
    public List<IplPerc> getMatchPerc(String team){
        return iplPreviewService.getMatchPerc(team);}
}
