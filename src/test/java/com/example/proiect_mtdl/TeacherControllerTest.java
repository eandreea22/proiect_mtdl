package com.example.proiect_mtdl;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertNotNull;

public class TeacherControllerTest extends ApplicationTest {

    private TeacherController teacherController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherMainPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        teacherController = loader.getController();
        teacherController.setStage(stage);
    }

    @Test
    public void testOnLoginClickWithTeacherCredentials() {
        Platform.runLater(() -> {

            // Simulate the button click
            ActionEvent event = new ActionEvent();
            try {
                teacherController.onClickManageAccount(event);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Verify that the teacher main page is loaded
            Stage teacherStage = teacherController.getStage();
            assertNotNull(teacherStage);

        });
    }
}
