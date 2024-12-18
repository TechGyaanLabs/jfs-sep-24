package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.repo.IplStatDao;
import com.careerit.iplstats.util.ExcelUtil;
import com.careerit.iplstats.util.PdfService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class IplStatsServiceImpl implements IplStatsService {


    private final IplStatDao iplStatDao;

    private final PlayerService playerService;

    @Override
    public TeamNames getTeamNames() {
         TeamNames teamName = iplStatDao.getTeamNames();
         log.info("Total {} teams found",teamName.teamNames().size());
         return teamName;
    }

    @Override
    public List<TeamWithAmountDto> getTeamWithAmount() {
         List<TeamWithAmountDto> teamWithAmountList = iplStatDao.getTeamWithAmount();
         log.info("Total {} teams found",teamWithAmountList.size());
         return teamWithAmountList;
    }

    @Override
    public List<CountryWithPlayerCountDto> getPlayerCountByCountry() {
        List<CountryWithPlayerCountDto> countryWithPlayerCount = iplStatDao.getPlayerCountByCountry();
        log.info("Total {} countries found",countryWithPlayerCount.size());
        return countryWithPlayerCount;
    }

    @Override
    public List<TopPlayerDto> getTopPlayers() {
        List<TopPlayerDto> topPlayerDtoList = iplStatDao.getTopPlayers();

        log.info("Total {} top players found",topPlayerDtoList.size());
        return topPlayerDtoList;
    }

    @Override
    public List<RoleCountDto> getRoleCount() {
        List<RoleCountDto> roleCountDtoList = iplStatDao.getRoleCount();
        log.info("Total {} roles found",roleCountDtoList.size());
        return roleCountDtoList;
    }

    @Override
    public TeamStatsDto getTeamStats(String team) {
        log.info("Getting team stats");
        return iplStatDao.getTeamStats(team);
    }

    @Override
    public File exportPlayers(String team) {
        List<Player> players = playerService.findPlayersByTeam(team);
        String sheetName = team + "_players";
        String fileName = team + "_players.xlsx";
        return exportPlayersToFile(players, sheetName, fileName);
    }

    @Override
    public File exportAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        String sheetName = "ipl_players";
        String fileName = "ipl_players.xlsx";
        return exportPlayersToFile(players, sheetName, fileName);
    }

    @Override
    public File exportPdfPlayers(String team) {
        List<Player> players = playerService.findPlayersByTeam(team);
        return exportPlayersToPdf(players, team + "_players.pdf");
    }

    @Override
    public File exportPdfAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        return exportPlayersToPdf(players, "ipl_players.pdf");
    }

    private File exportPlayersToPdf(List<Player> players, String fileName) {

        String xslPath  = this.getClass().getResource("/xsl-template/players/template.xsl").getFile().toString();
        Map<String,Object> list = new HashMap<>();
        list.put("player",players);
        PdfService pdfService = PdfService.builder()
                .data(list)
                .xsltFilePath(xslPath)
                .rootElement("players")
                .fileName(fileName)
                .build();

        File file = pdfService.generateInvoicePdf();
        log.info("PDF file generated at : {}",file.getAbsolutePath());
        return file;
    }

    private File exportPlayersToFile(List<Player> players, String sheetName, String fileName) {
        List<String> headers = List.of("Name", "Role", "Country", "Team", "Price");
        List<List<Object>> data = new ArrayList<>();
        for (Player player : players) {
            List<Object> row = List.of(player.getName(), player.getRole(), player.getCountry(), player.getTeam(), String.valueOf(player.getPrice()));
            data.add(row);
        }
        ExcelUtil excelUtil = ExcelUtil.builder()
                .headers(headers)
                .data(data)
                .sheetName(sheetName)
                .fileName(fileName)
                .build();
        return excelUtil.createExcel();
    }

}
