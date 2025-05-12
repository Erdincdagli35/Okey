package service.generator;

import model.Color;
import model.Tile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TileGenerator implements TileManager {
    @Override
    public List<Tile> generateTiles() {
        List<Tile> tiles = Arrays.stream(Color.values())
                .filter(color -> color != Color.SAHTE)
                .flatMap(color ->
                        IntStream.rangeClosed(1, 13)
                                .mapToObj(number -> new Tile(color, number, false))
                                .flatMap(tile -> Stream.of(tile, tile))
                )
                .collect(Collectors.toList());

        generateFakeOkeyTiles(tiles);

        Collections.shuffle(tiles);

        return tiles;
    }

    private void generateFakeOkeyTiles(List<Tile> tiles) {
        Tile fakeOkey = new Tile(Color.SAHTE, -1, true);
        tiles.add(fakeOkey);
        tiles.add(fakeOkey);
    }
}
