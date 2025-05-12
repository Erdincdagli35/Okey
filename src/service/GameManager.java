package service;

import model.Tile;
import model.player.Player;
import service.generator.TileGenerator;
import service.generator.TileManager;
import service.generator.TilePrint;
import service.indicator.IndicatorPrint;
import service.indicator.IndicatorManager;
import service.indicator.IndicatorSelector;
import service.player.*;

import java.util.List;

public class GameManager {

    public void initializeGame() {
        System.out.println();
        TileManager tileManager = new TileGenerator();
        List<Tile> tiles = tileManager.generateTiles();
        System.out.println("---------------------------");
        System.out.println("Taşlar oluşturuldu.");

        TilePrint tilePrint = new TilePrint(tileManager);

        PlayerManager playerManager = new PlayerGenerator();
        List<Player> players = playerManager.generatePlayers(4);
        System.out.println("---------------------------");
        PlayerPrint playerPrint = new PlayerPrint(playerManager, tilePrint);

        TileDistributionStrategy distributionStrategy = new RandomTileDistribution(playerPrint);
        PlayerDistributor distributor = new PlayerDistributor(distributionStrategy);

        distributor.distributeTiles(players,tiles);

        //tilePrint.tilesPrint(tiles);
        System.out.println("---------------------------");
        //tilePrint.printTilesSize(tiles);
        System.out.println("---------------------------");
        //tilePrint.tilesPrintSpecific(tiles);
        System.out.println("---------------------------");

        IndicatorManager indicatorManager = new IndicatorSelector();

        IndicatorPrint indicatorPrint = new IndicatorPrint(indicatorManager);
        indicatorPrint.print(indicatorManager.selectIndicator(tiles));
        System.out.println("---------------------------");

        playerPrint.printPlayerSize(players);
    }
}
