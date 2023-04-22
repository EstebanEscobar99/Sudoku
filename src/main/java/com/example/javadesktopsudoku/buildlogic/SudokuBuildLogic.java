package com.example.javadesktopsudoku.buildlogic;

import com.example.javadesktopsudoku.computationlogic.GameLogic;
import com.example.javadesktopsudoku.persistence.LocalStorageImpl;
import com.example.javadesktopsudoku.services.IStorage;
import com.example.javadesktopsudoku.services.sudokuGame;
import com.example.javadesktopsudoku.userinterface.IUserInterfaceContract;
import com.example.javadesktopsudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        sudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException exception) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
