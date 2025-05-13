package service.finder;

import model.Color;
import model.Tile;

import java.util.*;
import java.util.stream.Collectors;

public class SequentialSeriesFinder implements TileStrategy{
    @Override
    public List<List<Tile>> findTiles(List<Tile> tiles, Set<Tile> usedTiles) {
        Map<Color, List<Tile>> byColor = tiles.stream()
                .filter(t -> !t.isOkey())
                .collect(Collectors.groupingBy(Tile::getColor));

        List<List<Tile>> seriesList = new ArrayList<>();

        for (List<Tile> colorGroup : byColor.values()) {
            colorGroup.sort(Comparator.comparingInt(Tile::getNumber));
            List<Tile> currentSeries = new ArrayList<>();

            for (Tile tile : colorGroup) {
                if (usedTiles.contains(tile)) continue;

                if (currentSeries.isEmpty() || tile.getNumber() == currentSeries.get(currentSeries.size() - 1).getNumber() + 1) {
                    currentSeries.add(tile);
                } else {
                    if (currentSeries.size() >= 3) {
                        seriesList.add(new ArrayList<>(currentSeries));
                        usedTiles.addAll(currentSeries);
                    }
                    currentSeries.clear();
                    currentSeries.add(tile);
                }
            }

            if (currentSeries.size() >= 3) {
                seriesList.add(currentSeries);
                usedTiles.addAll(currentSeries);
            }
        }

        return seriesList;
    }
}
