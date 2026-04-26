package com.example.tp2.views;

import com.example.tp2.model.Grille;
import com.example.tp2.model.Mecanisme;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.application.Platform;

public class JeuView extends BorderPane {

    private Grille grille;
    private Mecanisme mecanisme;

    private Label info;
    private Label diceInfo;

    private ImageView playerPawn;
    private ImageView cpuPawn;

    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 10;

    public JeuView() {

        grille = new Grille();
        mecanisme = new Mecanisme(grille);

        info = new Label("Tour du joueur");
        diceInfo = new Label("Lancez le dé !");
        diceInfo.setStyle("-fx-font-size: 14px; -fx-text-alignment: center;");
        diceInfo.setWrapText(true);

        ImageView board = new ImageView(
                new Image(getClass().getResource("/board.png").toExternalForm())
        );

        board.setPreserveRatio(true);

        // leave space for left menu + right panel
        board.fitWidthProperty().bind(this.widthProperty().subtract(200));
        // leave space for top menu
        board.fitHeightProperty().bind(this.heightProperty().subtract(100));

        playerPawn = new ImageView(
                new Image(getClass().getResource("/player.png").toExternalForm())
        );
        cpuPawn = new ImageView(
                new Image(getClass().getResource("/cpu.png").toExternalForm())
        );

        playerPawn.setFitWidth(40);
        playerPawn.setFitHeight(40);
        cpuPawn.setFitWidth(40);
        cpuPawn.setFitHeight(40);

        Pane layer = new Pane(playerPawn, cpuPawn);

        // Make layer follow board size
        layer.setPickOnBounds(false);
        layer.prefWidthProperty().bind(board.fitWidthProperty());
        layer.prefHeightProperty().bind(board.fitHeightProperty());

        layer.widthProperty().addListener((obs, oldVal, newVal) -> {
            movePawn(playerPawn, mecanisme.getPositionJoueur());
            movePawn(cpuPawn, mecanisme.getPositionOrdinateur());
        });

        layer.heightProperty().addListener((obs, oldVal, newVal) -> {
            movePawn(playerPawn, mecanisme.getPositionJoueur());
            movePawn(cpuPawn, mecanisme.getPositionOrdinateur());
        });

        StackPane boardContainer = new StackPane(board, layer);
        boardContainer.setAlignment(Pos.CENTER);

        Platform.runLater(() -> {
            movePawn(playerPawn, mecanisme.getPositionJoueur());
            movePawn(cpuPawn, mecanisme.getPositionOrdinateur());
        });

        Button lancer = new Button("Lancer le dé");

        lancer.setOnAction(e -> {

            // PLAYER TURN
            int de = mecanisme.lancerDe();
            mecanisme.deplacerJoueur(de);

            int posJoueur = mecanisme.getPositionJoueur();
            movePawn(playerPawn, posJoueur);

            if (mecanisme.verifierVictoire()) {
                diceInfo.setText("Joueur: " + de + " → position 100");
                showWin("Joueur");
                return;
            }

            // CPU TURN
            int deAI = mecanisme.lancerDe();
            mecanisme.deplacerOrdinateur(deAI);

            int posCPU = mecanisme.getPositionOrdinateur();
            movePawn(cpuPawn, posCPU);

            if (mecanisme.verifierVictoire()) {
                diceInfo.setText(
                        "Joueur: " + de + " → position " + posJoueur + "\n" +
                                "Ordinateur: " + deAI + " → position 100"
                );
                showWin("Ordinateur");
                return;
            }

            // UPDATE DISPLAY
            diceInfo.setText(
                    "Joueur: " + de + " → position " + posJoueur + "\n" +
                            "Ordinateur: " + deAI + " → position " + posCPU
            );
        });

        // RIGHT SIDE (button + info)
        Button restart = new Button("Recommencer");
        restart.setOnAction(e -> restartGame());

        VBox right = new VBox(10, lancer, restart, diceInfo);
        right.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);

        this.setTop(info);
        this.setCenter(boardContainer);
        this.setRight(right);
    }

    //Fonction pour le mouvement des pions
    private void movePawn(ImageView pawn, int position) {

        int row = (position - 1) / BOARD_SIZE;
        int col = (position - 1) % BOARD_SIZE;

        if (row % 2 == 1) {
            col = BOARD_SIZE - 1 - col;
        }

        Pane parent = (Pane) pawn.getParent();

        double width = parent.getWidth();
        double height = parent.getHeight();

        // Pour prendre en charge les marge entre les cases
        double marginX = width * 0.08;
        double marginY = height * 0.05;

        double gridWidth = width - (2 * marginX);
        double gridHeight = height - (2 * marginY);

        double tileWidth = gridWidth / BOARD_SIZE;
        double tileHeight = gridHeight / BOARD_SIZE;

        double x = marginX + col * tileWidth + (tileWidth - pawn.getFitWidth()) / 2;
        double y = marginY + (BOARD_SIZE - 1 - row) * tileHeight + (tileHeight - pawn.getFitHeight()) / 2;

        pawn.setLayoutX(x);
        pawn.setLayoutY(y);
    }

    //Fonction pour le pop-up the victoire
    private void showWin(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Victoire");
        alert.setHeaderText(null);
        alert.setContentText(winner + " gagne !");
        alert.showAndWait();
    }

    //FOnction pour reset le jeu sans devoir changer de scene
    private void restartGame() {
        mecanisme = new Mecanisme(new Grille());

        movePawn(playerPawn, mecanisme.getPositionJoueur());
        movePawn(cpuPawn, mecanisme.getPositionOrdinateur());

        info.setText("Tour du joueur");
        diceInfo.setText("Lancez le dé !");
    }
}