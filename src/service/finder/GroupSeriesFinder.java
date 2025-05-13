package service.finder;

import model.Color;
import model.Tile;

import java.util.*;
import java.util.stream.Collectors;

public class GroupSeriesFinder implements TileStrategy{
    @Override
    public List<List<Tile>> findTiles(List<Tile> tiles, Set<Tile> usedTiles) {
        Map<Integer, List<Tile>> byNumber = tiles.stream()
                .filter(t -> !t.isOkey() && !usedTiles.contains(t))
                .collect(Collectors.groupingBy(Tile::getNumber));

        List<List<Tile>> groupList = new ArrayList<>();

        for (List<Tile> group : byNumber.values()) {
            Map<Color, Tile> uniqueByColor = new HashMap<>();
            for (Tile t : group) {
                uniqueByColor.putIfAbsent(t.getColor(), t);
            }

            List<Tile> unique = new ArrayList<>(uniqueByColor.values());
            if (unique.size() >= 3) {
                List<Tile> groupSet = unique.subList(0, 3);
                groupList.add(groupSet);
                usedTiles.addAll(groupSet);
            }
        }

        return groupList;
    }
}
