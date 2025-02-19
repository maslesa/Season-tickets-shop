/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.club;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import model.Club;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Card;

/**
 *
 * @author Ljubomir
 */
public class ClubAllSeasonTickets extends javax.swing.JFrame {

    Club club = new Club(0, "", "", "", "", "");
    Controller k = Controller.getInstance();
    TableModelAllSeasonTickets model;
    Card selectedCard;
    List<Card> cards;
    String currentSeason = makeCurrentSeason();
    List<Card> currentSeasonCards;

    /**
     * Creates new form ClubAllSeasonTickets
     */
    public ClubAllSeasonTickets(Club club) {
        initComponents();
        this.club = club;
        txtClubName.setText(club.getFullName());
        cards = new ArrayList<>();
        cards = k.getAllCards(club, "s.naziv");
        model = new TableModelAllSeasonTickets(cards);
        tableCards.setModel(model);
        tableCards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        currentSeasonCards = new ArrayList<>();
        currentSeasonCards = makeCurrentSeasonCards(cards);
        
        setLocationRelativeTo(null);
        jbtnUpdate.setVisible(false);
        jbtnDelete.setVisible(false);
        addListener();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        welcomeMessage = new javax.swing.JTextField();
        txtClubName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCards = new javax.swing.JTable();
        jbtnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbSorting = new javax.swing.JComboBox<>();
        jbtnDelete = new javax.swing.JButton();
        jcheckboxCurrentSeason = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sport tickets shop | All season tickets");
        setResizable(false);

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGoBack.setText("<");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        welcomeMessage.setEditable(false);
        welcomeMessage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcomeMessage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        welcomeMessage.setText("All season tickets");
        welcomeMessage.setBorder(null);
        welcomeMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeMessageActionPerformed(evt);
            }
        });

        txtClubName.setEditable(false);
        txtClubName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtClubName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClubName.setBorder(null);
        txtClubName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClubNameActionPerformed(evt);
            }
        });

        tableCards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableCards);

        jbtnUpdate.setText("Update season ticket");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Sort by:");

        jcbSorting.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Season", "Card type", "Card ID", "Price", "Vacances" }));

        jbtnDelete.setText("Delete season ticket");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jcheckboxCurrentSeason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcheckboxCurrentSeason.setText("Current season");
        jcheckboxCurrentSeason.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSorting, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcheckboxCurrentSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtClubName, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(welcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbSorting, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jcheckboxCurrentSeason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        ClubHomePage chp = new ClubHomePage(club);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void welcomeMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_welcomeMessageActionPerformed

    private void txtClubNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClubNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClubNameActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        ClubUpdateCard cuc = new ClubUpdateCard(selectedCard, club, 1);
        dispose();
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want delete this season ticket?", "Delete season ticket", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (k.deleteSelectedSeasonTicket(selectedCard)) {
                cards = k.getAllCards(club, "s.naziv");
                refreshTable();
                JOptionPane.showMessageDialog(rootPane, "Card deleted successfuly", "Card deleted", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jbtnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JComboBox<String> jcbSorting;
    private javax.swing.JCheckBox jcheckboxCurrentSeason;
    private javax.swing.JTable tableCards;
    private javax.swing.JTextField txtClubName;
    private javax.swing.JTextField welcomeMessage;
    // End of variables declaration//GEN-END:variables

    private void addListener() {
        tableCards.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && tableCards.getSelectedRowCount() == 1) {
                    int rowIndex = tableCards.getSelectedRow();
                    selectedCard = model.getCard(rowIndex);
                    if (checkSeasons(currentSeason, selectedCard.getSeasonName())) {
                        jbtnUpdate.setVisible(true);
                        jbtnDelete.setVisible(true);
                    } else {
                        jbtnUpdate.setVisible(false);
                        jbtnDelete.setVisible(false);
                    }
                } else {
                    jbtnUpdate.setVisible(false);
                    jbtnDelete.setVisible(false);
                }
            }

            private boolean checkSeasons(String currentSeason, String seasonName) {
                String seasonCurr = currentSeason.substring(0, 4);
                String cardSeason = seasonName.substring(0, 4);
                int current = Integer.parseInt(seasonCurr);
                int card = Integer.parseInt(cardSeason);

                if (card <= current) {
                    return false;
                }
                return true;
            }

        });

        jcbSorting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSort = (String) jcbSorting.getSelectedItem();
                System.out.println(selectedSort);
                if (selectedSort.equals("Season")) {
                    if (jcheckboxCurrentSeason.isSelected()) {
                        cards = k.getAllCards(club, "s.naziv");
                        currentSeasonCards = makeCurrentSeasonCards(cards);
                        cards = currentSeasonCards;
                        refreshTable();
                    } else {
                        cards = k.getAllCards(club, "s.naziv");
                        refreshTable();
                    }
                } else if (selectedSort.equals("Card type")) {
                    if (jcheckboxCurrentSeason.isSelected()) {
                        cards = k.getAllCards(club, "tk.naziv");
                        currentSeasonCards = makeCurrentSeasonCards(cards);
                        cards = currentSeasonCards;
                        refreshTable();
                    } else {
                        cards = k.getAllCards(club, "tk.naziv");
                        refreshTable();
                    }
                } else if (selectedSort.equals("Card ID")) {
                    if (jcheckboxCurrentSeason.isSelected()) {
                        cards = k.getAllCards(club, "k.idkarta");
                        currentSeasonCards = makeCurrentSeasonCards(cards);
                        cards = currentSeasonCards;
                        refreshTable();
                    } else {
                        cards = k.getAllCards(club, "k.idkarta");
                        refreshTable();
                    }
                } else if (selectedSort.equals("Price")) {
                    if (jcheckboxCurrentSeason.isSelected()) {
                        cards = k.getAllCards(club, "k.cena");
                        currentSeasonCards = makeCurrentSeasonCards(cards);
                        cards = currentSeasonCards;
                        refreshTable();
                    } else {
                        cards = k.getAllCards(club, "k.cena");
                        refreshTable();
                    }
                } else if (selectedSort.equals("Vacances")) {
                    if (jcheckboxCurrentSeason.isSelected()) {
                        cards = k.getAllCards(club, "k.slobodnaMesta");
                        currentSeasonCards = makeCurrentSeasonCards(cards);
                        cards = currentSeasonCards;
                        refreshTable();
                    } else {
                        cards = k.getAllCards(club, "k.slobodnaMesta");
                        refreshTable();
                    }
                }
            }

        });

        jcheckboxCurrentSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jcbSorting.setSelectedItem("Season");
                if (jcheckboxCurrentSeason.isSelected()) {
                    cards = currentSeasonCards;
                    refreshTable();
                } else {
                    cards = k.getAllCards(club, "s.naziv");
                    refreshTable();
                }
            }
        });

    }

    private void refreshTable() {
        TableModelAllSeasonTickets tas = (TableModelAllSeasonTickets) tableCards.getModel();
        tas.setCards(cards);
        tas.refreshDatas();
    }

    private String makeCurrentSeason() {
        int currentYear = LocalDateTime.now().getYear();
        int currentMonth = LocalDateTime.now().getMonthValue();

        String season;

        if (currentMonth >= 9 && currentMonth <= 12) {
            season = String.valueOf(currentYear) + "/" + String.valueOf(currentYear + 1).substring(2);
            return season;
        } else if (currentMonth >= 1 && currentMonth <= 8) {
            season = String.valueOf(currentYear - 1) + "/" + String.valueOf(currentYear).substring(2);
            return season;
        }

        return null;
    }

    private List<Card> makeCurrentSeasonCards(List<Card> cards) {
        List<Card> currSeasonCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSeasonName().equals(currentSeason)) {
                currSeasonCards.add(card);
            }
        }
        return currSeasonCards;
    }
}
