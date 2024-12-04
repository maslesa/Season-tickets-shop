/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import models.Fan;
import gui.login.LoginPage;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Card;
import models.CardType;
import models.Club;
import models.Season;

/**
 *
 * @author Ljubomir
 */
public class DBBroker {

    public boolean userExistsLogin(String inputUsername, String inputPassword) {
        try {
            System.out.println("db.DBBroker.userExistsLogin()");

            String query = "SELECT username, password FROM navijac";

            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean ClubExistsLogin(String inputUsername, String inputPassword) {

        try {
            System.out.println("db.DBBroker.ClubExistsLogin()");

            String query = "SELECT username, password FROM klub";

            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Fan fillVariables(String inputUsername) {

        Fan fan = new Fan("", "", "", "", LocalDate.MIN, "", "");

        try {
            System.out.println("db.DBBroker.fillVariables()");

            String query = "SELECT * FROM navijac WHERE username = ?";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, inputUsername);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fan.setIdNavijac(rs.getInt("idNavijac"));
                fan.setName(rs.getString("name"));
                fan.setSurname(rs.getString("surname"));
                fan.setUsername(rs.getString("username"));
                fan.setEmail(rs.getString("email"));
                Date birthdayDate = rs.getDate("birthday");
                LocalDate birthday = birthdayDate.toLocalDate();
                fan.setBirthday(birthday);
                fan.setPhone(rs.getString("phone"));
                fan.setPassword(rs.getString("password"));
                System.out.println("id:" + fan.getIdNavijac() + " name:" + fan.getName() + "surname:" + fan.getSurname() + "username:" + inputUsername);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fan;
    }

    public boolean addNewNavijac(Fan fan) {

        try {

            System.out.println("db.DBBroker.addNewNavijac()");

            String query = "INSERT INTO navijac (name, surname, username, email, birthday, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);

            ps.setString(1, fan.getName());
            ps.setString(2, fan.getSurname());
            ps.setString(3, fan.getUsername());
            ps.setString(4, fan.getEmail());
            ps.setDate(5, java.sql.Date.valueOf(fan.getBirthday()));
            ps.setString(6, fan.getPhone());
            ps.setString(7, fan.getPassword());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User added", "Successful", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "User not added", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }

        return false;

    }

    public List<String> getAllFansUsernames() {
        List<String> allUsernames = new ArrayList<>();
        try {
            String query = "SELECT username FROM navijac";

            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");

                allUsernames.add(username);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Napunjena lista");
        return allUsernames;
    }

    public void updatePassword(String newPassword, Fan fan) {
        try {
            String query = "UPDATE navijac SET password = ? WHERE idNavijac = ?";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setInt(2, fan.getIdNavijac());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateDatasInBase(String newName, String newSurname, String newUsername, String newEmail, String newPhone, Fan fan) {
        try {
            String query = "UPDATE navijac SET name = ?, surname = ?, username = ?, email = ?, phone = ? WHERE idNavijac = ?";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);

            ps.setString(1, newName);
            ps.setString(2, newSurname);
            ps.setString(3, newUsername);
            ps.setString(4, newEmail);
            ps.setString(5, newPhone);
            ps.setInt(6, fan.getIdNavijac());

            int ra = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Season> getAllSeasons() {
        List<Season> sezone = new ArrayList<>();
        try {
            String query = "SELECT * FROM sezona";

            Statement st = Konekcija.getInstance().getCon().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idsezona");
                String naziv = rs.getString("naziv");

                Season newSeason = new Season(id, naziv);

                sezone.add(newSeason);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sezone;
    }

    public List<Club> getAllClubs() {
        List<Club> clubs = new ArrayList<>();
        try {
            String query = "SELECT * FROM klub";

            Statement st = Konekcija.getInstance().getCon().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idKlub");
                String username = rs.getString("username");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                Club newClub = new Club(id, username, password, fullName, email, phone);

                clubs.add(newClub);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubs;
    }

    public List<CardType> getAllCardTypes() {
        List<CardType> cardTypes = new ArrayList<>();
        try {
            String query = "SELECT * FROM tipkarte";

            Statement st = Konekcija.getInstance().getCon().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idTipKarte");
                String naziv = rs.getString("naziv");

                CardType newCardType = new CardType(id, naziv);

                cardTypes.add(newCardType);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cardTypes;
    }

    public Club fillVariablesClub(String inputUsername) {
        Club club = new Club(0, "", "", "", "", "");
        try {

            String query = "SELECT * FROM klub WHERE username = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, inputUsername);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                club.setIdKlub(rs.getInt("idKlub"));
                club.setUsername(rs.getString("username"));
                club.setFullName(rs.getString("fullName"));
                club.setSifra(rs.getString("password"));
                club.setEmail(rs.getString("email"));
                club.setPhone(rs.getString("phone"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return club;
    }

    public boolean insertNewCard(Card newCard) {
        try {
            String query = "INSERT INTO karta(cena, slobodnaMesta, idKlub, idSezona, idTipKarta) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setDouble(1, newCard.getPrice());
            ps.setInt(2, newCard.getVacances());
            ps.setInt(3, newCard.getIdClub());
            ps.setInt(4, newCard.getIdSeason());
            ps.setInt(5, newCard.getIdCardType());
            int ra = ps.executeUpdate();

            if (ra > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<Card> getAllCards(Club club) {
        List<Card> cards = new ArrayList<>();
        try {
            String query = "SELECT k.idkarta, s.naziv, tk.naziv, k.cena, k.slobodnaMesta FROM karta k JOIN klub kl on (k.idKlub = kl.idKlub) JOIN sezona s on (k.idSezona = s.idsezona) join tipkarte tk on (k.idTipKarta = tk.idTipKarte) where k.idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cardID = rs.getInt("k.idkarta");
                String seasonName = rs.getString("s.naziv");
                String cardTypeName = rs.getString("tk.naziv");
                double price = rs.getDouble("k.cena");
                int vacances = rs.getInt("k.slobodnaMesta");
                Card card = new Card(cardID, price, vacances, seasonName, cardTypeName);
                cards.add(card);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cards;

    }

    public List<Card> getAllCardsNew(Club club) {
        List<Card> cards = new ArrayList<>();
        try {
            String query = "SELECT * FROM karta WHERE idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cardID = rs.getInt("idkarta");
                double price = rs.getDouble("cena");
                int vacances = rs.getInt("slobodnaMesta");
                int idClub = rs.getInt("idKlub");
                int idSeason = rs.getInt("idSezona");
                int idCardType = rs.getInt("idTipKarta");
                Card card = new Card(cardID, price, vacances, idSeason, idClub, idCardType);
                cards.add(card);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cards;
    }

}
