package com.matchPreview.IplMatchPreview.Model;

public class IplPerc {

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public int getMatchesPlayed() {
        return MatchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        MatchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return MatchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        MatchesWon = matchesWon;
    }

    public double getWinPercentage() {
        return WinPercentage;
    }

    public void setWinPercentage(float winPercentage) {
        WinPercentage = winPercentage;
    }

    public IplPerc(String season, String team, int matchesPlayed, int matchesWon, double winPercentage) {
        Season = season;
        Team = team;
        MatchesPlayed = matchesPlayed;
        MatchesWon = matchesWon;
        WinPercentage = winPercentage;
    }

    private String Season;
    private String Team;
    private int MatchesPlayed;
    private int MatchesWon;
    private double WinPercentage;
}
