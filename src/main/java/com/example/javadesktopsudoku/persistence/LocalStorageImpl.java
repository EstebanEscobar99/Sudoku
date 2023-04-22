package com.example.javadesktopsudoku.persistence;

import com.example.javadesktopsudoku.services.IStorage;
import com.example.javadesktopsudoku.services.sudokuGame;

import java.io.*;

public class LocalStorageImpl implements IStorage {

    private static File GAME_DATA = new File(
            System.getProperty("user.home"),
            "gamedata.txt"
    );

    @Override
    public void updateGameData(sudokuGame game) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException exception) {
            throw new IOException("Unable to access Game Data");
        }
    }

    @Override
    public sudokuGame getGameData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            sudokuGame gameState = (sudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            throw new IOException("File Not Found");
        }
    }
}
