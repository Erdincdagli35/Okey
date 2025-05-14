package manager.indicator;

import model.Tile;

import java.util.List;

public interface IndicatorManager {
    IndicatorResult selectIndicator(List<Tile> tiles);
}
