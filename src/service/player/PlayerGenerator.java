package service.player;

import model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerGenerator extends PlayerManager{
    @Override
    public List<Player> generatePlayers(int numberOfPlayers){
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player(i));
        }
        return players;
    }

}
