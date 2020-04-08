import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * A GUI class that fills in the hole in the BookingTab where the table is supposed to be
 * Not only this, it also holds the action listeners for the table
 * 
 * @author Anton Akov
 *
 */
public class BookingTablePanel extends JPanel
{
   String[] columns = {"№", "Name", "Checked in", "Dates", "you're not supposed to see this one"};
   
   Object[][] data;
   
   JTextField text;
   JButton butt;
   JTable table;
   JPanel fortable;
   ActionListener listener;
   TableModel model;
   TableRowSorter<TableModel> sorter;
   JScrollPane pane;
   JLabel label;
   int dates;
   int rooms;
   
   Bookings bookings;
   JButton cancelB;
   JButton newB;
   JButton checkinB;
   Object thispanel;
   JButton editB;
   
   
   /**
    * Default constructor that takes the buttons needed to control the action listener as arguments
    * @param b The list of bookings the whole program uses
    * @param searchB Search button
    * @param searchT Search text box
    * @param mBooking Make Booking button
    * @param cancel Cancel Booking button
    * @param checkin Checkin Booking button
    * @param edit Edit Booking button
    */
   public BookingTablePanel(Bookings b, JButton searchB, JTextField searchT, JButton mBooking, JButton cancel, JButton checkin, JButton edit)
   {
      text = searchT;
      butt = searchB;
      
      newB = mBooking;
      cancelB = cancel;
      checkinB = checkin;
      editB = edit;
      
      bookings = b;
      dates = 0;
      rooms = 0;
      
      listener = new ButtonListener();
      butt.addActionListener(listener);
      newB.addActionListener(listener);
      cancelB.addActionListener(listener);
      checkinB.addActionListener(listener);
      editB.addActionListener(listener);
      
      thispanel=this;
      
      construct();
   }
   /**
    * Method that reads the information from the bookings list and constructs the table/pane
    */
   private void construct()
   {
      int i = 0;
      int j = 0;
      String tempRoomString = "";
      String tempDateString = "";
      data = new Object[bookings.getList().size()][5];
      while(i<bookings.getList().size())
      {
         while(j<bookings.get(i).getBookedRooms().length)
         {
            tempRoomString = tempRoomString + bookings.get(i).getBookedRooms()[j].getRoomNumber()+", ";
            j++;
         }
         data[i][0] = tempRoomString.substring(0, tempRoomString.length()-2);
         if(rooms<j)rooms = j;
         j=0;
         tempRoomString = "";
         
         
         data[i][1] = bookings.get(i).getName();
         data[i][2] = (boolean)bookings.get(i).isCheckedIn();
         
         data[i][3] = bookings.get(i).getDates();
         
         data[i][4] = bookings.get(i);
         
         
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
       
      table = new JTable(model);
      
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment( JLabel.CENTER );
      
      DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
      rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
      
      
      //TableColumn column = table.getColumnModel().getColumn(3);
      //MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer();
      //SwingConstants.LEFT, SwingConstants.BOTTOM);
      //column.setHeaderRenderer(headerRenderer);
      
      
      TableColumn column;
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      column = null;
      for(int ii = 0;ii<5;ii++)
      {
         column = table.getColumnModel().getColumn(ii);
         switch(ii)
         {
            case 0 : column.setPreferredWidth(32+(rooms-1)*5);column.setCellRenderer(rightRenderer);break;
            case 1 : column.setPreferredWidth(180);column.setCellRenderer(centerRenderer);break;
            case 2 : column.setPreferredWidth(80);break;
            case 3 : column.setMinWidth(300);break;
            case 4 : table.getColumnModel().removeColumn(column);
         }
      }
      
      
      sorter = new TableRowSorter<TableModel>(model);
      table.setRowSorter(sorter);
      
      
      pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      add(pane, BorderLayout.CENTER);

      pane.setPreferredSize(new Dimension(530,250));
      
      /*JViewport viewport = new JViewport();
      viewport.setSize(400, 200);
      pane.setViewport(viewport);*/
      
   }
   
   /**
    * method that remakes the table/pane, the end of the remake chain
    */
   public void remake()
   {
      remove(pane);
      construct();
      validate();
   }
   /**
    * method that reaches out to the containing window and triggers the update chain
    */
   public void updateMain()
   {
      MAIN mainW = (MAIN) SwingUtilities.getWindowAncestor(this);
      mainW.remakeAllTables();
   }
   /**
    * 
    * ButtonListener class that does something depending on which button has been pressed
    *
    */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == butt)
         {
            String txt = text.getText();
            if (txt.length() == 0) {
               sorter.setRowFilter(null);
            } else {
               sorter.setRowFilter(RowFilter.regexFilter(txt));
            }
         }
         if(e.getSource() == newB)
         {
            new MakeBooking(bookings, (BookingTablePanel)thispanel); 
         }
         if(e.getSource() == cancelB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Booking selected = (Booking) table.getModel().getValueAt(tablerow, 4);
            
            int choise = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected booking?", "Booking removal prompt", JOptionPane.YES_NO_OPTION);
            if(choise == JOptionPane.YES_OPTION)
            {
               bookings.delete(selected);
               updateMain();
               
               //getParent().getParent().
            }
         }
         if(e.getSource() == checkinB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Booking selected = (Booking) table.getModel().getValueAt(tablerow, 4);
            
            if(!selected.isCheckedIn())new CheckIn(selected, bookings, (BookingTablePanel) thispanel);
         }
         if(e.getSource() == editB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Booking selected = (Booking) table.getModel().getValueAt(tablerow, 4);
            
            if(!selected.isCheckedIn())new MakeBooking(bookings, (BookingTablePanel)thispanel, selected);
            
            
         }
         
         
         
      }
   }
   
}
