package service.evalutor;

import model.Tile;

import java.util.List;
import java.util.stream.Collectors;

public class PairEvaluator implements SeriesEvaluator {
    @Override
    public void evaluate(List<List<Tile>> seriesList, List<Tile> tiles) {
        long pairCount = tiles.stream()
                .collect(Collectors.groupingBy(Tile::getNumber))
                .values().stream()
                .filter(group -> group.size() == 2)
                .count();

        int pairCategory = 0; // pairCount'a göre kategori belirle
        if (pairCount == 2) {
            pairCategory = 1;  // Çift ihtimali %50
        } else if (pairCount >2 && pairCount <= 4) {
            pairCategory = 2;  // Çift ihtimali %70
        } else if (pairCount > 3 && pairCount <= 5) {
            pairCategory = 3;  // Çift ihtimali %80
        } else if (pairCount >= 7) {
            pairCategory = 4;  // Çift ihtimali %80
        } else {
            pairCategory = 5;  // Çift ihtimali %95
        }

        // switch yapısını kullanarak her kategoriye uygun mesajı yazdıralım
        switch (pairCategory) {
            case 1:
                System.out.println("Çift İhtimali : %35");
                break;
            case 2:
                System.out.println("Çift İhtimali : %45");
                break;
            case 3:
                System.out.println("Çift İhtimali : %75");
                break;
            case 4:
                System.out.println("Çift İhtimali : %95");
                break;
            case 5:
                System.out.println("Çift İhtimali : %0");
                break;
            default:
                System.out.println("Geçerli bir çift ihtimali bulunamadı.");
                break;
        }
    }
}
