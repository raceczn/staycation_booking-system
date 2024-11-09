package dashboard.screenpanels.tables;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;

public class TableforRooms extends JPanel{

	int width = getWidth();
	int height = getHeight();
	
	public TableforRooms() {
		
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		JTable table = new JTable(data, columnNames);
		table.setBounds(0, 0, width, height);
		add(table);
		
	}
	
}
