package service;

import model.Color;
import model.Tile;
import model.TileMarker;
import model.player.Player;
import model.player.PlayerHand;
import service.analyzer.GameAnalyzer;
import service.distribution.RandomTileDistribution;
import service.distribution.TileDistributionStrategy;
import service.finder.TileSeriesFinder;
import service.generator.TileGenerator;
import service.generator.TileManager;
import service.generator.TilePrint;
import service.indicator.IndicatorPrint;
import service.indicator.IndicatorManager;
import service.indicator.IndicatorResult;
import service.indicator.IndicatorSelector;
import service.player.*;

import java.util.List;

public class GameManager {

    public void initializeGame() {
        System.out.println();

        //Taşlar oluşturuluyor
        TileManager tileManager = new TileGenerator();
        List<Tile> tiles = tileManager.generateTiles();

        System.out.println("---------------------------");
        System.out.println("Taşlar oluşturuldu.");

        TilePrint tilePrint = new TilePrint(tileManager);

        System.out.println("---------------------------");
        tilePrint.printTilesSize(tiles);
        System.out.println("---------------------------");

        //Oyuncular oluşturuluyor
        PlayerManager playerManager = new PlayerGenerator();
        List<Player> players = playerManager.generatePlayers(4);

        System.out.println("---------------------------");
        PlayerPrint playerPrint = new PlayerPrint(playerManager, tilePrint);

        //Taşlar karıştırılıp oyuncuların ıstakasına ekleniyor
        TileDistributionStrategy distributionStrategy = new RandomTileDistribution(playerPrint);
        players = distributionStrategy.distributeTiles(players,tiles);

        IndicatorManager indicatorManager = new IndicatorSelector();
        IndicatorPrint indicatorPrint = new IndicatorPrint(indicatorManager);
        IndicatorResult indicatorResult = indicatorManager.selectIndicator(tiles);

        //System.out.println(tileMarker.getIndicator() +" "+ tileMarker.getOkey());

        indicatorPrint.print(indicatorResult);
        System.out.println("---------------------------");

        playerPrint.printPlayerSize(players);

        TileSeriesFinder tileSeriesFinder = new TileSeriesFinder(indicatorResult.getOkey(), indicatorResult.getIndicator());
        GameAnalyzer analyzer = new GameAnalyzer(indicatorResult.getOkey(), indicatorResult.getIndicator());

        for (Player player : players) {
            System.out.println("---------------------------------");
            System.out.println("\nPlayer "+player.getId() + "\nİhtimaller : \n" );
            tileSeriesFinder.printSeries(tileSeriesFinder.findAllValidSets(player.getHand().getTiles()));
            System.out.println("---------------------------------");
        }

        Integer bestPlayer = analyzer.determineBestPlayer(players);


        System.out.println("Best Player ID : " + bestPlayer);
    }
}
