package service.generator;

import model.Tile;

import java.util.List;

public class TilePrint {
    private TileManager tileManager;

    public TilePrint(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public void tilesPrint(List<Tile> tiles) {
        tiles.forEach(System.out::println);
    }

    public void printTilesSize(List<Tile> tiles) {
        System.out.println("Taş sayısı : " + tiles.size());
    }

    public void tilesPrintSpecific(List<Tile> tiles) {
        for (Tile tile : tiles)
            System.out.println(tile.getColor() + " -> " + tile.getNumber());
    }

    public String tilesPrintSpecificByString(List<Tile> tiles) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            stringBuilder.append(tile.getColor())
                    .append(" -> ")
                    .append(tile.getNumber());

            if (i < tiles.size() - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
