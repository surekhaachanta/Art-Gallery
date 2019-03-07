package artist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class ArtGallery extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArtGallery(JFrame frame) {

		JTabbedPane tabbedPane = new JTabbedPane();
		Color color = new Color(40, 191, 90);
		tabbedPane.setBackground(color);
		tabbedPane.setForeground(Color.WHITE);

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 10, 80, 25);
		nameLabel.setOpaque(true);
		nameLabel.setForeground(color);
		panel1.add(nameLabel);

		JTextField nameText = new JTextField(20);
		nameText.setBounds(100, 10, 160, 25);
		panel1.add(nameText);

		JLabel birthPlace = new JLabel("birthPlace");
		birthPlace.setBounds(10, 40, 80, 25);
		birthPlace.setForeground(color);
		panel1.add(birthPlace);

		JTextField birthPlaceText = new JTextField(20);
		birthPlaceText.setBounds(100, 40, 160, 25);
		panel1.add(birthPlaceText);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(10, 70, 80, 25);
		ageLabel.setForeground(color);
		panel1.add(ageLabel);

		JTextField ageText = new JTextField(20);
		ageText.setBounds(100, 70, 160, 25);
		panel1.add(ageText);

		JLabel styleLabel = new JLabel("Style");
		styleLabel.setBounds(10, 100, 80, 25);
		styleLabel.setForeground(color);
		panel1.add(styleLabel);

		JTextField styleText = new JTextField(20);
		styleText.setBounds(100, 100, 160, 25);
		panel1.add(styleText);

		JButton addButton = new JButton("Add");
		addButton.setBounds(10, 130, 80, 25);
		addButton.setBackground(color);
		addButton.setForeground(Color.white);
		panel1.add(addButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(180, 130, 80, 25);
		clearButton.setBackground(color);
		clearButton.setForeground(Color.white);
		panel1.add(clearButton);

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameText.setText("");
				birthPlaceText.setText("");
				ageText.setText("");
				styleText.setText("");
				// textfield.setText(null); //or use this
			}
		});
		frame.add(panel1);
		tabbedPane.addTab("Add Artist", panel1);
		panel1.setPreferredSize(new Dimension(550, 350));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.AddArtist(nameText.getText(), birthPlaceText.getText(), ageText.getText(),
						styleText.getText());

			}
		});

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);

		JLabel custLabel = new JLabel("CustId");
		custLabel.setBounds(10, 10, 80, 25);
		custLabel.setOpaque(true);

		custLabel.setForeground(color);
		panel2.add(custLabel);

		JTextField custIdText = new JTextField(20);
		custIdText.setBounds(100, 10, 160, 25);
		panel2.add(custIdText);

		JLabel custNameLabel = new JLabel("CName");
		custNameLabel.setBounds(10, 40, 80, 25);
		custNameLabel.setOpaque(true);

		custNameLabel.setForeground(color);
		panel2.add(custNameLabel);

		JTextField custNameText = new JTextField(20);
		custNameText.setBounds(100, 40, 160, 25);
		panel2.add(custNameText);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 70, 80, 25);
		addressLabel.setOpaque(true);

		addressLabel.setForeground(color);
		panel2.add(addressLabel);

		JTextField addressText = new JTextField(20);
		addressText.setBounds(100, 70, 160, 25);
		panel2.add(addressText);

		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(10, 100, 80, 25);
		amountLabel.setOpaque(true);

		amountLabel.setForeground(color);
		panel2.add(amountLabel);

		JTextField amountText = new JTextField(20);
		amountText.setBounds(100, 100, 160, 25);
		panel2.add(amountText);

		JButton addCusButton = new JButton("Add");
		addCusButton.setBounds(10, 130, 80, 25);
		addCusButton.setBackground(color);
		addCusButton.setForeground(Color.white);
		panel2.add(addCusButton);

		JButton clearcusButton = new JButton("Clear");
		clearcusButton.setBounds(180, 130, 80, 25);
		clearcusButton.setBackground(color);
		clearcusButton.setForeground(Color.white);
		panel2.add(clearcusButton);

		clearcusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custIdText.setText("");
				custNameText.setText("");
				amountText.setText("");
				addressText.setText("");
			}
		});

		frame.add(panel2);
		tabbedPane.addTab("Add Customer", panel2);

		addCusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.AddCustomer(custIdText.getText(), custNameText.getText(), addressText.getText(),
						amountText.getText());

			}
		});

		JPanel panel3 = new JPanel();
		panel3.setLayout(null);

		JLabel headingLabel = new JLabel("To Add Artist: ");
		headingLabel.setBounds(10, 10, 80, 25);
		panel3.add(headingLabel);

		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(10, 40, 80, 25);
		titleLabel.setOpaque(true);

		titleLabel.setForeground(color);
		panel3.add(titleLabel);

		JTextField titleText = new JTextField(20);
		titleText.setBounds(100, 40, 160, 25);
		panel3.add(titleText);

		JLabel awYearLabel = new JLabel("Year");
		awYearLabel.setBounds(10, 70, 80, 25);
		awYearLabel.setOpaque(true);

		awYearLabel.setForeground(color);
		panel3.add(awYearLabel);

		JTextField awYearText = new JTextField(20);
		awYearText.setBounds(100, 70, 160, 25);
		panel3.add(awYearText);

		JLabel typeLabel = new JLabel("Type");
		typeLabel.setBounds(10, 100, 80, 25);
		typeLabel.setOpaque(true);

		typeLabel.setForeground(color);
		panel3.add(typeLabel);

		JTextField typeText = new JTextField(20);
		typeText.setBounds(100, 100, 160, 25);
		panel3.add(typeText);

		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(10, 130, 80, 25);
		priceLabel.setOpaque(true);

		priceLabel.setForeground(color);
		panel3.add(priceLabel);

		JTextField priceText = new JTextField(20);
		priceText.setBounds(100, 130, 160, 25);
		panel3.add(priceText);

		JLabel aNameLabel = new JLabel("AName");
		aNameLabel.setBounds(10, 160, 80, 25);
		aNameLabel.setOpaque(true);
		aNameLabel.setForeground(color);
		panel3.add(aNameLabel);

		JTextField aNameText = new JTextField(20);
		aNameText.setBounds(100, 160, 160, 25);
		panel3.add(aNameText);

		JButton addArtWorkButton = new JButton("Add Artist");
		addArtWorkButton.setBounds(10, 190, 100, 25);
		addArtWorkButton.setBackground(color);
		addArtWorkButton.setForeground(Color.white);
		panel3.add(addArtWorkButton);

		JButton clearAWButton = new JButton("Clear");
		clearAWButton.setBounds(180, 190, 80, 25);
		clearAWButton.setBackground(color);
		clearAWButton.setForeground(Color.white);
		panel3.add(clearAWButton);

		clearAWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleText.setText("");
				awYearText.setText("");
				typeText.setText("");
				priceText.setText("");
				aNameText.setText("");
			}
		});

		addArtWorkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.AddArtWork(titleText.getText(), awYearText.getText(), typeText.getText(),
						priceText.getText(), aNameText.getText());

			}
		});

		JLabel headingGroupLabel = new JLabel();
		headingGroupLabel.setText("To Add Group:");
		headingGroupLabel.setBounds(320, 10, 80, 25);
		panel3.add(headingGroupLabel);

		JLabel GroupNameLabel = new JLabel();
		JTextField gNameText = new JTextField(20);

		GroupNameLabel.setBounds(320, 40, 80, 25);
		// GroupNameLabel.setOpaque(true);
		GroupNameLabel.setForeground(color);
		gNameText.setBounds(370, 40, 100, 25);

		JButton addGroupButton = new JButton("Add Group");
		addGroupButton.setBounds(300, 70, 120, 25);
		addGroupButton.setBackground(color);
		addGroupButton.setForeground(Color.white);

		JButton clearGroupButton = new JButton("Clear");
		clearGroupButton.setBounds(430, 70, 80, 25);
		clearGroupButton.setBackground(color);
		clearGroupButton.setForeground(Color.white);
		panel3.add(clearGroupButton);

		GroupNameLabel.setText("GName:");
		panel3.add(GroupNameLabel);
		panel3.add(gNameText);
		panel3.add(addGroupButton);

		addGroupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.insertGroup(gNameText.getText());

			}
		});

		clearGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gNameText.setText("");
			}
		});

		JLabel headingClassifyLabel = new JLabel();
		headingClassifyLabel.setText("To Add Classify:");
		headingClassifyLabel.setBounds(320, 120, 120, 25);
		panel3.add(headingClassifyLabel);

		JLabel titleClyLable = new JLabel();
		titleClyLable.setBounds(320, 150, 80, 25);
		titleClyLable.setForeground(color);
		titleClyLable.setText("Title:");

		JTextField titleClyText = new JTextField(20);
		titleClyText.setBounds(370, 150, 100, 25);

		JLabel gNameCLable = new JLabel();
		gNameCLable.setBounds(320, 180, 80, 25);
		gNameCLable.setForeground(color);
		gNameCLable.setText("GName:");

		JTextField gNameClyText = new JTextField(20);
		gNameClyText.setBounds(370, 180, 100, 25);

		JButton addClassifyButton = new JButton("Add To Classify");
		addClassifyButton.setBounds(300, 210, 130, 25);
		addClassifyButton.setBackground(color);
		addClassifyButton.setForeground(Color.white);

		JButton clearClassifyButton = new JButton("Clear");
		clearClassifyButton.setBounds(440, 210, 80, 25);
		clearClassifyButton.setBackground(color);
		clearClassifyButton.setForeground(Color.white);
		panel3.add(clearClassifyButton);

		panel3.add(titleClyLable);
		panel3.add(titleClyText);
		panel3.add(gNameCLable);
		panel3.add(gNameClyText);
		panel3.add(addClassifyButton);

		addClassifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.insertClassify(titleClyText.getText(), gNameClyText.getText());

			}
		});

		clearClassifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleClyText.setText("");
				gNameClyText.setText("");
			}
		});
		frame.add(panel3);
		tabbedPane.addTab("Add Art Work", panel3);

		JPanel panel4 = new JPanel();
		panel4.setLayout(null);

		frame.add(panel4);
		tabbedPane.addTab("Add Like_Group", panel4);

		JLabel cusheadingLabel = new JLabel("To add like groups:");
		cusheadingLabel.setBounds(10, 10, 140, 25);
		cusheadingLabel.setOpaque(true);
		panel4.add(cusheadingLabel);

		JLabel cusLabel = new JLabel("CustId:");
		cusLabel.setBounds(10, 40, 80, 25);
		cusLabel.setOpaque(true);
		cusLabel.setForeground(color);
		panel4.add(cusLabel);

		JTextField custText = new JTextField(20);
		custText.setBounds(100, 40, 160, 25);
		panel4.add(custText);

		JLabel likrGroupLabel = new JLabel("GName: ");
		likrGroupLabel.setBounds(10, 70, 80, 25);
		likrGroupLabel.setOpaque(true);
		likrGroupLabel.setForeground(color);
		panel4.add(likrGroupLabel);

		JTextField likeGroupText = new JTextField(20);
		likeGroupText.setBounds(100, 70, 160, 25);
		panel4.add(likeGroupText);

		JButton likeGroupButton = new JButton("Add Like Group");
		likeGroupButton.setBounds(10, 100, 120, 25);
		likeGroupButton.setBackground(color);
		likeGroupButton.setForeground(Color.white);
		panel4.add(likeGroupButton);

		JButton likeClearButton = new JButton("Clear");
		likeClearButton.setBounds(150, 100, 80, 25);
		likeClearButton.setBackground(color);
		likeClearButton.setForeground(Color.white);
		panel4.add(likeClearButton);

		likeGroupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.insertLikeGroup(custText.getText(), likeGroupText.getText());

			}
		});

		likeClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custText.setText("");
				likeGroupText.setText("");
			}
		});

		JPanel panel5 = new JPanel();
		panel5.setLayout(null);

		frame.add(panel5);
		tabbedPane.addTab("Update Artist", panel5);

		JLabel ArtistLabel = new JLabel("Artist Name");
		ArtistLabel.setBounds(10, 10, 80, 25);
		ArtistLabel.setOpaque(true);

		ArtistLabel.setForeground(color);
		panel5.add(ArtistLabel);

		JTextField ArtistText = new JTextField(20);
		ArtistText.setBounds(100, 10, 160, 25);
		panel5.add(ArtistText);

		JLabel newStyleLabel = new JLabel("Style");
		newStyleLabel.setBounds(10, 40, 80, 25);
		newStyleLabel.setOpaque(true);
		newStyleLabel.setForeground(color);
		panel5.add(newStyleLabel);

		JTextField newStyleText = new JTextField(20);
		newStyleText.setBounds(100, 40, 160, 25);
		panel5.add(newStyleText);

		JButton updateStyleButton = new JButton("Update");
		updateStyleButton.setBounds(10, 70, 80, 25);
		updateStyleButton.setBackground(color);
		updateStyleButton.setForeground(Color.white);
		panel5.add(updateStyleButton);

		JButton clearUpdateButton = new JButton("Clear");
		clearUpdateButton.setBounds(180, 70, 80, 25);
		clearUpdateButton.setBackground(color);
		clearUpdateButton.setForeground(Color.white);
		panel5.add(clearUpdateButton);

		updateStyleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArtGallery.updateArtist(ArtistText.getText(), newStyleText.getText());

			}
		});

		clearUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				newStyleText.setText("");
				ArtistText.setText("");
			}
		});
		JPanel panel6 = new JPanel();
		panel6.setLayout(null);

		frame.add(panel6);
		tabbedPane.addTab("View", panel6);

		JLabel viewLabel = new JLabel("Select to View: ");
		viewLabel.setBounds(10, 10, 100, 25);
		viewLabel.setOpaque(true);
		viewLabel.setForeground(color);
		panel6.add(viewLabel);

		String[] viewlist = { "select", "artist", "customer", "artwork", "groups", "classify", "like_artist",
				"like_group" };
		JComboBox<String> list = new JComboBox<String>(viewlist);
		list.setBounds(150, 10, 160, 25);
		panel6.add(list);

		add(tabbedPane);
		list.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String viewName = (String) cb.getSelectedItem();
				viewTable(viewName);
			}

		});

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected static void insertLikeGroup(String custId, String gName) {

		try {
			Connection conn = null;
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			props.load(in);
			in.close();

			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			conn = DriverManager.getConnection(myUrl, username, password);
			String query = "insert into like_group values(?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, custId);
			preparedStmt.setString(2, gName);
			preparedStmt.execute();

			System.out.println(gName + "see here");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from classify where GName=\"" + gName + "\"");
			ResultSetMetaData colno = rs.getMetaData();
			int cno = colno.getColumnCount();

			System.out.println("fffffffffffffff : " + cno);

			while (rs.next()) {
				System.out.println(rs.getString(1) + "");
				Statement st2 = conn.createStatement();
				ResultSet rs2 = st2.executeQuery("select * from artwork where title=\"" + rs.getString(1) + "\"");
				while (rs2.next()) {
					String query2 = "insert into like_artist values(?, ?)";
					PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
					preparedStmt2.setString(1, custId);
					preparedStmt2.setString(2, rs2.getString(5));
					preparedStmt2.execute();

					JOptionPane.showMessageDialog(null, "Inserted to like_group and updated like_artist table");

				}

			}

			conn.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	protected static void insertClassify(String title, String gname) {
		try {
			Connection conn = null;
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			props.load(in);
			in.close();

			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			conn = DriverManager.getConnection(myUrl, username, password);
			String query = "insert into classify values(?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, title);
			preparedStmt.setString(2, gname);
			int insert = preparedStmt.executeUpdate();
			System.out.println(insert);
			conn.close();
			if (insert == 1)
				JOptionPane.showMessageDialog(null, "Title Inserted to classify");
			else
				JOptionPane.showMessageDialog(null, "title Not Added: " + title);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	protected static void insertGroup(String gNameText) {
		try {
			Connection conn = null;
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			props.load(in);
			in.close();

			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			conn = DriverManager.getConnection(myUrl, username, password);
			String query = "insert into groups values(?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, gNameText);
			int insert = preparedStmt.executeUpdate();
			System.out.println(insert);
			conn.close();
			if (insert == 1)
				JOptionPane.showMessageDialog(null, "Group Inserted " + "   Group Name: " + gNameText);
			else
				JOptionPane.showMessageDialog(null, "Group Name Not Added: " + gNameText);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

	}

	protected static void updateArtist(String artistName, String style) {

		try {
			Connection conn = null;
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			props.load(in);
			in.close();

			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			conn = DriverManager.getConnection(myUrl, username, password);
			String query = "update artist set Style = ? where AName = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, style);
			preparedStmt.setString(2, artistName);
			int update = preparedStmt.executeUpdate();
			System.out.println(update);
			conn.close();
			if (update == 1)
				JOptionPane.showMessageDialog(null, "Artist Style Updated " + "   Artist Name: " + artistName);
			else
				JOptionPane.showMessageDialog(null,
						"Artist Style Not updates " + "Artist Does Not Exist : " + artistName);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	protected void viewTable(String viewName) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			Properties props = new Properties();
			FileInputStream in = new FileInputStream("db.properties");
			props.load(in);
			in.close();

			String driver = props.getProperty("jdbc.driver");

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			conn = DriverManager.getConnection(myUrl, username, password);
			JFrame frame1 = new JFrame("Database Search Result");
			frame1.setLayout(new BorderLayout());

			try {
				st = conn.createStatement();
				rs = st.executeQuery("select * from " + viewName);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int i = 0;
				Vector<String> columns = new Vector<String>();
				while (i < columnCount) {
					i++;
					System.out.print(rsmd.getColumnName(i) + "\t");
					columns.add(rsmd.getColumnName(i));
				}
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columns);
				JTable table = new JTable();
				table.setModel(model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

				while (rs.next()) {
					Vector<String> value = new Vector<String>();
					int j = 0;
					while (j < columnCount) {

						value.add(rs.getString(columns.elementAt(j).toString()));
						System.out.println(columns.elementAt(j));
						j++;
					}
					model.addRow(value);
					frame1.add(scroll);
					// model.addRow(new Object[] { AName, birthplace, age, style
					// });
				}

				frame1.setVisible(true);
				frame1.setSize(400, 300);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());

		}
	}

	public static void AddArtist(String AName, String BirthPlace, String Age, String Style) {
		try {
			Connection conn = null;
			Statement st = null;
			//ResultSet rs = null;

			Properties props = new Properties();
			FileInputStream in;

			in = new FileInputStream("db.properties");

			props.load(in);
			in.close();

			// create a mysql database connection
			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			// Setup the connection with the DB
			conn = DriverManager.getConnection(myUrl, username, password);
			st = conn.createStatement();
			String query = " insert into artist (AName, Birthplace, Age, Style)" + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, AName);
			preparedStmt.setString(2, BirthPlace);
			preparedStmt.setInt(3, Integer.parseInt(Age));
			preparedStmt.setString(4, Style);
			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
			JOptionPane.showMessageDialog(null, "Artist Added " + "   Artist Name: " + AName);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public static void AddArtWork(String title, String year, String type, String price, String AName) {
		try {
			Connection conn = null;
			Statement st = null;
			//ResultSet rs = null;
			Properties props = new Properties();
			FileInputStream in;
			in = new FileInputStream("db.properties");
			props.load(in);
			in.close();
			// create a mysql database connection
			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();

			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			// Setup the connection with the DB
			conn = DriverManager.getConnection(myUrl, username, password);
			st = conn.createStatement();
			String query = " insert into artwork (Title, Year, Type, Price, AName)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, title);
			preparedStmt.setString(2, year);
			preparedStmt.setString(3, type);
			preparedStmt.setFloat(4, Float.parseFloat(price));
			preparedStmt.setString(5, AName);
			// execute the preparedstatementice
			preparedStmt.execute();
			conn.close();
			JOptionPane.showMessageDialog(null, "Artwork Added " + "Title: " + title);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public static void AddCustomer(String CustId, String CName, String Address, String Amount) {
		try {
			Connection conn = null;

			Properties props = new Properties();
			FileInputStream in;
			in = new FileInputStream("db.properties");
			props.load(in);
			in.close();
			String driver = props.getProperty("jdbc.driver");
			Class.forName(driver).newInstance();
			Statement st = null;
			String myUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			// Setup the connection with the DB
			conn = DriverManager.getConnection(myUrl, username, password);
			st = conn.createStatement();
			String query = " insert into customer (CustId, CName, Address, Amount)" + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(CustId));
			preparedStmt.setString(2, CName);
			preparedStmt.setString(3, Address);
			preparedStmt.setFloat(4, Float.parseFloat(Amount));
			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
			JOptionPane.showMessageDialog(null, "Customer Added " + "   Customer Name: " + CName);
			// rs = st.executeQuery("select * from artist");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "Invalid value");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Art Gallery");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.add(new ArtGallery(frame));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldmetal", Boolean.FALSE);
				createAndShowGUI();

			}

		});
	}
}