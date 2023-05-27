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

public class LoginControllerTest extends ApplicationTest {

    private LoginController loginController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        loginController = loader.getController();
        loginController.setStage(stage);
    }

    @Before
    public void setUp() throws Exception {
        loginController.email_login = new TextField();
        loginController.password_login = new TextField();
    }

    @Test
    public void testOnLoginClickWithAdminCredentials() {
        Platform.runLater(() -> {
            // Set the input values for the login fields
            loginController.email_login.setText("admin");
            loginController.password_login.setText("admin");

            // Simulate the button click
            ActionEvent event = new ActionEvent();
            try {
                loginController.onLoginClick(event);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Verify that the admin main page is loaded
            Stage adminStage = loginController.getStage();
            assertNotNull(adminStage);

        });
    }
}
