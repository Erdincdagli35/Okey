package service.distribution;

import model.Tile;
import model.player.Player;
import model.player.PlayerHand;

import java.util.List;

public interface TileDistributionStrategy {
    List<Player> distributeTiles(List<Player> players, List<Tile> tiles);
}
