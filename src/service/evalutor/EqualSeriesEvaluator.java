package service.evalutor;

import model.Tile;

import java.util.List;

public class EqualSeriesEvaluator implements SeriesEvaluator{
    @Override
    public void evaluate(List<List<Tile>> seriesList, List<Tile> tiles) {
        if (seriesList.size() == 3) {
            System.out.println("Seri sayısı eşit, okeyi stratejik kullanarak yeni seriler oluşturabiliriz.");
            // Eşit seri sayısında okey kullanımı veya mevcut serileri tamamlayacak şekilde yeni setler eklenebilir.
        }
    }
}
