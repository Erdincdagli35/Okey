package service.player;

import model.Player;

import java.util.List;

public abstract class PlayerManager {
    public abstract List<Player> generatePlayers(int numberOfPlayers);
}
