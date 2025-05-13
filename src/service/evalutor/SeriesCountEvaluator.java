package service.evalutor;

import model.Tile;

import java.util.List;

public class SeriesCountEvaluator implements SeriesEvaluator {
    @Override
    public void evaluate(List<List<Tile>> seriesList, List<Tile> tiles) {
        int seriesCount = seriesList.size();
        int seriesCategory;

        if (seriesCount == 1) {
            seriesCategory = 1;  // Seri ihtimali %40
        } else if (seriesCount == 2) {
            seriesCategory = 2;  // Seri ihtimali %60
        } else if (seriesCount == 3) {
            seriesCategory = 3;  // Seri ihtimali %80
        } else if (seriesCount >= 4) {
            seriesCategory = 4;  // Seri ihtimali %95
        } else {
            seriesCategory = 0;  // Seri bulunamadı
        }

        switch (seriesCategory) {
            case 1:
                System.out.println("Seri İhtimali : %40");
                break;
            case 2:
                System.out.println("Seri İhtimali : %60");
                break;
            case 3:
                System.out.println("Seri İhtimali : %80");
                break;
            case 4:
                System.out.println("Seri İhtimali : %95");
                break;
            default:
                System.out.println("Seri İhtimali : %20");
                break;
        }
    }
}
