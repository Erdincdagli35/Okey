package service.finder;

import model.Tile;

import java.util.List;
import java.util.Set;

public interface TileStrategy {
    List<List<Tile>> findTiles(List<Tile> tiles, Set<Tile> usedTiles);
}
