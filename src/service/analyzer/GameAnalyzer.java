package service.analyzer;

import model.Tile;
import model.player.Player;
import model.player.PlayerHand;
import service.finder.TileSeriesFinder;

import java.util.List;
import java.util.Map;

public class GameAnalyzer {
    private final TileSeriesFinder finder;

    public GameAnalyzer(Tile okeyTile, Tile indicatorTile) {
        this.finder = new TileSeriesFinder(okeyTile, indicatorTile);
    }

    public Integer determineBestPlayer(List<Player> players) {
        Integer bestPlayer = null;
        int bestScore = -1;

        for (Player player : players) {
            List<Tile> tiles = player.getHand().getTiles();

            Map<String, Integer> counts = finder.countSetTypes(tiles);
            int score = calculateScore(counts);

            System.out.println("Player: " + player.getId() + ", Series: " + counts.get("series") +
                    ", Groups: " + counts.get("group") +
                    ", Pairs: " + counts.get("pair") +
                    ", Score: " + score);

            if (score > bestScore) {
                bestScore = score;
                bestPlayer = player.getId();
            }
        }

        return bestPlayer;
    }

    private int calculateScore(Map<String, Integer> counts) {
        // Örnek puanlama: Seri=5, Grup=3, Çift=1
        return counts.getOrDefault("series", 0) * 5 +
                counts.getOrDefault("group", 0) * 3 +
                counts.getOrDefault("pair", 0) * 1;
    }
}
