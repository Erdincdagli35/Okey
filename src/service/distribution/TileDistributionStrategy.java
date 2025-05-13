package service.distribution;

import model.Tile;
import model.Player;

import java.util.List;

public interface TileDistributionStrategy {
    List<Player> distributeTiles(List<Player> players, List<Tile> tiles);
}
