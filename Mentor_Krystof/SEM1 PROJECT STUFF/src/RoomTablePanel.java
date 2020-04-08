import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 * The RoomTablePanel is the panel that contains the room table
 * It has all the information regarding the rooms and supports extensive searching functionality
 * @author Anton Akov
 *
 */
public class RoomTablePanel extends JPanel
{
   private String[] columns = {"№", "Type", "P/N", "Booked for", "roomObject"};
   
   private Object[][] data;
   
   private JTextField text;
   private JButton butt;
   private JTable table;
   private JPanel fortable;
   private ActionListener listener;
   private TableModel model;
   private TableRowSorter<TableModel> sorter;
   private JScrollPane pane;
   private JLabel label;
   private int dates;
   
   private AbstractTableModel tempHolder;
   
   private JTextField date1;
   private JTextField date2;
   private JTextField price1;
   private JTextField price2;
   
   private JButton bookingB;
   private JButton checkinB;
   
   private Rooms rooms;
   private Bookings bookings;
   
   private RoomTablePanel thiswindow;
   
   /**
    * The default constructor that takes all the buttons and fields from the outside for functionality and the informaton to work with aswell
    * @param rooms List of all rooms
    * @param B List of all bookings
    * @param searchB Search button
    * @param searchT Text field
    * @param d1 Available from
    * @param d2 Available to
    * @param p1 from price
    * @param p2 to price
    * @param bb make a booking button
    * @param cb checkin button
    */
   public RoomTablePanel(Rooms rooms, Bookings B, JButton searchB, JTextField searchT, JTextField d1, JTextField d2, JTextField p1, JTextField p2, JButton bb, JButton cb)
   {
      text = searchT;
      butt = searchB;
      date1 = d1;
      date2 = d2;
      price1 = p1;
      price2 = p2;
      bookingB = bb;
      checkinB = cb;
      bookings = B;
      
      this.rooms = rooms;
      fillTable(); 
      construct();
      bookingB.addActionListener(listener);
      checkinB.addActionListener(listener);
      
      thiswindow = this;
   }
   /**
    * This is called paired with construct to create the table and fill it up with data
    */
   private void fillTable()
   {
      dates = 0;
      int i = 0;
      int j = 0;
      String tempDateString = "";
      data = new Object[25][5];
      while(i<rooms.getList().size())
      {
         data[i][0] = (Integer)rooms.get(i).getRoomNumber();
         //TODO data[i][1] = String.valueOf(Rooms.get(i).getType());
         //0-suite, 1-2bedroom suite, 2-3bedroomsuite, 3-singleroom, 4-doubleroomKingsize, 5-doubleroom Double
         switch(rooms.get(i).getType())
         {
            case 0: data[i][1] = "suite";break;
            case 1: data[i][1] = "2 bedroom suite";break;
            case 2: data[i][1] = "3 bedroom suite";break;
            case 3: data[i][1] = "single bed room";break;
            case 4: data[i][1] = "kingsize bed";break;
            case 5: data[i][1] = "double bed";break;
         }
         data[i][2] = (Integer)rooms.get(i).getPricePerNight();
         while(j<rooms.get(i).getBookings().getList().size())
         {
            tempDateString = tempDateString + rooms.get(i).getBookings().get(j).getDates() + "    //    ";
            
            j++;
            
         }
         if(j!=0)tempDateString = tempDateString.substring(0, tempDateString.length()-10);
         if(j>dates)dates = j;
         j=0;
         data[i][3] = tempDateString;
         tempDateString = "";
         data[i][4] = rooms.get(i);
         i++;
      }
      model = new DefaultTableModel(data, columns) {
         public Class getColumnClass(int column) {
           Class returnValue;
              if ((column >= 0) && (column < getColumnCount())) {
                returnValue = getValueAt(0, column).getClass();
              } else {
                returnValue = Object.class;
              }
              return returnValue;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return false;
            }
      };
      tempHolder = (AbstractTableModel) model;
      table = new JTable(model);
   }
   /**
    * This is called paired with fillTable to create the table and fill it up with data
    */
   private void construct()
   {
      
      
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment( JLabel.CENTER );
      
      
      TableColumn column = table.getColumnModel().getColumn(3);
      MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer();
      //SwingConstants.LEFT, SwingConstants.BOTTOM);
      column.setHeaderRenderer(headerRenderer);
      
      
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      column = null;
      for(int i = 0;i<=4;i++)
      {
         column = table.getColumnModel().getColumn(i);
         switch(i)
         {
            case 0 : column.setPreferredWidth(35);break;
            case 1 : column.setPreferredWidth(100);column.setCellRenderer(centerRenderer);break;
            case 2 : column.setPreferredWidth(50);column.setCellRenderer(centerRenderer);break;
            case 3 : if(dates == 1){column.setMinWidth(230+250-35-100-50);}
               column.setMinWidth(230+(dates-1)*255);
               if(dates == 0)column.setMinWidth(350);break;
            case 4 : table.getColumnModel().removeColumn(column);
         }
      }
      sorter = new TableRowSorter<TableModel>(model);
      table.setRowSorter(sorter);
      pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      add(pane, BorderLayout.CENTER);
      listener = new ButtonListener();
      butt.addActionListener(listener);
      pane.setPreferredSize(new Dimension(500,250));
      /*JViewport viewport = new JViewport();
      viewport.setSize(400, 200);
      pane.setViewport(viewport);*/
      
   }
   /**
    * The button listener for the roomTablePanel one is the most complex one as it encorporates the code to sort by 3 different critera
    * 
    *
    */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == butt)
         {
            
            boolean dateFilter = date1.getText().length()!=0&&date2.getText().length()!=0;
            boolean priceFilter = price1.getText().length()!=0&&price2.getText().length()!=0;
            Room[] filteredRooms = null;
            if(dateFilter&&!priceFilter)
            {
               filteredRooms = rooms.getRoomsByDateRange(date1.getText(), date2.getText());
               
            }
            if(!dateFilter&&priceFilter)
            {
               filteredRooms = rooms.getRoomsByPriceRange(Integer.parseInt(price1.getText()), Integer.parseInt(price2.getText()));
               int ii=0;
               while(ii<filteredRooms.length)
               {
                  System.out.println(filteredRooms[ii]);
                  ii++;
               }
            }
            if(dateFilter&&priceFilter)
            {
               filteredRooms = rooms.getRoomsByDateAndPriceRange(date1.getText(), date2.getText(), Integer.parseInt(price1.getText()), Integer.parseInt(price2.getText()));
            }
            
            if(!dateFilter&&!priceFilter) 
            {
               table = new JTable(tempHolder);
               
               DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
               centerRenderer.setHorizontalAlignment( JLabel.CENTER );
               
               
               TableColumn column = table.getColumnModel().getColumn(3);
               MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer();
               //SwingConstants.LEFT, SwingConstants.BOTTOM);
               column.setHeaderRenderer(headerRenderer);
               
               
               table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               column = null;
               for(int iii = 0;iii<5;iii++)
               {
                  column = table.getColumnModel().getColumn(iii);
                  switch(iii)
                  {
                     case 0 : column.setPreferredWidth(35);break;
                     case 1 : column.setPreferredWidth(100);column.setCellRenderer(centerRenderer);break;
                     case 2 : column.setPreferredWidth(50);column.setCellRenderer(centerRenderer);break;
                     case 3 : //if(dates == 1){column.setMinWidth(230+250-35-100-50);}
                        //column.setMinWidth(230+(dates-1)*255);break;
                        column.setMinWidth(350);
                        if(dates-1>0)column.setMinWidth(350 + (dates)*350);break;
                     case 4 : table.getColumnModel().removeColumn(column);break;
                  }
               }
               sorter = new TableRowSorter<TableModel>(tempHolder);
               table.setRowSorter(sorter);
                  
            }
            else
            {
               dates = 0;
               int i = 0;
               int j = 0;
               String tempDateString = "";
               
               data = new Object[filteredRooms.length][5];
               
               while(i<filteredRooms.length)
               {
                  data[i][0] = (Integer)filteredRooms[i].getRoomNumber();
                  //TODO data[i][1] = String.valueOf(Rooms.get(i).getType());
                  //0-suite, 1-2bedroom suite, 2-3bedroomsuite, 3-singleroom, 4-doubleroomKingsize, 5-doubleroom Double
                  switch(filteredRooms[i].getType())
                  {
                     case 0: data[i][1] = "suite";break;
                     case 1: data[i][1] = "2 bedroom suite";break;
                     case 2: data[i][1] = "3 bedroom suite";break;
                     case 3: data[i][1] = "single bed room";break;
                     case 4: data[i][1] = "kingsize bed";break;
                     case 5: data[i][1] = "double bed";break;
                  }
                  data[i][2] = (Integer)filteredRooms[i].getPricePerNight();
                  while(j<filteredRooms[i].getBookings().getList().size())
                  {
                     tempDateString = tempDateString + filteredRooms[i].getBookings().get(j).getDates() + "    //    ";
                     
                     j++;
                     
                  }
                  if(j!=0)tempDateString = tempDateString.substring(0, tempDateString.length()-10);
                  if(j>dates)dates = j;
                  j=0;
                  data[i][3] = tempDateString;
                  data[i][4] = filteredRooms[i];
                  tempDateString = "";
                  i++;
               }
               model = new DefaultTableModel (data, columns) {
                  public Class getColumnClass(int column) {
                    Class returnValue;
                       if ((column >= 0) && (column < getColumnCount()-1)) {
                         returnValue = getValueAt(0, column).getClass();
                       } else {
                         returnValue = Object.class;
                       }
                       return returnValue;
                     }
                     @Override
                     public boolean isCellEditable(int row, int column) {
                         //Only the third column
                         return false;
                     }
               };
               table = new JTable(model);
               
               DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
               centerRenderer.setHorizontalAlignment( JLabel.CENTER );
               
               
               TableColumn column = table.getColumnModel().getColumn(3);
               MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer();
               //SwingConstants.LEFT, SwingConstants.BOTTOM);
               column.setHeaderRenderer(headerRenderer);
               
               
               table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
               column = null;
               for(int iii = 0;iii<=4;iii++)
               {
                  column = table.getColumnModel().getColumn(iii);
                  switch(iii)
                  {
                     case 0 : column.setPreferredWidth(35);break;
                     case 1 : column.setPreferredWidth(100);column.setCellRenderer(centerRenderer);break;
                     case 2 : column.setPreferredWidth(50);column.setCellRenderer(centerRenderer);break;
                     case 3 : //if(dates == 1){column.setMinWidth(230+250-35-100-50);}
                        //column.setMinWidth(230+(dates-1)*255);break;
                        column.setMinWidth(350);
                        if(dates-1>0)column.setMinWidth(350 + (dates)*350);break;
                     case 4 : table.getColumnModel().removeColumn(column);break;
                  }
               }
               sorter = new TableRowSorter<TableModel>(model);
               table.setRowSorter(sorter);
               
               
            }
            
            //pane = null;
            
            remove(pane);
            
            pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            pane.setPreferredSize(new Dimension(500,250));
            
            add(pane, BorderLayout.CENTER);
            
            //((AbstractTableModel) model).fireTableDataChanged();
            //repaint(10);
            
            validate();
            
            String txt = text.getText();
            if (txt.length() == 0) {
              sorter.setRowFilter(null);
            } else {
              sorter.setRowFilter(RowFilter.regexFilter(txt));
            }
         }
         if(e.getSource()==bookingB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Room selected = (Room) table.getModel().getValueAt(tablerow, 4);
            
            new MakeBooking(bookings, thiswindow, selected);
         }
         if(e.getSource() == checkinB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Room selected = (Room) table.getModel().getValueAt(tablerow, 4);
            
            Booking toCI = new Booking(new Guest(selected), new BookingDate(), new Room[]{selected});
            new CheckIn(toCI, bookings, thiswindow);
            
         }
      }
   }
   /**
    * Remake this table
    */
   public void remake()
   {
      remove(pane);
      fillTable();
      construct();
      validate();
   }
   /**
    * Triggers main update chain
    * 
    */
   public void updateMain()
   {
      MAIN mainW = (MAIN) SwingUtilities.getWindowAncestor(this);
      mainW.remakeAllTables();
   }
}
