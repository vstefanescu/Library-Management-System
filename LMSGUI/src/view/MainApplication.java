package view;

import controller.BookController;
import model.Book;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApplication extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Label nameLabel = new Label("Book Name:");
		TextField nameField = new TextField();
		
		Label authorLabel = new Label("Author:");
		TextField authorField = new TextField();

		Label yearLabel = new Label("Year:");
		TextField yearField = new TextField();
		
		
		Button addButton = new Button("| Add Book |");
		
		BookController bookController = new BookController();
		
		addButton.setOnAction(event -> {
			String title = nameField.getText();
			String author = authorField.getText();
			int year = Integer.parseInt(yearField.getText());
			
			Book book = new Book(title, author, year);
			bookController.addBook(book);
			
			System.out.println("Book added: " + book.getTitle());
		});
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(10));
		root.setHgap(10);
		root.setVgap(10);
		
		root.add(nameLabel, 0, 0);
		root.add(nameField, 1, 0);
		root.add(authorLabel, 0, 1);
		root.add(authorField, 1, 1);
		root.add(yearLabel, 0, 2);
		root.add(yearField, 1, 2);
		root.add(addButton, 0, 3, 2, 1);
		
		GridPane.setHalignment(addButton, javafx.geometry.HPos.CENTER);
		
		Scene scene = new Scene(root, 400, 200);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Library Management System");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
