package service.player;

import model.Tile;
import model.player.Player;
import model.player.PlayerHand;

import java.util.List;
import java.util.Random;

public class RandomTileDistribution implements TileDistributionStrategy {

    private PlayerPrint playerPrint;

    public RandomTileDistribution(PlayerPrint playerPrint) {
        this.playerPrint = playerPrint;
    }

    @Override
    public void distributeTiles(List<Player> players, List<Tile> tiles) {
        Random random = new Random();
        for (Player player : players) {
            PlayerHand hand = new PlayerHand(player);
            for (int i = 0; i < 15; i++) {
                int randomIndex = random.nextInt(tiles.size());
                Tile tile = tiles.remove(randomIndex);
                hand.addTile(tile);
            }

            player.setHand(hand);
            hand.setPlayer(player);
            playerPrint.printTileByPlayer(player, hand);
        }
    }
}
