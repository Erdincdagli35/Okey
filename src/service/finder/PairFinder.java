package service.finder;

import model.Tile;

import java.util.*;
import java.util.stream.Collectors;

public class PairFinder implements TileStrategy{
    @Override
    public List<List<Tile>> findTiles(List<Tile> tiles, Set<Tile> usedTiles) {
        // Aynı sayı ve renk ile grupla
        Map<String, List<Tile>> grouped = tiles.stream()
                .filter(t -> !t.isOkey() && !usedTiles.contains(t))
                .collect(Collectors.groupingBy(t -> t.getNumber() + "-" + t.getColor()));

        List<List<Tile>> pairs = new ArrayList<>();

        for (List<Tile> group : grouped.values()) {
            // En az 2 aynı taş varsa çift oluştur
            while (group.size() >= 2) {
                Tile t1 = group.remove(0);
                Tile t2 = group.remove(0);
                pairs.add(Arrays.asList(t1, t2));
                usedTiles.add(t1);
                usedTiles.add(t2);
            }
        }

        return pairs;
    }

}
