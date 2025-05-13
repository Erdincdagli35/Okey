package service.distribution;

import model.Tile;
import model.player.Player;
import model.player.PlayerHand;
import service.player.PlayerPrint;

import java.util.List;
import java.util.Random;

public class RandomTileDistribution implements TileDistributionStrategy {

    private PlayerPrint playerPrint;

    public RandomTileDistribution(PlayerPrint playerPrint) {
        this.playerPrint = playerPrint;
    }

    @Override
    public List<Player> distributeTiles(List<Player> players, List<Tile> tiles) {
        Random random = new Random();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            PlayerHand hand = new PlayerHand(player);

            int tileCount = (i == 0) ? 15 : 14;

            for (int j = 0; j < tileCount; j++) {
                int randomIndex = random.nextInt(tiles.size());
                Tile tile = tiles.remove(randomIndex);
                hand.addTile(tile);
            }

            player.setHand(hand);
            hand.setPlayer(player);
            playerPrint.printTileByPlayer(player, hand);
        }

        return players;
    }
}
