package com.example.csit228_f1_v2;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.Optional;
import javafx.scene.control.Alert;

import java.util.concurrent.atomic.AtomicReference;

public class crudApplication {
    public TextField textFieldName;
    public TextField textFieldEmail;
    public TextField textFieldAddress;
    public TextField textFieldUsername;

    public TextField textFieldId;
    public PasswordField textFieldPassword;

    @FXML
    protected void btnUpdateClick() {
        Optional<String> result = diaUtil.showUpdateDialog("Update Record", "Enter ID to Update", "Please enter the ID:");

        AtomicReference<Optional<String>> newName = new AtomicReference<>(Optional.empty());
        AtomicReference<Optional<String>> newEmail = new AtomicReference<>(Optional.empty());
        AtomicReference<Optional<String>> newAddress = new AtomicReference<>(Optional.empty());

        result.ifPresent(id -> {
            if (!id.isEmpty()) {
                newName.set(diaUtil.showInputDialog("Update Name", "Enter New Name", "Enter the new name:"));
                newEmail.set(diaUtil.showInputDialog("Update Email", "Enter New Email", "Enter the new email:"));
                newAddress.set(diaUtil.showInputDialog("Update Address", "Enter New Address", "Enter the new address:"));

                newName.get().ifPresent(name -> {
                    newEmail.get().ifPresent(email -> {
                        newAddress.get().ifPresent(address -> {
                            tablecrud.update(id, name, email, address);
                        });
                    });
                });
            } else {
                diaUtil.showAlert(Alert.AlertType.WARNING, "Updating Failed", "ID is Empty", "Please enter a valid ID.");
            }
        });
    }


    @FXML
    protected void btnReadClick() {
        Optional<String> result = diaUtil.showInputDialog("Read Record", "Enter ID to Read", "Please enter the ID:");

        result.ifPresent(id -> {
            if (!id.isEmpty()) {
                tablecrud.read(id);
            } else {
                diaUtil.showAlert(Alert.AlertType.WARNING, "Reading Failed", "ID is Empty", "Please enter a valid ID.");
            }
        });
    }

    @FXML
    protected void btnDeleteClick() {
        Optional<String> result = diaUtil.showInputDialog("Delete Record", "Enter ID to Delete", "Please enter the ID:");

        result.ifPresent(id -> {
            if (!id.isEmpty()) {
                if(tablecrud.delete(id))
                    diaUtil.showAlert(Alert.AlertType.INFORMATION, "Delete Successful", "Record Deleted", "Record with ID " + id + " has been deleted.");
            } else {
                diaUtil.showAlert(Alert.AlertType.WARNING, "Delete Failed", "ID is Empty", "Please enter a valid ID.");
            }
        });
    }

    @FXML
    protected void btnRegisterClick() {
        if (textFieldEmail.getLength() == 0) {
            System.out.println("Please Enter Details");
            return;
        }
        boolean success = false;
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO tblaccounts(name, email, address) VALUES (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS
             )) {
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String address = textFieldAddress.getText();
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, address);
            int rows = statement.executeUpdate();
            if (rows != 0) {
                success = true;
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int accountId = generatedKeys.getInt(1);
                    // Insert into tblusers with the obtained accountId as id_fk
                    insertIntoUsers(accountId);
                }
            }
            System.out.println("Rows Inserted: " + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertIntoUsers(int accountId) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO tblusers(username, password, id_fk) VALUES (?, ?, ?)"
             )) {
            String username = textFieldUsername.getText();
            String password = textFieldPassword.getText();
            String hashPass = String.valueOf(password.hashCode());
            statement.setString(1, username);
            statement.setString(2, hashPass);
            statement.setInt(3, accountId); // Use accountId as id_fk
            int rows = statement.executeUpdate();
            System.out.println("Rows Inserted into tblusers: " + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}