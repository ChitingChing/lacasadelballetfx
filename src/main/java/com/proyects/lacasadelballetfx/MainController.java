/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyects.lacasadelballetfx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author chiti
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            Pane box= FXMLLoader.load(getClass().getResource("/fxml/DrawerContent.fxml")) ;
            //VBox box2= FXMLLoader.load(getClass().getResource("/fxml/DrawerContent.fxml")) ;
            
            drawer.setSidePane(box);
            //drawer.setContent(box2);
            HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
            burgerTask.setRate(-1);
            hamburger.addEventFilter(MouseEvent.MOUSE_PRESSED,(e)->{
                burgerTask.setRate(burgerTask.getRate()*-1);
                burgerTask.play();
                if(drawer.isShown())
                    drawer.close();
                else
                    drawer.open();
            });
        }catch(IOException ex){}
    }

}
