package service.evalutor;

import model.Tile;

import java.util.List;

public interface SeriesEvaluator {
    void evaluate(List<List<Tile>> seriesList, List<Tile> tiles);
}
