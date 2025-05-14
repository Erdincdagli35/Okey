package manager.distribution;

import model.Player;
import model.Tile;

import java.util.List;

public interface TileDistributionStrategy {
    List<Player> distributeTiles(List<Player> players, List<Tile> tiles);
}
