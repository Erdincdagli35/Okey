package service.player;

import model.Tile;
import model.Player;
import model.PlayerHand;
import service.generator.TilePrint;

import java.util.List;

public class PlayerPrint {
    private PlayerManager playerManager;
    private TilePrint tilePrint;

    public PlayerPrint(PlayerManager playerManager, TilePrint tilePrint) {
        this.playerManager = playerManager;
        this.tilePrint = tilePrint;
    }

    public void printPlayerSize(List<Player> players){
        System.out.println("Oyuncu Sayısı : " + players.size());
    }

    public void printTileByPlayer(Player player, PlayerHand hand){
        List<Tile> tiles = hand.getTiles();
        String tileList = tilePrint.tilesPrintSpecificByString(tiles);

        System.out.println("Player : " + player.getId()  +
                            "\nHand : " +
                            "{" + tileList + "}");
    }
}
