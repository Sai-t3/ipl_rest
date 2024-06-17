package com.matchPreview.IplMatchPreview.Model;

import jakarta.persistence.*;

@Entity
public class IplPreview {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getMatchType() {
        return MatchType;
    }

    public void setMatchType(String matchType) {
        MatchType = matchType;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    public String getWinner() {
        return Winner;
    }

    public void setWinner(String winner) {
        Winner = winner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    @Column
    private String Season;
    @Column
    private String City;
    @Column
    private String MatchType;
    @Column
    private String Venue;
    @Column
    private String Team1;
    @Column
    private String Team2;
    @Column
    private String Winner;
}

