package com.matchPreview.IplMatchPreview.Repo;

import com.matchPreview.IplMatchPreview.Model.IplPerc;
import com.matchPreview.IplMatchPreview.Model.IplPreview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IplRepo extends JpaRepository<IplPreview, Long> {
    @Query("SELECT i FROM IplPreview i WHERE (i.Team1 = :teamName OR i.Team2 = :teamName) AND i.Season = :season")
    List<IplPreview> getMatchPreviewByTeam(String teamName, String season);

    @Query("SELECT DISTINCT i.Team1 FROM IplPreview i")
    List<String> getTeams();
    @Query("SELECT DISTINCT i.Season FROM IplPreview i")
    List<String> getSeason();

    @Query("SELECT Season AS Season, " +
            ":team AS Team, " +
            "COUNT(*) AS MatchesPlayed, " +
            "SUM(CASE WHEN Winner = :team THEN 1 ELSE 0 END) AS MatchesWon, " +
            "ROUND((SUM(CASE WHEN Winner = :team THEN 1 ELSE 0 END) * 100.0 / COUNT(*)), 2) AS WinPercentage " +
            "FROM IplPreview " +
            "WHERE Team1 = :team OR Team2 = :team " +
            "GROUP BY Season")
    public List<Object[]> getMatchePerc(String team);
}

