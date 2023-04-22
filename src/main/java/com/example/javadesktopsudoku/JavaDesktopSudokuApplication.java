package com.example.javadesktopsudoku;

import com.example.javadesktopsudoku.buildlogic.SudokuBuildLogic;
import com.example.javadesktopsudoku.userinterface.IUserInterfaceContract;
import com.example.javadesktopsudoku.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JavaDesktopSudokuApplication extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws Exception {
        uiImpl = new UserInterfaceImpl(primaryStage);
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
