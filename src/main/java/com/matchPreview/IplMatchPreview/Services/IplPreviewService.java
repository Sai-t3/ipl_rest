package com.matchPreview.IplMatchPreview.Services;

import com.matchPreview.IplMatchPreview.Model.IplPerc;
import com.matchPreview.IplMatchPreview.Model.IplPreview;
import com.matchPreview.IplMatchPreview.Repo.IplRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IplPreviewService {
    @Autowired
    IplRepo iplRepo;

    public List<IplPreview> getMatchPreviewByTeam(String team,String year){
        List<IplPreview> list = new ArrayList<>();
        list = iplRepo.getMatchPreviewByTeam(team,year);
        return list;
    }
    public String UploadCsvFile(List<IplPreview> iplPreviews){
        iplRepo.saveAll(iplPreviews);
        return "Save Sucessful!!";
    }

    public List<String> getTeams(){
        List<String> list = new ArrayList<>();
        list = iplRepo.getTeams();
        return list;
    }
    public List<String> getSeason(){
        List<String> list = new ArrayList<>();
        list = iplRepo.getSeason();
        return list;
    }
    public List<IplPerc> getMatchPerc(String team){
        List<Object[]> rows = iplRepo.getMatchePerc(team);
        List<IplPerc> result = new ArrayList<>();
        for (Object[] row : rows) {
            String season = (String) row[0];
            String team1 = (String) row[1];
            int matchesPlayed = ((Long) row[2]).intValue();
            int matchesWon = ((Long) row[3]).intValue();
            double winPercentage = (double) row[4];
            IplPerc iplPerc = new IplPerc(season, team1, matchesPlayed, matchesWon, winPercentage);
            result.add(iplPerc);
        }

        return result;
    }


}
