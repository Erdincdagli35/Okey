package service.player;

import model.Tile;
import model.player.Player;

import java.util.List;

public interface TileDistributionStrategy {
    void distributeTiles(List<Player> players, List<Tile> tiles);
}
