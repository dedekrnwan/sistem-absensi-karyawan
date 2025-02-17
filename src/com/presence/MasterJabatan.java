/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.presence;

import com.presence.common.koneksi;
import com.presence.common.utilities;
import com.presence.entities.departemen;
import com.presence.entities.jabatan;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adw-ahad
 */
public class MasterJabatan extends javax.swing.JPanel {

    /**
     * Creates new form MasterJabatan
     */
    
    Border textfield_border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY);
    
    HashMap<Integer, Integer> IDHolderDepartemen = new HashMap<>();
    public MasterJabatan() {
        initComponents();
        setOpaque(false);
        getDataDept();
        fillDataTable();
        
        txtId.setVisible(false);

        txtNamaJabatan.setBorder(textfield_border);      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbJabatan = new javax.swing.JTable();
        btnSimpan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnReset = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamaJabatan = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        cbLevelJabatan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbNamaDept = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(244, 244, 244));

        lbTitle.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lbTitle.setText("Master Jabatan");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbJabatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Jabatan", "Level Jabatan", "Nama Departemen"
            }
        ));
        jScrollPane1.setViewportView(tbJabatan);

        btnSimpan.setBackground(new java.awt.Color(45, 197, 112));
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simpan");

        javax.swing.GroupLayout btnSimpanLayout = new javax.swing.GroupLayout(btnSimpan);
        btnSimpan.setLayout(btnSimpanLayout);
        btnSimpanLayout.setHorizontalGroup(
            btnSimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        btnSimpanLayout.setVerticalGroup(
            btnSimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnEdit.setBackground(new java.awt.Color(229, 216, 104));
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ubah");

        javax.swing.GroupLayout btnEditLayout = new javax.swing.GroupLayout(btnEdit);
        btnEdit.setLayout(btnEditLayout);
        btnEditLayout.setHorizontalGroup(
            btnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        btnEditLayout.setVerticalGroup(
            btnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        btnHapus.setBackground(new java.awt.Color(238, 95, 95));
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hapus");

        javax.swing.GroupLayout btnHapusLayout = new javax.swing.GroupLayout(btnHapus);
        btnHapus.setLayout(btnHapusLayout);
        btnHapusLayout.setHorizontalGroup(
            btnHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        btnHapusLayout.setVerticalGroup(
            btnHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnReset.setBackground(new java.awt.Color(153, 153, 153));
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Reset");

        javax.swing.GroupLayout btnResetLayout = new javax.swing.GroupLayout(btnReset);
        btnReset.setLayout(btnResetLayout);
        btnResetLayout.setHorizontalGroup(
            btnResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        btnResetLayout.setVerticalGroup(
            btnResetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nama Jabatan");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Level Jabatan");

        txtId.setOpaque(true);

        cbLevelJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "HRD", "Manajer", "Karyawan" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nama Departemen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNamaJabatan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLevelJabatan, javax.swing.GroupLayout.Alignment.LEADING, 0, 229, Short.MAX_VALUE)
                            .addComponent(cbNamaDept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(250, 250, 250)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbLevelJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbNamaDept, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        // TODO add your handling code here:
        String id = txtId.getText();
        String nama_jabatan = txtNamaJabatan.getText();
        int role_level = getRoleLevel(cbLevelJabatan.getSelectedItem().toString());
        int dept_id = IDHolderDepartemen.get(cbNamaDept.getSelectedIndex());

        if (fieldStillEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Silakan lengkapi semua field",
                "Gagal",
                JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (id == null || id.length() == 0) { //tambah data baru
                String insQuery = "Insert into jabatan (nama_jabatan,role_level,departemen_id) VALUES (?,?,?)";
                try {
                    Connection conn = new koneksi().connect();

                    Statement st = conn.createStatement();
                    PreparedStatement preparedStatement = conn.prepareStatement(insQuery);
                    preparedStatement.setString(1, nama_jabatan);
                    preparedStatement.setInt(2, role_level);
                    preparedStatement.setInt(3, dept_id);
                    preparedStatement.executeUpdate();

                    st.close();
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Gagal",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {// update data
                String updQuery = "update jabatan SET nama_jabatan = ?,role_level=?, departemen_id = ? WHERE id =" + id;
                try {
                    Connection conn = new koneksi().connect();

                    Statement st = conn.createStatement();
                    PreparedStatement preparedStatement = conn.prepareStatement(updQuery);
                    preparedStatement.setString(1, nama_jabatan);
                    preparedStatement.setInt(2, role_level);
                    preparedStatement.setInt(3, dept_id);

                    preparedStatement.executeUpdate();

                    st.close();
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Gagal",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(null,
            "Berhasil simpan data!",
            "Sukses",
            JOptionPane.INFORMATION_MESSAGE);
        fillDataTable();
        clearAllFields();
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        int index = tbJabatan.getSelectedRow();
        if (index >= 0) {
            fillDataField(index);
        } else {
            JOptionPane.showMessageDialog(null,
                "Harap pilih data untuk diubah",
                "Peringatan",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
        int index = tbJabatan.getSelectedRow();
        if (index >= 0) {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(utilities.getVisibleWindow(), "Anda yakin untuk menghapus data?", "Peringatan", dialogBtn);

            if (dialogResult == 0) {
                deleteData(index);
                JOptionPane.showMessageDialog(null,
                    "Data berhasil dihapus!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                fillDataTable();
                clearAllFields();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                "Harap pilih data untuk dihapus",
                "Peringatan",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        clearAllFields();
    }//GEN-LAST:event_btnResetMouseClicked

    private void fillDataTable() {
        ArrayList<jabatan> data = getDataJabatan();
        DefaultTableModel model = (DefaultTableModel) tbJabatan.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < data.size(); i++) {
            row[0] = data.get(i).getId();
            row[1] = data.get(i).getNama_jabatan();
            row[2] = data.get(i).getNama_level();
            row[3] = data.get(i).getNama_dept();
            model.addRow(row);
        }
    }
    
    private void fillDataField(int index) {
        int id = getDataJabatan().get(index).getId();
        txtId.setText(Integer.toString(id));
        txtNamaJabatan.setText(getDataJabatan().get(index).getNama_jabatan());
        cbLevelJabatan.setSelectedItem(getDataJabatan().get(index).getNama_level());
        cbNamaDept.setSelectedItem(getDataJabatan().get(index).getNama_dept());
    }    
    
    private void deleteData(int index) {
        int id = getDataJabatan().get(index).getId();
        txtId.setText(Integer.toString(id));

        String delQuery = "delete from jabatan where id=?";
        try {
            Connection conn = new koneksi().connect();
            Statement st = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(delQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Gagal",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    

    private ArrayList<jabatan> getDataJabatan() {
        ArrayList<jabatan> data = new ArrayList();
        try {
            Connection conn = new koneksi().connect();

            Statement st = conn.createStatement();
            String sql = "select j.id, j.nama_jabatan, j.role_level, j.departemen_id, "
                    + "CASE role_level WHEN 1 THEN 'Admin' WHEN 2 THEN 'HRD' WHEN 3 THEN 'Manajer' WHEN 4 THEN 'Karyawan' END as nama_level, d.nama_dept "
                    + "from jabatan j join departemen d on j.departemen_id = d.id;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            int idx = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                jabatan jbt = new jabatan(rs.getInt("id"), rs.getString("nama_jabatan"),
                        rs.getInt("role_level"), rs.getInt("departemen_id"), rs.getString("nama_level"), rs.getString("nama_dept"));
                data.add(jbt);
//                jComboBox1.addItem(rs.getString("nama_lengkap")); //Name Column Value
//                IDHolderManager.put(idx, rs.getInt("id")); //ID Column Value
                idx++;
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Gagal",
                        JOptionPane.ERROR_MESSAGE);
                    
        }
        return data;
    }    
    
    private void getDataDept() {
        try {
            Connection conn = new koneksi().connect();

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM departemen";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            int idx = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                cbNamaDept.addItem(rs.getString("nama_dept")); //Name Column Value
                IDHolderDepartemen.put(idx, rs.getInt("id")); //ID Column Value
                idx++;
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Gagal",
                        JOptionPane.ERROR_MESSAGE);
                    return;
        }
    }    
    
    private int getRoleLevel(String level){
        switch(level){
            case "Admin":
                return 1;
            case "HRD":
                return 2;
            case "Manajer":
                return 3;
            case "Karyawan":
                return 4;
            default:
                return 0;
        }
    }
    
    private boolean fieldStillEmpty() {
        return txtNamaJabatan.getText() == null || txtNamaJabatan.getText().length() == 0;
    }    
    
    private void clearAllFields() {
        txtId.setText("");
        txtNamaJabatan.setText("");
        cbNamaDept.removeAllItems();
        getDataDept();
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEdit;
    private javax.swing.JPanel btnHapus;
    private javax.swing.JPanel btnReset;
    private javax.swing.JPanel btnSimpan;
    private javax.swing.JComboBox<String> cbLevelJabatan;
    private javax.swing.JComboBox<String> cbNamaDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTable tbJabatan;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNamaJabatan;
    // End of variables declaration//GEN-END:variables
}
