package mql.pages.web_components;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import wagu.Block;
import wagu.Board;
import wagu.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EventHistoryTable extends TableWC<HistoryTableRecord> {

    public EventHistoryTable(By rowLocator, Class<HistoryTableRecord> rowClass) {
        super(rowLocator, rowClass);
    }

    public List<HistoryTableRecord> filterLastYears(int years) {
        LocalDateTime currentTime = getFirst().getDateTime().minusYears(years);
        List<HistoryTableRecord> targetRecords = rows.stream()
                .filter(row -> row.getDateTime().isAfter(currentTime)).collect(Collectors.toList());
        targetRecords.forEach(row -> log.debug(row.getDateTime().toString()));
        return targetRecords;
    }

    public void logRecords(List<HistoryTableRecord> records) {
        int width = 60;
        Board board = new Board(width);
        List<List<String>> valuesList = new ArrayList<>();
        records.forEach(record -> valuesList.add(record.getValues()));
        Table table = new Table(board, width, records.get(0).getColumns(), valuesList);
        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        log.info("\n" + board.getPreview());
        Allure.addAttachment("history for the last 1 year", board.getPreview());
    }
}
