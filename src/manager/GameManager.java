package manager;

import model.Player;
import model.Tile;
import manager.analyzer.GameAnalyzer;
import manager.distribution.RandomTileDistribution;
import manager.distribution.TileDistributionStrategy;
import manager.placer.TileSeriesPlacer;
import manager.generator.TileGenerator;
import manager.generator.TileManager;
import manager.generator.TilePrint;
import manager.indicator.IndicatorManager;
import manager.indicator.IndicatorPrint;
import manager.indicator.IndicatorResult;
import manager.indicator.IndicatorSelector;
import manager.player.PlayerGenerator;
import manager.player.PlayerManager;
import manager.player.PlayerPrint;

import java.util.List;

public class GameManager {

    public void initializeGame() {
        System.out.println();

        //1.Taşlar oluşturuluyor
        TileManager tileManager = new TileGenerator();
        List<Tile> tiles = tileManager.generateTiles();

        System.out.println("---------------------------");
        System.out.println("Tiles have been created");

        TilePrint tilePrint = new TilePrint(tileManager);

        System.out.println("---------------------------");
        tilePrint.printTilesSize(tiles);
        System.out.println("---------------------------");

        //1.Oyuncular oluşturuluyor
        PlayerManager playerManager = new PlayerGenerator();
        List<Player> players = playerManager.generatePlayers(4);

        System.out.println("---------------------------");
        PlayerPrint playerPrint = new PlayerPrint(playerManager, tilePrint);

        //2.Taşlar karıştırılıp oyuncuların ıstakasına ekleniyor
        TileDistributionStrategy distributionStrategy = new RandomTileDistribution(playerPrint);
        players = distributionStrategy.distributeTiles(players, tiles);

        IndicatorManager indicatorManager = new IndicatorSelector();
        IndicatorPrint indicatorPrint = new IndicatorPrint(indicatorManager);
        IndicatorResult indicatorResult = indicatorManager.selectIndicator(tiles);

        indicatorPrint.print(indicatorResult);
        System.out.println("---------------------------");

        playerPrint.printPlayerSize(players);

        //3.Taşlar diziliyor
        TileSeriesPlacer tileSeriesFinder = new TileSeriesPlacer(indicatorResult.getOkey(), indicatorResult.getIndicator());
        GameAnalyzer analyzer = new GameAnalyzer(indicatorResult.getOkey(), indicatorResult.getIndicator());

        for (Player player : players) {
            System.out.println("---------------------------------");
            System.out.println("\nPlayer " + player.getId() + "\n");
            tileSeriesFinder.printSeries(tileSeriesFinder.findAllValidSets(player.getHand().getTiles()));
            System.out.println("---------------------------------");
        }

        //En iyi oyuncu bulunuyor
        Integer bestPlayer = analyzer.determineBestPlayer(players);
        System.out.println("Best Player ID : Player " + bestPlayer);
    }
}
