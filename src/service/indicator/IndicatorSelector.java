package service.indicator;

import model.Tile;

import java.util.List;
import java.util.Random;

public class IndicatorSelector implements IndicatorManager {
    private final Random random = new Random();

    @Override
    public IndicatorResult selectIndicator(List<Tile> tiles) {
        Tile indicator;
        do {
            indicator = tiles.get(random.nextInt(tiles.size()));
        }while (indicator.isFake());

        Tile okeyTile = determineOkeyTile(indicator);
        return new IndicatorResult(indicator, okeyTile);
    }

    private Tile determineOkeyTile(Tile indicator){
        int nextNumber = indicator.getNumber() == 13 ? 1 : indicator.getNumber() + 1;
        return new Tile(indicator.getColor(), nextNumber, false);
    }
}
