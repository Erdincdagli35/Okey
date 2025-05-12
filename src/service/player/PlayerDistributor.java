package service.player;

import model.Tile;
import model.player.Player;
import model.player.PlayerHand;

import java.util.List;
import java.util.Random;

public class PlayerDistributor implements TileDistributionStrategy{
    private TileDistributionStrategy distributionStrategy;

    public PlayerDistributor(TileDistributionStrategy strategy) {
        this.distributionStrategy = strategy;
    }

    public void distributeTiles(List<Player> players, List<Tile> tiles) {
        distributionStrategy.distributeTiles(players, tiles);
    }

}
